package com.rushwash.app.payment.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.app.item.vo.ItemVo;
import com.rushwash.app.member.service.MemberService;
import com.rushwash.app.member.vo.MemberVo;
import com.rushwash.app.payment.service.PaymentService;
import com.rushwash.app.payment.vo.LaundryOrderVo;
import com.rushwash.app.payment.vo.UserLaundryVo;
import com.rushwash.app.plan.service.PlanService;

@WebServlet("/payment/laundry-form")
public class FormWriteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 유저정보 가져오기
			// 이름,	연락처, 주소지, 유저포인트 - 세션으로 해결
			
			// 결제정보
			// 수량합,  최종결제금액, 유저의 결제수단 정보		
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			List<ItemVo> itemList = (List<ItemVo>) session.getAttribute("selectedItemList");
			String memberNo = loginMember.getNo();
			
			// 유저의 포인트정보
			MemberService memberService = new MemberService();
			int memberPoint = memberService.getPointInfo(memberNo);
			
			loginMember.setPoint(Integer.toString(memberPoint));
			
			// 유저의 플랜정보
			PlanService planService = new PlanService();
			String discountRate = planService.getDiscountRate(memberNo);
			
			//총수량 과 할인된 금액
			PaymentService paymentService = new PaymentService();
			Map<String , String> map = paymentService.calcTotalEaAndPrice(itemList,discountRate);
			String ea = map.get("resultEa");
			String price = map.get("resultPrice");
			
			
			session.setAttribute("ea", ea);
			session.setAttribute("price", price);
			req.getRequestDispatcher("/WEB-INF/views/user/payment/laundry_form.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String ea = req.getParameter("totalEa");
			String spendPoint = req.getParameter("spendPoint");
			String totalPrice = req.getParameter("totalPrice");
			String requestComment = "없음";
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			List<ItemVo> itemVoList = (List<ItemVo>) session.getAttribute("selectedItemList");
			int userPoint = Integer.parseInt(loginMember.getPoint()) - Integer.parseInt(spendPoint);
			String memberNo = loginMember.getNo();
			
			LaundryOrderVo orderVo = new LaundryOrderVo();
			orderVo.setMemberNo(loginMember.getNo());
			orderVo.setPrice(totalPrice);
			orderVo.setRequest(requestComment);
			orderVo.setAddress(loginMember.getMemberAddress());
			
			
			PaymentService paymentService = new PaymentService();

			//유저 포인트 차감
			int pointResult = paymentService.changeUserPoint(memberNo , userPoint);
			  
			//laundryOrder 데이터 insert
			int orderResult = paymentService.putLaundryOrder(orderVo);
			
			//laundry 데이터 insert
			int laundryResult = 0;
			for (ItemVo itemVo : itemVoList) {
				String itemNo = itemVo.getItemNo();
				String itemEa = itemVo.getEa();
				UserLaundryVo laundryVo = new UserLaundryVo();
				laundryVo.setMemberNo(memberNo);
				laundryVo.setItemNo(itemNo);
				laundryVo.setEa(itemEa);
				laundryResult = paymentService.putLaundry(laundryVo);
			}

			if(orderResult != 1 && laundryResult != 1 && pointResult != 1) {
				throw new Exception();
			}

			session.setAttribute("lastTotalPrice", totalPrice);
			session.setAttribute("spendPoint", spendPoint);
			resp.sendRedirect("/rushwash/apply/confirm-form");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

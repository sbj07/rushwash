package com.rushwash.app.apply;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.rushwash.app.item.service.ItemService;
import com.rushwash.app.item.vo.ItemVo;
import com.rushwash.app.member.vo.MemberVo;
import com.rushwash.app.plan.service.PlanService;

@WebServlet("/apply/request/once")
public class ApplyOnceController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html;charset=UTF-8");
			
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			String memberNo = loginMember.getNo();
			String isShow = req.getParameter("showtable");			
			
			//service
			//품목정보 가져오기
			ItemService itemService = new ItemService();
			List<ItemVo> itemList = itemService.selectItemList();
			
			//유저 구독정보 가져오기
			PlanService planService = new PlanService();
			String discountRate = planService.getDiscountRate(memberNo);
			if(!discountRate.equals("0")) {
				session.setAttribute("alertMsg","구독회원은 프리미엄 세탁을 이용해주세요!");
				resp.sendRedirect("/rushwash/apply/request");
			}
			
			Gson gson = new Gson();
			
			//상품목록 리스트 json 변환
			List<String> jsonList = new ArrayList<String>();
			for(ItemVo vo : itemList) {
				String jsonStr = gson.toJson(vo);
				jsonList.add(jsonStr);
			}
			
			// 할인율json 리스트에추가
//			jsonList.add(discountRate);
						
			//view
			String json = new Gson().toJson(jsonList);
			if(isShow != null) 
			{
				PrintWriter out = resp.getWriter();
				out.write(json);				
			}else {
				req.getRequestDispatcher("/WEB-INF/views/user/apply/once_basket.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Enumeration<String> parameterNames = req.getParameterNames();
			
			List<ItemVo> itemList = new ArrayList<ItemVo>();
			ItemService itemService = new ItemService();
			
			
		    while (parameterNames.hasMoreElements()) {
		        String paramName = parameterNames.nextElement();
		        String itemNo = paramName.substring(4);
		        String paramValue = req.getParameter(paramName);
		        ItemVo vo = new ItemVo();
		        vo.setItemNo(itemNo);
		        vo.setEa(paramValue);
		        if(!paramValue.equals("0")) {	        	
		        	String itemPrice = itemService.getPrice(itemNo);
		        	vo.setPrice(itemPrice);
		        	itemList.add(vo);
		        }
		    }
		    HttpSession session = req.getSession();
		    
		    session.setAttribute("selectedItemList", itemList);
		    resp.sendRedirect("/rushwash/payment/laundry-form");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

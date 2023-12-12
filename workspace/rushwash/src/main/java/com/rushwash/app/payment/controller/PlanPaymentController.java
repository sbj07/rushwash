package com.rushwash.app.payment.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.app.member.vo.MemberVo;
import com.rushwash.app.payment.service.PaymentService;
import com.rushwash.app.payment.vo.CardVo;
import com.rushwash.app.plan.service.PlanService;
import com.rushwash.app.plan.vo.PlanGradeVo;
import com.rushwash.app.plan.vo.PlanVo;

@WebServlet("/payment/plan")
public class PlanPaymentController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			String gradeNo = (String) session.getAttribute("seletedGrade");
			String memberNo = loginMember.getNo();
			PaymentService paymentService = new PaymentService();
			CardVo cardVo = paymentService.getCardInfo(memberNo);
			if(cardVo.getNo() == null) {
				req.setAttribute("alertMsg", "카드정보 등록후 이용해주세요.");
				req.getRequestDispatcher("/WEB-INF/views/user/payment/card_regist.jsp").forward(req, resp);
			}
			PlanService planService = new PlanService();
			PlanGradeVo gradeVo = planService.getPlanGrade(gradeNo);
			
			LocalDate now = LocalDate.now();
			int periodDate = now.getDayOfMonth();
			
			req.setAttribute("cardVo", cardVo);
			req.setAttribute("gradeVo", gradeVo);
			req.setAttribute("periodDate", periodDate);
			
			req.getRequestDispatcher("/WEB-INF/views/user/payment/plan.jsp").forward(req, resp);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		
			// 유저 번호
			String memberNo = loginMember.getNo();
			// 클릭한플랜등급
			String gradeNo = req.getParameter("planName");
			
			// 요청 일자 구하기
			LocalDate now = LocalDate.now();
			int periodDate = now.getDayOfMonth();
			
			PlanService planService = new PlanService();
			PaymentService paymentService = new PaymentService();
			
			//비구독자 판별
			String discountRate = planService.getDiscountRate(memberNo);
			CardVo cardVo = paymentService.getCardInfo(memberNo);
			String cardNo = cardVo.getNo();
			int payResult;
			if(discountRate.equals("0")) {
				//비구독에서 신규 구독이면 정기결제 insert
				payResult = paymentService.putRegularPayment(cardNo, periodDate);
				
			}else {
				//기존 구독자면 수정
				payResult = paymentService.changeReqularPayment(cardNo,periodDate);
			}
			int gradeResult = planService.changeGrade(gradeNo, memberNo);
			
			if(payResult == 1|| gradeResult == 1) {
				resp.sendRedirect("/rushwash/home");
			}else {	
				throw new Exception();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}

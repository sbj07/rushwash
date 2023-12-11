package com.rushwash.app.payment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.app.member.vo.MemberVo;
import com.rushwash.app.payment.service.PaymentService;
import com.rushwash.app.payment.vo.CardVo;

@WebServlet("/payment/card-regist")
public class CardRegistController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			String memberNo = loginMember.getNo();
			PaymentService paymentService = new PaymentService();
			CardVo cardVo = paymentService.getCardInfo(memberNo);
			
			if(cardVo.getNo() != null) {
				req.setAttribute("cardVo", cardVo);
			}
			req.getRequestDispatcher("/WEB-INF/views/user/payment/card_regist.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			
			String memberNo = loginMember.getNo();
			String cardCompany = req.getParameter("cardCompany");
			String cardNo = req.getParameter("cardNo");
			String validityPeriod = req.getParameter("validityPeriod");
			String cvcNo = req.getParameter("cvcNo");
			String cardPwd = req.getParameter("cardPwd");
			
			
			String[] splitPeriod = validityPeriod.split("-");
			String year = splitPeriod[0].substring(2); // 연도의 마지막 두 자리만 추출
			String month = splitPeriod[1];
			String period = year + month;
			
			CardVo cardVo = new CardVo();
			cardVo.setMemberNo(memberNo);
			cardVo.setCardCompany(cardCompany);
			cardVo.setCardNo(cardNo);
			cardVo.setValidityPeriod(period);
			cardVo.setCvcNo(cvcNo);
			cardVo.setCardPwd(cardPwd);
			
			PaymentService paymentService = new PaymentService();
			CardVo preCardVo = paymentService.getCardInfo(memberNo);
			int result;
			if(preCardVo.getNo() == null) {
				result = paymentService.putCardInfo(cardVo);
			}else {
				result = paymentService.changeCardInfo(cardVo);
			}
			CardVo newCardVo = paymentService.getCardInfo(memberNo);
			req.setAttribute("cardVo", newCardVo);
			if(result != 1) {
				throw new Exception();
			}
			session.setAttribute("alertMsg","카드등록이 완료되었습니다. 다시 진행해주세요!");
			resp.sendRedirect("/rushwash/home");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}

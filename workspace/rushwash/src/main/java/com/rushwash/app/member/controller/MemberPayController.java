package com.rushwash.app.member.controller;

import java.io.IOException;
import java.security.DrbgParameters.Reseed;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.app.member.service.MemberService;
import com.rushwash.app.member.vo.MemberVo;
import com.rushwash.app.payment.service.PaymentService;
import com.rushwash.app.payment.vo.CardVo;

@WebServlet("/member/pay")
public class MemberPayController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
            HttpSession session = req.getSession();

            MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
            
            PaymentService ps = new PaymentService();
            CardVo cardVo = ps.getCardInfo(loginMember.getNo());
            if(cardVo.getCardCompany() == null) {
            	System.out.println("if문 실행");
            	resp.sendRedirect("/rushwash/payment/card-regist");
            	return;
            }
            req.setAttribute("cardVo", cardVo);
            
            req.getRequestDispatcher("/WEB-INF/views/user/member/pay.jsp").forward(req, resp);

        } catch(Exception e) {
            System.out.println("[ERROR-M010] 결제 정보 조회 중 에러 발생 ...");
            e.printStackTrace();
            req.setAttribute("errorMsg", "결제 정보 조회 실패...");
            req.getRequestDispatcher("/WEB-INF/views/user/member/pay.jsp").forward(req, resp);
        }
	}
}

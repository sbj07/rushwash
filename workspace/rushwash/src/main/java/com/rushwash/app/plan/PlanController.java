package com.rushwash.app.plan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.app.member.vo.MemberVo;
import com.rushwash.app.payment.service.PaymentService;

@WebServlet("/plan/select")
public class PlanController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/plan/select_plan.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			String gradeNo = req.getParameter("planName");
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			String memberNo = loginMember.getNo();
			
			PaymentService paymentService = new PaymentService();
			int result = paymentService.changePlanInfo(memberNo, gradeNo);
			
			if(result != 1) {
				throw new Exception();
			}
			
			resp.sendRedirect("/rushwash/home");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

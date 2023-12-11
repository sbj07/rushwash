package com.rushwash.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.app.member.service.MemberService;
import com.rushwash.app.member.vo.MemberVo;

@WebServlet("/member/quit")
public class MemberQuitController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/member/quit.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			//data
			String id = req.getParameter("memberId");
			String pwd = req.getParameter("password");
			MemberVo loginMember =  (MemberVo)req.getSession().getAttribute("loginMember");
			if(loginMember == null) {
				throw new Exception("잘못된 접근입니다.");
			}
			String memberId = loginMember.getMemberId();
			
			//service
			MemberService ms = new MemberService();
			int result = ms.delete(id, pwd);
			
			//result == view
			if(result != 1) {
				throw new Exception ("회원 탈퇴 중 에러 발생");
			}
	
			req.getSession().invalidate();
			req.getSession().setAttribute("alertMsg", "회원 탈퇴 완료. 로그아웃 됩니다.");
			resp.sendRedirect("/rushwash/home");
			
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "회원 탈퇴 불가");
			req.getRequestDispatcher("/WEB-INF/views/user/member/quit.jsp").forward(req, resp);
		}
	}
}

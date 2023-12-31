package com.rushwash.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.app.member.service.MemberService;
import com.rushwash.app.member.vo.MemberVo;

@WebServlet("/member/idchange")
public class MemberIdChangeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/member/idchange.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			MemberVo vo = (MemberVo) session.getAttribute("loginMember");
			
			String id = vo.getMemberId();
			String inputId = req.getParameter("memberId");
			//data
			String newId = req.getParameter("newId");
			
			if(!id.equals(inputId)) {
				throw new Exception("현재 아이디 정보를 입력하세요.");
			}
			
			//service
			MemberService ms = new MemberService();
			int result = ms.idChange(id, newId);
			
			//result
			if(result != 1) {
				throw new Exception("아이디 변경 불가");

			} else {
				req.getSession().invalidate();
				req.getSession().setAttribute("alertMsg", "아이디 변경 완료. 재로그인 하세요.");
				resp.sendRedirect("/rushwash/home");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg" , "현재 아이디 정보를 입력하세요");
			req.getRequestDispatcher("/WEB-INF/views/user/member/idchange.jsp").forward(req, resp);
		}
		
	}
}

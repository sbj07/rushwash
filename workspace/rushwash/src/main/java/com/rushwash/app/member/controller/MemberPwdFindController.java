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

@WebServlet("/member/pwdfind")
public class MemberPwdFindController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/member/pwdfind.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//data
			String memberName = req.getParameter("memberName");
			String memberId = req.getParameter("memberId");

			MemberVo vo = new MemberVo();
			vo.setMemberName(memberName);
			vo.setMemberId(memberId);
			
			//service
			MemberService ms = new MemberService();
			String memberPwd = ms.pwdFind(vo); // 아이디 찾기 결과를 String으로 받음

			// 아이디를 session 속성에 저장
			HttpSession session = req.getSession();
			session.setAttribute("memberPwd", memberPwd);

			//result
			req.getRequestDispatcher("/WEB-INF/views/user/member/knowpwd.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "일치하는 계정이 없습니다.");
			req.getRequestDispatcher("/WEB-INF/views/user/member/pwdfind.jsp").forward(req, resp);
		}
	}
}

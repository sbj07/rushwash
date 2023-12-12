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

@WebServlet("/member/idfind")
public class MemberIdFindController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/member/idfind.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		    // 사용자가 입력한 이메일
		    String email = req.getParameter("email");

		    // MemberService를 이용해 이메일로 사용자 아이디 찾기
		    MemberService ms = new MemberService();
		    String memberId = ms.findUserByEmail(email); // 이메일로 사용자 아이디 찾기 결과를 문자열로 받음

		    if (memberId != null) {
		        // 사용자 아이디 찾기 성공: 아이디를 세션에 저장하고 결과 페이지로 이동
		        HttpSession session = req.getSession();
		        session.setAttribute("memberId", memberId);
		        req.getRequestDispatcher("/WEB-INF/views/user/member/knowid.jsp").forward(req, resp);
		    } else {
		        // 사용자 아이디 찾기 실패: 오류 메시지를 설정하고 아이디 찾기 페이지로 이동
		        req.setAttribute("errorMsg", "해당 이메일로 가입된 계정이 없습니다.");
		        req.getRequestDispatcher("/WEB-INF/views/user/member/idfind.jsp").forward(req, resp);
		    }
		} catch(Exception e) {
		    e.printStackTrace();
		    req.setAttribute("errorMsg", "아이디 찾기에 실패했습니다. 다시 시도해주세요.");
		    req.getRequestDispatcher("/WEB-INF/views/user/member/idfind.jsp").forward(req, resp);
		}
	}
}
 
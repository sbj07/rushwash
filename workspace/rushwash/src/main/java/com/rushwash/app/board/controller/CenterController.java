package com.rushwash.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.app.member.vo.MemberVo;

@WebServlet("/board/center")
public class CenterController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인 안되어있으면 에러페이지로 보내기
		
		MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
		if(loginMember == null) {
			req.setAttribute("erroMsg", "로그인 하세요.");
			req.getRequestDispatcher("/WEB-INF/views/member/login.jsp");
		}
		
		req.getRequestDispatcher("/WEB-INF/views/user/board/center.jsp").forward(req, resp);
		
	}
}

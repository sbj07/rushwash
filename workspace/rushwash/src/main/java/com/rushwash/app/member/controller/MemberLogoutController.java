package com.rushwash.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/logout")
public class MemberLogoutController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//기존 세션있으니까, 가져와서 만료시킴
		req.getSession().invalidate();
		
		//세션 없으니까, 세션을 새로 만듬
		req.getSession().setAttribute("alertMsg", "로그아웃 완료");
		resp.sendRedirect("/rushwash/home");
	}
	
}

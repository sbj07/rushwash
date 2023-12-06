package com.rushwash.admin.app.manager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.admin.app.manager.service.ManagerService;
import com.rushwash.admin.app.manager.vo.ManagerVo;

@WebServlet("/admin/login")
public class ManagerLoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/admin/view/manager/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("adminInputID");
		String pwd = req.getParameter("adminInputPWD");
		ManagerVo vo = new ManagerVo();
		vo.setId(id);
		vo.setPwd(pwd);
		
		System.out.println(vo);
		
		//세션에 로그인 정보 담기
		HttpSession session = req.getSession();
		session.setAttribute("loginData", vo);
	
	}

}

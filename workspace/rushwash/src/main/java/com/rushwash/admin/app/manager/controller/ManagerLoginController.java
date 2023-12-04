package com.rushwash.admin.app.manager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//data
		String id = req.getParameter("Id");
		String pwd = req.getParameter("Password");
		String pwd2 = req.getParameter("Password2");
		String name = req.getParameter("Name");
		
		ManagerVo vo = new ManagerVo();
		
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setPwd2(pwd2);
		vo.setName(name);
		
		
		//service
		ManagerService ms = new ManagerService();
		int result = ms.regist(vo);
		
		//result
		if(result != 1) {
			throw new Exception("[ERROR-M002]매니저 등록 실패");
		}
		
		req.getRequestDispatcher("").forward(req, resp);
		
	
	}

}

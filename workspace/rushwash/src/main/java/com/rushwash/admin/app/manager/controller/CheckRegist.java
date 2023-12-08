package com.rushwash.admin.app.manager.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.admin.app.manager.service.ManagerService;

@WebServlet("/admin/check")
public class CheckRegist extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try{

			// data
			String id = req.getParameter("Id");

			// service
			ManagerService ms = new ManagerService();
			boolean isOk = ms.checkId(id);

			// result
			if (isOk) {
				out.write("{\"msg\" : \"ok\"}");
			} else {
				throw new Exception();
			}

		}catch(Exception e){
			System.out.println("[ERROR-M011] 아이디 중복체크 중 에러 발생...");
			e.printStackTrace();
			out.write("{\"msg\" : \"no\"}");
		}
	}
	
}

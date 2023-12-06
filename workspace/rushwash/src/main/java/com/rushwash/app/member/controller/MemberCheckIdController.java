package com.rushwash.app.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.app.member.service.MemberService;

@WebServlet("/member/check/id")
public class MemberCheckIdController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter out = resp.getWriter();
		try {
			
			// data
			String memberId = req.getParameter("memberId");
			
			// service
			MemberService ms = new MemberService();
			boolean isOk = ms.checkId(memberId);
			
			// result
			if(isOk) {
				out.write("{\"msg\" : \"ok\"}");
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR-M011] 아이디 중복체크 중 에러 발생...");
			e.printStackTrace();
			out.write("{\"msg\" : \"no\"}");
		}
	}
}

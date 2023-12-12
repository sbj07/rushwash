package com.rushwash.app.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/verify")
public class EmailCheckController extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String email = req.getParameter("email");
	    String inputCheckNum = req.getParameter("checkNum");
	    HttpSession session = req.getSession();
	    Integer sessionCheckNum = (Integer) session.getAttribute(email);
	    System.out.println(sessionCheckNum);
	    System.out.println(inputCheckNum);

	    PrintWriter out = resp.getWriter();
	    if (sessionCheckNum != null && Integer.parseInt(inputCheckNum) == sessionCheckNum) {
	        // 인증번호 일치
	        out.write("{\"msg\" : \"success\"}"); 
	    } else {
	        // 인증번호 불일치
	        out.write("{\"msg\" : \"fail\"}"); 
	    }
	}
}

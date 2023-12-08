package com.rushwash.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			//data
			String id = req.getParameter("id");
			String newId = req.getParameter("newId");
			
			//service
			MemberService ms = new MemberService();
			int result = ms.idChange(id, newId);
			
			//result
			if(result != 1) {
				throw new Exception("아이디 변경 실패");
//				req.setAttribute("errorMsg" , "아이디 변경 실패. 다시 시도 하세요.");
//				req.getRequestDispatcher("/WEB-INF/views/user/member/idchange.jsp").forward(req, resp);
			} else {
				req.setAttribute("alertMsg" , "아이디 변경 성공");
				resp.sendRedirect("rushwash/user/mypage.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg" , "아이디 변경 실패. 다시 시도 하세요.");
			req.getRequestDispatcher("/WEB-INF/views/user/member/idchange.jsp").forward(req, resp);
		}
		
	}
}

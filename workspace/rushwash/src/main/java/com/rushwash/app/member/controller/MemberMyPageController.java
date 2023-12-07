package com.rushwash.app.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.app.member.service.MemberService;
import com.rushwash.app.member.vo.MemberVo;

@WebServlet("/member/mypage")
public class MemberMyPageController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 try {
			 
			 //data
			 String no = req.getParameter("no");
			 
			 //service
			 MemberService ms = new MemberService();
			 MemberVo vo = ms.myInfo(no);
			 	
			 //result
			 req.setAttribute("vo", vo);
	         req.getRequestDispatcher("/WEB-INF/views/user/member/mypage.jsp").forward(req, resp);

	    }catch(Exception e) {
	        System.out.println("[ERROR-M003] 사용자 정보 조회 중 에러 발생 ...");
	        e.printStackTrace();
	        req.setAttribute("errorMsg", "사용자 정보 조회 실패...");
	        req.getRequestDispatcher("/WEB-INF/views/user/member/mypage.jsp").forward(req, resp);
	    }
	}
}
	
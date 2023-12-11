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

@WebServlet("/member/addrchange")
public class MemberAddrChangeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/member/addrchange.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVo vo = (MemberVo) session.getAttribute("loginMember");
			
			String id = vo.getMemberId();
			String addr = vo.getMemberAddress();
			//data
			String newAddr = req.getParameter("newAddr");
			
			//service
			MemberService ms = new MemberService();
			int result = ms.addrChange(id, addr, newAddr);
			
			//result
			if(result != 1) {
				throw new Exception("주소 변경 불가");

			} else {
				req.getSession().invalidate();
				req.getSession().setAttribute("alertMsg", "주소 변경 완료");
				resp.sendRedirect("/rushwash/home");
//				vo.setMemberId(newId);
//				session.setAttribute("loginMember", vo);
				
//				req.setAttribute("alertMsg" , "아이디 변경 완료. 재로그인 하세요.");
//				resp.sendRedirect("/rushwash/home");
			}
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg" , "주소 변경 불가. 다시 시도 하세요.");
			req.getRequestDispatcher("/WEB-INF/views/user/member/addrchange.jsp").forward(req, resp);
		}
	}
}

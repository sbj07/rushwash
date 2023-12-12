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
			String inputId = req.getParameter("memberId");
			String inputAddr = req.getParameter("addr");
			String newAddr = req.getParameter("newAddr");
			
			if(!id.equals(inputId)) {
				throw new Exception("현재 아이디 정보를 입력하세요.");
			}
			
			if(!addr.equals(inputAddr)) {
				throw new Exception("현재 주소 정보를 입력하세요.");
			}
			
			//service
			MemberService ms = new MemberService();
			int result = ms.addrChange(id, addr, newAddr);
			
			//result
			if(result != 1) {
				throw new Exception("주소 변경 불가");

			} else {
				vo.setMemberAddress(newAddr);
				session.setAttribute("loginMember", vo);
				
				session.setAttribute("alertMsg" , "주소 변경 완료");
				resp.sendRedirect("/rushwash/member/mypage");
			}
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg" , "아이디 혹은 주소 정보를 잘못 입력하셨습니다");
			req.getRequestDispatcher("/WEB-INF/views/user/member/addrchange.jsp").forward(req, resp);
		}
	}
}

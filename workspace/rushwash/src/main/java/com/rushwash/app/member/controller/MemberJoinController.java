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

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/member/join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			//data
			req.setCharacterEncoding("UTF-8");
			//데이터
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			String memberPwd2 = req.getParameter("memberPwd2");
			String memberName = req.getParameter("memberName");
			String memberEmail = req.getParameter("memberEmail");
			String memberAddress = req.getParameter("memberAddress");
			String memberTel = req.getParameter("memberTel");
			
			
			MemberVo vo = new MemberVo();
			vo.setMemberId(memberId);
			vo.setMemberPwd(memberPwd);
			vo.setMemberPwd2(memberPwd2);
			vo.setMemberName(memberName);
			vo.setMemberEmail(memberEmail);
			vo.setMemberAddress(memberAddress);
			vo.setMemberTel(memberTel);
			
		
			//서비스
			MemberService ms = new MemberService();
			int result = ms.join(vo);
			
			//결과
			if(result == 1) {
				HttpSession session = req.getSession();
				session.setAttribute("alertMsg" , "회원가입 성공");
				resp.sendRedirect("/rushwash/home");
			}else {
				throw new Exception("result 값이 1이 아님");
			}
		}catch(Exception e) {
			
			System.out.println("[ERROR-M001] 회원가입 중 에러 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errorMsg" , "회원가입 실패. 다시 시도 하세요");
			req.getRequestDispatcher("/WEB-INF/views/user/member/join.jsp").forward(req, resp);
		}
		
	
	}
}

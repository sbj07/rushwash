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

@WebServlet("/member/pwdchange")
public class MemberPwdChangeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/member/pwdchange.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			MemberVo vo = (MemberVo) session.getAttribute("loginMember");
			
			if(vo != null) {
				String id = vo.getMemberId();
	            String pwd = vo.getMemberPwd();
	            
	            //data
	            String inputId = req.getParameter("memberId");
	            String inputPwd = req.getParameter("memberPwd");
	            String newPwd = req.getParameter("newPwd");
	            
	            if (!id.equals(inputId)) {
	                throw new Exception("아이디가 일치하지 않습니다.");
	            }
	            
	            if (!pwd.equals(inputPwd)) {
	                throw new Exception("현재 비밀번호가 일치하지 않습니다.");
	            }
	            
	            //service
	            MemberService ms = new MemberService();
	            int result = ms.pwdChange(id, pwd, newPwd);
	            
	            //result
	            if(result != 1) {
	                throw new Exception("비밀번호 변경 불가");
	            } else {
	                req.getSession().invalidate();
	                req.getSession().setAttribute("alertMsg", "비밀번호 변경 완료. 재로그인 하세요.");
	                resp.sendRedirect("/rushwash/home");
	            }
	        } else {
	            throw new Exception("로그인이 필요합니다.");
	        }
			
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg" , "아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
			req.getRequestDispatcher("/WEB-INF/views/user/member/pwdchange.jsp").forward(req, resp);
		}
	}
}

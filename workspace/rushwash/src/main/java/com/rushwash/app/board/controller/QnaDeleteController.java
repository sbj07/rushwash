package com.rushwash.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.app.board.qna.service.QnaService;
import com.rushwash.app.member.vo.MemberVo;

@WebServlet("/board/qnadelete")
public class QnaDeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			resp.setContentType("text/html;charset=UTF-8");
			HttpSession session =req.getSession();
			
			String no = req.getParameter("no");
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			
			String memberNo = loginMember.getNo();
			QnaService qs = new QnaService();
			int result = qs.delete(no, memberNo);
			
			if(result != 1) {
				throw new Exception("qna게시글 삭제 중 에러");
			}
			resp.getWriter().print("<script>alert('게시글이 삭제 되었습니다.'); location.href='/rushwash/board/center';</script>");
			//resp.sendRedirect("/rushwash/board/center");
		}catch(Exception e) {
			System.out.println("[ERROR]게시글 삭제중 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 삭제 중 에러 ");
		}
		
	}
}

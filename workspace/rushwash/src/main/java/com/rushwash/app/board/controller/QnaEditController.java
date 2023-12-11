package com.rushwash.app.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.app.board.qna.service.QnaService;
import com.rushwash.app.board.qna.vo.QnaVo;

@WebServlet("/board/qnaedit")
public class QnaEditController extends HttpServlet{
	
	//수정 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String no = req.getParameter("no");
			
			QnaService qs = new QnaService();
			Map<String, Object> m = qs.edit(no);
			QnaVo vo = (QnaVo) m.get("vo");
			
			if(vo == null) {
				throw new Exception();
			}
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/user/board/qnaedit.jsp").forward(req, resp);
		}catch(Exception e) {
			System.out.println("qna 게시글 수정하기 화면 에러");
			e.printStackTrace();
			req.setAttribute("errorMsg", "qna게시글 수정 화면 조회 에러");
		}
		
	}
	
	//게시글 수정
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("~~~~~");
		System.out.println(req.getSession().getAttribute("loginMember"));
		System.out.println("~~~~~");
		
		try {
			String title = req.getParameter("title");
			String content = req.getParameter("CONTENT");
			String no = req.getParameter("NO");
			
			QnaVo vo = new QnaVo();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setNo(no);
			
			QnaService qs = new QnaService();
			int result = qs.edit(vo);
			
			if(result != 1) {
				throw new Exception();
			}
			resp.sendRedirect("/rushwash/board/qnadetail?no=" + no);
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 수정 실패...");
			
		}
		
	}

}

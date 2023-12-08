package com.rushwash.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.app.board.qna.service.QnaService;
import com.rushwash.app.board.qna.vo.QnaVo;

@WebServlet("/board/qnadetail")
public class QnaDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String no = req.getParameter("no");
			
			QnaService bs = new QnaService();
			QnaVo vo = bs.selectQnaByNo(no);
			
			req.setAttribute("vo", vo);
			req.setAttribute("currPage", req.getParameter("currPage"));
			req.getRequestDispatcher("/WEB-INF/views/user/board/qnadetail.jsp").forward(req, resp);
		}catch(Exception e) {
			System.out.println("[ERROR]게시글 조회 중 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 상세조회 실패");
		}
		
		
	}
}

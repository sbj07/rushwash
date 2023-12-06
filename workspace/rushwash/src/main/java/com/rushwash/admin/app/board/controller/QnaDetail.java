package com.rushwash.admin.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.admin.app.board.qna.service.QnaService;
import com.rushwash.admin.app.board.qna.vo.QnaVo;


@WebServlet("/admin/board/qna/detail")
public class QnaDetail extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			// data
			String no = req.getParameter("no");
			
			// service
			QnaService bs = new QnaService();
			QnaVo vo = bs.selectQnaByNo(no);
			
			// result == view
			req.setAttribute("vo", vo);
			req.setAttribute("currPage", req.getParameter("currPage"));
			if(vo.getCommt() == null) {
				req.getRequestDispatcher("/WEB-INF/admin/view/board/qnaDetailCommtNull.jsp").forward(req, resp);				
			}else {
				req.getRequestDispatcher("/WEB-INF/admin/view/board/qnaDetail.jsp").forward(req, resp);
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR-B003] 게시글 상세조회 중 에러 발생 ...");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 상세조회 실패...");
		}

	}//doGet
}

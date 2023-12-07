package com.rushwash.admin.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.admin.app.board.qna.service.QnaService;

@WebServlet("/admin/board/qnaCommtDelete")
public class QnaCommtDelete extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			// data
			String no = req.getParameter("no");
			System.out.println(no);
			
			// service
			QnaService bs = new QnaService();
			int result = bs.commtDelete(no);
			
			// result == view
			if(result != 1) {
				throw new Exception("게시글 삭제 중 에러 발생 ...");
			}
			// 게시글 삭제 성공 => 게시글 목록으로 이동
			req.getSession().setAttribute("alertMsg", "댓글 삭제 성공!");
			resp.sendRedirect("/rushwash/admin/board/qna");
			
		}catch(Exception e) {
			System.out.println("[ERROR-B004] 게시글 삭제 중 에러 발생 ...");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 삭제 중 에러 발생 ...");
		}
	}//doGet
}

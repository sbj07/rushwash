package com.rushwash.admin.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.admin.app.board.qna.service.QnaService;
import com.rushwash.admin.app.board.qna.vo.QnaVo;
import com.rushwash.admin.app.manager.vo.ManagerVo;

@WebServlet("/admin/board/qnaWriteCommt")
public class qnaWriteCommt extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			
			HttpSession session = req.getSession();
			
			// data
			String commt = req.getParameter("commt");
			String no = req.getParameter("no");
			
			QnaVo vo = new QnaVo();
			vo.setCommt(commt);
			
			// service
			QnaService bs = new QnaService();
			int result = bs.write(vo, no);
			
			// result == view
			if(result != 1) {
				throw new Exception("result 가 1이 아님 ,,,,");
			}
			
			req.getSession().setAttribute("alertMsg", "게시글 작성 성공 !");
			resp.sendRedirect("/rushwash/admin/board/qna");
			
		}catch(Exception e) {
			System.out.println("[ERROR-B002] 게시글 작성 실패 ...");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 작성 실패 ...");
		}
	}
}


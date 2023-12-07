package com.rushwash.admin.app.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.admin.app.board.faq.service.FaqService;
import com.rushwash.admin.app.board.faq.vo.FaqVo;
import com.rushwash.admin.app.board.notice.service.NoticeService;
import com.rushwash.admin.app.board.notice.vo.NoticeVo;

@WebServlet("/admin/board/faq/edit")
public class FaqEditController extends HttpServlet{
	// 게시글 수정 (화면)
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				//data
				String no = req.getParameter("no");
				
				//service
				FaqService bs = new FaqService();
				Map<String, Object> m = bs.edit(no);
				FaqVo vo = (FaqVo) m.get("vo");
				
				//result
				if(vo == null) {
					throw new Exception();
				}
				req.setAttribute("vo", vo);
				req.getRequestDispatcher("/WEB-INF/admin/view/board/faqEdit.jsp").forward(req, resp);
			}catch(Exception e) {
				System.out.println("게시글 수정하기 화면 조회 에러 ...");
				e.printStackTrace();
				req.setAttribute("errorMsg", "게시글 수정 화면 조회 에러 ...");
			}
		}
		
		// 게시글 수정
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			try {
				
				//data
				String title = req.getParameter("title");
				String content = req.getParameter("content");
				String no = req.getParameter("no");
				
				FaqVo vo = new FaqVo();
				vo.setTitle(title);
				vo.setContent(content);
				vo.setNo(no);
				
				//service
				FaqService bs = new FaqService();
				int result = bs.edit(vo, no);
				
				//result
				if(result != 1) {
					throw new Exception();
				}
				resp.sendRedirect("/rushwash/admin/board/faq?no=" + no);
				
			}catch(Exception e) {
				e.printStackTrace();
				req.setAttribute("errorMsg", "게시글 수정 실패 ...");
			}
		}
}

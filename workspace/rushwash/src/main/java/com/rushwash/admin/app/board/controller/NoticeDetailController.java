package com.rushwash.admin.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.admin.app.board.notice.service.NoticeService;
import com.rushwash.admin.app.board.notice.vo.NoticeVo;


@WebServlet("/admin/board/notice/detail")
public class NoticeDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			// data
			String no = req.getParameter("no");
			
			// service
			NoticeService bs = new NoticeService();
			NoticeVo vo = bs.selectNoticeByNo(no);
			
			// result == view
			req.setAttribute("vo", vo);
			req.setAttribute("currPage", req.getParameter("currPage"));
			req.getRequestDispatcher("/WEB-INF/admin/view/board/noticeDetail.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println("[ERROR-B003] 게시글 상세조회 중 에러 발생 ...");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 상세조회 실패...");
		}

	}//doGet

}

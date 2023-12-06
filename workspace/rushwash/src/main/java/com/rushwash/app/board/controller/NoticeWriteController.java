package com.rushwash.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.app.board.notice.service.UserNoticeService;
import com.rushwash.app.board.notice.vo.UserNoticeVo;

@WebServlet("/board/noticewrite")
public class NoticeWriteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//data
			String no = req.getParameter("no");
			
			//service
			UserNoticeService bs = new UserNoticeService();
			UserNoticeVo vo = bs.selectNoticeByNo(no);
			
			//result
			req.setAttribute("vo", vo);
			req.setAttribute("currPage", req.getParameter("currPage"));
			req.getRequestDispatcher("/WEB-INF/views/user/board/noticewrite.jsp").forward(req, resp);
		}catch(Exception e) {
			System.out.println("[ERROR]공지사항 상세조회 중 에러");
			e.printStackTrace();
			
		}
		
		
		
		
	}
}

package com.rushwash.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.admin.app.page.vo.PageVo;
import com.rushwash.app.board.notice.service.UserNoticeService;
import com.rushwash.app.board.notice.vo.UserNoticeVo;

@WebServlet("/board/notice")
public class NoticeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			UserNoticeService bs = new UserNoticeService();
			
			//data
			int listCount = bs.selectNoticeCount();
			String currentPage_ = req.getParameter("pno");
			if(currentPage_ == null) {
				currentPage_ = "1";
			}
			int currentPage = Integer.parseInt(currentPage_);
			int pageLimit = 5;
			int boardLimit = 10;
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			//service
			List<UserNoticeVo> boardVoList = bs.selectNoticeList(pvo);
			
			//result
			req.setAttribute("boardVoList", boardVoList);
			req.setAttribute("pvo", pvo);
			req.getRequestDispatcher("/WEB-INF/views/user/board/notice.jsp").forward(req, resp);
		}catch(Exception e) {
			System.out.println("[ERROR]공지사항 목록 조회 중 에러");
			e.printStackTrace();
		}
		
		
	}
}

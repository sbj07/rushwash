package com.rushwash.admin.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.admin.app.board.notice.service.NoticeService;
import com.rushwash.admin.app.board.notice.vo.NoticeVo;
import com.rushwash.admin.app.page.vo.PageVo;


@WebServlet("/admin/board/notice")
public class NoticeController extends HttpServlet{
	
	//공지사항 화면
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				NoticeService bs = new NoticeService();
				
				// data
				int listCount = bs.selectNoticeCount();		//전체 게시글 갯수
				String currentPage_ = req.getParameter("pno");
				if(currentPage_ == null) {
					currentPage_ = "1";
				}
				int currentPage = Integer.parseInt(currentPage_);	//현재 페이지
				int pageLimit = 5;
				int noticeLimit = 10;
				PageVo pvo = new PageVo(listCount, currentPage, pageLimit, noticeLimit);
				
				// service
				List<NoticeVo> NoticeVoList = bs.selectNoticeList(pvo);
				
				// result (==view)
				req.setAttribute("NoticeVoList", NoticeVoList);
				req.setAttribute("pvo" , pvo);
				req.getRequestDispatcher("/WEB-INF/admin/view/board/noticeList.jsp").forward(req, resp);
			}catch(Exception e) {
				System.out.println("[ERROR-B001]게시글 목록 조회 중 에러 발생 ...");
				e.printStackTrace();
				req.setAttribute("errorMsg", "게시글 목록 조회 에러");
			}
				
		}
		
		
		
		//공지사항 처리
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		}
		

}
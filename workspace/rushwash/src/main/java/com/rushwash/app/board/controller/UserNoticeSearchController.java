package com.rushwash.app.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.admin.app.page.vo.PageVo;
import com.rushwash.app.board.notice.service.UserNoticeService;
import com.rushwash.app.board.notice.vo.UserNoticeVo;

@WebServlet("/board/search")
public class UserNoticeSearchController extends HttpServlet{
	
	//게시글 검색
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			UserNoticeService bs = new UserNoticeService();
			
			//data
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			
			Map<String, String> m = new HashMap<String, String>();
			m.put("searchType", searchType);
			m.put("searchValue", searchValue);
			
			int listCount = bs.selectSearchNoticeCount(m);
			int currentPage = 1;
			if(req.getParameter("pno") != null) {
				currentPage = Integer.parseInt(req.getParameter("pno"));
			}
			int pageLimit = 5;
			int boardLimit = 10;
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			//service
			List<UserNoticeVo> boardVoList = bs.search(m, pvo);
			
			//result
			req.setAttribute("boardVoList", boardVoList);
			req.setAttribute("pvo", pvo);
			req.setAttribute("searchMap", m);
			req.getRequestDispatcher("/WEB-INF/views/user/board/notice.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println("게시글 검색 중 에러");
			e.printStackTrace();
		}
		
	}
}

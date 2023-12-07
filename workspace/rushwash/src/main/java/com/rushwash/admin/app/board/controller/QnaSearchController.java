package com.rushwash.admin.app.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.admin.app.board.qna.service.QnaService;
import com.rushwash.admin.app.board.qna.vo.QnaVo;
import com.rushwash.admin.app.page.vo.PageVo;

@WebServlet("/admin/board/qna/search")
public class QnaSearchController extends HttpServlet {
	
	// 게시글 검색
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			QnaService bs = new QnaService();
			
			// data
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			
			Map<String, String> m = new HashMap<String, String>();
			m.put("searchType", searchType);
			m.put("searchValue", searchValue);
			
			int listCount = bs.selectSearchQnaCount(m);
			int currentPage = 1;
			if(req.getParameter("pno") != null) {
				currentPage = Integer.parseInt(req.getParameter("pno"));
			}
			int pageLimit = 5;
			int boardLimit = 10;
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			
			// service
			List<QnaVo> QnaVoList = bs.search(m , pvo);
			
			// result
			req.setAttribute("searchType", searchType); // 추가된 부분
            req.setAttribute("searchValue", searchValue); // 추가된 부분
			req.setAttribute("QnaVoList", QnaVoList);
			req.setAttribute("pvo", pvo);
			req.getRequestDispatcher("/WEB-INF/admin/view/board/qnaList.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println("[ERROR-B123] 게시글 검색 중 에러 발생 ...");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 검색 중 에러 발생 ...");
		}
		
	}
}
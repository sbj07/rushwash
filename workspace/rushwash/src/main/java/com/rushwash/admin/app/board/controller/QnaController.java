package com.rushwash.admin.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.admin.app.board.qna.service.QnaService;
import com.rushwash.admin.app.board.qna.vo.QnaVo;
import com.rushwash.admin.app.page.vo.PageVo;

@WebServlet("/admin/board/qna")
public class QnaController extends HttpServlet{
	
	//공지사항 화면
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				try {
					QnaService bs = new QnaService();
					
					// data
					int listCount = bs.selectQnaCount();		//전체 게시글 갯수
					String currentPage_ = req.getParameter("pno");
					if(currentPage_ == null) {
						currentPage_ = "1";
					}
					int currentPage = Integer.parseInt(currentPage_);	//현재 페이지
					int pageLimit = 5;
					int noticeLimit = 10;
					PageVo pvo = new PageVo(listCount, currentPage, pageLimit, noticeLimit);
					
					// service
					List<QnaVo> QnaVoList = bs.selectQnaList(pvo);
					
					// result (==view)
					req.setAttribute("QnaVoList", QnaVoList);
					req.setAttribute("pvo" , pvo);
					req.getRequestDispatcher("/WEB-INF/admin/view/board/qnaList.jsp").forward(req, resp);
				}catch(Exception e) {
					System.out.println("[ERROR-B001]게시글 목록 조회 중 에러 발생 ...");
					e.printStackTrace();
					req.setAttribute("errorMsg", "게시글 목록 조회 에러");
				}
					
			}
}
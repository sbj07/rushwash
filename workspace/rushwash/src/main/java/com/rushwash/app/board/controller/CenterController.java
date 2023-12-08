package com.rushwash.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.admin.app.page.vo.PageVo;
import com.rushwash.app.board.qna.service.QnaService;
import com.rushwash.app.board.qna.vo.QnaVo;
import com.rushwash.app.member.vo.MemberVo;

@WebServlet("/board/center")
public class CenterController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//로그인 안되어있으면 에러페이지로 보내기
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			if(loginMember == null) {
				req.getRequestDispatcher("/WEB-INF/views/user/member/login.jsp").forward(req, resp);
			}
			
			QnaService bs = new QnaService();
			//
			int listCount = bs.selectQnaCount();
			String currentPage_ = req.getParameter("pno");
			if(currentPage_ == null) {
				currentPage_ = "1";
			}
			int currentPage = Integer.parseInt(currentPage_);
			int pageLimit = 5;
			int boardLimit = 10;
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			List<QnaVo> boardVoList = bs.selectQnaList(pvo);
			
			req.setAttribute("boardVoList", boardVoList);
			req.setAttribute("pvo", pvo);
			req.getRequestDispatcher("/WEB-INF/views/user/board/center.jsp").forward(req, resp);
			/////
		}catch(Exception e) {
			System.out.println("로그인 하세요.");
			req.setAttribute("errorMsg", "로그인 하세요.");
		}
		
		
	}
}

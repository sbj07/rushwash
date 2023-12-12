package com.rushwash.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.admin.app.page.vo.PageVo;
import com.rushwash.app.board.faq.service.FaqService;
import com.rushwash.app.board.faq.vo.FaqVo;
import com.rushwash.app.board.qna.service.QnaService;
import com.rushwash.app.board.qna.vo.QnaVo;
import com.rushwash.app.member.vo.MemberVo;

@WebServlet("/board/center")
public class CenterController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			  resp.setContentType("text/html;charset=UTF-8");
			  HttpSession session =req.getSession();
		      MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			
			//로그인 안되어있으면 에러페이지로 보내기
		    
		    if(loginMember == null) {
		    	throw new Exception("로그인 멤버가 NULL 임");
		    }

			QnaService bs = new QnaService();
			FaqService fs = new FaqService();
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
			
			List<QnaVo> boardVoList = bs.selectQnaList(pvo, loginMember.getNo());
			List<FaqVo> faqVoList = fs.selectFaqList(pvo);
			
//			req.getRequestDispatcher("/WEB-INF/views/user/board/center.jsp").forward(req, resp);
			/////
			
			req.setAttribute("boardVoList", boardVoList);
			req.setAttribute("pvo", pvo);
			req.setAttribute("faqVoList", faqVoList);
			req.getRequestDispatcher("/WEB-INF/views/user/board/center.jsp").forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("로그인 하세요.");
			req.setAttribute("errorMsg", "로그인 하세요.");
			req.setAttribute("alerMsg","로그인 후 이용해주세요");
			resp.getWriter().print("<script>alert('로그인이 필요합니다.'); location.href='/rushwash/member/login';</script>");
		}
		
		
	}
}

package com.rushwash.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.app.board.qna.service.QnaService;
import com.rushwash.app.board.qna.vo.QnaVo;
import com.rushwash.app.member.vo.MemberVo;

@WebServlet("/board/qnawrite")
public class QnaWriteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/board/qnawrite.jsp").forward(req, resp);
	}

	// 게시글 작성 로직
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// 인코딩
			// req.setCharacterEncoding("UTF-8");

			HttpSession session = req.getSession();

			// data
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");

			
			 if(loginMember == null) { throw new Exception("로그인 안함"); }
			

			QnaVo vo = new QnaVo();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setMemberNo(loginMember.getNo());

			// service
			QnaService bs = new QnaService();
			int result = bs.write(vo);

			// result
			if (result != 1) {
				throw new Exception("result 1이 아님");
			}
			req.getSession().setAttribute("alertMsg", "게시글이 작성 되었습니다.");
			resp.sendRedirect("/rushwash/board/center");

		} catch (Exception e) {
			System.out.println("[ERROR]게시글 작성실패");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 작성 실패.");
			req.getRequestDispatcher("/WEB-INF/views/user/board/center.jsp").forward(req, resp);
		}

	}
}

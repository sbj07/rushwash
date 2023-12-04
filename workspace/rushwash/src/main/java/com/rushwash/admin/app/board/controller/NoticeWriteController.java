package com.rushwash.admin.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.admin.app.board.notice.service.NoticeService;
import com.rushwash.admin.app.board.notice.vo.NoticeVo;
import com.rushwash.admin.app.manager.vo.ManagerVo;


@WebServlet("/admin/board/noticeWrite")
public class NoticeWriteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/admin/view/board/noticeWrite.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			//인코딩
//			req.setCharacterEncoding("UTF-8");	//필터에서 인코딩 처리 해줌
			
			HttpSession session = req.getSession();
			
			// data
			String category = req.getParameter("category");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			ManagerVo loginManager = (ManagerVo)session.getAttribute("loginManager");
			
//			if(loginManager == null) {
//				throw new Exception("로그인 안했음");
//			}
			
			NoticeVo vo = new NoticeVo();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setManagerNo(loginManager.getNo());
			
			// service
			NoticeService bs = new NoticeService();
			int result = bs.write(vo);
			
			// result == view
			if(result != 1) {
				throw new Exception("result 가 1이 아님 ,,,,");
			}
			
			req.getSession().setAttribute("alertMsg", "게시글 작성 성공 !");
			resp.sendRedirect("/rushwash/admin/board/notice");
			
		}catch(Exception e) {
			System.out.println("[ERROR-B002] 게시글 작성 실패 ...");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 작성 실패 ...");
		}
	}

}

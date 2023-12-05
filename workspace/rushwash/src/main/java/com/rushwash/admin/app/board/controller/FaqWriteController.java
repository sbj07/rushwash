package com.rushwash.admin.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.admin.app.board.faq.service.FaqService;
import com.rushwash.admin.app.board.faq.vo.FaqVo;
import com.rushwash.admin.app.manager.vo.ManagerVo;

@WebServlet("/admin/board/faqWrite")
public class FaqWriteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/admin/view/board/faqWrite.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			//인코딩
//			req.setCharacterEncoding("UTF-8");	//필터에서 인코딩 처리 해줌
			
			HttpSession session = req.getSession();
			
			// data
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			
			ManagerVo loginManager = new ManagerVo();
//			ManagerVo loginManager = (ManagerVo)session.getAttribute("loginManager");
			
//			if(loginManager == null) {
//				throw new Exception("로그인 안했음");
//			}
			
			FaqVo vo = new FaqVo();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setManagerId(loginManager.getNo());
			
			// service
			FaqService bs = new FaqService();
			int result = bs.write(vo);
			
			// result == view
			if(result != 1) {
				throw new Exception("result 가 1이 아님 ,,,,");
			}
			
			req.getSession().setAttribute("alertMsg", "FAQ 작성 성공 !");
			resp.sendRedirect("/rushwash/admin/board/faq");
			
		}catch(Exception e) {
			System.out.println("[ERROR-B002] FAQ 작성 실패 ...");
			e.printStackTrace();
			req.setAttribute("errorMsg", "FAQ 작성 실패 ...");
		}
	}

}

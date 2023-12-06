package com.rushwash.admin.app.manager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.admin.app.manager.service.ManagerService;
import com.rushwash.admin.app.manager.vo.ManagerVo;

@WebServlet("/admin/login")
public class ManagerLoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/admin/view/manager/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//DATA
			String id = req.getParameter("adminInputID");
			String pwd = req.getParameter("adminInputPWD");
			ManagerVo vo = new ManagerVo();
			vo.setId(id);
			vo.setPwd(pwd);
			
			//서비스
			ManagerService ms = new ManagerService();
			ManagerVo loginManager = ms.login(vo);
			
			System.out.println(vo);
			System.out.println(loginManager);
			if(loginManager==null) {
				throw new Exception("ERROR 매니저 로그인 실패");
			}
			
			//세션에 로그인 정보 담기
			HttpSession session = req.getSession();
			session.setAttribute("loginManager", loginManager);
			session.setAttribute("alertMsg", "관리자 로그인에 성공하였습니다.");
			//성공 후 대시보드로 리다이렉트
			resp.sendRedirect("/rushwash/admin/dashboard");
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "매니저 로그인 실패");
			req.getRequestDispatcher("/WEB-INF/admin/view/manager/login.jsp").forward(req, resp);
		}
	}
}//class end

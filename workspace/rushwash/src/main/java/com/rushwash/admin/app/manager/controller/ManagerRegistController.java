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

@WebServlet("/admin/regist")
public class ManagerRegistController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/admin/view/manager/regist.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// data
			String id = req.getParameter("Id");
			String pwd = req.getParameter("Password");
			String pwd2 = req.getParameter("Password2");
			String name = req.getParameter("Name");

			ManagerVo vo = new ManagerVo();

			vo.setId(id);
			vo.setPwd(pwd);
			vo.setPwd2(pwd2);
			vo.setName(name);

			// service
			ManagerService ms = new ManagerService();
			int result = ms.regist(vo);

			// result
			if (result != 1) {
				throw new Exception("[ERROR-M002]매니저 등록 실패");
			}
			
			HttpSession session = req.getSession();
			session.setAttribute("alertMsg", "관리자 등록에 성공하였습니다.");
			//성공 후 대시보드로 리다이렉트
			resp.sendRedirect("/rushwash/admin/manager/view");

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "매니저 등록 실패 \\n"+e.getMessage());
			req.getRequestDispatcher("/WEB-INF/admin/view/manager/regist.jsp").forward(req, resp);
		}

	}

}

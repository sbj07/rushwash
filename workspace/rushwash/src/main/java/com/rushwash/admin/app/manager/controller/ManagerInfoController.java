package com.rushwash.admin.app.manager.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.admin.app.manager.service.ManagerService;
import com.rushwash.admin.app.manager.vo.ManagerVo;

@WebServlet("/admin/manager/view")
public class ManagerInfoController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//DATA
			
			//SERVICE
			ManagerService ms = new ManagerService();
			List<ManagerVo> voList = ms.infoView();
			
			//RESULT
			if (voList == null) {
				throw new Exception("[ERROR-M001 매니저 정보 전체조회 실패]");
			}
			
			req.setAttribute("voList", voList);
			req.getRequestDispatcher("/WEB-INF/admin/view/manager/ManagerInfo.jsp").forward(req, resp);
			
		} catch (Exception e) {
			System.out.println("[ERROR-M001 매니저 정보 전체조회 실패]");
			e.printStackTrace();
			req.setAttribute("errMsg", "매니저 정보 전체조회 실패 에러");
			req.getRequestDispatcher("/WEB-INF/view/common/error.jsp").forward(req, resp);
		}
		
	}
}

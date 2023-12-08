package com.rushwash.admin.app.dashboard.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.admin.app.dashboard.service.adminDashboardService;
import com.rushwash.admin.app.dashboard.vo.DashboardVo;
import com.rushwash.admin.app.manager.vo.ManagerVo;

@WebServlet("/admin/dashboard")
public class AdminDashboardController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session    = req.getSession();
			System.out.println("dashboard controller > session :::  " + session + "/" + session.getCreationTime());
			ManagerVo loginManager = (ManagerVo) session.getAttribute("loginManager");
			System.out.println("dashboard controller > loginManager :::  " + loginManager);
			
			if(loginManager==null) {
//				resp.sendRedirect("/rushwash/adminlogin");
			}
			
			
			//service
			adminDashboardService as = new adminDashboardService();
			DashboardVo dashboardVo  = as.getDashboardInfo();
			
			//result req에 데이터 많이 전달해야함
				//plan_info - grade_no 별 count
				//laundry - item_no 별 카운트
				//laundry_order - order_status 별 카운트 (수거중-1 세탁대기-2 세탁중-3 미수령-4,5)
			
			Map<String, String> itemCategoryCount = dashboardVo.getItemCategoryCount();
			Map<String, String> planInfoCount     = dashboardVo.getPlanInfoCount();
			Map<String, String> orderStatusCount  = dashboardVo.getOrderStatusCount();

			req.setAttribute("itemCategoryCount", itemCategoryCount);
			req.setAttribute("planInfoCount", planInfoCount);
			req.setAttribute("orderStatusCount", orderStatusCount);
			
			req.getRequestDispatcher("/WEB-INF/admin/view/dashboard/dashboard.jsp").forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("errMsg", "대시보드 불러오기 실패");
			req.getRequestDispatcher("/WEB-INF/admin/view/common/error.jsp");
		}
	}
}

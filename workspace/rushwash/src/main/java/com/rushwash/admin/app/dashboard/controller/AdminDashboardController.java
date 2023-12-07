package com.rushwash.admin.app.dashboard.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.admin.app.dashboard.service.adminDashboardService;
import com.rushwash.admin.app.dashboard.vo.DashboardVo;

@WebServlet("/admin/dashboard")
public class AdminDashboardController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
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

			System.out.println(itemCategoryCount.get("1"));
			System.out.println(itemCategoryCount.get("2"));
			System.out.println(itemCategoryCount.get("3"));
			System.out.println(planInfoCount);
			System.out.println(orderStatusCount);
			
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

package com.rushwash.admin.app.dashboard.service;

import java.sql.Connection;
import java.util.Map;

import com.rushwash.admin.app.dashboard.dao.DashboardDao;
import com.rushwash.admin.app.dashboard.vo.DashboardVo;
import com.rushwash.admin.app.db.util.JDBCTemplate;

public class adminDashboardService {

	public DashboardVo getDashboardInfo() throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		DashboardDao dao = new DashboardDao();
		
		Map<String, String> planInfoCount = dao.countPlanInfo(conn);
		Map<String, String> itemCategoryCount = dao.countItemCategory(conn);
		Map<String, String> countOrderStatus = dao.countOrderStatus(conn);
		
		DashboardVo dashboardVo = new DashboardVo();
		dashboardVo.setPlanInfoCount(planInfoCount);
		dashboardVo.setItemCategoryCount(itemCategoryCount);
		dashboardVo.setOrderStatusCount(countOrderStatus);
		
		//close
		JDBCTemplate.close(conn);
		
		return dashboardVo;
	}
}

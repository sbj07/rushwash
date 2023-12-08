package com.rushwash.app.plan.service;

import java.sql.Connection;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.app.plan.dao.PlanDao;
import com.rushwash.app.plan.vo.PlanVo;

public class PlanService {

	public String getDiscountRate(String memberNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		PlanDao dao = new PlanDao();
		String discountRate = dao.getDiscountRate(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return discountRate;
	}

}

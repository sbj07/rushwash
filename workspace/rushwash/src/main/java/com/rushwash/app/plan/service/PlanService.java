package com.rushwash.app.plan.service;

import java.sql.Connection;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.app.plan.dao.PlanDao;
import com.rushwash.app.plan.vo.PlanGradeVo;
import com.rushwash.app.plan.vo.PlanVo;

public class PlanService {

	public String getDiscountRate(String memberNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		PlanDao dao = new PlanDao();
		String discountRate = dao.getDiscountRate(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return discountRate;
	}
	
	public int changeGrade(String gradeNo , String memberNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		PlanDao dao = new PlanDao();
		int result = dao.changeGrade(conn, gradeNo, memberNo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public PlanGradeVo getPlanGrade(String gradeNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		PlanDao dao = new PlanDao();
		PlanGradeVo gradeVo = dao.getPlanGrade(conn, gradeNo);
		return gradeVo;
	}

}

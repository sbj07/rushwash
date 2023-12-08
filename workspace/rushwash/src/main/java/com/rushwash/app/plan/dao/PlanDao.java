package com.rushwash.app.plan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rushwash.admin.app.db.util.JDBCTemplate;

public class PlanDao {

	public String getDiscountRate(Connection conn, String memberNo) throws Exception {
		String sql = "SELECT PG.DISCOUNT_RATE FROM PLAN_INFO PI JOIN PLAN_GRADE PG ON PI.GRADE_NO = PG.NO JOIN MEMBER M ON PI.MEMBER_NO = M.NO WHERE PI.MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		String discountRate = "";
		if(rs.next()) {
			discountRate = rs.getString("DISCOUNT_RATE");
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return discountRate;
	}

}

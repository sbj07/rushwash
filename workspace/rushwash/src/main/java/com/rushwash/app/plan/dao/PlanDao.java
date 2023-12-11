package com.rushwash.app.plan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.app.plan.vo.PlanGradeVo;
import com.rushwash.app.plan.vo.PlanVo;

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
	
	public int changeGrade(Connection conn , String gradeNo , String memberNo) throws Exception {
		String sql = "UPDATE PLAN_INFO SET GRADE_NO = ? ,PLAN_DATE = SYSDATE WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, gradeNo);
		pstmt.setString(2, memberNo);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public PlanGradeVo getPlanGrade(Connection conn, String gradeNo) throws Exception {
		String sql = "SELECT SUB_GRADE ,DISCOUNT_RATE ,PRICE FROM PLAN_GRADE WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, gradeNo);
		ResultSet rs = pstmt.executeQuery();
		
		PlanGradeVo gradeVo = null;
		if(rs.next()) {
			String gradeName = rs.getString("SUB_GRADE");
			String rate = rs.getString("DISCOUNT_RATE");
			String price = rs.getString("PRICE");
			
			gradeVo = new PlanGradeVo();
			gradeVo.setNo(gradeNo);
			gradeVo.setSubGrade(gradeName);
			gradeVo.setDiscountRate(rate);
			gradeVo.setPrice(price);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return gradeVo;
	}
	

}

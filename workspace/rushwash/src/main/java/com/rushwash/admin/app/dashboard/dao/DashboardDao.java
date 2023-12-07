package com.rushwash.admin.app.dashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.rushwash.admin.app.db.util.JDBCTemplate;

public class DashboardDao {

	public Map<String, String> countPlanInfo(Connection conn) throws Exception {
		//sql
		String sql = "SELECT NVL(PI.GRADE_NO, 1) AS GRADE_NO, COUNT(*) AS COUNT FROM MEMBER M LEFT JOIN PLAN_INFO PI ON M.NO = PI.MEMBER_NO GROUP BY NVL(PI.GRADE_NO, 1)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		Map<String, String> planInfoMap = new HashMap<String, String>();
		while(rs.next()) {
			String gradeNo = rs.getString("GRADE_NO");
			String count = rs.getString("COUNT");
			planInfoMap.put(gradeNo, count);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return planInfoMap;
	}
	
	public Map<String, String> countItemCategory(Connection conn) throws Exception {
		//sql
		String sql = "select ic.no, count(*) from laundry l join item i on l.item_no = i.no join item_category ic on i.category_code = ic.no group by ic.no";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		Map<String, String> itemCategoryMap = new HashMap<String, String>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String count = rs.getString("COUNT(*)");
			itemCategoryMap.put(no, count);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return itemCategoryMap;
	}
	
	public Map<String, String> countOrderStatus(Connection conn) throws Exception {
		//sql
		String sql = "SELECT ORDER_STATUS, COUNT(ORDER_STATUS) FROM laundry_order GROUP BY ORDER_STATUS";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		Map<String, String> orderStatusMap = new HashMap<String, String>();
		while(rs.next()) {
			String no = rs.getString("ORDER_STATUS");
			String count = rs.getString("COUNT(ORDER_STATUS)");
			orderStatusMap.put(no, count);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return orderStatusMap;
	}

}

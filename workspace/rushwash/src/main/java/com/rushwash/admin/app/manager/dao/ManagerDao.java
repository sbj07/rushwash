package com.rushwash.admin.app.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.manager.vo.ManagerVo;

public class ManagerDao {

	public List<ManagerVo> infoView(Connection conn) throws Exception {
		//sql
		String sql = "select * from manager";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<ManagerVo> voList = new ArrayList<ManagerVo>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("MANAGER_ID");
			String pwd = rs.getString("MANAGER_PWD");
			String name = rs.getString("NAME");
			String delYn = rs.getString("DEL_YN");
			
			ManagerVo vo = new ManagerVo();
			
			vo.setNo(no);
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(name);
			vo.setDelYn(delYn);
			
			voList.add(vo);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
	}

	public int regist(Connection conn, ManagerVo vo) throws Exception {
		//sql
		String sql = "";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}

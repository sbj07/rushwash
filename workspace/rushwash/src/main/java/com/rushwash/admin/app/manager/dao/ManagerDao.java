package com.rushwash.admin.app.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.manager.vo.ManagerVo;
import com.rushwash.admin.app.member.vo.MemberVo;

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
		String sql = "insert into manager (no , manager_id , manager_pwd , name) VALUES (seq_manager_no.nextval,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getName());
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public ManagerVo login(Connection conn, ManagerVo vo) throws Exception {
		//sql
		String sql = "select * from manager where manager_id=? and manager_pwd=? and del_yn='N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		ManagerVo loginManager = null;
		if(rs.next()) {
			String id = rs.getString("MANAGER_ID");
			String pwd = rs.getString("MANAGER_PWD");
			String name = rs.getString("NAME");
			String delYn = rs.getString("DEL_YN");
			
			loginManager = new ManagerVo();
			loginManager.setId(id);
			loginManager.setPwd(pwd);
			loginManager.setName(name);
			loginManager.setDelYn(delYn);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return loginManager;
	}

	//아이디 중복체크
	public boolean checkId(Connection conn, String id) throws Exception {
		//sql
		String sql = "select * from manager where manager_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		boolean isOk = true;
		if(rs.next()) {
			isOk  = false;
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return isOk;
	}

	//로그인정보 상태값 갱신
		public int submitStatus(Connection conn, ManagerVo vo) throws Exception {
			//sql
			String sql = "update manager set del_yn=? WHERE no=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getDelYn());
			pstmt.setString(2, vo.getNo());
			int result = pstmt.executeUpdate();
			
			//close
			JDBCTemplate.close(pstmt);
			
			return result;
		}

}

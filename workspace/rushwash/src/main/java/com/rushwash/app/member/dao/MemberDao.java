package com.rushwash.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.app.member.vo.MemberVo;

public class MemberDao {

	public int join(Connection conn, MemberVo vo) throws Exception {

		String sql = "INSERT INTO MEMBER(NO, ID, PWD, EMAIL, ADDRESS, NAME, TEL) VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
		String email = vo.getMemberEmail();
		if (email == null) {
		    email = "default@email.com";
		}
		pstmt.setString(3, email);
		pstmt.setString(4, vo.getMemberAddress());
		pstmt.setString(5, vo.getMemberName());		
		pstmt.setString(6, vo.getMemberTel());
		int result = pstmt.executeUpdate();
		
		//rs
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	
	}

	public MemberVo login(Connection conn, MemberVo vo) throws Exception {
		//sql
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		MemberVo loginMember = null;
		if(rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String email = rs.getString("EMAIL");
			String address = rs.getString("ADDRESS");
			String name = rs.getString("NAME");
			String tel = rs.getString("TEL");
			String enrollDate = rs.getString("ENROLL_DATE");
			String delYn = rs.getString("DEL_YN");
			String modifyDate = rs.getString("MODIFY_DATE");
			String point = rs.getString("POINT");

			loginMember = new MemberVo();
			loginMember.setNo(no);
			loginMember.setMemberId(id);
			loginMember.setMemberPwd(pwd);
			loginMember.setMemberEmail(email);
			loginMember.setMemberAddress(address);
			loginMember.setMemberName(name);
			loginMember.setMemberTel(tel);
			loginMember.setEnrollDate(enrollDate);
			loginMember.setDelYn(delYn);
			loginMember.setModifyDate(modifyDate);
			loginMember.setPoint(point);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return loginMember;
	}

	public boolean checkId(Connection conn, String memberId) throws Exception {
	
		//sql
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberId);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		boolean result = true;
		if(rs.next()) {
			result = false;
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}

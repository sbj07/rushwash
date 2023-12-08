package com.rushwash.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

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
		String sql = "SELECT M.NO ,M.ID ,M.PWD ,M.EMAIL ,M.ADDRESS ,M.NAME ,M.TEL ,M.ENROLL_DATE ,M.MODIFY_DATE, M.POINT, M.DEL_YN ,C.CARD_COMPANY ,C.CARD_NO ,G. SUB_GRADE FROM MEMBER M LEFT JOIN PLAN_INFO P ON M.NO = P.MEMBER_NO LEFT JOIN PLAN_GRADE G ON G.NO = P.GRADE_NO LEFT JOIN CARD_INFO C ON M.NO = C.MEMBER_NO WHERE M.ID = ? AND M.PWD = ? AND M.DEL_YN = 'N'";
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
			String planName = rs.getString("SUB_GRADE");
			String cardNo = rs.getString("CARD_NO");
			String cardCompany = rs.getString("CARD_COMPANY");

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
			loginMember.setSubGrade(planName);
			loginMember.setCardNo(cardNo);
			loginMember.setCardCompany(cardCompany);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return loginMember;
	}

	//중복체크
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

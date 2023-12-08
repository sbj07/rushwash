package com.rushwash.admin.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.laundry.vo.LaundryVo;
import com.rushwash.admin.app.laundry.vo.OrderVo;
import com.rushwash.admin.app.member.vo.MemberVo;

public class MemberDao {

	//유저 정보 조회 (일반, 로그인 동일 로직)
	public List<MemberVo> infoView(Connection conn) throws Exception {
		//sql
		String sql = "select M.* ,pi.plan_date,pg.sub_grade from member M LEFT JOIN PLAN_INFO PI ON PI.MEMBER_NO = M.NO LEFT JOIN PLAN_GRADE PG ON PG.NO = PI.GRADE_NO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<MemberVo> memberList = new ArrayList<MemberVo>();
		
		while(rs.next()) {
			String no = rs.getString("NO");
			String name = rs.getString("NAME");
			String address = rs.getString("ADDRESS");
			String email = rs.getString("EMAIL");
			String tel = rs.getString("TEL");
			String planDate = rs.getString("PLAN_DATE");
			String subGrade = rs.getString("SUB_GRADE");
			String point = rs.getString("POINT");
			String delYn = rs.getString("DEL_YN");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			
			MemberVo vo = new MemberVo();
			
			vo.setNo(no);
			vo.setName(name);
			vo.setAddress(address);
			vo.setEmail(email);
			vo.setTel(tel);
			vo.setPlanDate(planDate);
			vo.setSubGrade(subGrade);
			vo.setPoint(point);
			vo.setDelYn(delYn);
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			
			memberList.add(vo);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return memberList;
	}

	//로그인정보 상태값 갱신
	public int submitStatus(Connection conn, MemberVo vo) throws Exception {
		//sql
		String sql = "update member set del_yn=? WHERE no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getDelYn());
		pstmt.setString(2, vo.getNo());
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}

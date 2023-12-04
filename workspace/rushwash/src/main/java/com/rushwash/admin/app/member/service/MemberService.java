package com.rushwash.admin.app.member.service;

import java.sql.Connection;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.member.dao.MemberDao;
import com.rushwash.admin.app.member.vo.MemberVo;

public class MemberService {

	//member 정보조회 (일반, 로그인 동일 로직)
	public List<MemberVo> infoView() throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		MemberDao dao = new MemberDao();
		List<MemberVo> memberVoList = dao.infoView(conn);
		
		//close
		JDBCTemplate.close(conn);
		return memberVoList;
	}

}

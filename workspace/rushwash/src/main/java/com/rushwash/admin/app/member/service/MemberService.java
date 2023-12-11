package com.rushwash.admin.app.member.service;

import java.sql.Connection;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.laundry.vo.OrderVo;
import com.rushwash.admin.app.member.dao.MemberDao;
import com.rushwash.admin.app.member.vo.MemberVo;

public class MemberService {

	MemberDao dao = new MemberDao();
	//member 정보조회 (일반, 로그인 동일 로직)
	public List<MemberVo> infoView() throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		List<MemberVo> memberVoList = dao.infoView(conn);
		
		//close
		JDBCTemplate.close(conn);
		return memberVoList;
	}

	// 로그인정보 상태값 갱신
		public int submitStatus(MemberVo vo) throws Exception {
			// conn
			Connection conn = JDBCTemplate.getConnection();

			// dao
			int result = dao.submitStatus(conn, vo);

			// tx
			if (result == 1) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}

			// close
			JDBCTemplate.close(conn);

			return result;
		}
}

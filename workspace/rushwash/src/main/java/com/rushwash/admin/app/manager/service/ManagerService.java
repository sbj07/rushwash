package com.rushwash.admin.app.manager.service;

import java.sql.Connection;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.manager.dao.ManagerDao;
import com.rushwash.admin.app.manager.vo.ManagerVo;
import com.rushwash.admin.app.member.vo.MemberVo;

public class ManagerService {

	ManagerDao dao = new ManagerDao();

	public List<ManagerVo> infoView() throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		List<ManagerVo> voList = dao.infoView(conn);

		// close
		JDBCTemplate.close(conn);

		return voList;
	}

	public int regist(ManagerVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// business login
		String id = vo.getId();
		boolean idOk = id.matches("^[a-zA-Z0-9_-]{5,20}$");

		if (!idOk) {
			throw new Exception("ID는 5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
		}

		// 비밀번호 8~15자리, 특수문자 포함
		String pwd = vo.getPwd();
		boolean pwdOk = pwd.matches("^[a-zA-Z0-9~!@#$%^&*()_+|<>?:{}]{8,16}$");

		if (!pwdOk) {
			throw new Exception("비밀번호는 특수문자를 포함한 8~16자리로 설정 필요.");
		}

		// 이름은 한국어 only
		String name = vo.getName();
		boolean nameOk = name.matches("^[가-힣]+$");

		if (!nameOk) {
			throw new Exception("이름은 한국어만 사용 가능");
		}

		// 비밀번호 일치여부 체크
		if (!vo.getPwd().equals(vo.getPwd2())) {
			throw new Exception("비밀번호 재확인 불일치");
		}

		// dao
		int result = dao.regist(conn, vo);

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

	public ManagerVo login(ManagerVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		ManagerVo dbVo = dao.login(conn, vo);

		// close
		JDBCTemplate.close(conn);

		return dbVo;
	}

	public boolean checkId(String id) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		boolean isOk = dao.checkId(conn, id);

		// close
		JDBCTemplate.close(conn);

		return isOk;
	}

	// 로그인정보 상태값 갱신
	public int submitStatus(ManagerVo vo) throws Exception {
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

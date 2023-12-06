package com.rushwash.admin.app.manager.service;

import java.sql.Connection;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.manager.dao.ManagerDao;
import com.rushwash.admin.app.manager.vo.ManagerVo;

public class ManagerService {

	ManagerDao dao = new ManagerDao();
	
	public List<ManagerVo> infoView() throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		List<ManagerVo> voList = dao.infoView(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return voList;
	}

	public int regist(ManagerVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		int result = dao.regist(conn,vo);
		
		if(!vo.getPwd().equals(vo.getPwd2())) {
			throw new Exception("비밀번호 재확인 불일치");
		}
		
		//tx
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	public ManagerVo login(ManagerVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		ManagerVo dbVo = dao.login(conn, vo);
		
		//close
		JDBCTemplate.close(conn);
		
		return dbVo;
	}

}

package com.rushwash.app.board.qna.service;

import java.sql.Connection;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.app.board.qna.dao.QnaDao;
import com.rushwash.app.board.qna.vo.QnaVo;

public class QnaService {

	public int write(QnaVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		QnaDao dao = new QnaDao();
		int result = dao.write(conn, vo);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
		
	}

}

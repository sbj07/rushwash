package com.rushwash.app.board.qna.service;

import java.sql.Connection;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.page.vo.PageVo;
import com.rushwash.app.board.qna.dao.QnaDao;
import com.rushwash.app.board.qna.vo.QnaVo;

public class QnaService {

	//목록 조회
	public List<QnaVo> selectQnaList(PageVo pvo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		QnaDao dao = new QnaDao();
		List<QnaVo> boardVoList = dao.selectQnaList(conn,pvo);
		JDBCTemplate.close(conn);
		return boardVoList;
	}
	
	//전체 게시글 갯수 조회
	public int selectQnaCount() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		QnaDao dao = new QnaDao();
		int cnt = dao.selectQnaCount(conn);
		JDBCTemplate.close(conn);
		return cnt;
	}
	
	
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

	//상세조회
	public QnaVo selectQnaByNo(String no) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		QnaDao dao = new QnaDao();
		QnaVo vo = dao.selectQnaByNo(conn, no);
		
		if(vo != null) {
			JDBCTemplate.commit(conn);
		}else {
	        JDBCTemplate.rollback(conn);
     }
	
	
	//close
	JDBCTemplate.close(conn);
	
	return vo;
	}


	



}

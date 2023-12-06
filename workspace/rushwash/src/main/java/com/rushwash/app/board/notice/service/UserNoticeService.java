package com.rushwash.app.board.notice.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.page.vo.PageVo;
import com.rushwash.app.board.notice.dao.UserNoticeDao;
import com.rushwash.app.board.notice.vo.UserNoticeVo;

public class UserNoticeService {
	
	//게시글 목록 조회
	public List<UserNoticeVo> selectNoticeList(PageVo pvo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		UserNoticeDao dao = new UserNoticeDao();
		List<UserNoticeVo> boardVoList = dao.selectBoardList(conn, pvo);
		
		//close
		JDBCTemplate.close(conn);
		
		return boardVoList;
	}

	public int selectNoticeCount() throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		UserNoticeDao dao = new UserNoticeDao();
		int cnt = dao.selectBoardCount(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
		
		
	}

	//공지사항 상세조회
	public UserNoticeVo selectNoticeByNo(String no) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		UserNoticeDao dao = new UserNoticeDao();
		UserNoticeVo vo = dao.selectBoardByNo(conn, no);
		
		//tx
		 if (vo != null) {
		        JDBCTemplate.commit(conn);
		 } else {
		        JDBCTemplate.rollback(conn);
	     }
		
		
		//close
		JDBCTemplate.close(conn);
		
		return vo;
	}

	
	
	//게시글 검색
	public List<UserNoticeVo> search(Map<String, String> m, PageVo pvo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	//게시글 갯수조회
	public int selectSearchNoticeCount(Map<String, String> m) throws Exception {

		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		UserNoticeDao dao = new UserNoticeDao();
		int cnt = dao.getNoticeCountBySearch(conn,m);
		
		//close
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	



}

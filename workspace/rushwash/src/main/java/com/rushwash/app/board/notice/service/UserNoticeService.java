package com.rushwash.app.board.notice.service;

import java.sql.Connection;
import java.util.List;

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
		
		//close
	}



}

package com.rushwash.admin.app.board.notice.service;

import java.sql.Connection;
import java.util.List;

import com.rushwash.admin.app.board.notice.dao.NoticeDao;
import com.rushwash.admin.app.board.notice.vo.NoticeVo;
import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.page.vo.PageVo;



public class NoticeService {
	
	// 게시글 목록 조회
	public List<NoticeVo> selectNoticeList(PageVo pvo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		NoticeDao dao = new NoticeDao();
		List<NoticeVo> NoticeVoList = dao.selectNoticeList(conn, pvo);
		
		// close
		JDBCTemplate.close(conn);
		
		return NoticeVoList;
	}
	
	// 전체 게시글 갯수 조회
	public int selectNoticeCount() throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		NoticeDao dao = new NoticeDao();
		int cnt = dao.selectNoticeCount(conn);
		
		// close
		JDBCTemplate.close(conn);
		
		return cnt;
		
	}//selectNoticeCount
	
	
	//공지사항 상세조회
	public NoticeVo selectNoticeByNo(String no) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		NoticeDao dao = new NoticeDao();
		NoticeVo vo = null;
		vo = dao.selectNoticeByNo(conn , no);
		
		
		// tx
//		if(result == 1) {
//			JDBCTemplate.commit(conn);
//		}else {
//			JDBCTemplate.rollback(conn);
//		}
		
		// close
		JDBCTemplate.close(conn);
		
		return vo;
	}
	
	//게시글 삭제
		public int delete(String no) throws Exception {
			//conn
			Connection conn = JDBCTemplate.getConnection();
			
			//dao
			NoticeDao dao = new NoticeDao();
			int result = dao.delete(conn , no);
			
			//tx
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			//close
			JDBCTemplate.close(conn);

			return result;
		}//delete
		
		
		//게시글 작성
		public int write(NoticeVo vo) throws Exception {
			
			// conn
			Connection conn = JDBCTemplate.getConnection();
			
			// dao
			NoticeDao dao = new NoticeDao();
			int result = dao.write(conn, vo);
			
			// tx
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			// close
			JDBCTemplate.close(conn);
			
			return result;
		}
	
}

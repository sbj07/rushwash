package com.rushwash.admin.app.board.faq.service;

import java.sql.Connection;
import java.util.List;

import com.rushwash.admin.app.board.faq.dao.FaqDao;
import com.rushwash.admin.app.board.faq.vo.FaqVo;
import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.page.vo.PageVo;

public class FaqService {
	// 게시글 목록 조회
		public List<FaqVo> selectFaqList(PageVo pvo) throws Exception {
			
			// conn
			Connection conn = JDBCTemplate.getConnection();
			
			// dao
			FaqDao dao = new FaqDao();
			List<FaqVo> FaqVoList = dao.selectFaqList(conn, pvo);
			
			// close
			JDBCTemplate.close(conn);
			
			return FaqVoList;
		}
		
		// 전체 게시글 갯수 조회
		public int selectFaqCount() throws Exception {
			
			// conn
			Connection conn = JDBCTemplate.getConnection();
			
			// dao
			FaqDao dao = new FaqDao();
			int cnt = dao.selectFaqCount(conn);
			
			// close
			JDBCTemplate.close(conn);
			
			return cnt;
			
		}//selectNoticeCount
		
		
		//공지사항 상세조회
		public FaqVo selectFaqByNo(String no) throws Exception {
			
			// conn
			Connection conn = JDBCTemplate.getConnection();
			
			// dao
			FaqDao dao = new FaqDao();
			FaqVo vo = null;
			vo = dao.selectFaqByNo(conn, no);
			
			
			// tx
//			if(result == 1) {
//				JDBCTemplate.commit(conn);
//			}else {
//				JDBCTemplate.rollback(conn);
//			}
			
			// close
			JDBCTemplate.close(conn);
			
			return vo;
		}
		
		//게시글 삭제
			public int delete(String no) throws Exception {
				//conn
				Connection conn = JDBCTemplate.getConnection();
				
				//dao
				FaqDao dao = new FaqDao();
				int result = dao.delete(conn, no);
				
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
			public int write(FaqVo vo) throws Exception {
				
				// conn
				Connection conn = JDBCTemplate.getConnection();
				
				// dao
				FaqDao dao = new FaqDao();
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

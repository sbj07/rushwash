package com.rushwash.admin.app.board.faq.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rushwash.admin.app.board.faq.dao.FaqDao;
import com.rushwash.admin.app.board.faq.vo.FaqVo;
import com.rushwash.admin.app.board.notice.dao.NoticeDao;
import com.rushwash.admin.app.board.notice.vo.NoticeVo;
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

			// 게시글 수정 (화면)
			public Map<String, Object> edit(String no) throws Exception {
				
				// conn
				Connection conn = JDBCTemplate.getConnection();
				
				// dao
				FaqDao dao = new FaqDao();
				FaqVo vo = dao.selectFaqByNo(conn , no);
				
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("vo", vo);
				
				// close
				JDBCTemplate.close(conn);
				
				return m;
			}
			
			
			//게시글 수정
			public int edit(FaqVo vo, String no) throws Exception {
				
				//conn
				Connection conn = JDBCTemplate.getConnection();
				
				//dao
				FaqDao dao = new FaqDao();
				int result = dao.updateFaqByNo(conn , vo, no);
				
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
			
			// 게시글 검색
			public List<FaqVo> search(Map<String, String> m , PageVo pvo) throws Exception {
				// conn
				Connection conn = JDBCTemplate.getConnection();
				
				// DAO
				FaqDao dao = new FaqDao();
				List<FaqVo> FaqVoList = dao.search(conn , m, pvo);
				
				//close
				JDBCTemplate.close(conn);
				
				return FaqVoList;
			}
		
			// 게시글 갯수 조회 (검색값에 따라)
			public int selectSearchFaqCount(Map<String, String> m) throws Exception {
				
				// conn
				Connection conn = JDBCTemplate.getConnection();
				
				// DAO
				FaqDao dao = new FaqDao();
				int cnt = dao.getFaqCountBySearch(conn , m);
				
				// close
				JDBCTemplate.close(conn);
				
				return cnt;
			}
}

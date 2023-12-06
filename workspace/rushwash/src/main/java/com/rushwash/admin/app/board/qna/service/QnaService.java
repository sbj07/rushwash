package com.rushwash.admin.app.board.qna.service;

import java.sql.Connection;
import java.util.List;

import com.rushwash.admin.app.board.qna.dao.QnaDao;
import com.rushwash.admin.app.board.qna.vo.QnaVo;
import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.page.vo.PageVo;

public class QnaService {
	// 게시글 목록 조회
		public List<QnaVo> selectQnaList(PageVo pvo) throws Exception {
			
			// conn
			Connection conn = JDBCTemplate.getConnection();
			
			// dao
			QnaDao dao = new QnaDao();
			List<QnaVo> FaqVoList = dao.selectQnaList(conn, pvo);
			
			// close
			JDBCTemplate.close(conn);
			
			return FaqVoList;
		}
		
		// 전체 게시글 갯수 조회
		public int selectQnaCount() throws Exception {
			
			// conn
			Connection conn = JDBCTemplate.getConnection();
			
			// dao
			QnaDao dao = new QnaDao();
			int cnt = dao.selectQnaCount(conn);
			
			// close
			JDBCTemplate.close(conn);
			
			return cnt;
			
		}//selectNoticeCount
		
		
		//공지사항 상세조회
		public QnaVo selectQnaByNo(String no) throws Exception {
			
			// conn
			Connection conn = JDBCTemplate.getConnection();
			
			// dao
			QnaDao dao = new QnaDao();
			QnaVo vo = null;
			vo = dao.selectQnaByNo(conn, no);
			
			
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
			QnaDao dao = new QnaDao();
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
		
		//댓글 삭제
				public int cmmtDelete(String no) throws Exception {
					//conn
					Connection conn = JDBCTemplate.getConnection();
					
					//dao
					QnaDao dao = new QnaDao();
					int result = dao.commtDelete(conn, no);
					
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
		public int write(QnaVo vo) throws Exception {
			
			// conn
			Connection conn = JDBCTemplate.getConnection();
			
			// dao
			QnaDao dao = new QnaDao();
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

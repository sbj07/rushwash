package com.rushwash.admin.app.board.qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rushwash.admin.app.board.notice.vo.NoticeVo;
import com.rushwash.admin.app.board.qna.vo.QnaVo;
import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.page.vo.PageVo;

public class QnaDao {
	
		//게시글 목록 조회
	   public List<QnaVo> selectQnaList(Connection conn, PageVo pvo) throws Exception{
	      
	      //SQL
	      String sql = "SELECT * FROM( SELECT ROWNUM RNUM, T.* FROM ( SELECT N.NO, N.TITLE , N.CONTENT , N.COMMT, M.MANAGER_ID , N.DEL_YN, N.ENROLL_DATE , N.SECRET_YN, ME.ID FROM QNA N JOIN MANAGER M ON N.MANAGER_NO = M.NO JOIN MEMBER ME ON N.MEMBER_NO = ME.NO WHERE N.DEL_YN = 'N' ORDER BY NO DESC) T) WHERE RNUM BETWEEN ? AND ?";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setInt(1, pvo.getStartRow());
	      pstmt.setInt(2, pvo.getLastRow());
	      ResultSet rs = pstmt.executeQuery();
	      
	      //rs
	      List<QnaVo> QnaVoList = new ArrayList<QnaVo>();
	      while(rs.next()) {
	         
	         String no = rs.getString("NO");
	         String memberId = rs.getString("ID");
	         String managerId = rs.getString("MANAGER_ID");
	         String title = rs.getString("TITLE");
	         String content = rs.getString("CONTENT");
	         String delYn = rs.getString("DEL_YN");
	         String enrollDate = rs.getString("ENROLL_DATE");
	         String secretYn = rs.getString("SECRET_YN");
	         
	         
	         
	         QnaVo vo = new QnaVo();
	         vo.setNo(no);
	         vo.setMemberId(memberId);
	         vo.setManagerId(managerId);
	         vo.setTitle(title);
	         vo.setContent(content);
	         vo.setDelYn(delYn);
	         vo.setEnrollDate(enrollDate);
	         vo.setSecretYn(secretYn);
	         
	         QnaVoList.add(vo);
	         
	      }
	      
	      
	      //close
	      JDBCTemplate.close(pstmt);
	      JDBCTemplate.close(rs);
	      
	      return QnaVoList;
	   }
	   
	   
	   public int selectQnaCount(Connection conn) throws Exception{
		      
	      //SQL
	      String sql = "SELECT COUNT(*) as cnt FROM QNA WHERE DEL_YN = 'N'";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      
	      ResultSet rs = pstmt.executeQuery();
	      
	      //rs
	      int cnt = 0;
	      if(rs.next()) {
//			         int cnt = rs.getInt("cnt");
	         cnt = rs.getInt(1); //첫번째 열을 가져오겠다 라는 뜻, 계산에 써야되기 때문에 String이 아닌 Int로 받아줌
	      }
	      
	      //close
	      JDBCTemplate.close(rs);
	      JDBCTemplate.close(pstmt);
	      
	      return cnt;
	         
	   }

	   //게시글 번호로 게시글 1개 조회
	   public QnaVo selectQnaByNo(Connection conn, String no) throws Exception{
	      
	      //SQL
	      String sql = "SELECT N.NO, N.TITLE, N.CONTENT, M.MANAGER_ID, N.ENROLL_DATE, ME.ID, N.COMMT FROM QNA N JOIN MANAGER M ON N.MANAGER_NO = M.NO JOIN MEMBER ME ON N.MEMBER_NO = ME.NO WHERE N.NO = ?";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, no);
	      ResultSet rs = pstmt.executeQuery();
	      
	      //rs
	      QnaVo vo = null;
	      if(rs.next()) {
	    	 no = rs.getString("NO");
			 String managerId = rs.getString("MANAGER_ID");
			 String title = rs.getString("TITLE");
			 String content = rs.getString("CONTENT");
			 String enrollDate = rs.getString("ENROLL_DATE");
			 String memberId = rs.getString("ID");
			 String commt = rs.getString("COMMT");
	         
	         vo = new QnaVo();
	         vo.setNo(no);
	         vo.setManagerId(managerId);
	         vo.setTitle(title);
	         vo.setContent(content);
	         vo.setEnrollDate(enrollDate);
	         vo.setMemberId(memberId);
	         vo.setCommt(commt);
	         
	      }
	      //close
	      JDBCTemplate.close(rs);
	      JDBCTemplate.close(pstmt);
	      return vo;
	   }
	   
	   	//게시글 삭제
	   	public int delete(Connection conn, String no) throws Exception {
	      
	      //SQL
	      String sql = "UPDATE QNA SET DEL_YN = 'Y' WHERE NO = ?";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, no);
	      int result = pstmt.executeUpdate();
	      
	      //close
	      JDBCTemplate.close(pstmt);
	      
	      return result;
	   }//delete
	   
	   //댓글 작성
		public int write(Connection conn, QnaVo vo, String no) throws Exception {
			//SQL
		      String sql = "UPDATE QNA SET COMMT = ?, MANAGER_NO = (SELECT m.NO FROM MANAGER m WHERE m.MANAGER_ID = ?), ENROLL_DATE = SYSDATE WHERE NO = ?";
		      PreparedStatement pstmt = conn.prepareStatement(sql);
		      pstmt.setString(1, vo.getCommt());
		      pstmt.setString(2, vo.getManagerId());
		      pstmt.setString(3, no);
		      int result = pstmt.executeUpdate();
		      //close
		      JDBCTemplate.close(pstmt);
		      return result;
		      
		}
		
		//댓글삭제
		public int commtDelete(Connection conn, String no) throws Exception {
			//SQL
		      String sql = "UPDATE QNA SET COMMT = '' WHERE NO = ?";
		      PreparedStatement pstmt = conn.prepareStatement(sql);
		      pstmt.setString(1, no);
		      int result = pstmt.executeUpdate();
		      
		      //close
		      JDBCTemplate.close(pstmt);
		      
		      return result;
		   }//cmmtDelete
		
		//게시글 검색
		public List<QnaVo> search(Connection conn, Map<String, String> m , PageVo pvo) throws Exception {
			
			String searchType = m.get("searchType");
			
			// SQL
			String sql = "SELECT * FROM( SELECT ROWNUM RNUM, T.* FROM ( SELECT N.NO, N.TITLE , N.CONTENT , N.COMMT, M.MANAGER_ID , N.ENROLL_DATE , N.DEL_YN, N.SECRET_YN, ME.ID FROM QNA N JOIN MANAGER M ON N.MANAGER_NO = M.NO JOIN MEMBER ME ON N.MEMBER_NO = ME.NO WHERE N.DEL_YN = 'N' AND  " + searchType + "  LIKE '%' || ?|| '%' ORDER BY NO DESC) T) WHERE RNUM BETWEEN ? AND ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.get("searchValue"));
			pstmt.setInt(2, pvo.getStartRow());
			pstmt.setInt(3, pvo.getLastRow());
			ResultSet rs = pstmt.executeQuery();
			
			
			//rs
		      List<QnaVo> QnaVoList = new ArrayList<QnaVo>();
		      while(rs.next()) {
		         
		         String no = rs.getString("NO");
		         String memberId = rs.getString("ID");
		         String managerId = rs.getString("MANAGER_ID");
		         String title = rs.getString("TITLE");
		         String content = rs.getString("CONTENT");
		         String delYn = rs.getString("DEL_YN");
		         String enrollDate = rs.getString("ENROLL_DATE");
		         String secretYn = rs.getString("SECRET_YN");
		         
		         
		         
		         QnaVo vo = new QnaVo();
		         vo.setNo(no);
		         vo.setMemberId(memberId);
		         vo.setManagerId(managerId);
		         vo.setTitle(title);
		         vo.setContent(content);
		         vo.setDelYn(delYn);
		         vo.setEnrollDate(enrollDate);
		         vo.setSecretYn(secretYn);
		         
		         QnaVoList.add(vo);
		         System.out.println("검색결과 : "+vo);
		      }
		      
		
			// close
		    JDBCTemplate.close(rs);
		    JDBCTemplate.close(pstmt);
		      
		    return QnaVoList;
		}

		// 게시글 갯수 조회 (검색값에 따라)
		public int getQnaCountBySearch(Connection conn, Map<String, String> m) throws Exception {
			
			// SQL
			String sql = "SELECT COUNT(*) FROM QNA WHERE DEL_YN = 'N' AND " + m.get("searchType") + " LIKE '%' || ? || '%'";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.get("searchValue"));
			System.out.println(m);
			ResultSet rs = pstmt.executeQuery();
			
			// rs
			int cnt = 0;
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			
			// close
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
			return cnt;
		}
		
	}
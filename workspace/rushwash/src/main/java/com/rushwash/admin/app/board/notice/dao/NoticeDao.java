package com.rushwash.admin.app.board.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rushwash.admin.app.board.notice.vo.NoticeVo;
import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.page.vo.PageVo;


public class NoticeDao {
	//게시글 목록 조회
	   public List<NoticeVo> selectNoticeList(Connection conn, PageVo pvo) throws Exception{
	      
	      //SQL
	      String sql = "SELECT * FROM( SELECT ROWNUM RNUM, T.* FROM ( SELECT N.NO, N.TITLE , N.CONTENT , M.MANAGER_ID , N.ENROLL_DATE FROM NOTICE N JOIN MANAGER M ON N.MANAGER_NO = M.NO WHERE N.DEL_YN = 'N' ORDER BY NO DESC) T) WHERE RNUM BETWEEN ? AND ?";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setInt(1, pvo.getStartRow());
	      pstmt.setInt(2, pvo.getLastRow());
	      ResultSet rs = pstmt.executeQuery();
	      
	      //rs
	      List<NoticeVo> NoticeVoList = new ArrayList<NoticeVo>();
	      while(rs.next()) {
	         
	         String no = rs.getString("NO");
	         String managerId = rs.getString("MANAGER_ID");
	         String title = rs.getString("TITLE");
	         String content = rs.getString("CONTENT");
	         String enrollDate = rs.getString("ENROLL_DATE");
	         
	         
	         
	         NoticeVo vo = new NoticeVo();
	         vo.setNo(no);
	         vo.setManagerId(managerId);
	         vo.setTitle(title);
	         vo.setContent(content);
	         vo.setEnrollDate(enrollDate);
	         
	         NoticeVoList.add(vo);
	         
	      }
	      
	      
	      //close
	      JDBCTemplate.close(pstmt);
	      JDBCTemplate.close(rs);
	      
	      return NoticeVoList;
	   }
	   
	   public int selectNoticeCount(Connection conn) throws Exception{
		      
	      //SQL
	      String sql = "SELECT COUNT(*) as cnt FROM NOTICE WHERE DEL_YN = 'N'";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      
	      ResultSet rs = pstmt.executeQuery();
	      
	      //rs
	      int cnt = 0;
	      if(rs.next()) {
//		         int cnt = rs.getInt("cnt");
	         cnt = rs.getInt(1); //첫번째 열을 가져오겠다 라는 뜻, 계산에 써야되기 때문에 String이 아닌 Int로 받아줌
	      }
	      
	      //close
	      JDBCTemplate.close(rs);
	      JDBCTemplate.close(pstmt);
	      
	      return cnt;
	         
	   }

	 //게시글 번호로 게시글 1개 조회
	   public NoticeVo selectNoticeByNo(Connection conn, String no) throws Exception{
	      
	      //SQL
	      String sql = "SELECT N.NO, N.TITLE, N.CONTENT, M.MANAGER_ID, N.ENROLL_DATE FROM NOTICE N JOIN MANAGER M ON N.MANAGER_NO = M.NO WHERE N.NO = ?";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, no);
	      ResultSet rs = pstmt.executeQuery();
	      
	      //rs
	      NoticeVo vo = null;
	      if(rs.next()) {
	    	 no = rs.getString("NO");
			 String managerId = rs.getString("MANAGER_ID");
			 String title = rs.getString("TITLE");
			 String content = rs.getString("CONTENT");
			 String enrollDate = rs.getString("ENROLL_DATE");
	         
	         vo = new NoticeVo();
	         vo.setNo(no);
	         vo.setManagerId(managerId);
	         vo.setTitle(title);
	         vo.setContent(content);
	         vo.setEnrollDate(enrollDate);
	         
	      }
	      //close
	      JDBCTemplate.close(rs);
	      JDBCTemplate.close(pstmt);
	      return vo;
	   }
	   
	 //게시글 삭제
	   public int delete(Connection conn, String no) throws Exception {
	      
	      //SQL
	      String sql = "UPDATE NOTICE SET DEL_YN = 'Y' WHERE NO = ?";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, no);
	      int result = pstmt.executeUpdate();
	      
	      //close
	      JDBCTemplate.close(pstmt);
	      
	      return result;
	   }//delete

	public int write(Connection conn, NoticeVo vo) throws Exception {
		//SQL
	      String sql = "INSERT INTO NOTICE (NO, TITLE, CONTENT, MANAGER_NO, ENROLL_DATE) VALUES ( SEQ_NOTICE_NO.NEXTVAL, ?, ?, 2, SYSDATE)";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
//	      pstmt.setString(1, vo.getNo());
	      pstmt.setString(1, vo.getTitle());
	      pstmt.setString(2, vo.getContent());
//	      pstmt.setString(4, vo.getManagerNo());
	      int result = pstmt.executeUpdate();
	      
	      //close
	      JDBCTemplate.close(pstmt);
	      return result;
	      
	}  
}
	

	   

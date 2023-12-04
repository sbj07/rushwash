package com.rushwash.admin.app.board.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rushwash.admin.app.board.notice.vo.NoticeVo;
import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.page.vo.PageVo;


public class NoticeDao {
	//게시글 목록 조회
	   public List<NoticeVo> selectNoticeList(Connection conn, PageVo pvo) throws Exception{
	      
	      //SQL
	      String sql = "SELECT * FROM( SELECT ROWNUM RNUM, T.* FROM ( SELECT N.NO, N.TITLE, N.CONTENT, N.ADMIN_NO, N.ENROLL_DATE FROM NOTICE N WHERE N.DEL_YN = 'N' ORDER BY NO DESC) T) WHERE RNUM BETWEEN ? AND ?";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setInt(1, pvo.getStartRow());
	      pstmt.setInt(2, pvo.getLastRow());
	      ResultSet rs = pstmt.executeQuery();
	      
	      //rs
	      List<NoticeVo> NoticeVoList = new ArrayList<NoticeVo>();
	      while(rs.next()) {
	         
	         String no = rs.getString("NO");
	         String adminNo = rs.getString("ADMIN_NO");
	         String title = rs.getString("TITLE");
	         String content = rs.getString("CONTENT");
	         String enrollDate = rs.getString("ENROLL_DATE");
	         
	         
	         
	         NoticeVo vo = new NoticeVo();
	         vo.setNo(no);
	         vo.setAdminNo(adminNo);
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
	      String sql = "SELECT NO, TITLE, CONTENT, ADMIN_NO, ENROLL_DATE FROM NOTICE WHERE NO = ?";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, no);
	      ResultSet rs = pstmt.executeQuery();
	      
	      //rs
	      NoticeVo vo = null;
	      if(rs.next()) {
	    	 no = rs.getString("NO");
			 String adminNo = rs.getString("ADMIN_NO");
			 String title = rs.getString("TITLE");
			 String content = rs.getString("CONTENT");
			 String enrollDate = rs.getString("ENROLL_DATE");
	         
	         vo = new NoticeVo();
	         vo.setNo(no);
	         vo.setAdminNo(adminNo);
	         vo.setTitle(title);
	         vo.setContent(content);
	         vo.setEnrollDate(enrollDate);
	         
	      }
	      //close
	      JDBCTemplate.close(rs);
	      JDBCTemplate.close(pstmt);
	      return vo;
	   }

	   
}
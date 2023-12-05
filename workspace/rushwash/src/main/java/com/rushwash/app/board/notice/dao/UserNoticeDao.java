package com.rushwash.app.board.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.page.vo.PageVo;
import com.rushwash.app.board.notice.vo.UserNoticeVo;

public class UserNoticeDao {

	//게시글 목록 조회
	public List<UserNoticeVo> selectBoardList(Connection conn, PageVo pvo) throws Exception {
	
		//sql
		String sql = "SELECT NO, TITLE, CONTENT, ENROLL_DATE, DEL_YN FROM ( SELECT TITLE, CONTENT, ENROLL_DATE, DEL_YN FROM NOTICE WHERE DEL_YN = 'N' ORDER BY ENROLL_DATE DESC ) WHERE ROWNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pvo.getStartRow());
		pstmt.setInt(2, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<UserNoticeVo> boardVoList = new ArrayList<UserNoticeVo>();
		while(rs.next()) {
			
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String delYn = rs.getString("DEL_YN");
			
			UserNoticeVo vo = new UserNoticeVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setDelYn(delYn);
			
			boardVoList.add(vo);
		}
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return boardVoList;
	
	}

	public int selectBoardCount(Connection conn) throws Exception {
		String sql = "";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt(1);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cnt;
		
	}

}

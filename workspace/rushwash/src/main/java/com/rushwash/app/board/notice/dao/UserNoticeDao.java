package com.rushwash.app.board.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.page.vo.PageVo;
import com.rushwash.app.board.notice.vo.UserNoticeVo;

public class UserNoticeDao {

	//게시글 목록 조회
	public List<UserNoticeVo> selectBoardList(Connection conn, PageVo pvo) throws Exception {
	
		//sql
		String sql = "SELECT * FROM( SELECT ROWNUM RNUM, T.* FROM ( SELECT N.NO, N.TITLE , N.CONTENT , M.MANAGER_ID , N.ENROLL_DATE, N.DEL_YN FROM NOTICE N JOIN MANAGER M ON N.MANAGER_NO = M.NO WHERE N.DEL_YN = 'N' ORDER BY NO DESC) T) WHERE RNUM BETWEEN ? AND ?";
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
		String sql = "SELECT COUNT(*) AS cnt FROM NOTICE WHERE DEL_YN = 'N'";
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

	//공지사항 상세조회
	public UserNoticeVo selectBoardByNo(Connection conn, String no) throws Exception {
		//sql
		String sql = " SELECT B.NO, B.TITLE ,B.CONTENT ,B.ENROLL_DATE, M.MANAGER_ID FROM NOTICE B JOIN MANAGER M ON B.MANAGER_NO = M.NO WHERE M.NO = ? AND B.DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "2");
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		UserNoticeVo vo = null;
		if(rs.next()) {
			no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String managerId = rs.getString("MANAGER_ID");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			vo = new UserNoticeVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setManagerId(managerId);
			vo.setEnrollDate(enrollDate);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}

	public int getNoticeCountBySearch(Connection conn, Map<String, String> m) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}

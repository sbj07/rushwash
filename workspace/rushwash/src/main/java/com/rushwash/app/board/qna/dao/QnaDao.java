package com.rushwash.app.board.qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.page.vo.PageVo;
import com.rushwash.app.board.qna.vo.QnaVo;

public class QnaDao {

	//게시글작성
	public int write(Connection conn, QnaVo vo) throws Exception{
		
		//sql
		String sql = "INSERT INTO QNA(NO, MANAGER_NO, MEMBER_NO, TITLE, CONTENT, SECRET_YN, DEL_YN, ENROLL_DATE)VALUES(SEQ_QNA_NO.NEXTVAL, 1, ?, ?, ?, 'Y', 'N', SYSDATE)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberNo());
		pstmt.setString(2, vo.getTitle());
		pstmt.setString(3, vo.getContent());
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		return result;
	}

	//게시글 목록 조회
	public List<QnaVo> selectQnaList(Connection conn, PageVo pvo) throws Exception {
		
		String sql = "SELECT * FROM( SELECT ROWNUM RNUM, T.* FROM ( SELECT N.NO, N.TITLE , N.CONTENT , N.COMMT, M.MANAGER_ID , N.ENROLL_DATE, N.DEL_YN FROM QNA N JOIN MANAGER M ON N.MANAGER_NO = M.NO WHERE N.DEL_YN = 'N' ORDER BY NO DESC) T) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pvo.getStartRow());
		pstmt.setInt(2, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<QnaVo> boardVoList = new ArrayList<QnaVo>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String commt = rs.getString("COMMT");
			String managerId = rs.getString("MANAGER_ID");
			String enrollDate = rs.getString("ENROLL_DATE");
			String delYn = rs.getString("DEL_YN");
			
			QnaVo vo = new QnaVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setCommt(commt);
			vo.setManagerId(managerId);
			vo.setEnrollDate(enrollDate);
			vo.setDelYn(delYn);
			
			boardVoList.add(vo);
		}
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return boardVoList;
		
	}

	public int selectQnaCount(Connection conn) throws Exception {
		
		String sql = "SELECT COUNT(*) AS cnt FROM QNA WHERE DEL_YN = 'N'";
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

	public QnaVo selectQnaByNo(Connection conn, String no) throws Exception {
		 
		String sql = "";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		QnaVo vo = null;
		if(rs.next()) {
			String title = rs.getString();
		}
	}

}

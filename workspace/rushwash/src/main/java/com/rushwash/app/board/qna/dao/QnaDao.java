package com.rushwash.app.board.qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.rushwash.admin.app.db.util.JDBCTemplate;
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

}

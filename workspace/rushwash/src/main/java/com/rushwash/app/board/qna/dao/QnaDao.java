package com.rushwash.app.board.qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.page.vo.PageVo;
import com.rushwash.app.board.qna.vo.QnaVo;

import oracle.jdbc.proxy.annotation.Pre;

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
public List<QnaVo> selectQnaList(Connection conn, PageVo pvo, String memberNo) throws Exception {
		
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.NO, T.TITLE, T.CONTENT, T.COMMT, T.MANAGER_ID, T.MEMBER_NO, TO_CHAR(T.ENROLL_DATE , 'YYYY\"년\"MM\"월\"DD\"일\"') AS ENROLL_DATE, T.MODIFY_DATE, T.DEL_YN FROM ( SELECT N.NO, N.TITLE, N.CONTENT, N.COMMT, M.MANAGER_ID, N.MEMBER_NO, N.ENROLL_DATE, N.MODIFY_DATE, N.DEL_YN FROM QNA N JOIN MEMBER B ON N.MEMBER_NO = B.NO JOIN MANAGER M ON N.MANAGER_NO = M.NO WHERE N.DEL_YN = 'N' AND N.MEMBER_NO = ? ORDER BY NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
	    pstmt.setInt(2, pvo.getStartRow());
	    pstmt.setInt(3, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<QnaVo> boardVoList = new ArrayList<QnaVo>();
		while(rs.next()) {
			
			QnaVo vo = new QnaVo();
			
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String commt = rs.getString("COMMT");
			String managerId = rs.getString("MANAGER_ID");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String delYn = rs.getString("DEL_YN");
			
			
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setCommt(commt);
			vo.setManagerId(managerId);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setDelYn(delYn);
			vo.setMemberNo(memberNo);;
			
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
		 
		String sql = "SELECT B.NO ,B.CONTENT ,B.TITLE,  TO_CHAR(B.ENROLL_DATE , 'YYYY\"년\"MM\"월\"DD\"일\"') AS ENROLL_DATE , B.DEL_YN ,B.MODIFY_DATE, B.COMMT, M.MANAGER_ID FROM QNA B JOIN MANAGER M ON B.MANAGER_NO = M.NO WHERE B.NO = ? AND B.DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		System.out.println("dao's no : " + no);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		QnaVo vo = null;
		if(rs.next()) {
			String content = rs.getString("CONTENT");
			String title = rs.getString("TITLE");
//			String memberNo = rs.getString("MEMBER_NO");
			String enrollDate = rs.getString("ENROLL_DATE");
			String delYn = rs.getString("DEL_YN");
			String modifyDate = rs.getString("MODIFY_DATE");
			String commt = rs.getString("COMMT");
			String managerId = rs.getString("MANAGER_ID");
			
			vo = new QnaVo();
			vo.setNo(no);
			vo.setContent(content);
			vo.setTitle(title);
//			vo.setMemberNo(memberNo);
			vo.setEnrollDate(enrollDate);
			vo.setDelYn(delYn);
			vo.setModifyDate(modifyDate);
			vo.setCommt(commt);
			vo.setManagerId(managerId);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}

	//게시글 수정
	public int updateBoardByNo(Connection conn, QnaVo vo) throws Exception {
		
		String sql = "UPDATE QNA SET TITLE = ? , CONTENT = ? , MODIFY_DATE = SYSDATE WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getNo());
		int result = pstmt.executeUpdate();

		JDBCTemplate.close(pstmt);
		
		return result;
	}

	//게시글 삭제
	public int delete(Connection conn, String no, String memberNo) throws Exception {
		
		String sql = "UPDATE QNA SET DEL_YN = 'Y' WHERE NO = ? AND MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		pstmt.setString(2, memberNo);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}
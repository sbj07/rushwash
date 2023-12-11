package com.rushwash.app.board.faq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.page.vo.PageVo;
import com.rushwash.app.board.faq.vo.FaqVo;
import com.rushwash.app.board.notice.vo.UserNoticeVo;

public class FaqDao {

	public List<FaqVo> selectFaqList(Connection conn, PageVo pvo) throws Exception {
		
		String sql = "SELECT * FROM( SELECT ROWNUM RNUM, T.* FROM ( SELECT N.NO, N.TITLE , N.CONTENT , M.MANAGER_ID ,TO_CHAR(N.ENROLL_DATE , 'YYYY\"년 \"MM\"월 \"DD\"일\"') AS ENROLL_DATE, N.DEL_YN FROM FAQ N JOIN MANAGER M ON N.MANAGER_NO = M.NO WHERE N.DEL_YN = 'N' ORDER BY NO DESC) T) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pvo.getStartRow());
		pstmt.setInt(2, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<FaqVo> faqVoList = new ArrayList<FaqVo>();
		while(rs.next()) {
			
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String delYn = rs.getString("DEL_YN");
			
			FaqVo vo = new FaqVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setDelYn(delYn);
			
			faqVoList.add(vo);
		}
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return faqVoList;
	
	
	}

}

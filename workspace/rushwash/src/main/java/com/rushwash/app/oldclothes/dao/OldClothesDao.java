package com.rushwash.app.oldclothes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rushwash.admin.app.db.util.JDBCTemplate;

public class OldClothesDao {
	
	public int putOldClothes(Connection conn , String memberNo) throws Exception {
		String sql = "INSERT INTO OLD_CLOTHES ( NO , MEMBER_NO , REQUSET_CODE , REQUEST_DATE ) VALUES ( SEQ_OLD_CLOTHES_NO.NEXTVAL , ? , 1 , SYSDATE )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		return result;
	}
}

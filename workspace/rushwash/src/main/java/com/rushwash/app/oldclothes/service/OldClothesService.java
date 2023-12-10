package com.rushwash.app.oldclothes.service;

import java.sql.Connection;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.app.oldclothes.dao.OldClothesDao;

public class OldClothesService {
	
	public int putOldClothes(String memberNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		OldClothesDao dao = new OldClothesDao();
		int result = dao.putOldClothes(conn, memberNo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
}

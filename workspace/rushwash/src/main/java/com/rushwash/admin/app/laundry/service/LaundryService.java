package com.rushwash.admin.app.laundry.service;

import java.sql.Connection;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.laundry.dao.LaundryDao;
import com.rushwash.admin.app.laundry.vo.LaundryVo;

public class LaundryService {
	
	LaundryDao dao = new LaundryDao();
	
	//리스트 불러오기
	public List<LaundryVo> getLaundryList() throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		List<LaundryVo> voList = dao.getLaundryList(conn);

		//close
		JDBCTemplate.close(conn);
		
		return voList;
	}

	//상태값 갱신
	public int submitStatus(LaundryVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		int result = dao.submitStatus(conn,vo);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

}

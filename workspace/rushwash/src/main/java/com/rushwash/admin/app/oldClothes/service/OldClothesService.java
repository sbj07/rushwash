package com.rushwash.admin.app.oldClothes.service;

import java.sql.Connection;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.laundry.vo.LaundryVo;
import com.rushwash.admin.app.oldClothes.dao.OldClothesDao;
import com.rushwash.admin.app.oldClothes.vo.OldClothesVo;

public class OldClothesService {
	
	OldClothesDao dao = new OldClothesDao();
	
	public List<OldClothesVo> getOldClothesList() throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		
		List<OldClothesVo> voList = dao.getOldClothesList(conn);
		
		
		//close
		JDBCTemplate.close(conn);
		
		return voList;
	}
	//상태값 갱신
	public int submitStatus(OldClothesVo vo) throws Exception {
	    //conn
	    Connection conn = JDBCTemplate.getConnection();

	   
	        //dao
	        int[] result = dao.submitStatus(conn, vo);

	        

	        //close
	        JDBCTemplate.close(conn);
	    
	        return result[0];
	}
	 
}
	




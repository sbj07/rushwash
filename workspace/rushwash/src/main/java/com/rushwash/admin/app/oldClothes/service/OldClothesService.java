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
	public String getUpdatedCollect(String no) throws Exception 
	{
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		String endDate = dao.getUpdatedCollect(conn, no);
		
		// close
		JDBCTemplate.close(conn);
				
		return endDate;
	}
	
	// 무게 값 업데이트하고 가져오기
    public String updateWeight(String no, String weight) throws Exception {
        // conn
        Connection conn = JDBCTemplate.getConnection();

        try {
            // dao
            String updatedWeight = dao.getUpdatedWeight(conn, no, weight);

            // close
            JDBCTemplate.close(conn);

            return updatedWeight;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new Exception("무게 업데이트 실패");
        }
    }
}




package com.rushwash.admin.app.oldClothes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.laundry.vo.LaundryVo;
import com.rushwash.admin.app.oldClothes.vo.OldClothesVo;

public class OldClothesDao {

	public List<OldClothesVo> getOldClothesList(Connection conn) throws Exception {
		//sql
		String sql = "SELECT O.NO , M.NO AS MEMBER_NO , O.REQUSET_CODE , O.REQUEST_DATE , O.COLLECT_DATE , O.WEIGHT , O.DEL_YN , OS.STATUS, OS.NO AS STATUS_NO FROM OLD_CLOTHES O JOIN MEMBER M ON O.MEMBER_NO = M.NO JOIN OLDCLOTHES_STATUS OS ON  OS.NO = O.REQUSET_CODE";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<OldClothesVo> voList = new ArrayList<OldClothesVo>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String memberNo = rs.getString("MEMBER_NO");
			String requestCode = rs.getString("REQUSET_CODE");
			String requestDate = rs.getString("REQUEST_DATE");
			String collectDate = rs.getString("COLLECT_DATE");
			String weight = rs.getString("WEIGHT");
			String delYn = rs.getString("DEL_YN");
			String status = rs.getString("STATUS");
			String statusNo = rs.getString("STATUS_NO");
			
			OldClothesVo vo = new OldClothesVo();
			
			vo.setNo(no);
			vo.setMemberNo(memberNo);
			vo.setRequestCode(requestCode);
			vo.setRequestDate(requestDate);
			vo.setCollectDate(collectDate);
			vo.setWeight(weight);
			vo.setDelYn(delYn);
			vo.setStatus(status);
			vo.setStatusNo(statusNo);
			
			voList.add(vo);
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return voList;
	}
	
	//상태값 갱신
	public int[] submitStatus(Connection conn, OldClothesVo vo) throws Exception {
		
		int pointUpdateResult;
		PreparedStatement pointUpdateStmt = null;
		//sql
		String statusUpdateSql = "update Old_Clothes set REQUSET_CODE=? WHERE no=?";
		if(vo.getStatus().equals("3")) {
			String pointUpdateSql = "UPDATE MEMBER SET POINT = POINT + ((SELECT WEIGHT FROM OLD_CLOTHES WHERE NO = ?)/10) WHERE NO = (SELECT MEMBER_NO FROM OLD_CLOTHES WHERE NO = ?)";
			
			pointUpdateStmt = conn.prepareStatement(pointUpdateSql);
			
			pointUpdateStmt.setString(1, vo.getNo());
	        pointUpdateStmt.setString(2, vo.getNo());
		       
	       pointUpdateResult = pointUpdateStmt.executeUpdate();
	       
		}else {
			pointUpdateResult = 0;
		}
		PreparedStatement statusUpdateStmt = conn.prepareStatement(statusUpdateSql);
        

       // Set values for the status update
       statusUpdateStmt.setString(1, vo.getStatus()); 
       statusUpdateStmt.setString(2, vo.getNo());
       
       // Set values for the point update
       

       // Execute the updates and get the results
       int statusUpdateResult = statusUpdateStmt.executeUpdate();
      
		
		//close
		JDBCTemplate.close(statusUpdateStmt);
		JDBCTemplate.close(pointUpdateStmt);
		
		return new int[]{statusUpdateResult, pointUpdateResult};
        
	}
}


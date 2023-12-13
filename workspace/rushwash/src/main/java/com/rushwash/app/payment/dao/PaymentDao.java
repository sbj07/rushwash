package com.rushwash.app.payment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.app.item.vo.ItemVo;
import com.rushwash.app.payment.vo.CardVo;
import com.rushwash.app.payment.vo.LaundryOrderVo;
import com.rushwash.app.payment.vo.UserLaundryVo;

public class PaymentDao {
	
	public int putLaundryOrder(Connection conn , LaundryOrderVo vo) throws Exception {
		String sql = "INSERT INTO LAUNDRY_ORDER ( NO ,MEMBER_NO ,PRICE ,PAYMENT_DATE ,REQUEST ,ADDRESS ) VALUES ( SEQ_LAUNDRY_ORDER_NO.NEXTVAL ,? ,? ,SYSDATE ,? ,? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, vo.getMemberNo());
		pstmt.setString(2, vo.getPrice());
		pstmt.setString(3, vo.getRequest());
		pstmt.setString(4, vo.getAddress());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}
		
	
	public int putLaundry(Connection conn, UserLaundryVo vo) throws Exception {
		String sql = "INSERT INTO LAUNDRY ( NO ,ORDER_NO ,ITEM_NO ,EA ) VALUES ( SEQ_LAUNDRY_NO.NEXTVAL , ( SELECT MAX(NO) FROM LAUNDRY_ORDER WHERE MEMBER_NO = ? ) ,? ,? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberNo());
		pstmt.setString(2, vo.getItemNo());
		pstmt.setString(3, vo.getEa());
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		return result;
	}

	public int changeUserPoint(Connection conn, String memberNo, int userPoint) throws Exception {
		String sql = "UPDATE MEMBER SET POINT = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, userPoint);
		pstmt.setString(2, memberNo);
		int pointResult = pstmt.executeUpdate();

		JDBCTemplate.close(pstmt);
		
		return pointResult;
	}

}

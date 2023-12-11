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

	public CardVo getCardInfo(Connection conn, String memberNo) throws Exception {
//		String sql = "SELECT C.NO , C.CARD_COMPANY , C.CARD_NO , C.CVC_NO , C.CARD_PWD , C.VALIDITY_PERIOD , P.PAYMENT_DATE FROM CARD_INFO C JOIN MEMBER M ON C.MEMBER_NO = M.NO JOIN PAYMENT_INFO P ON C.NO = P.CARD_NO WHERE M.NO = ?";
		String sql = "SELECT C.NO , C.CARD_COMPANY , C.CARD_NO , C.CVC_NO , C.CARD_PWD , C.VALIDITY_PERIOD FROM CARD_INFO C JOIN MEMBER M ON C.MEMBER_NO = M.NO WHERE M.NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		CardVo vo = new CardVo();
		if(rs.next()) {
			String no = rs.getString("NO");
			String cardCompany = rs.getString("CARD_COMPANY");
			String cardNo = rs.getString("CARD_NO");
			String cvcNo = rs.getString("CVC_NO");
			String cardPwd = rs.getString("CARD_PWD");
			String validityPeriod = rs.getString("VALIDITY_PERIOD");
			
			vo.setNo(no);
			vo.setMemberNo(memberNo);
			vo.setCardCompany(cardCompany);
			vo.setCardNo(cardNo);
			vo.setCvcNo(cvcNo);
			vo.setCardPwd(cardPwd);
			vo.setValidityPeriod(validityPeriod);
		}
		System.out.println(vo);
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return vo;
	}
	
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
	
	public int putRegularPayment(Connection conn , String cardNo , int periodDate) throws Exception {
		String sql ="INSERT INTO PAYMENT_INFO ( NO ,CARD_NO ,PAYMENT_DATE ) VALUES ( SEQ_PAYMENT_INFO_NO.NEXTVAL ,? ,? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, cardNo);
		pstmt.setInt(2, periodDate);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
	
		return result;
	}

	public int changeRegularPayment(Connection conn, String cardNo, int periodDate) throws Exception {
		String sql ="UPDATE PAYMENT_INFO SET PAYMENT_DATE = ? WHERE CARD_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, periodDate);
		pstmt.setString(2, cardNo);
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
	
		return result;
	}
	
	public int putCardInfo(Connection conn,  CardVo cardVo) throws Exception {
		String sql = "INSERT INTO CARD_INFO ( NO ,MEMBER_NO ,CARD_COMPANY ,CARD_NO ,CVC_NO ,CARD_PWD ,VALIDITY_PERIOD ) VALUES ( SEQ_CARD_INFO_NO.NEXTVAL ,? ,? ,? ,? ,? ,? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, cardVo.getMemberNo());
		pstmt.setString(2, cardVo.getCardCompany());
		pstmt.setString(3, cardVo.getCardNo());
		pstmt.setString(4, cardVo.getCvcNo());
		pstmt.setString(5, cardVo.getCardPwd());
		pstmt.setString(6, cardVo.getValidityPeriod());
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		return result;
	}

	public int changeCardInfo(Connection conn, CardVo cardVo) throws Exception {
		String sql = "UPDATE CARD_INFO SET CARD_COMPANY = ? ,CARD_NO = ? ,CVC_NO = ? ,CARD_PWD = ? ,VALIDITY_PERIOD =? WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, cardVo.getCardCompany());
		pstmt.setString(2, cardVo.getCardNo());
		pstmt.setString(3, cardVo.getCvcNo());
		pstmt.setString(4, cardVo.getCardPwd());
		pstmt.setString(5, cardVo.getValidityPeriod());
		pstmt.setString(6, cardVo.getMemberNo());
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		return result;
	}

}

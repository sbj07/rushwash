package com.rushwash.app.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.app.order.vo.OrderVo;

public class OrderDao {

	// 주문내역 조회(진행중인내역,지난내역)
	public List<OrderVo> getorderList(Connection conn, String memberNo, String deleteYn) throws Exception {
		String sql = "SELECT O.DEL_YN , O.NO ,O.PRICE ,TO_CHAR(O.PAYMENT_DATE ,'YYYY\"년\"MM\"월\"DD\"일\"') AS PAYMENT_DATE ,TO_CHAR(O.RECEIVE_DATE ,'YYYY\"년\"MM\"월\"DD\"일\"') AS RECEIVE_DATE, T.STATUS AS ORDER_STATUS , L.EA, S.STATUS AS LAUNDRY_STATUS FROM LAUNDRY_ORDER O JOIN ORDER_STATUS T ON O.ORDER_STATUS = T.NO JOIN LAUNDRY L ON O.NO = L.ORDER_NO JOIN LAUNDRY_STATUS S ON L.LAUNDRY_STATUS = S.NO WHERE O.MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		List<OrderVo> orderVoList = new ArrayList<OrderVo>();
		while (rs.next()) {

			String delYn = rs.getString("DEL_YN");
			String no = rs.getString("NO");
			String price = rs.getString("PRICE");
			String paymentDate = rs.getString("PAYMENT_DATE");
			String receiveDate = rs.getString("RECEIVE_DATE");
			String orderStatus = rs.getString("ORDER_STATUS");
			String ea = rs.getString("EA");
			String laundryStatus = rs.getString("LAUNDRY_STATUS");

			OrderVo vo = new OrderVo();
			vo.setDelYn(delYn);
			vo.setNo(no);
			vo.setPrice(price);
			vo.setPaymentDate(paymentDate);
			vo.setReceiveDate(receiveDate);
			vo.setOrderStatus(orderStatus);
			vo.setEa(ea);
			vo.setLaundryStatus(laundryStatus);
			orderVoList.add(vo);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return orderVoList;
	}

	// 상세조회
	public ArrayList<OrderVo> getorderDetail(Connection conn, String memberNo, String no) throws Exception {

//		String sql = "SELECT O.ORDER_STATUS , O.NO ,I.NAME AS ITEM ,I.PRICE AS PRICE_ITEM ,O.PRICE ,L.EA ,TO_CHAR(O.PAYMENT_DATE , 'YYYY\"년\"MM\"월\"DD\"일\"') AS PAYMENT_DATE ,TO_CHAR(O.EXP_DATE , 'YYYY\"년\"MM\"월\"DD\"일\"') AS EXP_DATE ,T.STATUS AS LAUNDRY_STATUS ,M.NAME AS MEMBER_NAME ,M.TEL ,O.ADDRESS ,O.REQUEST FROM MEMBER M JOIN LAUNDRY_ORDER O ON M.NO = O.MEMBER_NO JOIN ORDER_STATUS T ON O.ORDER_STATUS = T.NO JOIN LAUNDRY L ON T.NO = L.ORDER_NO JOIN ITEM I ON L.ITEM_NO = I.NO  WHERE M.NO = ? AND O.NO = ? AND L.DEL_YN = 'N'";
		String sql = "SELECT O.ORDER_STATUS ,OS.STATUS ,L.ITEM_NO ,L.EA ,I.PRICE ,I.NAME ,O.PAYMENT_DATE ,O.EXP_DATE ,O.PRICE AS TOTAL_PRICE FROM LAUNDRY L JOIN ITEM I ON I.NO = L.ITEM_NO JOIN LAUNDRY_ORDER O ON L.ORDER_NO = O.NO JOIN ORDER_STATUS OS ON OS.NO = O.ORDER_STATUS WHERE L.ORDER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, memberNo);
		pstmt.setString(1, no);

		ResultSet rs = pstmt.executeQuery();

		OrderVo vo = null;

		ArrayList<OrderVo> voList = new ArrayList<OrderVo>();
		while (rs.next()) {
			vo = new OrderVo();
			vo.setItem(rs.getString("NAME"));
			vo.setPriceItem(rs.getString("PRICE"));
			vo.setPrice(rs.getString("TOTAL_PRICE"));
			vo.setEa(rs.getString("EA"));
			vo.setPaymentDate(rs.getString("PAYMENT_DATE"));
			vo.setExpDate(rs.getString("EXP_DATE"));
			vo.setLaundryStatus(rs.getString("STATUS"));
			vo.setOrderStatus(rs.getString("ORDER_STATUS"));

			voList.add(vo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return voList;
	}

	// 주문내역 삭제(수거요청시에만)
	public int detaildelete(Connection conn, String no) throws Exception {
		String sql = "UPDATE LAUNDRY SET DEL_YN = 'Y' WHERE DEL_YN = 'N' AND ORDER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();

		JDBCTemplate.close(pstmt);

		return result;

	}
	
	public int detaildeleteOrder(Connection conn, String no) throws Exception {
		String sql = "UPDATE LAUNDRY_ORDER SET DEL_YN = 'Y' WHERE DEL_YN = 'N' AND NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();

		JDBCTemplate.close(pstmt);

		return result;

	}

	
	//수령완료(배송완료시에만)
	public int status(Connection conn, String no) throws Exception {
		String sql = "UPDATE LAUNDRY_ORDER SET ORDER_STATUS = 6 WHERE ORDER_STATUS = 5 AND NO =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();

		JDBCTemplate.close(pstmt);

		return result;

	}

}
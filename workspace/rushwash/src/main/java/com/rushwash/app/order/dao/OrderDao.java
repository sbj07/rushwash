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

	public List<OrderVo> getorderList(Connection conn) throws Exception {
		
		String sql = "SELECT O.NO ,O.PRICE ,O.PAYMENT_DATE ,O.RECEIVE_DATE ,O.DEL_YN ,M.NAME AS MEMBER_NAME ,M.ADDRESS ,M.TEL ,I.NAME AS ITEM ,L.EA ,S.STATUS AS LAUNDRY_STATUS ,T.STATUS AS ORDER_STATUS FROM LAUNDRY L JOIN LAUNDRY_ORDER O ON O.NO = L.ORDER_NO JOIN ORDER_STATUS T ON O.ORDER_STATUS = T.NO JOIN MEMBER M ON O.MEMBER_NO = M.NO JOIN LAUNDRY_STATUS S ON L.LAUNDRY_STATUS = S.NO JOIN ITEM I ON L.ITEM_NO = I.NO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<OrderVo> orderVoList = new ArrayList<OrderVo>();
		while(rs.next()) {
			
			String no = rs.getString("NO"); 
			String price = rs.getString("PRICE");
			String paymentDate = rs.getString("PAYMENT_DATE");
			String receiveDate = rs.getString("RECEIVE_DATE");
			String delYn = rs.getString("DEL_YN");
			String memberName = rs.getString("MEMBER_NAME");
			String address = rs.getString("ADDRESS");
			String tel = rs.getString("TEL");
			String item = rs.getString("ITEM");
			String ea = rs.getString("EA");
			String laundryStatus = rs.getString("LAUNDRY_STATUS");
			String orderStatus = rs.getString("ORDER_STATUS");
			
			OrderVo vo = new OrderVo();
			vo.setNo(no);
			vo.setPrice(price);
			vo.setPaymentDate(paymentDate);
			vo.setReceiveDate(receiveDate);
			vo.setDelYn(delYn);
			vo.setMemberName(memberName);
			vo.setAddress(address);
			vo.setTel(tel);
			vo.setItem(item);
			vo.setEa(ea);
			vo.setLaundryStatus(laundryStatus);
			vo.setOrderStatus(orderStatus);
			
			orderVoList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return orderVoList;
	}

}

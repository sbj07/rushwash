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
		
		String sql = "SELECT O.NO ,O.PAYMENT_DATE ,L.EA ,S.STATUS FROM LAUNDRY_ORDER O JOIN LAUNDRY L ON O.NO = L.ORDER_NO JOIN LAUNDRY_STATUS S ON L.LAUNDRY_STATUS = S.NO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<OrderVo> orderVoList = new ArrayList<OrderVo>();
		while(rs.next()) {
			
			String no = rs.getString("NO"); 
			String item = rs.getString("ITEM");
			String price = rs.getString("PRICE");
			String ea = rs.getString("EA");
			String name = rs.getString("NAME");
			String address = rs.getString("ADDRESS");
			String tel = rs.getString("TEL");
			String request = rs.getString("REQUEST");
			String expDate = rs.getString("EXP_DATE");
			String status = rs.getString("STATUS");
			String laundryStatus = rs.getString("LAUNDRY_STATUS");
			String paymentDate = rs.getString("PAYMENT_DATE");
			String diliveryDate = rs.getString("DILIVERY_DATE");
			String collectDate = rs.getString("COLLECT_DATE");
			String receiveDate = rs.getString("RECEIVE_DATE");
			String delYn = rs.getString("DEL_YN");
			
			OrderVo vo = new OrderVo();
			vo.setNo(no);
			vo.setItem(item);
			vo.setPrice(price);
			vo.setEa(ea);
			vo.setName(name);
			vo.setAddress(address);
			vo.setTel(tel);
			vo.setRequest(request);
			vo.setExpDate(expDate);
			vo.setStatus(status);
			vo.setLaundryStatus(laundryStatus);
			vo.setPaymentDate(paymentDate);
			vo.setCollectDate(collectDate);
			vo.setReceiveDate(receiveDate);
			vo.setDelYn(delYn);
			
			orderVoList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return orderVoList;
	}

}

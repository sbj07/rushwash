package com.rushwash.admin.app.laundry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.laundry.vo.LaundryVo;
import com.rushwash.admin.app.laundry.vo.OrderVo;

public class LaundryDao {

	//상세세탁물 리스트 불러오기
	public List<LaundryVo> getLaundryList(Connection conn) throws Exception {
		//sql
		String sql = "SELECT L.*,LO.MEMBER_NO, LS.STATUS , I.NAME FROM LAUNDRY L LEFT JOIN LAUNDRY_ORDER LO ON L.ORDER_NO=LO.NO LEFT JOIN LAUNDRY_STATUS LS ON L.LAUNDRY_STATUS = LS.NO LEFT JOIN ITEM I ON I.NO = L.ITEM_NO LEFT JOIN ITEM_CATEGORY IC ON IC.NO = L.ITEM_NO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<LaundryVo> voList = new ArrayList<LaundryVo>();
		while(rs.next()) {
			String orderNo = rs.getString("ORDER_NO");
			String memberNo = rs.getString("MEMBER_NO");
			String no = rs.getString("NO");
			String name = rs.getString("NAME");
			String ea = rs.getString("EA");
			String washStartDate = rs.getString("WASH_START_DATE");
			String washEndDate = rs.getString("WASH_END_DATE");
			String status = rs.getString("STATUS");
			String delYn = rs.getString("DEL_YN");
			String statusNo = rs.getString("LAUNDRY_STATUS");
			
			LaundryVo vo = new LaundryVo();
			
			vo.setOrderNo(orderNo);
			vo.setMemberNo(memberNo);
			vo.setNo(no);
			vo.setItem(name);
			vo.setEa(ea);
			vo.setWashStartDate(washStartDate);
			vo.setWashEndDate(washEndDate);
			vo.setStatus(status);
			vo.setStatusNo(statusNo);
			vo.setDelYn(delYn);
			
			voList.add(vo);
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return voList;
	}

	//상세세탁물 상태값 갱신
	public int submitStatus(Connection conn, LaundryVo vo) throws Exception {
		//sql
		String sql = "update laundry set laundry_status=? WHERE no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getStatus());
		pstmt.setString(2, vo.getNo());
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	
	//상세세탁물 중 같은 주문번호끼리 모두 세탁완료(3)이 되면 오더를 배송중(4)로 변경

	//세탁주문 리스트 불러오기
	public List<OrderVo> getOrderList(Connection conn) throws Exception {
		//sql
		String sql = "select * from LAUNDRY_ORDER";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<OrderVo> voList = new ArrayList<OrderVo>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String memberNo = rs.getString("MEMBER_NO");
			String orderStatus = rs.getString("ORDER_STATUS");
			String price = rs.getString("PRICE");
			String paymentDate = rs.getString("PAYMENT_DATE");
			String collectDate = rs.getString("COLLECT_DATE");
			String expDate = rs.getString("EXP_DATE");
			String diliveryDate = rs.getString("DILIVERY_DATE");
			String request = rs.getString("REQUEST");
			String address = rs.getString("ADDRESS");
			String receiveDate = rs.getString("RECEIVE_DATE");
			String delYn = rs.getString("DEL_YN");
			
			OrderVo vo = new OrderVo();
			
			vo.setOrderNo(no);
			vo.setMemberNo(memberNo);
			vo.setStatus(orderStatus);
			vo.setPrice(price);
			vo.setPaymentDate(paymentDate);
			vo.setCollectDate(collectDate);
			vo.setExpDate(expDate);
			vo.setDiliveryDate(diliveryDate);
			vo.setOrderRequset(request);
			vo.setAddress(address);
			vo.setReceiveDate(receiveDate);
			vo.setDelYn(delYn);
			
			voList.add(vo);
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return voList;
	}

	public int submitOrderStatus(Connection conn, OrderVo vo) throws Exception {
		//sql
		String sql = "update laundry_order set order_status=? WHERE no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getStatus());
		pstmt.setString(2, vo.getOrderNo());
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}

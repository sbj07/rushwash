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

	// 상세세탁물 리스트 불러오기
	public List<LaundryVo> getLaundryList(Connection conn) throws Exception {
		// sql
		String sql = "SELECT m.name as memberName, L.*,LO.MEMBER_NO, LS.STATUS , I.NAME FROM LAUNDRY L LEFT JOIN LAUNDRY_ORDER LO ON L.ORDER_NO=LO.NO LEFT JOIN LAUNDRY_STATUS LS ON L.LAUNDRY_STATUS = LS.NO LEFT JOIN ITEM I ON I.NO = L.ITEM_NO LEFT JOIN ITEM_CATEGORY IC ON IC.NO = L.ITEM_NO left join member m on lo.member_no=m.no";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		// rs
		List<LaundryVo> voList = new ArrayList<LaundryVo>();
		while (rs.next()) {
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
			String memberName = rs.getString("MEMBERNAME");

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
			vo.setMemberName(memberName);

			voList.add(vo);
		}

		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);

		return voList;
	}
	// 상세세탁물 리스트 불러오기 -- ver2 orderNo 오버로딩
	public List<LaundryVo> getLaundryList(Connection conn, String ordNo) throws Exception {
		// sql
		String sql = "SELECT m.name as memberName, L.*,LO.MEMBER_NO, LS.STATUS , I.NAME FROM LAUNDRY L LEFT JOIN LAUNDRY_ORDER LO ON L.ORDER_NO=LO.NO LEFT JOIN LAUNDRY_STATUS LS ON L.LAUNDRY_STATUS = LS.NO LEFT JOIN ITEM I ON I.NO = L.ITEM_NO LEFT JOIN ITEM_CATEGORY IC ON IC.NO = L.ITEM_NO left join member m on lo.member_no=m.no where order_no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, ordNo);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<LaundryVo> voList = new ArrayList<LaundryVo>();
		while (rs.next()) {
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
			String memberName = rs.getString("MEMBERNAME");
			
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
			vo.setMemberName(memberName);
			
			voList.add(vo);
		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return voList;
	}

	// 상세세탁물 상태값 갱신
	public int submitStatus(Connection conn, LaundryVo vo) throws Exception {
		// sql
		String sql = "update laundry set laundry_status=? WHERE no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getStatus());
		pstmt.setString(2, vo.getNo());
		int result = pstmt.executeUpdate();

		diliverLaundry(conn, vo);

		// close
		JDBCTemplate.close(pstmt);

		return result;
	}

	// 상세세탁물 상태 변경 시 세탁시작일 sysdate update
	public int inputStartDate(Connection conn, LaundryVo vo) throws Exception {
		// sql
		String sql = "update laundry set wash_start_date=sysdate WHERE no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getNo());
		int result = pstmt.executeUpdate();

		return result;
	}

	// 상세세탁물 상태 변경 시 세탁종료일 sysdate update
	public int inputEndDate(Connection conn, LaundryVo vo) throws Exception {
		// sql
		String sql = "update laundry set wash_end_date=sysdate WHERE no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getNo());
		int result = pstmt.executeUpdate();

		return result;
	}

	// 상세세탁물 중 같은 주문번호끼리 모두 세탁완료(3)이 되면 오더를 배송중(4)로 변경
	private int diliverLaundry(Connection conn, LaundryVo vo) throws Exception {
		boolean isComplete = false;
		String orderNo = findOrderNo(conn, vo);

		// sql -- 현재 세탁물과 주문번호가 일치하는 세탁물들 조회
		String sql = "select * from laundry l join laundry_order lo on l.order_no=lo.no where lo.no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, orderNo);
		ResultSet rs = pstmt.executeQuery();

		// rs -- 일치세탁물 들의 상태 체크
		List<LaundryVo> voList = new ArrayList<LaundryVo>();
		while (rs.next()) {
			String laundryStatus = rs.getString("LAUNDRY_STATUS");
			LaundryVo dbVo = new LaundryVo();
			dbVo.setStatus(laundryStatus);
			voList.add(dbVo);
		}

		// result
		for (LaundryVo laundryVo : voList) {
			String status = laundryVo.getStatus();
			if (status.equals("3")) {
				isComplete = true;
			} else {
				isComplete = false;
				break;
			}
		}

		// true일 때 해당 Order의 Order_Status를 배송중(4)로 변경
		int result = 0;
		if (isComplete) {
			OrderVo orderVo = new OrderVo();
			orderVo.setStatus("4");
			orderVo.setOrderNo(orderNo);
			result = submitOrderStatus(conn, orderVo);
			inputDiliveryDate(conn, orderVo); //세탁주문의 배송일을 현재시간으로 변경
			System.out.println(orderVo.getOrderNo() + "번 세탁물의 상태를" + orderVo.getStatus() + "로 " + result + "번 수정");
		}

		return result;
	}

	// 상세세탁물 넘버로 오더넘버 찾기
	private String findOrderNo(Connection conn, LaundryVo vo) throws Exception {
		// sql
		String sql = "select ORDER_NO from laundry where no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getNo());
		ResultSet rs = pstmt.executeQuery();

		String orderNo = null;
		if (rs.next()) {
			orderNo = rs.getString("ORDER_NO");
		}

		return orderNo;
	}

	// -----------------------------------------------------

	// 세탁주문 리스트 불러오기
	public List<OrderVo> getOrderList(Connection conn) throws Exception {
		// sql
		String sql = "select lo.*, m.name from LAUNDRY_ORDER lo join member m on lo.member_no=m.no";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		// rs
		List<OrderVo> voList = new ArrayList<OrderVo>();
		while (rs.next()) {
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
			String memberName = rs.getString("NAME");

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
			vo.setMemberName(memberName);

			voList.add(vo);
		}

		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);

		return voList;
	}

	public int submitOrderStatus(Connection conn, OrderVo vo) throws Exception {
		// sql
		String sql = "update laundry_order set order_status=? WHERE no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getStatus());
		pstmt.setString(2, vo.getOrderNo());
		int result = pstmt.executeUpdate();

		// close
		JDBCTemplate.close(pstmt);

		return result;
	}

	//상세세탁물 세탁시작일 가져오기
	public String getUpdatedStartDate(Connection conn, String no) throws Exception {
		// sql
		String sql = "select wash_start_date from laundry where no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();

		// rs
		String startDate = null;
		if (rs.next()) {
			startDate = rs.getString("WASH_START_DATE");
		}

		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return startDate;
	}

	//상세세탁물 세탁완료일 가져오기
	public String getUpdatedEndDate(Connection conn, String no) throws Exception {
		// sql
		String sql = "select wash_end_date from laundry where no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();

		// rs
		String endDate = null;
		if (rs.next()) {
			endDate = rs.getString("WASH_END_DATE");
		}

		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return endDate;
	}
	
	
	//세탁주문 수거일 업데이트
	public int inputCollectDate(Connection conn, OrderVo vo) throws Exception {
		// sql
		String sql = "update laundry_order set COLLECT_DATE=sysdate WHERE no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getOrderNo());
		int result = pstmt.executeUpdate();

		return result;
	}
	
	//세탁주문 발송일 업데이트
	public int inputDiliveryDate(Connection conn, OrderVo vo) throws Exception {
		// sql
		String sql = "update laundry_order set DILIVERY_DATE=sysdate WHERE no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getOrderNo());
		int result = pstmt.executeUpdate();
		
		return result;
	}
	
	//세탁주문 수거일 가져오기
	public String getUpdatedCollect(Connection conn, String no) throws Exception {
		// sql
		String sql = "select COLLECT_DATE from laundry_order where no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();

		// rs
		String collectDate = null;
		if (rs.next()) {
			collectDate = rs.getString("COLLECT_DATE");
		}

		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return collectDate;
	}
	
	//세탁주문 발송일 가져오기
	public String getUpdateDilivery(Connection conn, String no) throws Exception {
		// sql
		String sql = "select DILIVERY_DATE from laundry_order where no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		String diliveryDate = null;
		if (rs.next()) {
			diliveryDate = rs.getString("DILIVERY_DATE");
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return diliveryDate;
	}
	

}

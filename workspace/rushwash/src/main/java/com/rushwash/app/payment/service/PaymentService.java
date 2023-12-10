package com.rushwash.app.payment.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.app.item.vo.ItemVo;
import com.rushwash.app.payment.dao.PaymentDao;
import com.rushwash.app.payment.vo.CardVo;
import com.rushwash.app.payment.vo.LaundryOrderVo;
import com.rushwash.app.payment.vo.UserLaundryVo;

public class PaymentService {

	// 결제정보
	public CardVo getCardInfo(String memberNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		PaymentDao dao = new PaymentDao();
		
		CardVo vo = dao.getCardInfo(conn , memberNo);
		
		JDBCTemplate.close(conn);
		
		return vo;
	}

	// 총수량, 가격 계산
	public Map<String, String> calcTotalEaAndPrice(List<ItemVo> itemList, String discountRate) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		int totalEa = 0;
		double totalPrice = 0;
		double rate = 100 - Integer.parseInt(discountRate);
		
		for (ItemVo itemVo : itemList) {
			int ea = Integer.parseInt(itemVo.getEa());
			int price = Integer.parseInt(itemVo.getPrice()) ;
			totalEa += ea;
			totalPrice += price * ea;
		}
		
		totalPrice = totalPrice * (rate / 100);		
		String resultEa =  Integer.toString(totalEa);
		String resultPrice =  Integer.toString((int)totalPrice);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("resultEa", resultEa);
		map.put("resultPrice", resultPrice);
		return map;
	}
	
	//LaundryOrder테이블에 주문 삽입
	public int putLaundryOrder(LaundryOrderVo orderVo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		PaymentDao dao = new PaymentDao();
		int result = dao.putLaundryOrder(conn, orderVo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int putLaundry(UserLaundryVo laundryVo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		PaymentDao dao = new PaymentDao();
		int result = dao.putLaundry(conn, laundryVo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}

	public int changeUserPoint(String memberNo, int userPoint) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		PaymentDao dao = new PaymentDao();
		int pointResult = dao.changeUserPoint(conn, memberNo ,userPoint);
		
		if(pointResult == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return pointResult;
	}

	public int putRegularPayment(String cardNo , int periodDate) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		PaymentDao dao = new PaymentDao();
		int result = dao.putRegularPayment(conn, cardNo, periodDate);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}

	public int changeReqularPayment(String cardNo, int periodDate) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		PaymentDao dao = new PaymentDao();
		int result = dao.changeRegularPayment(conn, cardNo, periodDate);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}
}

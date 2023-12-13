package com.rushwash.app.order.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.app.order.dao.OrderDao;
import com.rushwash.app.order.vo.OrderVo;

public class OrderService {

	
	//주문내역
	public List<OrderVo> getorderList(String memberNo , String deleteYn) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		OrderDao dao = new OrderDao();
		List<OrderVo> orderVoList = dao.getorderList(conn, memberNo , deleteYn);
		
		JDBCTemplate.close(conn);

		return orderVoList;

	}

	
	//상세조회
	public ArrayList<OrderVo> getorderDetail(String memberNo, String no) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		OrderDao dao = new OrderDao();
		ArrayList<OrderVo> voList = dao.getorderDetail(conn, memberNo ,no);

		JDBCTemplate.close(conn);
		
		return voList;

	}

	
	//삭제
	public int detaildelete(String no) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		
		OrderDao dao = new OrderDao();
		int result =dao.detaildelete(conn, no);
		int result2 =dao.detaildeleteOrder(conn, no);
		if(result > 0 && result2 > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		result = result + result2;
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//수령완료
	public int status(String no) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		OrderDao dao = new OrderDao();
		int result = dao.status(conn,no);
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}

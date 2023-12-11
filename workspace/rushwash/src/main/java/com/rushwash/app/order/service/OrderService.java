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

	public List<OrderVo> getorderList(String memberNo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		OrderDao dao = new OrderDao();
		List<OrderVo> orderVoList = dao.getorderList(conn, memberNo);

		JDBCTemplate.close(conn);

		return orderVoList;

	}

	public ArrayList<OrderVo> getorderDetail(String memberNo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		OrderDao dao = new OrderDao();
		ArrayList<OrderVo> voList = dao.getorderDetail(conn, memberNo);

		JDBCTemplate.close(conn);
		
		return voList;

	}

}

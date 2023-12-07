package com.rushwash.app.order.service;

import java.sql.Connection;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.app.order.dao.OrderDao;
import com.rushwash.app.order.vo.OrderVo;


public class OrderService {

	public List<OrderVo> getorderList() throws Exception{
		
		Connection conn = JDBCTemplate.getConnection();
		
		OrderDao dao = new OrderDao();
		List<OrderVo> orderVoList = dao.getorderList(conn);
		
		JDBCTemplate.close(conn);
		
		return orderVoList;
		
	}
	

}

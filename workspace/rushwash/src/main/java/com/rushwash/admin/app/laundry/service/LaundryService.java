package com.rushwash.admin.app.laundry.service;

import java.sql.Connection;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.laundry.dao.LaundryDao;
import com.rushwash.admin.app.laundry.vo.LaundryVo;
import com.rushwash.admin.app.laundry.vo.OrderVo;

public class LaundryService {

	LaundryDao dao = new LaundryDao();

	// 상세세탁물 리스트 불러오기
	public List<LaundryVo> getLaundryList() throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		List<LaundryVo> voList = dao.getLaundryList(conn);

		// close
		JDBCTemplate.close(conn);

		return voList;
	}

	// 상세세탁물 상태값 갱신
	public int submitStatus(LaundryVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		int result = dao.submitStatus(conn, vo);

		// tx
		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		// close
		JDBCTemplate.close(conn);

		return result;
	}

	// 세탁주문 리스트 불러오기
	public List<OrderVo> getOrderList() throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		List<OrderVo> voList = dao.getOrderList(conn);

		// close
		JDBCTemplate.close(conn);

		return voList;
	}

	// 세탁주문 상태값 갱신
	public int submitOrderStatus(OrderVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		int result = dao.submitOrderStatus(conn, vo);

		// tx
		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		// close
		JDBCTemplate.close(conn);

		return result;
	}

}

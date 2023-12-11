package com.rushwash.app.board.price.service;

import java.sql.Connection;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.app.board.price.dao.PriceDao;
import com.rushwash.app.board.price.vo.PriceVo;

public class PriceService {

	public List<PriceVo> selectPriceList() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		PriceDao dao = new PriceDao();
		List<PriceVo> priceVoList = dao.selectPriceList(conn);
		
		JDBCTemplate.close(conn);
		
		return priceVoList;
	}

}

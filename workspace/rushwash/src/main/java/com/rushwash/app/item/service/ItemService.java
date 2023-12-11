package com.rushwash.app.item.service;

import java.sql.Connection;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.app.item.dao.ItemDao;
import com.rushwash.app.item.vo.ItemVo;

public class ItemService {
	
	//품목리스트 조회
	public List<ItemVo> selectItemList() throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		ItemDao dao = new ItemDao();
		List<ItemVo> itemList = dao.selectItemList(conn);
		
		JDBCTemplate.close(conn);
		
		return itemList;
		
	}

	//품목 가격 조회
	public String getPrice(String itemNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		ItemDao dao = new ItemDao();
		String itemPrice = dao.getPrice(conn, itemNo);
		
		JDBCTemplate.close(conn);
		return itemPrice;
	}

}

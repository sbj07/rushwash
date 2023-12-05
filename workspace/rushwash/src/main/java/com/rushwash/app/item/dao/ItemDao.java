package com.rushwash.app.item.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.app.item.vo.ItemVo;

public class ItemDao {
	
	public List<ItemVo> selectItemList(Connection conn) throws Exception {
		String sql = "SELECT * FROM ITEM WHERE DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		
		List<ItemVo> itemList = new ArrayList<ItemVo>();
		while(rs.next()) {
			String itemNo = rs.getString("NO"); 
			String categoryCode = rs.getString("CATEGORY_CODE"); 
			String name = rs.getString("NAME"); 
			String price = rs.getString("PRICE");
			
			ItemVo vo = new ItemVo();
			vo.setItemNo(itemNo);
			vo.setCategoryCode(categoryCode);
			vo.setName(name);
			vo.setPrice(price);
			
			itemList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return itemList;
	}

}

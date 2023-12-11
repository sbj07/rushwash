package com.rushwash.app.board.price.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.app.board.faq.vo.FaqVo;
import com.rushwash.app.board.price.vo.PriceVo;

public class PriceDao {

	public List<PriceVo> selectPriceList(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.NO ,B.CATEGORY_CODE , B.NAME, B.PRICE, B.DEL_YN FROM ITEM B JOIN ITEM_CATEGORY M ON B.CATEGORY_CODE= M.NO WHERE B.DEL_YN = 'N' ) T )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<PriceVo> priceVoList = new ArrayList<PriceVo>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String categoryCode = rs.getString("CATEGORY_CODE");
			String name = rs.getString("Name");
			String price = rs.getString("PRICE");
			String delYn = rs.getString("DEL_YN");
			
			PriceVo vo = new PriceVo();
			vo.setNo(no);
			vo.setCategoryCode(categoryCode);
			vo.setName(name);
			vo.setPrice(price);
			vo.setDelYn(delYn);
			
			priceVoList.add(vo);
		}
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return priceVoList;
		
	}

}

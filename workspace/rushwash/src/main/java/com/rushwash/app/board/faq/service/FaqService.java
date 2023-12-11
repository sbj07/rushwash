package com.rushwash.app.board.faq.service;

import java.sql.Connection;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.admin.app.page.vo.PageVo;
import com.rushwash.app.board.faq.dao.FaqDao;
import com.rushwash.app.board.faq.vo.FaqVo;

public class FaqService {

	public List<FaqVo> selectFaqList(PageVo pvo) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		FaqDao dao = new FaqDao();
		List<FaqVo> faqVoList = dao.selectFaqList(conn, pvo);
		
		JDBCTemplate.close(conn);
		
		return faqVoList;
	}

}

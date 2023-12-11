package com.rushwash.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.app.board.price.service.PriceService;
import com.rushwash.app.board.price.vo.PriceVo;

@WebServlet("/board/price")
public class PriceController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			PriceService ps = new PriceService();
			
			List<PriceVo> priceVoList = ps.selectPriceList();
			
			req.setAttribute("priceVoList", priceVoList);
			req.getRequestDispatcher("/WEB-INF/views/user/board/price.jsp").forward(req, resp);
		}catch(Exception e) {
			System.out.println("[ERROR]가격표 조회중 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "가격표 조회 중 에러 발생");
		}
		
	}
}

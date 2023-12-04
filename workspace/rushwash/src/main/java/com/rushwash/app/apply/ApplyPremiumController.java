package com.rushwash.app.apply;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.app.item.service.ItemService;
import com.rushwash.app.item.vo.ItemVo;

@WebServlet("/apply/request/premium")
public class ApplyPremiumController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			// 유저의 구독플랜 정보 갖고오기
//			String categoryCode = req.getParameter("category");
//			//service
//			ItemService itemService = new ItemService();
//			List<ItemVo> itemList = itemService.selectItemList();
			//view
			req.getRequestDispatcher("/WEB-INF/views/user/apply/premium_basket.jsp").forward(req, resp);
			
		} catch (Exception e) {
			System.out.println("[ERROR-A001] 품목리스트 조회 에러");
			e.printStackTrace();
		}
		
	}
}

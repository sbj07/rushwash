package com.rushwash.app.apply;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.rushwash.app.item.service.ItemService;
import com.rushwash.app.item.vo.ItemVo;

@WebServlet("/apply/request/premium")
public class ApplyPremiumController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html;charset=UTF-8");
			//data
			// 유저의 구독플랜 정보 갖고오기
			String categoryNo = req.getParameter("category");
			System.out.println(categoryNo);
			
//			//service
			ItemService itemService = new ItemService();
			List<ItemVo> itemList = itemService.selectItemList(categoryNo);
			Gson gson = new Gson();
			List<String> jsonList = new ArrayList<String>();
			for(ItemVo vo : itemList) {
				String jsonStr = gson.toJson(vo);
				System.out.println(jsonStr);
				jsonList.add(jsonStr);
			}
			
			String json = new Gson().toJson(jsonList);
			
			//view
			if(categoryNo != null) {
				PrintWriter out = resp.getWriter();
				out.write(json);
			}
			else {				
				req.getRequestDispatcher("/WEB-INF/views/user/apply/premium_basket.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			System.out.println("[ERROR-A001] 품목리스트 조회 에러");
			e.printStackTrace();
		}
		
	}
}

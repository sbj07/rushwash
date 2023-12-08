package com.rushwash.app.apply;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.google.gson.Gson;
import com.rushwash.app.item.service.ItemService;
import com.rushwash.app.item.vo.ItemVo;
import com.rushwash.app.member.vo.MemberVo;
import com.rushwash.app.plan.service.PlanService;
import com.rushwash.app.plan.vo.PlanVo;


@WebServlet("/apply/request/premium")
public class ApplyPremiumController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html;charset=UTF-8");
			
			// 유저의 구독플랜 할인률 갖고오기
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			String memberNo = loginMember.getNo();
			
			String isShow = req.getParameter("showtable");			
			
			//service
			//품목정보 가져오기
			ItemService itemService = new ItemService();
			List<ItemVo> itemList = itemService.selectItemList();
			
			//유저 구독정보 가져오기
			PlanService planService = new PlanService();
			String discountRate = planService.getDiscountRate(memberNo);
			
			Gson gson = new Gson();
			
			//상품목록 리스트 json 변환
			List<String> jsonList = new ArrayList<String>();
			for(ItemVo vo : itemList) {
				String jsonStr = gson.toJson(vo);
				jsonList.add(jsonStr);
			}
			// 할인율json 리스트에추가
			jsonList.add(discountRate);
						
			//view
			String json = new Gson().toJson(jsonList);
			if(isShow != null) 
			{
				PrintWriter out = resp.getWriter();
				out.write(json);				
			}else {
				req.getRequestDispatcher("/WEB-INF/views/user/apply/premium_basket.jsp").forward(req, resp);				
			}
		} catch (Exception e) {
			System.out.println("[ERROR-A001] 품목리스트 조회 에러");
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post요청 날라옴");
		Enumeration<String> parameterNames = req.getParameterNames();
		
		List<ItemVo> itemList = new ArrayList<ItemVo>();
		
	    while (parameterNames.hasMoreElements()) {
	        String paramName = parameterNames.nextElement();
	        String itemNo = paramName.substring(4);
	        String paramValue = req.getParameter(paramName);
	        ItemVo vo = new ItemVo();
	        
	        vo.setItemNo(itemNo);
	        vo.setEa(paramValue);
	        
	        if(!paramValue.equals("0")) {	        	
	        	itemList.add(vo);
	        }
	    }
	    
	    
	    System.out.println(itemList);
	}
}

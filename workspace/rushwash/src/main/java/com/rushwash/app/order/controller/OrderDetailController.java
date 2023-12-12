package com.rushwash.app.order.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.app.member.vo.MemberVo;
import com.rushwash.app.order.service.OrderService;
import com.rushwash.app.order.vo.OrderVo;

@WebServlet("/order/detail")
public class OrderDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			String memberNo = loginMember.getNo();
			String no = req.getParameter("no");
			
			//service
			OrderService os = new OrderService();
			ArrayList<OrderVo> voList = os.getorderDetail(memberNo, no);
			req.setAttribute("voList", voList);
			req.setAttribute("orderDetailNo", no);
			req.setAttribute("totalprice", voList.get(0).getPrice());
			req.getRequestDispatcher("/WEB-INF/views/user/order/detail.jsp").forward(req, resp);
		}catch(Exception e) {
			System.out.println("[ERROR-O002] 주문내역 상세조회 중 에러 발생...");
			e.printStackTrace();

		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String no = req.getParameter("orderNo");
			
			OrderService os = new OrderService();
			int result = os.detaildelete(no);
			if(result > 0) {
				req.setAttribute("alertMsg", "주문 취소완료");
//				req.getRequestDispatcher("/WEB-INF/views/user/order/list.jsp").forward(req, resp);
				resp.sendRedirect("/rushwash/order/list");
			}
			
		}catch(Exception e) {
			System.out.println("에러");
			e.printStackTrace();
			
		}
	}

}

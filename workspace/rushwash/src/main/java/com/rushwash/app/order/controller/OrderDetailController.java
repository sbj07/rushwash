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
	
	
	//상세조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html;charset=UTF-8");

			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			String memberNo = loginMember.getNo();
			String no = req.getParameter("no");
			
			//service
			OrderService os = new OrderService();
			ArrayList<OrderVo> voList = os.getorderDetail(memberNo, no);
			req.setAttribute("voList", voList);
			req.setAttribute("orderDetailNo", no);
			req.setAttribute("orderStatus", voList.get(0).getOrderStatus());
			req.setAttribute("totalprice", voList.get(0).getPrice());
			req.getRequestDispatcher("/WEB-INF/views/user/order/detail.jsp").forward(req, resp);
//			System.out.println("여기");
		}catch(Exception e) {
			System.out.println("[ERROR-O002] 주문내역 상세조회 중 에러 발생...");
			e.printStackTrace();
//			System.out.println("왜왜");

		}
		
		
	}
	
	//주문취소
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			resp.setContentType("text/html;charset=UTF-8");
			OrderService os = new OrderService();
		
			
			String no = req.getParameter("orderNo");
			System.out.println(no);
			int result = os.detaildelete(no);
			System.out.println(result);
			if(result > 0) {
				req.setAttribute("alertMsg", "주문 취소완료");
				resp.sendRedirect("/rushwash/order/list");
				return;
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR-E003] 주문 취소 에러");
			e.printStackTrace();
		    req.setAttribute("errorMsg", "수거요청 시에만 주문취소");
//	         System.out.println("catch 블록에서의 result 값: " + result);
			req.getRequestDispatcher("/WEB-INF/views/user/order/detail.jsp").forward(req, resp);
		}
	}

}

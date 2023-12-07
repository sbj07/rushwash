package com.rushwash.app.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.app.order.service.OrderService;
import com.rushwash.app.order.vo.OrderVo;

@WebServlet("/order/list")
public class OrderListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			OrderService os = new OrderService();
			List<OrderVo> orderVoList = os.getorderList();
			
			req.setAttribute("orderVoList", orderVoList);
			req.getRequestDispatcher("/WEB-INF/views/user/order/list.jsp").forward(req, resp);
		}catch(Exception e) {
			System.out.println("[ERROR-O001] 주문내역 조회 중 에러 발생....");
			e.printStackTrace();
			req.setAttribute("errorMag","갤러리 목록 조회 실패");
		}
	}

}

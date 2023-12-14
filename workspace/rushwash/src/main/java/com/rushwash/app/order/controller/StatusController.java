package com.rushwash.app.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.app.order.service.OrderService;

@WebServlet("/order/cpmpleted")
public class StatusController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String no = req.getParameter("orderNo");
			
			OrderService os = new OrderService();
			int result = os.status(no);
			if(result == 1) {
				resp.sendRedirect("/rushwash/order/list");
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR-R004] 수령완료에서 문제 생김");
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/user/order/list.jsp").forward(req, resp);
			
		}
	}
}

package com.rushwash.app.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.app.member.vo.MemberVo;
import com.rushwash.app.order.service.OrderService;
import com.rushwash.app.order.vo.OrderVo;

@WebServlet("/order/list")
public class OrderListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html;charset=UTF-8");
			String deleteYn = req.getParameter("deleteYn");
			
			if(deleteYn == null) {
				deleteYn = "N";
				System.out.println("fdsjkdsdskjksdf,dfhkdbkg");
			}
			System.out.println("딜리트" + deleteYn);
			HttpSession session =req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			String memberNo = loginMember.getNo();
			
			if (loginMember != null) {
			     memberNo = loginMember.getNo();
			} else {
			   throw new Exception("회원 정보 없음");
			}
			OrderService os = new OrderService();
			List<OrderVo> orderVoList = os.getorderList(memberNo , deleteYn);
			System.out.println("딜리트" + deleteYn);
			req.setAttribute("detailBtn", deleteYn);
			req.setAttribute("orderVoList", orderVoList);
			req.getRequestDispatcher("/WEB-INF/views/user/order/list.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println("[ERROR-O001] 주문내역 조회 중 에러 발생...");
			e.printStackTrace();
			req.setAttribute("errorMag","주문내역 에러");
			req.setAttribute("alerMsg","접근권한없음 로그인 후 이용");
            resp.getWriter().print("<script>alert('로그인이 필요합니다.'); location.href='/rushwash/home';</script>");
			
		}
	}

}

package com.rushwash.app.order.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
			}
			HttpSession session =req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			String memberNo = loginMember.getNo();
			
			if (loginMember != null) {
			     memberNo = loginMember.getNo();
			} else {
			   throw new Exception("회원 정보 없음");
			}
			
			OrderService os = new OrderService();
			List<OrderVo> voList = os.getorderList(memberNo , deleteYn);
			
			//중복 제거 // Map 을 활용
			// Map 은 키값이 중복되면 덮어쓰기 된다는 점을 이용
			// no 값이 동일한건 하나만 있으면 되니까....
			// key 값을 no 로 하여 중복을 제거하자
			HashMap<String, OrderVo> map = new HashMap<String, OrderVo>();
			for (OrderVo orderVo : voList) {
			    String compositeKey = orderVo.getNo() + "-" + orderVo.getOrderStatus();
			    map.put(compositeKey, orderVo);
				map.put(orderVo.getEa(), orderVo);
				map.put(orderVo.getDelYn(), orderVo);
				map.put(orderVo.getPrice(), orderVo);
				map.put(orderVo.getPaymentDate(), orderVo);
				map.put(orderVo.getReceiveDate(), orderVo);
				map.put(orderVo.getOrderStatus(), orderVo);
				map.put(orderVo.getLaundryStatus(), orderVo);
			}

				
				
			
			
			// 중복제거 완료
			
			// 확인
			System.out.println("===============");
			System.out.println(map);
			System.out.println("===============");
			
			// map 에는 여러 객체가 있을 수 있다. (no가 중복인건 없고, 다른 요청들 여러개)
			// map 에 있는 여러 객체들을 전부 꺼내자
			
			// 1. map 의 모든 value 를 꺼내기
			// 2. value (==객체) 들을 List 에 담기
			// 그러니까 ,,, map의 모든 value 들을 List 로 만들면 된다.
			// java map to list 이런식으로 검색해보자 ...
			
			//검색한 내용을 바탕으로 작성 ㄱㄱ
			ArrayList<OrderVo> orderVoList = new ArrayList<OrderVo>(map.values());
			
			
			
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

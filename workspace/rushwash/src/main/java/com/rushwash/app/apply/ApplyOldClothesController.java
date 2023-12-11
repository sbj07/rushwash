package com.rushwash.app.apply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.app.member.vo.MemberVo;
import com.rushwash.app.oldclothes.service.OldClothesService;

@WebServlet("/apply/request/old-clothes")
public class ApplyOldClothesController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/apply/old_clothes.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			String memberNo = loginMember.getNo();
			
			OldClothesService oldClothesService = new OldClothesService();
			int result = oldClothesService.putOldClothes(memberNo);
			
			if(result != 1) {
				throw new Exception();
			}
			req.setAttribute("alertMsg", "헌옷수거 요청완료!");
			req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

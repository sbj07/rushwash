package com.rushwash.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.app.member.service.MemberService;
import com.rushwash.app.member.vo.MemberVo;

@WebServlet("/member/sub")
public class MemberSubController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
            HttpSession session = req.getSession();

            MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
            
            MemberService ms = new MemberService();
            String gradeName = ms.getMemberInfo(loginMember.getNo());
            
            req.setAttribute("gradeName", gradeName);
            req.getRequestDispatcher("/WEB-INF/views/user/member/sub.jsp").forward(req, resp);

        } catch(Exception e) {
            System.out.println("[ERROR-M011] 구독 정보 조회 중 에러 발생 ...");
            e.printStackTrace();
            req.setAttribute("errorMsg", "구독 정보 조회 실패...");
            req.getRequestDispatcher("/WEB-INF/views/user/member/sub.jsp").forward(req, resp);
        }
	}
}

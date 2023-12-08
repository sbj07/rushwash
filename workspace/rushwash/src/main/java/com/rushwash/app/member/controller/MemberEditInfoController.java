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

@WebServlet("/member/editinfo")
public class MemberEditInfoController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
            HttpSession session = req.getSession();

            MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
            
            req.setAttribute("vo", loginMember);
            req.getRequestDispatcher("/WEB-INF/views/user/member/editinfo.jsp").forward(req, resp);

        } catch(Exception e) {
            System.out.println("[ERROR-M003] 사용자 정보 조회 중 에러 발생 ...");
            e.printStackTrace();
            req.setAttribute("errorMsg", "사용자 정보 조회 실패...");
            req.getRequestDispatcher("/WEB-INF/views/user/member/editinfo.jsp").forward(req, resp);
        }
	}
}

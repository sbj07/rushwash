package com.rushwash.admin.app.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.admin.app.member.service.MemberService;
import com.rushwash.admin.app.member.vo.MemberVo;

@WebServlet("/admin/member/view")
public class MemberInfoController extends HttpServlet {

	//멤버 일반정보 조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// data

			// service
			MemberService us = new MemberService();
			List<MemberVo> memberVoList = us.infoView();

			// result
			if (memberVoList == null) {
				throw new Exception("[ERROR-U001 유저 정보 전체조회 실패]");
			}

			req.setAttribute("memberVoList", memberVoList);
			req.getRequestDispatcher("/WEB-INF/admin/view/member/memberInfo.jsp").forward(req, resp);
			
			for(MemberVo vo : memberVoList) {
				System.out.println(vo);
			}
			
		} catch (Exception e) {
			System.out.println("[ERROR-U001 유저 정보 전체조회 실패]");
			e.printStackTrace();
			req.setAttribute("errMsg", "유저 정보 전체조회 실패 에러");
			req.getRequestDispatcher("/WEB-INF/view/common/error.jsp").forward(req, resp);
		}
	}
}

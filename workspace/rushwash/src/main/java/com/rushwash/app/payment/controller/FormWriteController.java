package com.rushwash.app.payment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.app.item.vo.ItemVo;
import com.rushwash.app.member.vo.MemberVo;
import com.rushwash.app.payment.service.PaymentService;

@WebServlet("/payment/laundry-form")
public class FormWriteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get요청
	
		System.out.println("get요청");
		
		// 유저정보 가져오기
		// 이름,	연락처, 주소지, 유저포인트 - 세션으로 해결
		// 결제정보
		// 수량합,  최종결제금액, 유저의 결제수단 정보
		HttpSession session = req.getSession();
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		
		
		List<ItemVo> itemList = (List<ItemVo>) req.getAttribute("selectedItemList");
		for (ItemVo itemVo : itemList) {
			System.out.println(itemVo);
		}
		
	}
}

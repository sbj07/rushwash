package com.rushwash.admin.app.laundry.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rushwash.admin.app.laundry.service.LaundryService;
import com.rushwash.admin.app.laundry.vo.LaundryVo;

@WebServlet("/admin/laundry/control")
public class AdminLaundryController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//data
		
		
		//service
		LaundryService ls = new LaundryService();
		List<LaundryVo> voList = ls.getLaundryList();
		
		//result
		
		
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/WEB-INF/admin/view/laundry/laundryControl.jsp").forward(req, resp);
	}
}

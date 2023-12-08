package com.rushwash.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rushwash.admin.app.manager.vo.ManagerVo;

@WebFilter("/admin/*")
public class AdminFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session    = req.getSession();
		ManagerVo loginManager = (ManagerVo) session.getAttribute("loginManager");
		
		if(loginManager==null) {
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect("/rushwash/adminlogin");
			return;
		}
		
		chain.doFilter(request, response);
	}

	

}

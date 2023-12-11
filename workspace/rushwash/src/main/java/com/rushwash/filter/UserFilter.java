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

import com.rushwash.app.member.vo.MemberVo;

@WebFilter("/apply/*")
public class UserFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session    = req.getSession();
		MemberVo loginMember =(MemberVo) session.getAttribute("loginMember");
		
		
		if( loginMember == null ) {
			req.setAttribute("alertMsg", "로그인이 필요합니다.");
			resp.sendRedirect("/rushwash/home");
		}else {
			chain.doFilter(request, response);
		}
	}

}

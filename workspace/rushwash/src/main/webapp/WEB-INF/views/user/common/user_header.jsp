<%@page import="com.rushwash.app.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
%>

<script src="https://kit.fontawesome.com/396e40307f.js" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/rushwash/resources/css/user/template/user_header.css">

<header>
    <nav>
      <a href="/rushwash/home"><i class="fa-brands fa-waze"></i></a>
        <a href="/rushwash/home">RUSH&WASH</a>
        <a href="/rushwash/apply/request">세탁신청</a>
        <a href="/rushwash/plan/select">구독</a>
        <a href="/rushwash/board/price">가격표</a>
        <a href="/rushwash/board/map">서비스지역</a>
        <a href="/rushwash/board/notice">공지사항</a>
        <a href="/rushwash/order/list">주문내역</a>	
        <a href="/rushwash/board/center">고객센터</a>
   
    
        <% if(loginMember == null){ %>
	        <a href="/rushwash/member/join">회원가입</a>
	        <a href="/rushwash/member/login">로그인</a>        	
        <% } else { %> 
	        <a href="/rushwash/member/logout">로그아웃</a>  
        	<a href="/rushwash/member/mypage" style="color: #163172; font-weight: bold;"><%= loginMember.getMemberName() %>님</a>
        <% }%>
        <a href="/rushwash/member/mypage"><i class="fa-regular fa-user"></i></a>
    </nav>
</header>
<script>
/*   function checkLogin() {
    if (loginMember == null) {
		alert("로그인 해주세요.");
    }
  } */
</script>

<!-- <div class="event">
  <h1>광고</h1>
</div> -->

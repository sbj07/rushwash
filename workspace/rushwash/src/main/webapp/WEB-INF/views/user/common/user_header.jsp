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
        <a href="/rushwash/board/center" onclick="checkLogin()">고객센터</a>
   
    
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
  function checkLogin() {
    // 사용자가 로그인되어 있는지 확인하는 로직을 추가하세요
    // 데모용으로 사용자가 로그인되어 있지 않다고 가정합니다
    var isLoggedIn = false;

    if (!isLoggedIn) {
      // 경고 메시지를 표시합니다 (이 메시지를 사용자 정의할 수 있습니다)
      var confirmation = confirm("로그인이 필요합니다. 로그인 페이지로 이동하시겠습니까?");
      
      // 확인 버튼이 클릭되면 로그인 페이지로 리디렉션합니다
      if (confirmation) {
        window.location.href = "/rushwash/member/login";
      }
    }
  }
</script>

<!-- <div class="event">
  <h1>광고</h1>
</div> -->

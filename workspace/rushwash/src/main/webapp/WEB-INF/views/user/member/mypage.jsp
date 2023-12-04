<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/member/mypage.css">
</head>
<%@ include file='/WEB-INF/views/user/common/user_header.jsp' %>
<body>
	
		<div id="main" style="display: flex;">
        <div id="sidebar">
            <a href="" class="menu-item">내 정보</a>
            <a href="/rushwash/member/editinfo" class="menu-item">개인정보수정</a>
            <a href="/rushwash/member/pay" class="menu-item">결제 수단</a>
            <a href="/rushwash/member/quit" class="menu-item">탈퇴 하기</a>
            <a href="/rushwash/member/sub" class="menu-item">구독 등급</a>
        </div>
        <div id="content">
            <div id="info-content" class="content-section">
                <div id="title-box">
                    <h2 id="title">내 정보</h2> 
                </div>     
                <div id="user-info">
                    <form id="user">
                        <p>이메일 (아이디)</p>
                        <input type="text" id="userid" name="userid">
                        <p>비밀번호</p>
                        <input type="password" id="password" name="password">                                      
                        <p>주소 (배송지)</p>
                        <input type="text" id="address" name="address">   
                        <p>전화번호</p>
                        <input type="tel" id="phone" name="phone">
                    </form>
                </div>
            </div>
        </div>
    </div>
		
	

</body>
<%@ include file='/WEB-INF/views/user/common/user_footer.jsp' %>
</html>
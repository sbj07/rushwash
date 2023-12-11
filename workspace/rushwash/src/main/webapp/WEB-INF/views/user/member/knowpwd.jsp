<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/member/knowpwd.css">
</head>
<%@ include file='/WEB-INF/views/user/common/user_header.jsp' %>
<body>
	
	<form action="/rushwash/member/knowid" method="POST">
		<div id="text">
        	<h1 align="center">사용자 비밀번호 정보</h1>
        	<p>입력하신 사용자의 비밀번호 정보입니다</p>
       	 	<div id="input-container">
       	 		<p>현재 비밀번호</p>
            	<input type="text" name="memberPwd" id="memberPwd" value="${memberPwd}" readonly>
        	</div>
    	</div>
	</form>		
		
</body>
<%@ include file='/WEB-INF/views/user/common/user_footer.jsp' %>
</html>
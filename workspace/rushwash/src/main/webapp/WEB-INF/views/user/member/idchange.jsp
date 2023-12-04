<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/member/idchange.css">
</head>
<%@ include file='/WEB-INF/views/user/common/user_header.jsp' %>
<body>

	<div id="text">
        <h1 align="center">아이디 변경</h1>
        <div id="input-container">
            <p>현재 아이디</p>
            <input type="text">
            <p>새로운 아이디</p>
            <input type="text" placeholder="새로운 아이디 입력">
        </div>
    </div>
    <div id="button-container">
        <button type="button" onclick="">아이디 변경</button>
    </div>	

</body>
<%@ include file='/WEB-INF/views/user/common/user_footer.jsp' %>
</html>
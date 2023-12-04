<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/member/pwdchange.css">
</head>
<%@ include file='/WEB-INF/views/user/common/user_header.jsp' %>
<body>

	<div id="text">
        <h1 align="center">비밀번호 변경</h1>
        <div id="input-container">
            <p>현재 비밀번호</p>
            <input type="password">
            <p>새로운 비밀번호</p>
            <input type="password" placeholder="영문, 숫자, 특수문자 조합 8-16자">
            <p>비밀번호 확인</p>
            <input type="password" placeholder="영문, 숫자, 특수문자 조합 8-16자">
        </div>
    </div>
    <div id="button-container">
        <button type="button" onclick="">비밀번호 변경</button>
    </div>

</body>
<%@ include file='/WEB-INF/views/user/common/user_footer.jsp' %>
</html>
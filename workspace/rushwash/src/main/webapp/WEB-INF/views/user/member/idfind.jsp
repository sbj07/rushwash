<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/member/idfind.css">
</head>
<%@ include file='/WEB-INF/views/user/common/user_header.jsp' %>
<body>

	<div id="text">
        <h1 align="center">아이디 찾기</h1>
        <p>가입시 등록한 이름과 비밀번호를 입력하시면</p>
        <p>아이디를 알려드립니다</p>
        <div id="input-container">
            <input type="text" placeholder="이름">
            <input type="password" placeholder="비밀번호">
        </div>
    </div>
    	<div id="button-container">
        	<button type="button" onclick="">아이디 찾기</button>
    	</div>

</body>
<%@ include file='/WEB-INF/views/user/common/user_footer.jsp' %>
</html>
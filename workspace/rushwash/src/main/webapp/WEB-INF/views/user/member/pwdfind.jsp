<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/member/pwdfind.css">
</head>
<%@ include file='/WEB-INF/views/user/common/user_header.jsp' %>
<body>

	<div id="text">
        <h1 align="center">비밀번호 찾기</h1>
        <p>가입시 등록한 이름과 이메일 주소를 입력하시면</p>
        <p>비밀번호 알려드립니다</p>
        <div id="input-container">
            <input type="text" placeholder="이름">  
            <input type="text" placeholder="이메일 주소">
        </div>
    </div>
    <div id="button-container">
        <button type="button" onclick="">비밀번호 찾기</button>
    </div>

</body>
<%@ include file='/WEB-INF/views/user/common/user_footer.jsp' %>
</html>
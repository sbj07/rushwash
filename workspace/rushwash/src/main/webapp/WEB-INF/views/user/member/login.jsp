<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/member/login.css">
</head>
<%@ include file='/WEB-INF/views/user/common/user_header.jsp' %>
<body>
	
	<div class="login-container">
      <h1>로그인</h1>
      <form id="login-form" aciton="" method="post">
          <input type="email" id="email" name="email" placeholder="이메일" required>
          <input type="password" id="password" name="password" placeholder="비밀번호" required>
          <div class="remember-container">
              <input type="checkbox" id="remember">
              <label for="remember">로그인 상태유지</label>
          </div>
          <input type="submit" value="로그인">
      </form>
      <div class="extra-links">
          <a href="/rushwash/member/join">회원가입</a>
          <a href="/rushwash/member/idfind">아이디 찾기</a>
          <a href="/rushwash/member/pwdfind">비밀번호 찾기</a>
      </div>
    </div>
    
</body>
<%@ include file='/WEB-INF/views/user/common/user_footer.jsp' %>
</html>
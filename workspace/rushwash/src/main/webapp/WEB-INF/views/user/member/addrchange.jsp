<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   	String x = (String) request.getAttribute("errorMsg");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/member/addrchange.css">
</head>
<%@ include file='/WEB-INF/views/user/common/user_header.jsp' %>
<body>
	<form action="/rushwash/member/addrchange" method="POST">
	<div id="text">
        <h1 align="center">주소 변경</h1>
        <div id="input-container">
        	<p>아이디</p>
            <input type="text" name="memberId" id="memberId">
            <p>현재 주소</p>
            <input type="text" name="addr" id="addr">
            <p>새로운 주소</p>
            <input type="text" name="newAddr" id="newAddr" placeholder="변경할 주소지">
        </div>
    </div>
    <div id="button-container">
        <button type="submit">주소 변경</button>
    </div>
	</form>
  

</body>
<%@ include file='/WEB-INF/views/user/common/user_footer.jsp' %>
</html>
<script>
	<% if(x != null){ %>
		alert('<%= x %>');
	<% } %>
</script>
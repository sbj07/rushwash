<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   	String x = (String) request.getAttribute("errorMsg");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/member/pwdchange.css">
</head>
<%@ include file='/WEB-INF/views/user/common/user_header.jsp' %>
<body>

	<form action="/rushwash/member/pwdchange" method="POST" onsubmit="return checkPwd()">
		<div id="text">
        	<h1 align="center">비밀번호 변경</h1>
       	 	<div id="input-container">
       	 		<p>아이디</p>
            	<input type="text" name="memberId" id="memberId">
            	<p>현재 비밀번호</p>
            	<input type="password" name="memberPwd" id="memberPwd">
            	<p>새로운 비밀번호</p>
           	 	<input type="password" name="newPwd" id="newPwd" placeholder="영문, 숫자, 특수문자 조합 8-16자">
            	<p>비밀번호 확인</p>
            	<input type="password" name="newPwd2" id="newPwd2" placeholder="영문, 숫자, 특수문자 조합 8-16자">
        	</div>
    	</div>
    	<div id="button-container">
        	<button type="submit">비밀번호 변경</button>
    	</div>
	</form>

</body>
<%@ include file='/WEB-INF/views/user/common/user_footer.jsp' %>
</html>
<script>
	<% if(x != null){ %>
		alert('<%= x %>');
	<% } %>
	
	
	function checkPwd() {
		const newPwd = document.getElementById('newPwd').value;
		const newPwd2 = document.getElementById('newPwd2').value;
		
		if(newPwd != newPwd2) {
			alert("새로운 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return false;
		} 
		
		if(newPwd.length < 8 || newPwd.length > 15) {
			alert("비밀번호는 8~15자 사이로 입력해주세요.");
			return false;
		}

		if(!(/^(?=.*[a-zA-Z])(?=.*\d)(?=.*[~!@#$%^&*()_+|<>?:{}]).{8,16}$/).test(newPwd)){
			alert("비밀번호는 영문 대문자, 소문자, 숫자, 특수문자(~!@#$%^&*()_+|<>?:{})를 각각 최소 하나 이상 포함해야 합니다.");
			return false;
		}
		
		else {
			return true;
		}
	}
</script>
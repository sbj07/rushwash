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
<link rel="stylesheet" href="/rushwash/resources/css/user/member/idchange.css">
</head>
<%@ include file='/WEB-INF/views/user/common/user_header.jsp' %>
<body>
	
	<form action = "/rushwash/member/idchange" method ="POST">
		<div id="text">
        <h1 align="center">아이디 변경</h1>
        	<div id="input-container">
            	<p>현재 아이디</p>
            	<input type="text" name="memberId" id="memberId">
            	<p>새로운 아이디</p>
            	<input type="text" name="newId" id="newId" placeholder="새로운 아이디 입력">
            	<button type="button" class="step-url" onclick="checkIdDup();">중복확인</button>
        	</div>
    	</div>
    	<div id="button-container">
        	<button type="submit">아이디 변경</button>
    	</div>	
	</form>

</body>
<%@ include file='/WEB-INF/views/user/common/user_footer.jsp' %>
</html>

<script>
	<% if(x != null){ %>
		alert('<%= x %>');
	<% } %>
	
	
function checkIdDup(){
	
	const newIdValue = document.querySelector("input[name=newId]").value;
	
	if(newIdValue.length < 6 || newIdValue.length > 12){
		alert("아이디는 6~12자 사이로 입력해주세요.");
		return;
	}

	if(!(/^[a-z0-9]+$/).test(newIdValue)){
		alert("아이디는 영어 소문자와 숫자로만 이루어져야 합니다.");
		return;
	}

	
	fetch("/rushwash/member/check/id?memberId=" + newIdValue)
	.then( (resp) => { return resp.json() } )
	.then( (data) => { 
		const result = data.msg;
		const isOk = result === "ok";
		if(isOk){	
			alert("사용가능한 아이디 입니다.");
			window.idOk = true;
		}else{
			alert("이미 사용중인 아이디 입니다.");
			window.idOk = false;
		}
	} );
}


function submitIdChange() {
    if (!window.idOk) {
        alert("아이디 중복 확인을 해주세요.");
        return;
    }
    document.querySelector("form").submit();
}

window.onload = function() {
    document.querySelector("button[type=submit]").addEventListener("click", function(event) {
        event.preventDefault();  
        submitIdChange();  
    });
};    
</script>


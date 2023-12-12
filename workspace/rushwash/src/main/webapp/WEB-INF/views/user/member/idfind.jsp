<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/member/idfind.css">
</head>
<%@ include file='/WEB-INF/views/user/common/user_header.jsp' %>
<body>
	<form action="/rushwash/member/idfind" method="post" onsubmit="return checkVerification()">
	<div id="text">
        <h1 align="center">아이디 찾기</h1>
        <p>가입시 등록한 이름과 비밀번호를 입력하시면</p>
        <p>아이디를 알려드립니다</p>
        <div id="input-container">
            <input type="text" id="email" name="email" placeholder="이메일">
            <button type="button" class="step-url" onclick="sendEmail()">인증번호 전송</button>
            <input type="text" id="checkNum" name="checkNum" placeholder="인증번호">
            <button type="button" class="step-url2" onclick="verifyCode()">인증하기</button>
        </div>
    </div>
    	<div id="button-container">
        	<button type="submit">아이디 찾기</button>
    	</div>
	</form>

</body>
<%@ include file='/WEB-INF/views/user/common/user_footer.jsp' %>
</html>
<script>
function sendEmail() {
    const email = document.getElementById('email').value;
   
    if (!email) {
        alert('이메일을 입력해주세요');
        return;
    }
    
    $.ajax({
        url: '/rushwash/member/email',
        type: 'POST',
        data: {
            memberEmail: email
        },
        success: function(response) {
            alert('인증번호 전송 완료');
        },
        error: function() {
            alert('해당 이메일로 가입된 아이디가 없습니다');
        }
    });
}


let isVerified = false;

function verifyCode() {
    const email = document.getElementById('email').value;
    const checkNum = document.getElementById('checkNum').value;
    $.ajax({
        url: '/rushwash/member/verify',
        type: 'POST',
        data: {
            email: email,
            checkNum: checkNum
        },
        dataType: 'json',  // 응답을 JSON으로 해석하도록 설정
        success: function(response) {
            if(response.msg === "success") {
                alert('인증 완료');
                isVerified = true;
            } else {
                alert('인증번호가 일치하지 않습니다');
            }
        },
        error: function() {
            alert('인증번호가 일치하지 않습니다.');
        }
    });
}

function checkVerification() {
    if (!isVerified) {
        alert('인증이 완료되지 않았습니다');
        return false;
    }
    return true;
}
</script>
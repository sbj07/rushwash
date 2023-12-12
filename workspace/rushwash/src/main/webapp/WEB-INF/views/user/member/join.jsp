<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
    String x = (String) request.getAttribute("errorMsg");
%> 
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/member/join.css">
</head>
<body>
	<main>
	<form action="/rushwash/member/join" method="post">
            <div id="header">
                <a href="/rushwash/home"><img src="/rushwash/resources/img/user/member/logo.png" id="logo"></a>
                <h1>회원가입</h1>
            </div>
            <!-- wrapper -->
            <div id="wrapper">
    
                <!-- content-->
                <div id="content">
                    <div>
                        <h3 class="join_title">
                            <label for="id">아이디</label>
                        </h3>
                        <span class="box int_id">
                            <input type="text" id="id" class="int" maxlength="20" name="memberId">
                            <button type="button" class="step-url" onclick="checkIdDup();">중복확인</button> 
                        </span>
                        <span class="error_next_box"></span>
                    </div>
    
                    <div>
                        <h3 class="join_title"><label for="pswd1">비밀번호</label></h3>
                        <span class="box int_pass">
                            <input type="password" id="pswd1" class="int" maxlength="20" name="memberPwd">
                            <span id="alertTxt">사용불가</span>
                            <img src="/rushwash/resources/img/user/member/pass.png" id="pswd1_img1" class="pswdImg">
                        </span>
                        <span class="error_next_box"></span>
                    </div>
    
                    <div>
                        <h3 class="join_title"><label for="pswd2">비밀번호 확인</label></h3>
                        <span class="box int_pass_check">
                            <input type="password" id="pswd2" class="int" maxlength="20" name="memberPwd2">
                            <img src="/rushwash/resources/img/user/member/disable.png" id="pswd2_img1" class="pswdImg">
                        </span>
                        <span class="error_next_box"></span>
                    </div>
    
                    <div>
                        <h3 class="join_title"><label for="name">이름</label></h3>
                        <span class="box int_name">
                            <input type="text" id="name" class="int" maxlength="20" name="memberName">
                        </span>
                        <span class="error_next_box"></span>
                    </div>
                    
                    <div>
                        <h3 class="join_title"><label for="email">이메일</label></h3>
                        <span class="box int_email">
                            <input type="text" id="email" class="int" maxlength="100" name="memberEmail" placeholder="이메일 입력">
                       		<button type="button" class="step-url" onclick="checkEmailDup();">중복확인</button> 
                        </span>
                        <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>   

                    </div>
    
                    <div>
                        <h3 class="join_title"><label for="addr">주소(배송지)</label></h3>
                        <span class="box int_addr">
                            <input type="text" id="addr" class="int" maxlength="100" name="memberAddress" placeholder="주소 입력">
                        </span>
                        <span class="error_next_box">올바른 주소를 입력하세요</span> 
                    </div>
    
                    <div>
                        <h3 class="join_title"><label for="phoneNo">휴대전화</label></h3>
                        <span class="box int_mobile">
                            <input type="tel" id="mobile" class="int" maxlength="16" name="memberTel" placeholder="전화번호 입력">
                        </span>
                        <span class="error_next_box"></span>    
                    </div>
    
                    <div class="btn_area">
                        <button type="submit" id="btnJoin">
                            <span>가입하기</span>
                        </button>             
                    </div>
                </div> 
                <!-- content-->
            </div> 
        </form>
        <!-- wrapper -->
	</main>
</body>
</html>

<script>

<% if(x != null){ %>
	alert('<%= x %>');
<% } %>

const id = document.querySelector('#id');
const pw1 = document.querySelector('#pswd1');
const pwMsg = document.querySelector('#alertTxt');
const pwImg1 = document.querySelector('#pswd1_img1');
const pw2 = document.querySelector('#pswd2');
const pwImg2 = document.querySelector('#pswd2_img1');
const pwMsgArea = document.querySelector('.int_pass');
const userName = document.querySelector('#name');
const addr = document.querySelector('#addr');
const email = document.querySelector('#email');
const mobile = document.querySelector('#mobile');
const error = document.querySelectorAll('.error_next_box');


/*이벤트 핸들러 연결*/

id.addEventListener("focusout", checkId);
pw1.addEventListener("focusout", checkPw);
pw2.addEventListener("focusout", comparePw);
userName.addEventListener("focusout", checkName);
addr.addEventListener("focusout", checkAddr);
email.addEventListener("focusout", isEmailCorrect);
mobile.addEventListener("focusout", checkPhoneNum);



/*콜백 함수*/


function checkId() {
    const idPattern = /[a-zA-Z0-9_-]{5,20}/;
    if(id.value === "") {
        error[0].innerHTML = "필수 정보입니다.";
        error[0].style.display = "block";
    } else if(!idPattern.test(id.value)) {
        error[0].innerHTML = "6~12자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.";
        error[0].style.color = "red";
        error[0].style.display = "block";
    } else {
        error[0].style.color = "#08A600";
        error[0].style.display = "block";
    }  
}

function checkPw() {
	const pwPattern = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[~!@#$%^&*()_+|<>?:{}]).{8,16}$/;
    if(pw1.value === "") {
        error[1].innerHTML = "필수 정보입니다.";
        error[1].style.display = "block";
    } else if(!pwPattern.test(pw1.value)) {
        error[1].innerHTML = "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.";
        pwMsg.innerHTML = "사용불가";
        pwMsgArea.style.paddingRight = "93px";
        error[1].style.display = "block";
        
        pwMsg.style.display = "block";
        pwImg1.src = "/rushwash/resources/img/user/member/not_use.png";
    } else {
        error[1].style.display = "none";
        pwMsg.innerHTML = "안전";
        pwMsg.style.display = "block";
        pwMsg.style.color = "#03c75a";
        pwImg1.src = "/rushwash/resources/img/user/member/safe.png";
    }
}

function comparePw() {
    if(pw2.value === pw1.value && pw2.value != "") {
        pwImg2.src = "/rushwash/resources/img/user/member/enable.png";
        error[2].style.display = "none";
    } else if(pw2.value !== pw1.value) {
        pwImg2.src = "/rushwash/resources/img/user/member/disable.png";
        error[2].innerHTML = "비밀번호가 일치하지 않습니다.";
        error[2].style.display = "block";
    } 

    if(pw2.value === "") {
        error[2].innerHTML = "필수 정보입니다.";
        error[2].style.display = "block";
    }
}

function checkName() {
    const namePattern = /[a-zA-Z가-힣]/;
    if(userName.value === "") {
        error[3].innerHTML = "필수 정보입니다.";
        error[3].style.display = "block";
    } else if(!namePattern.test(userName.value) || userName.value.indexOf(" ") > -1) {
        error[3].innerHTML = "한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)";
        error[3].style.display = "block";
    } else {
        error[3].style.display = "none";
    }
}

function isEmailCorrect() {
    const emailPattern = /[a-z0-9]{2,}@[a-z0-9-]{2,}\.[a-z0-9]{2,}/;

    if(email.value === ""){ 
    	error[4].innerHTML = "필수 정보입니다.";
        error[4].style.display = "block"; // 이메일이 빈 문자열일 때 에러 메시지를 표시하도록 수정
    } else if(!emailPattern.test(email.value)) {
        error[4].innerHTML = "이메일 주소를 다시 확인해주세요."; // 이메일 형식이 맞지 않을 때 에러 메시지를 표시
        error[4].style.display = "block";
    } else {
        error[4].style.display = "none"; 
    }

}

function checkAddr() {
    if(addr.value === "") {
        error[5].innerHTML = "필수 정보입니다.";
        error[5].style.display = "block";
    } else {
        error[5].style.display = "none";
    }
}


function checkPhoneNum() {
    const isPhoneNum = /([01]{2})([01679]{1})-([0-9]{3,4})-([0-9]{4})/;
    if(mobile.value === "") {
        error[6].innerHTML = "필수 정보입니다.";
        error[6].style.display = "block";
    } else if(!isPhoneNum.test(mobile.value)) {
        error[6].innerHTML = "형식에 맞지 않는 번호입니다. (-)를 추가해주세요.";
        error[6].style.display = "block";
    } else {
        error[6].style.display = "none";
    }
}

function checkIdDup(){
	
	const memberIdValue = document.querySelector("main input[name=memberId]").value;
	
	fetch("/rushwash/member/check/id?memberId=" + memberIdValue)
	.then( (resp) => { return resp.json() } )
	.then( (data) => { 
		const result = data.msg;
		const isOk = result === "ok";
		if(isOk){	
			error[0].innerHTML = "사용가능한 아이디 입니다.";
			window.idOk = true;
		}else{
			error[0].innerHTML = "이미 사용중인 아이디 입니다.";
			error[0].style.color = "#ff0000";
			window.idOk = false;
		}
	} );
}

function checkEmailDup(){
	
	const memberEmailValue = document.querySelector("main input[name=memberEmail]").value;
	
	if(!memberEmailValue){
		alert("이메일을 입력하세요");
		return;
	}
	
	
	fetch("/rushwash/member/check/email?memberEmail=" + memberEmailValue)
	.then( (resp) => { return resp.json() } )
	.then( (data) => { 
		const result = data.msg;
		const isOk = result === "ok";
		if(isOk){	
			alert("사용가능한 이메일 입니다.");
			window.idOk = true;
		}else{
			alert("이미 사용중인 이메일 입니다.");
			window.idOk = false;
		}
	} );
}

	
</script>
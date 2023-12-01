<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/member/join.css">
</head>
<body>
	<main>
	<form action="" method="post">
            <div id="header">
                <a href="/rushwash/home"><img src="/rushwash/resources/img/user/member/logo.png" id="logo"></a>
                <h1>회원가입</h1>
            </div>
            <!-- wrapper -->
            <div id="wrapper">
    
                <!-- content-->
                <div id="content">
    
                    <!-- ID -->
                    <div>
                        <h3 class="join_title">
                            <label for="id">아이디(이메일)</label>
                        </h3>
                        <span class="box int_id">
                            <input type="text" id="id" class="int" maxlength="20">
                        </span>
                        <span class="error_next_box"></span>
                    </div>
    
                    <!-- PW1 -->
                    <div>
                        <h3 class="join_title"><label for="pswd1">비밀번호</label></h3>
                        <span class="box int_pass">
                            <input type="password" id="pswd1" class="int" maxlength="20">
                            <span id="alertTxt">사용불가</span>
                            <img src="/rushwash/resources/img/user/member/pass.png" id="pswd1_img1" class="pswdImg">
                        </span>
                        <span class="error_next_box"></span>
                    </div>
    
                    <!-- PW2 -->
                    <div>
                        <h3 class="join_title"><label for="pswd2">비밀번호 확인</label></h3>
                        <span class="box int_pass_check">
                            <input type="password" id="pswd2" class="int" maxlength="20">
                            <img src="/rushwash/resources/img/user/member/disable.png" id="pswd2_img1" class="pswdImg">
                        </span>
                        <span class="error_next_box"></span>
                    </div>
    
                    <!-- NAME -->
                    <div>
                        <h3 class="join_title"><label for="name">이름</label></h3>
                        <span class="box int_name">
                            <input type="text" id="name" class="int" maxlength="20">
                        </span>
                        <span class="error_next_box"></span>
                    </div>
    
                    <!-- EMAIL -->
                    <div>
                        <h3 class="join_title"><label for="email">주소(배송지)</label></h3>
                        <span class="box int_email">
                            <input type="text" id="email" class="int" maxlength="100" placeholder="주소입력">
                        </span>
                        <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>    
                    </div>
    
                    <!-- MOBILE -->
                    <div>
                        <h3 class="join_title"><label for="phoneNo">휴대전화</label></h3>
                        <span class="box int_mobile">
                            <input type="tel" id="mobile" class="int" maxlength="16" placeholder="전화번호 입력">
                        </span>
                        <span class="error_next_box"></span>    
                    </div>
    
                    <!-- JOIN BTN-->
                    <div class="btn_area">
                        <button type="button" id="btnJoin" onclick="">
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
	
const id = document.querySelector('#id');

const pw1 = document.querySelector('#pswd1');
const pwMsg = document.querySelector('#alertTxt');
const pwImg1 = document.querySelector('#pswd1_img1');

const pw2 = document.querySelector('#pswd2');
const pwImg2 = document.querySelector('#pswd2_img1');
const pwMsgArea = document.querySelector('.int_pass');

const userName = document.querySelector('#name');

const yy = document.querySelector('#yy');
const mm = document.querySelector('#mm');
const dd = document.querySelector('#dd');

const gender = document.querySelector('#gender');

const email = document.querySelector('#email');

const mobile = document.querySelector('#mobile');

const error = document.querySelectorAll('.error_next_box');



/*이벤트 핸들러 연결*/


id.addEventListener("focusout", checkId);
pw1.addEventListener("focusout", checkPw);
pw2.addEventListener("focusout", comparePw);

email.addEventListener("focusout", isEmailCorrect);
mobile.addEventListener("focusout", checkPhoneNum);





/*콜백 함수*/


function checkId() {
    const idPattern = /[a-zA-Z0-9_-]{5,20}/;
    if(id.value === "") {
        error[0].innerHTML = "필수 정보입니다.";
        error[0].style.display = "block";
    } else if(!idPattern.test(id.value)) {
        error[0].innerHTML = "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.";
        error[0].style.display = "block";
    } else {
        error[0].innerHTML = "멋진 아이디네요!";
        error[0].style.color = "#08A600";
        error[0].style.display = "block";
    }
}

function checkPw() {
    const pwPattern = /[a-zA-Z0-9~!@#$%^&*()_+|<>?:{}]{8,16}/;
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
        error[6].style.display = "none"; 
    } else if(!emailPattern.test(email.value)) {
        error[6].style.display = "block";
    } else {
        error[6].style.display = "none"; 
    }

}

function checkPhoneNum() {
    const isPhoneNum = /([01]{2})([01679]{1})([0-9]{3,4})([0-9]{4})/;

    if(mobile.value === "") {
        error[7].innerHTML = "필수 정보입니다.";
        error[7].style.display = "block";
    } else if(!isPhoneNum.test(mobile.value)) {
        error[7].innerHTML = "형식에 맞지 않는 번호입니다.";
        error[7].style.display = "block";
    } else {
        error[7].style.display = "none";
    }

    
}
	
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String errMsg = (String) request.getAttribute("errMsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/admin/view/common/header.jsp"%>
</head>
<!-- PAGE TOP -->
<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">

		<%@ include file="/WEB-INF/admin/view/common/sidebar.jsp"%>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">
			<!-- 탑바 -->
				<%@ include file="/WEB-INF/admin/view/common/topbar.jsp"%>

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading(페이지 제목) -->
					<div
						class="d-sm-flex align-items-center mb-4 text-center">
						<h1 class="h3 mb-0 text-gray-800">매니저 추가</h1>
					</div>
					<p class="mb-4">새로운 관리자 계정을 생성하여 공유하십시오. 모든 기능은 로그인 후 이용해야합니다.</p>
					
					<form class="user" method="post">
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <input id = "id" type="text" class="form-control form-control-user" name="Id" placeholder="ID">
                                    	
                                    	<div>
	                                    	<button type="button" class="btn-primary dupbox " onclick="checkIdDup();">중복확인</button>
                                    	</div>
                                    	
                                    </div>
                                <span class="error_next_box"></span>
                                </div>
                                
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <input id = "pwd1" type="password" class="form-control form-control-user"
                                            name="Password" placeholder="Password">
                                    </div>
                                <span class="error_next_box"></span>
                                </div>
                                
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <input id = "pwd2" type="password" class="form-control form-control-user"
                                            name="Password2" placeholder="Repeat Password">
                                    </div>
                                <span class="error_next_box"></span>
                                </div>
                                
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <input id = "name" type="text" class="form-control form-control-user" name="Name"
                                            placeholder="Name">
                                    </div>
                                <span class="error_next_box"></span>
                                </div>
                                
                                <input type="submit" class="btn btn-primary btn-user btn-block" value="계정 등록">
                            </form>
					
					
				</div>
				<!-- End of Main Content -->

				<%@ include file="/WEB-INF/admin/view/common/footer.jsp"%>

			</div>
		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<%@ include file="/WEB-INF/admin/view/common/logoutModal.jsp"%>

</body>
<script>
<%if (errMsg != null) {%>
alert("<%=errMsg%>");
<%}%>

/* 쿼리셀렉터 */
const idInput   = document.querySelector('#id');
const pwd1Input = document.querySelector('#pwd1');
const pwd2Input = document.querySelector('#pwd2');
const nameInput = document.querySelector('#name');
const errorbox = document.querySelectorAll('.error_next_box');

/*이벤트 핸들러 연결*/
idInput.addEventListener  ("focusout", checkId);
pwd1Input.addEventListener("focusout", checkPw);
pwd2Input.addEventListener("focusout", comparePw);
nameInput.addEventListener("focusout", checkName);

/* 중복체크여부 */
let dupCookie = false;

function checkId() {
    const idPattern = /[a-zA-Z0-9_-]{5,20}/;
    if(idInput.value == "") {
        errorbox[0].innerHTML = "필수 정보입니다.";
        errorbox[0].style.color = "red";
        errorbox[0].style.display = "block";
    } else if(!idPattern.test(id.value)) {
        errorbox[0].innerHTML = "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.";
        errorbox[0].style.display = "block";
    } else {
        errorbox[0].innerHTML = "사용가능한 아이디입니다.";
        errorbox[0].style.display = "block";
        errorbox[0].style.color = "green";
    }  
    
    if(!dupCookie){
    	errorbox[0].innerHTML = "아이디 중복확인을 부탁드립니다.";
        errorbox[0].style.display = "block";
    } 
}

function checkPw() {
    const pwPattern = /[a-zA-Z0-9~!@#$%^&*()_+|<>?:{}]{8,16}/;
    if(pwd1Input.value == "") {
        errorbox[1].innerHTML = "필수 정보입니다.";
        errorbox[1].style.color = "red";
        errorbox[1].style.display = "block";
    } else if(!pwPattern.test(pwd1Input.value)) {
        errorbox[1].innerHTML = "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.";
        errorbox[1].style.display = "block";
    } else {
    	errorbox[1].innerHTML = "사용 가능한 비밀번호입니다.";
        errorbox[1].style.display = "block";
        errorbox[1].style.color = "green";
    }
}

function comparePw() {
    if(pwd2Input.value === "") {
        errorbox[2].innerHTML = "필수 정보입니다.";
        errorbox[2].style.display = "block";
    } else if(pwd2Input.value !== pwd1Input.value) {
        errorbox[2].innerHTML = "비밀번호가 일치하지 않습니다.";
        errorbox[2].style.color = "red";
        errorbox[2].style.display = "block";
    } else if(pwd2Input.value == pwd1Input.value) {
        errorbox[2].style.display = "block";
        errorbox[2].style.color = "green";
        errorbox[2].innerHTML = "비밀번호가 일치합니다.";
    } 

}

function checkName() {
    const namePattern = /[가-힣]/;
    if(nameInput.value === "") {
        errorbox[3].innerHTML = "필수 정보입니다.";
        errorbox[3].style.display = "block";
    } else if(!namePattern.test(nameInput.value) || nameInput.value.indexOf(" ") > -1) {
        errorbox[3].style.display = "block";
        errorbox[3].innerHTML = "한글을 사용하세요. (특수기호, 공백 사용 불가)";
    } else {
        errorbox[3].innerHTML = "사용 가능한 이름입니다.";
        errorbox[3].style.display = "block";
        errorbox[3].style.color = "green";

    }
}

function checkIdDup(){
	const memberIdValue = idInput.value;
	fetch("/rushwash/admin/check?Id=" + memberIdValue)
	.then( (resp) => { return resp.json() } )
	.then( (data) => { 
		const result = data.msg;
		const isOk = result === "ok";
		if(isOk){
			errorbox[0].innerHTML = "사용가능한 아이디입니다.";
			errorbox[0].style.color = "green";
			window.idOk = true;
		}else{
			errorbox[0].innerHTML = "이미 사용중인 아이디입니다.";
			errorbox[0].style.color = "#ff0000";
			window.idOk = false;
		}
	} );
	
	dupCookie = true;
	}
</script>

</html>
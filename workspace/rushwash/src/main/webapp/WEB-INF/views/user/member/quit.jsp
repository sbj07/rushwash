<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/member/quit.css">
</head>
<%@ include file='/WEB-INF/views/user/common/user_header.jsp' %>
<body>

	<div id="main" style="display: flex;">
        <div id="sidebar">
            <a href="/rushwash/member/mypage" class="menu-item">내 정보</a>
            <a href="/rushwash/member/editinfo" class="menu-item">개인정보수정</a>
            <a href="/rushwash/member/pay" class="menu-item">결제 수단</a>
            <a href="/rushwash/member/quit" class="menu-item">탈퇴 하기</a>
            <a href="/rushwash/member/sub" class="menu-item">구독 등급</a>
        </div>
        <div id="content">
            <div id="withdraw-content" class="content-section" style="display: flex;">
                <div id="title-box">
                    <h2 id="title">회원 탈퇴</h2> 
                </div>     
                <div id="user-info">
                    <form id="user-info-form">
                        <p>이메일주소</p>
                        <input type="text" id="memberId" name="memberId" >                                            
                        <p>패스워드</p>
                        <input type="password" id="password" name="password" >   
                        <p>패스워드 재입력</p>
                        <input type="password" id="password2" name="password2">
                    </form>
                    <div id="btn01">
                        <button class="btn0" onclick="">회원탈퇴하기</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
<%@ include file='/WEB-INF/views/user/common/user_footer.jsp' %>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	MemberVo vo = (MemberVo) request.getAttribute("vo");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/member/pay.css">
</head>
<%@ include file='/WEB-INF/views/user/common/user_header.jsp' %>
<body>

	<div id="main" style="display: flex;">
        <div id="sidebar">
            <a href="/rushwash/member/mypage" class="menu-item">내 정보</a>
            <a href="/rushwash/member/editinfo" class="menu-item">개인정보수정</a>
<!--             <a href="/rushwash/member/pay" class="menu-item">결제 수단</a> -->
            <a href="/rushwash/member/quit" class="menu-item">탈퇴 하기</a>
            <a href="/rushwash/member/sub" class="menu-item">구독 등급</a>
        </div>
        <div id="content">
            <div id="pay-content" class="content-section" style="display: flex;">
                <div id="title-box">
                    <h2 id="title">결제 수단</h2> 
                    <div id="card-box">
                        <button type="button" id="change-card" onclick="location.href='/rushwash/payment/card-regist'">카드 변경</button> 
                    </div>
                </div>     
                <div id="pay-info">
                    <form id="pay-form">
                    <c:if test="${ not empty loginMember }" > 
                    	<p>카드</p>
                        <input type="text" id="cardNo" name="cardNo" value="${ cardVo.cardCompany }" readonly> 
                        <p>결제정보</p>
                        <input type="text" id="cardCompany" name="cardCompany" value="${ cardVo.cardNo }" readonly>   
                        <button type="button" id="delete-card" onclick="location.href='/rushwash/payment/card-regist'">변경</button>                                        
                   	</c:if>
                   	<c:if test="${ empty cardVo.cardNo }" >
                    	<p>카드</p>
                        <input type="text" id="cardNo" name="cardNo" readonly> 
                        <p>결제정보</p>
                        <input type="text" id="cardCompany" name="cardCompany" readonly>   
                        <button type="button" id="delete-card" onclick="location href='/rushwash/payment/card-regist">변경</button> 
                   </c:if>
                    </form>
                   
                </div>
            </div>
        </div>
    </div>

</body>
<%@ include file='/WEB-INF/views/user/common/user_footer.jsp' %>
</html>
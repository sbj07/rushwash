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
<link rel="stylesheet" href="/rushwash/resources/css/user/member/sub.css">
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
            <div id="subscribe-content" class="content-section" style="display: flex;">
                <div id="title-box">
                    <h2 id="title">구독 등급</h2> 
                </div>     
                <div id="sub-info">
                    <form id="sub-form">   
                    <c:if test="${ not empty loginMember }" >  
					    <p>이름</p>
					    <input type="text" id="memberName" name="memberName" value="${ loginMember.memberName }" readonly>                                            
					    <p>아이디</p>
					    <input type="text" id="memberId" name="memberId" value="${ loginMember.memberId }" readonly>   
					    <p>구독 여부</p>
					    <input type="text" id="sub" name="sub" value="${ gradeName }" readonly> 
					</c:if>
                    <c:if test="${ empty loginMember }" >  
					    <p>이름</p>
					    <input type="text" id="memberName" name="memberName" readonly>                                            
					    <p>아이디</p>
					    <input type="text" id="memberId" name="memberId" readonly>   
					    <p>구독 여부</p>
					    <input type="text" id="sub" name="sub" readonly>         
					</c:if>
					</form>
                   <c:if test="${ empty loginMember }" >  
					    <div id="subtext">
					        <p>자세한 할인율과 플랜을 알고싶다면?</p>
					        <p>구독을 하고싶다면?</p>
					    </div>
					    <div id="btn01">
					        <button class="btn1" onclick="location.href='/rushwash/plan/select'">구독 신청하러 가기</button>
					    </div>
					</c:if>
					<c:if test="${gradeName == '비구독'}">
					    <div id="subtext">
					        <p>자세한 할인율과 플랜을 알고싶다면?</p>
					        <p>구독을 하고싶다면?</p>
					    </div>
					    <div id="btn01">
					        <button type="button" class="btn1" onclick="location.href='/rushwash/plan/select'">구독 신청하러 가기</button>
					    </div>
					 </c:if>
                </div>
            </div>
        </div>
    </div>

</body>
<%@ include file='/WEB-INF/views/user/common/user_footer.jsp' %>
</html>
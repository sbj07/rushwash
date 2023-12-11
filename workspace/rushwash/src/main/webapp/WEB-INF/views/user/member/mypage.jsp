<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberVo vo = (MemberVo) request.getAttribute("vo");
	String x = (String) session.getAttribute("alertMsg"); 
	session.removeAttribute("alertMsg");
%>

    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/member/mypage.css">
</head>
<%@ include file='/WEB-INF/views/user/common/user_header.jsp' %>
<body>
	
		<div id="main" style="display: flex;">
        <div id="sidebar">
            <a href="" class="menu-item">내 정보</a>
            <a href="/rushwash/member/editinfo" class="menu-item">개인정보수정</a>
            <a href="/rushwash/member/pay" class="menu-item">결제 수단</a>
            <a href="/rushwash/member/quit" class="menu-item">탈퇴 하기</a>
            <a href="/rushwash/member/sub" class="menu-item">구독 등급</a>
        </div>
        <div id="content">
            <div id="info-content" class="content-section">
                <div id="title-box">
                    <h2 id="title">내 정보</h2> 
                </div>     
                <div id="user-info">
                    <form id="user">        
                    <% if(vo != null){  %>
                    	<p>아이디</p>
						<input type="text" name="memberId" value="<%= vo.getMemberId() %>" readonly>
						<p>이메일</p>
						<input type="text" id="email" name="email" value="<%= vo.getMemberEmail() %>" readonly>
						<p>주소 (배송지)</p>
						<input type="text" id="address" name="address" value="<%= vo.getMemberAddress() %>" readonly>
						<p>전화번호</p>
						<input type="tel" id="phone" name="phone" value="<%= vo.getMemberTel() %>" readonly>
						<p>보유 포인트</p>
						<input type="text" id="point" name="point" value="<%= vo.getPoint() %>" readonly>
                    <% } else { %>
                    	<p>아이디</p>
						<input type="text" name="memberId" value="" readonly>
						<p>이메일</p>
						<input type="text" id="email" name="email" value="" readonly>
						<p>주소 (배송지)</p>
						<input type="text" id="address" name="address" value="" readonly>
						<p>전화번호</p>
						<input type="tel" id="phone" name="phone" value="" readonly>
						<p>보유 포인트</p>
						<input type="text" id="point" name="point" value="" readonly>
                   	 <% } %>
                                 
                    </form>
                </div>
            </div>
        </div>
    </div>
		
	

</body>
<%@ include file='/WEB-INF/views/user/common/user_footer.jsp' %>
</html>
<script>
<% if(x != null){ %>
alert('<%= x %>');
<% } %>
</script>
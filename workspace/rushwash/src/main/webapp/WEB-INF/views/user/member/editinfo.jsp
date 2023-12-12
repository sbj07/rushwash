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
<link rel="stylesheet" href="/rushwash/resources/css/user/member/editinfo.css">
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
            <div id="edit-content" class="content-section">
                <div id="title-box">
                    <h2 id="title">개인정보수정</h2> 
                </div>     
                <div id="edit-info">
                    <form id="edit">
                   <% if(vo != null){  %>
                    	<p>아이디</p>
                        <input type="text" id="userid" name="memberId" value="<%= vo.getMemberId() %>" readonly>
                        <button type="button" class="btn7" onclick="location.href='/rushwash/member/idchange'">변경</button>
                        <p>비밀번호</p>
                        <input type="password" id="password" name="memberPwd" value ="<%= vo.getMemberPwd() %>" readonly>   
                        <button type="button" class="btn7" onclick="location.href='/rushwash/member/pwdchange'">변경</button>                              
                        <p>주소</p>
                        <input type="text" id="address" name="memberAddress" value="<%= vo.getMemberAddress() %>" readonly>   
                        <button type="button" class="btn7" onclick="location.href='/rushwash/member/addrchange'">변경</button>
                        <p>전화번호</p>
                        <input type="tel" id="phone" name="memberTel" value="<%= vo.getMemberTel() %>" readonly>  
                   <% } else { %>
                   			<p>아이디</p>
	                        <input type="text" id="userid" name="memberId" value="" readonly>
	                        <button type="button" class="btn7" onclick="location.href='/rushwash/member/idchange'">변경</button>
	                        <p>비밀번호</p>
	                        <input type="password" id="password" name="memberPwd" value ="" readonly>   
	                        <button type="button" class="btn7" onclick="location.href='/rushwash/member/pwdchange'">변경</button>                              
	                        <p>주소</p>
	                        <input type="text" id="address" name="memberAddress" value="" readonly>   
	                        <button type="button" class="btn7" onclick="location.href='/rushwash/member/addrchange'">변경</button>
	                        <p>전화번호</p>
	                        <input type="tel" id="phone" name="memberTel" value="" readonly> 
	                  	<% } %>                        
                    </form>
                </div>
            </div>
        </div>
    </div>

</body>
<%@ include file='/WEB-INF/views/user/common/user_footer.jsp' %>
</html>
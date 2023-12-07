<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   	String x = (String) request.getAttribute("errorMsg");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/member/login.css">
</head>
<%@ include file='/WEB-INF/views/user/common/user_header.jsp' %>
<body>
	
	<div class="login-container">
      <h1>로그인</h1>
      <form id="login-form" action="/rushwash/member/login" method="post" onsubmit="return frm_check();">
          <input type="text" id="id" name="memberId" placeholder="아이디" required>
          <input type="password" id="password" name="memberPwd" placeholder="비밀번호" required>
          <div class="remember-container">
              <input type="checkbox" id="remember">
              <label for="remember">로그인 상태유지</label>
          </div>
          <input type="submit" value="로그인">
      </form>
      <div class="extra-links">
          <a href="/rushwash/member/join">회원가입</a>
          <a href="/rushwash/member/idfind">아이디 찾기</a>
          <a href="/rushwash/member/pwdfind">비밀번호 찾기</a>
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

<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
 
 
<script type="text/javascript">
     $(function() {
         
           fnInit();
         
     });
     
     function frm_check(){
         saveid();
     }
 
    function fnInit(){
        var cookieid = getCookie("remember");
        console.log(cookieid);
        if(cookieid !=""){
            $("input:checkbox[id='remeber']").prop("checked", true);
            $('#id').val(cookieid);
        }
        
    }    
 
    function setCookie(name, value, expiredays) {
        var todayDate = new Date();
        todayDate.setTime(todayDate.getTime() + 0);
        if(todayDate > expiredays){
            document.cookie = name + "=" + escape(value) + "; path=/; expires=" + expiredays + ";";
        }else if(todayDate < expiredays){
            todayDate.setDate(todayDate.getDate() + expiredays);
            document.cookie = name + "=" + escape(value) + "; path=/; expires=" + todayDate.toGMTString() + ";";
        }
        
        
        console.log(document.cookie);
    }
 
    function getCookie(Name) {
        var search = Name + "=";
        console.log("search : " + search);
        
        if (document.cookie.length > 0) { // 쿠키가 설정되어 있다면 
            offset = document.cookie.indexOf(search);
            console.log("offset : " + offset);
            if (offset != -1) { // 쿠키가 존재하면 
                offset += search.length;
                // set index of beginning of value
                end = document.cookie.indexOf(";", offset);
                console.log("end : " + end);
                // 쿠키 값의 마지막 위치 인덱스 번호 설정 
                if (end == -1)
                    end = document.cookie.length;
                console.log("end위치  : " + end);
                
                return unescape(document.cookie.substring(offset, end));
            }
        }
        return "";
    }
 
    function saveid() {
        var expdate = new Date();
        if ($("#remember").is(":checked")){
            expdate.setTime(expdate.getTime() + 1000 * 3600 * 24 * 30);
            setCookie("remember", $("#id").val(), expdate);
            }else{
           expdate.setTime(expdate.getTime() - 1000 * 3600 * 24 * 30);
            setCookie("remember", $("#id").val(), expdate);
             
        }
    }
 
</script>
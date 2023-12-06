<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/board/center.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>

	<main>
	    <div id="wrap">
	      <div class="font">
	        문의내역
	      </div>
	      <table class="table-wrapper">
	        <tr>
	          <td>번호</td>
	          <td>제목</td>
	          <td>작성일</td>
	        </tr>
	          <tr>
	            <td>1</td>
	            <td>이게뭔가요</td>
	            <td>2023.11.11</td>
	          </tr>
	          <tr>
	            <td>1</td>
	            <td>이게뭔가요</td>
	            <td>2023.11.11</td>
	          </tr>
	          <tr>
	            <td>1</td>
	            <td>이게뭔가요</td>
	            <td>2023.11.11</td>
	          </tr>
	          <tr>
	            <td>1</td>
	            <td>이게뭔가요</td>
	            <td>2023.11.11</td>
	          </tr>
	          <tr>
	            <td>1</td>
	            <td>이게뭔가요</td>
	            <td>2023.11.11</td>
	          </tr>
	          
	       </table>
	       <div class="btn">
	        <button class="btn1" onclick="go();">작성하기</button>
	    </div>
	    </div>
	     <div id="wrap">
	      <div class="font">
	        FAQ
	      </div>
	      <table class="table-wrapper">
	        <tr>
	          <td>번호</td>
	          <td>제목</td>
	          <td>작성일</td>
	        </tr>
	          <tr>
	            <td>1</td>
	            <td>이게뭔가요</td>
	            <td>2023.11.11</td>
	          </tr>
	          <tr>
	            <td>1</td>
	            <td>이게뭔가요</td>
	            <td>2023.11.11</td>
	          </tr>
	          <tr>
	            <td>1</td>
	            <td>이게뭔가요</td>
	            <td>2023.11.11</td>
	          </tr>
	          <tr>
	            <td>1</td>
	            <td>이게뭔가요</td>
	            <td>2023.11.11</td>
	          </tr>
	          <tr>
	            <td>1</td>
	            <td>이게뭔가요</td>
	            <td>2023.11.11</td>
	          </tr>
	          
	       </table>
	    </div>
        
   </main>
        
        

	
    </div>
    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>

    <script>
        function go(){
            window.location.href = '/rushwash/board/qnawrite';
        }
    </script>
</body>
</html>
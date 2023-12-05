<%@page import="com.rushwash.app.board.notice.vo.UserNoticeVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<link rel="stylesheet" href="/rushwash/resources/css/user/notice.css">
<body>
    
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>

	<main>
    <div id="wrap">
      <div class="font">
        공지사항
      </div>
      <table>
        <tr>
          <td colspan="2"></td>
        </tr>
          <tr>
            <td>제목</td>
            <td>작성일시</td>
          </tr>
          
          <%-- <%for(UserNoticeVo vo : boardVoList){ %>
	          <tr>
	            <td><%= vo.getNo()%><%= vo.getTitle() %></td>
	            <td><%= vo.getEnrollDate() %></td>
	          </tr>
          <%}%> --%>
          
       </table>
    </div>
        
   </main>
        
        

	
    </div>
    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>
    
</body>
</html>
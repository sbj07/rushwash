<%@page import="com.rushwash.app.board.notice.vo.UserNoticeVo"%>
<%@ page language="java"
    pageEncoding="UTF-8"%>
    <%
    	UserNoticeVo vo = (UserNoticeVo)request.getAttribute("vo");
    	String currPage = (String)request.getAttribute("currPage");
    	if(currPage == null){
    		currPage = "1";
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/board/notice_write.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>

   <main>
        <div id="wrap">
            <div class="font">
                공지사항
            </div>
            <table>
              
                <tr>
                    <td>제목</td>
                    <td><%= vo.getTitle()%><div class="date"></div></td>
                   	<td class="date"><%= vo.getEnrollDate() %></td>
                </tr>
                <tr>
                    <td id="content">공지</td>
                    <td colspan="2"><%= vo.getContent()%></td>
                </tr>
                <tr class="third">
                    <td colspan="3"><button class="btn1" onclick="go();">목록으로</button></td>
                </tr>
            </table>
        </div>
	</main>

    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>

    <script>
        function go(){
            window.location.href = '/rushwash/board/notice';
        }
    </script>
</body>
</html>
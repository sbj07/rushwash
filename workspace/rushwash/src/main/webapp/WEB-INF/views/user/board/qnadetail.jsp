<%@page import="com.rushwash.app.board.qna.vo.QnaVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	QnaVo vo = (QnaVo)request.getAttribute("vo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/board/qna_detail.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>

	<main>
        <div id="wrap">
            <div class="font">
                문의내역
            </div>
            <table>
                <tr>
                    <td>제목</td>
                    <td><%= vo.getTitle() %></td>
                </tr>
                <tr>
                    <td id="content">내용</td>
                    <td><%= vo.getContent() %></td>
                </tr>
                <tr class="third">
                    <td class="answer">답변</td>
                    <% if(vo.getCommt() == null ){%>
                    	<td></td>                    
                    <% }else {%>
                    	<td><%= vo.getCommt() %></td>
                    <%} %>
                </tr>
            </table>
            <div class="btn">
            	<button class="btn1" onclick="location.href='/rushwash/board/qnaedit?no=<%= vo.getNo() %>'">수정하기</button>
				<button class="btn1" onclick="location.href='/rushwash/board/qnadelete?no=<%= vo.getNo() %>'">삭제하기</button>
            	<button class="btn1" onclick="go();">목록으로</button>
            </div>
        </div>
	</main>

    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>

    <script>
        function go(){
            window.location.href = '/rushwash/board/center';
        }
    </script>
</body>
</html>
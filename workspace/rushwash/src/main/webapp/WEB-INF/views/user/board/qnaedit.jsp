<%@page import="com.rushwash.app.board.qna.vo.QnaVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	QnaVo vo = (QnaVo) request.getAttribute("vo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/board/qna_write.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>

    <main>
        <div id="wrap">
            <div class="font">
                문의작성하기(수정)
            </div>
          <form action="/rushwash/board/qnaedit" method="post">
            <table>
                <tr>
                    <td class="title">제목</td>
                    <td><input type="text" name="title" value="<%= vo.getTitle()%>"></td>
                </tr>
                <tr class="second">
                    <td></td>
                    <td><textarea name="content" id="content" cols="100" rows="30" ><%= vo.getContent()%></textarea></td>
                </tr>
                <tr>
                    
                    <td class="submit-cell" colspan="2"><input type="submit" value="수정하기" class="submit"></td>
                </tr>
            </table>
          </form>
        </div>
        
    </main>
    

    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>
    
    <script>
    	
    </script>
</body>
</html>
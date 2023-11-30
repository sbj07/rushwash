<%@ page language="java"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/notice_write.css">
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
                    <td></td>
                </tr>
                <tr>
                    <td id="content">공지</td>
                    <td></td>
                </tr>
                <tr class="third">
                    <td colspan="2"><button class="btn1" onclick="go();">목록으로</button></td>
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
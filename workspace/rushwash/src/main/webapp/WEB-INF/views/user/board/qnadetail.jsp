<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/qna_detail.css">
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
                    <td></td>
                </tr>
                <tr>
                    <td id="content">공지</td>
                    <td></td>
                </tr>
                <tr class="third">
                    <td class="answer">답변</td>
                    <td></td>
                </tr>
            </table>
            <div class="btn">
            	<button class="btn1" onclick="go();">목록으로</button>
            </div>
        </div>
	</main>

    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>

    <script>
        function go(){
            window.location.href = '/rushwash/board/qna';
        }
    </script>
</body>
</html>
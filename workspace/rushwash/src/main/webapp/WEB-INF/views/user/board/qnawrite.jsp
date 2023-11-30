<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/qna_write.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>

    <main>
        <div id="wrap">
            <div class="font">
                문의작성하기
            </div>
          <form action="">
            <table>
                <tr>
                    <td class="title">제목</td>
                    <td><input type="text" name="title"></td>
                </tr>
                <tr class="second">
                    <td></td>
                    <td><textarea name="content" id="content" cols="100" rows="30" placeholder="의견을 남겨주세요."></textarea></td>
                </tr>
                <tr>
                    
                    <td class="submit-cell" colspan="2"><input type="submit" value="작성하기" class="submit"></td>
                </tr>
            </table>
          </form>
        </div>
    </main>

    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>
</body>
</html>
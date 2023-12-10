<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수거요청서</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/apply/old_clothes.css">

</head>

<body>
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>
    <main>
        <div class="page-name">헌옷 수거</div>
        <div class="form-box">
            <div class="form-header">수거 요청서 작성</div>
            <form action="/rushwash/apply/request/old-clothes" method="post">
                <div class="form-body form-content1">
                    <span>수거/배송지 정보</span>
                    <hr>
                    <table class="form-table" id="addr-info">
                        <tr>
                            <td>요청인</td>
                            <td><span class="info-span">${loginMember.memberName}</span></td>
                        </tr>
                        <tr>
                            <td>연락처</td>
                            <td><span class="info-span">${loginMember.memberTel}</span></td>
                        </tr>
                        <tr>
                            <td>주소지</td>
                            <td><span class="info-span">${loginMember.memberAddress}</span></td>
                        </tr>
                    </table>
                </div>
                <div class="form-body form-content2">
                    <div class="grey-box">
                        <span>포인트 적립 안내</span>
                        <pre>수거 신청하고 헌 옷 수거가 완료된 후! [헌옷무게 X500P]로 계산되어<br>자동으로 포인트가 지급됩니다!</pre>
                    </div>
                </div>
                <div class="form-footer">
                    <button class="btn-footer" type="submit">요청하기</button>
                </div>
            </form>
        </div>
    </main>
    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>
</body>
</html>
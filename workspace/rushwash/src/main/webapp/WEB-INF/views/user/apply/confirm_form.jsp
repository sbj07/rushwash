<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세탁요청서</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/apply/confirm_form.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>
    <main>
        <form action="">
            <div class="form-box">

                <div class="form-body form-header">결제확인서</div>
                <div class="alert-box">
                    <span>결제가 완료되었습니다! 결제확인서를 확인해주세요!</span>
                </div>
                <div class="form-body form-content">
                    <span>수거/배송지 정보</span>
                    <hr>
                    <table class="form-table" id="addr-info">
                        <tr>
                            <td>수령인</td>
                            <td>이름</td>
                        </tr>
                        <tr>
                            <td>연락처</td>
                            <td>연락처</td>
                        </tr>
                        <tr>
                            <td>주소지</td>
                            <td>배송지</td>
                        </tr>
                    </table>
                </div>
                <div class="form-body form-content">
                    <span>최종 결제 금액</span>
                    <hr>
                    <table class="form-table">
                        <tr>
                            <td>수량합계</td>
                            <td>개수</td>
                        </tr>
                        <tr>
                            <td>사용 포인트</td>
                            <td>사용포인트값 </td>
                        </tr>
                        <tr>
                            <td>최종 결제 금액</td>
                            <td>15000 원</td>
                        </tr>
                    </table>
                </div>
                <div class="form-body form-content">
                    <span>결제 수단</span>
                    <hr>
                    <table class="form-table">
                        <tr>
                            <td>카드사</td>
                            <td>신한</td>
                        </tr>
                        <tr>
                            <td>카드번호</td>
                            <td>1234-1234-****-****</td>
                        </tr>
                    </table>
                </div>
                <div class="form-body form-footer">
                    <button id="btn-go-main">메인으로</button>
                </div>
            </div>
        </form>
    </main>
    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>
</body>
</html>
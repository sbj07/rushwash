<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세탁요청서</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/payment/laundry_form.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>
    <main>
        <form action="">
            <div class="form-box">

                <div class="form-body form-header">세탁요청서 작성</div>

                <div class="form-body form-content">
                    <span>수거/배송지 정보</span>
                    <hr>
                    <table class="form-table" id="addr-info">
                        <tr>
                            <td>수령인</td>
                            <td><input type="text" id="user-name"></td>
                        </tr>
                        <tr>
                            <td>연락처</td>
                            <td><input type="text" id="user-phone"></td>
                        </tr>
                        <tr>
                            <td>주소지</td>
                            <td><input type="text" id="user-addr"></td>
                        </tr>
                    </table>
                </div>
                <div class="form-body form-content">
                    <span>최종 결제 금액</span>
                    <hr>
                    <table class="form-table">
                        <tr>
                            <td>수량합계</td>
                            <td colspan="2">15개</td>
                        </tr>
                        <tr>
                            <td>포인트 할인</td>
                            <td>보유포인트 : </td>
                            <td><input type="text" id="user-point"></td>
                        </tr>
                        <tr>
                            <td>최종 결제 금액</td>
                            <td colspan="2">15000 원</td>
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
                        <tr>
                            <td colspan="2"><button id="btn-card-regist">결제수단등록</button></td>
                        </tr>
                    </table>
                </div>
                <div class="form-body form-footer">
                    <button id="btn-payment">결제하기</button>
                </div>
            </div>
        </form>
    </main>
    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>
</body>
</html>
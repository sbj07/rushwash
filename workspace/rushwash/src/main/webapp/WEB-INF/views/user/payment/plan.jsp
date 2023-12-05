<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정기결제</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/payment/plan.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>
    <main>
        <div class="form-box">
            <div class="form-body form-header">정기결제</div>

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

            <form action="">

                <div class="form-body form-content">
                    <span>결제 금액</span>
                    <hr>
                    <table class="form-table">
                        <tr>
                            <td>선택하신 플랜</td>
                            <td>플랜명</td>
                        </tr>
                        <tr>
                            <td>월 결제 예정일</td>
                            <td>sysdate</td>
                        </tr>
                        <tr>
                            <td>정기 결제 금액</td>
                            <td>플랜별금액</td>
                        </tr>
                    </table>
                </div>

                <div class="form-body form-footer">
                    <button id="btn-regist">결제하기</button>
                </div>

            </form>
        </div>
    </main>
    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제수단등록</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/payment/card_regist.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>
    <main>
        <div class="form-box">

            <div class="form-body form-header">결제수단 등록</div>

            <div class="form-body form-content">
                <span>현재 결제 수단</span>
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
                    <span>결제 수단 등록/변경</span>
                    <hr>
                    <table class="form-table">
                        <tr>
                            <td>카드사</td>
                            <td>
                                <select id="">
                                    <option value="">에제</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>카드번호</td>
                            <td><input type="text"></td>
                        </tr>
                        <tr>
                            <td>카드 유효기간</td>
                            <td><input type="text" placeholder="MM/YY"></td>
                        </tr>
                        <tr>
                            <td>CVC 번호</td>
                            <td><input type="text"></td>
                        </tr>
                        <tr>
                            <td>카드 비밀번호</td>
                            <td><input type="password"></td>
                        </tr>
                    </table>
                </div>

                <div class="form-body form-footer">
                    <button id="btn-regist">등록/변경</button>
                </div>

            </form>
        </div>
    </main>
    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제수단등록</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/payment/card_regist.css">
</head>

<script>
    <c:if test="${ not empty alertMsg}">
        alert("${alertMsg}");
    </c:if>
</script>
<body>
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>
    <main>
        <div class="form-box">

            <div class="form-body form-header">결제수단 등록</div>

            <c:if test="${not empty cardVo}">
                <div class="form-body form-content">
                        <span>현재 결제 수단</span>
                        <hr>
                    <table class="form-table">
                        <tr>
                            <td>카드사</td>
                            <td>${cardVo.cardCompany}</td>
                        </tr>
                        <tr>
                            <td>카드번호</td>
                            <td>${cardVo.cardNo}</td>
                        </tr>
                    </table>
                </div>
            </c:if>

            <form action="/rushwash/payment/card-regist" method="post">

                <div class="form-body form-content">
                    <span>결제 수단 등록/변경</span>
                    <hr>
                    <table class="form-table">
                        <tr>
                            <td>카드사</td>
                            <td>
                                <select name="cardCompany">
                                    <option value="신한">신한</option>
                                    <option value="삼성">삼성</option>
                                    <option value="KB">KB</option>
                                    <option value="농협">농협</option>
                                    <option value="롯데">롯데</option>
                                    <option value="우리">우리</option>
                                    <option value="하나">하나</option>
                                    <option value="현대">현대</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>카드번호</td>
                            <td>
                                <input type="password" name="cardNo1"> -
                                <input type="password" name="cardNo2"> -
                                <input type="password" name="cardNo3"> - 
                                <input type="password" name="cardNo4">
                            </td>
                        </tr>
                        <tr>
                            <td>카드 유효기간</td>
                            <td><input type="month" name="validityPeriod"></td>
                        </tr>
                        <tr>
                            <td>CVC 번호</td>
                            <td><input type="password" name="cvcNo"></td>
                        </tr>
                        <tr>
                            <td>카드 비밀번호</td>
                            <td><input type="password" name="cardPwd"></td>
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

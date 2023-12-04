<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Premium</title>
    <link rel="stylesheet" href="/rushwash/resources/css/user/apply/premium_basket.css">
</head>

<body>
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>
        
    <main>
        <div id="wrap">
            <div class="price-box">
                <button data-target="top-table" class="btn-top tag-btn btn-selected">상의</button>
                <button data-target="bottom-table" class="btn-bottom tag-btn">하의</button>
                <button data-target="outer-table" class="btn-outer tag-btn">아우터</button>

                <table class="price-table">

                    <!-- 상단 -->
                    <thead>
                        <th id="product">품목</th>
                        <th id="normal-price">일반가격</th>
                        <th id="plan-price">플랜 할인 가격</th>
                        <th id="ea">수량</th>
                    </thead>

                    <!-- 바디 -->
                    <tbody>
                        <tr>
                            <td>
                                와이셔츠
                            </td>
                            <td>
                                2100원
                            </td>
                            <td>1995</td>
                            <td>
                                <div class="quantity">
                                    <button class="quantity-up" id="up-btn">+</button>
                                    <input type="text" class="quantity-input" value="0" min="0" max="99">
                                    <button class="quantity-down" id="down-btn">-</button>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                와이셔츠
                            </td>
                            <td>
                                2100원
                            </td>
                            <td>1995</td>
                            <td>
                                <div class="quantity">
                                    <input type="text" class="quantity-input" value="0" min="0" max="99">
                                    <button class="quantity-up" id="up-btn">+</button>
                                    <button class="quantity-down" id="down-btn">-</button>
                                </div>
                            </td>
                        </tr>
                    </tbody>


                       <!-- 하단 -->
                    <tfoot>
                        <tr id="tfoot-top">
                            <td>수량합계</td>
                            <td>총가격</td>
                            <td>19000원</td>
                            <td rowspan="2" class="td-payment">
                                <button id="btn-payment">바로결제</button>
                            </td>
                        </tr>
                        <tr id="tfoot-bottom">
                            <td>15개</td>
                            <td>플랜 할인 가격</td>
                            <td>15000원</td>
                        </tr>
                    </tfoot>

                </table>
                <table id="bottom-table"></table>
                <table id="outer-table"></table>
            </div>
        </div>
    </main>
        
    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>
</body>
</html>

<script>

    // 수량증감 함수
    document.addEventListener('DOMContentLoaded', function () {
        var quantityInput = document.querySelector('.quantity-input');
        var quantityUpBtn = document.querySelector('.quantity-up');
        var quantityDownBtn = document.querySelector('.quantity-down');

        quantityUpBtn.addEventListener('click', function () {
            var currentValue = parseInt(quantityInput.value, 10) || 0;
            var maxValue = parseInt(quantityInput.getAttribute('max'), 10) || Infinity;

            if (currentValue < maxValue) {
                quantityInput.value = currentValue + 1;
            }
        });

        quantityDownBtn.addEventListener('click', function () {
            var currentValue = parseInt(quantityInput.value, 10) || 0;
            var minValue = parseInt(quantityInput.getAttribute('min'), 10) || 0;

            if (currentValue > minValue) {
                quantityInput.value = currentValue - 1;
            }
        });

        // 입력값이 숫자가 아닌 경우 처리 (옵션)
        quantityInput.addEventListener('input', function () {
            var sanitizedValue = this.value.replace(/[^0-9]/g, '');
            this.value = sanitizedValue;
        });
    });

</script>
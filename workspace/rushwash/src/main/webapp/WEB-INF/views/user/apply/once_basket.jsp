<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Once</title>
    <link rel="stylesheet" href="/rushwash/resources/css/user/apply/once_basket.css">
    <script defer src="/rushwash/resources/js/user/apply/once_basket.js"></script>
</head>

<body>
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>
    <main>
        <div id="wrap">
            <div class="price-box">
                <button data-target="top-table" class="btn-top tag-btn btn-selected" id="top-category" value="1">상의</button>
                <button data-target="bottom-table" class="btn-bottom tag-btn" id="bottom-category" value="2">하의</button>
                <button data-target="outer-table" class="btn-outer tag-btn" id="outer-category"value="3">아우터</button>

                <form action="/rushwash/apply/request/once" method="post">
                    <table class="price-table">
                        <!-- 상단 -->
                        <thead>
                            <th id="product">품목</th>
                            <th style="display: none;"></th>
                            <th id="normal-price">일반가격</th>
                            <th colspan="2" id="ea">수량</th>
                        </thead>

                        <!-- 바디 -->
                        <tbody id="resultTable">
                        </tbody>

                        <!-- 하단 -->
                        <tfoot>
                            <tr id="tfoot-top">
                                <td>수량합계</td>
                                <td rowspan="2">총가격</td>
                                <td rowspan="2"><span class="normalPriceSum">0</span>원</td>
                                <td rowspan="2" class="td-payment">
                                    <button type="submit" id="btn-payment">바로결제</button>
                                </td>
                            </tr>
                            <tr id="tfoot-bottom">
                                <td><span class="eaSum" name="eaSum">0</span>개</td>
                            </tr>
                        </tfoot>

                    </table>
                </form>
            </div>
        </div>
    </main>
        
    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>
</body>
</html>

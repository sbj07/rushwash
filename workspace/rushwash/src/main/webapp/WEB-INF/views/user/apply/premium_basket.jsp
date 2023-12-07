<%@page import="com.rushwash.app.item.vo.ItemVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    List<ItemVo> itemList = (List<ItemVo>) request.getAttribute("itemList");
%>    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Premium</title>
    <link rel="stylesheet" href="/rushwash/resources/css/user/apply/premium_basket.css">
    <script defer src="/rushwash/resources/js/user/apply/premium_basket.js"></script>
</head>

<body>
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>
        
    <main>
        <div id="wrap">
            <div class="price-box">
                <button data-target="top-table" class="btn-top tag-btn btn-selected" id="top-category" value="1">상의</button>
                <button data-target="bottom-table" class="btn-bottom tag-btn" id="bottom-category" value="2">하의</button>
                <button data-target="outer-table" class="btn-outer tag-btn" id="outer-category"value="3">아우터</button>

                <form action="/rushwash/apply/request/premium" method="post">
                    <table class="price-table">
                        <!-- 상단 -->
                        <thead>
                            <th id="product">품목</th>
                            <th id="normal-price">일반가격</th>
                            <th id="plan-price">플랜 할인 가격</th>
                            <th id="ea">수량</th>
                        </thead>

                        <!-- 바디 -->
                        <tbody id="resultTable">
                        </tbody>

                        <!-- 하단 -->
                        <tfoot>
                            <tr id="tfoot-top">
                                <td>수량합계</td>
                                <td>총가격</td>
                                <td>19000원</td>
                                <td rowspan="2" class="td-payment">
                                    <button type="submit" id="btn-payment">바로결제</button>
                                </td>
                            </tr>
                            <tr id="tfoot-bottom">
                                <td><span class="eaSum">0</span>개</td>
                                <td>플랜 할인 가격</td>
                                <td>15000원</td>
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
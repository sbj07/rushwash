<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="/rushwash/resources/css/user/order/detail.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>

<main id="wrap">

    <div id="div1">
       주문내역 상세조회
       <br>
       <br>
    </div>

    <div id="div2">
        <table>
            <thead>
                <tr>
                    <th>상품</th>
                    <th>가격</th>
                    <th>수량</th>
                    <th>주문일</th>
                    <th>진행상태</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>스터트</td>
                    <td>5,000 원</td>
                    <td>2</td>
                    <td>2021.02.15</td>
                    <td>세탁중</td>
                </tr>
                <tr>
                    <td>청바지</td>
                    <td>5,000  원</td>
                    <td>1</td>
                    <td>2021.02.15</td>
                    <td>세탁중</td>
                </tr>
                <tr>
                    <td>와이셔츠</td>
                    <td>5,000 원</td>
                    <td>2</td>
                    <td>2021.02.15</td>
                    <td>세탁중</td>
                </tr>
            </tbody>
        </table>
    </div>

    <div id="div2">

    </div>
</main>

<%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>

</body>
</html>
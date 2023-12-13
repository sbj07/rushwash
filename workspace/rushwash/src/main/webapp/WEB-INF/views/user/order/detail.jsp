<%@page import="com.rushwash.app.order.vo.OrderVo"%>
<%@page import="com.rushwash.app.member.vo.MemberVo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="/rushwash/resources/css/user/order/detail.css">
 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>	
</head>
<script >
	console.log("${orderDetailNo}");
</script>
<body>

<%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>
<main id="wrap">

    <div id="div1">
       주문내역 상세조회
       <br>
       <br>
    </div>
   <div id="div4">총 가격 : ${totalprice}원</div>
    <div id="div2">
    <table id="tt00">
            <thead>
               <tr id="th1">
                  <th>상품</th>
                  <th>수량</th>
                  <th>주문일</th>
                  <th>예상세탁완료일</th>
                  <th>진행상태</th>
               </tr>
            </thead>
            <tbody>
         
               <c:forEach items="${voList }" var="vo">
                  <tr class="td2" id="td21">
                     <td>${vo.item}</td>
                     <td>${vo.ea}</td>
                     <td>${vo.paymentDate }</td>
                     <td>${vo.expDate }</td>
                     <td>${vo.laundryStatus }</td>
                  </tr>
               </c:forEach>
               <tr class="td2" id="td22">
                  <td>수령인</td>
                  <td>핸드폰번호</td>
                  <td colspan="2">주소</td>
                  <td colspan="2">요청사항</td>
               </tr>
                  <tr class="td2" id="td23">
                     <td>${loginMember.memberName }</td>
                     <td>${loginMember.memberTel }</td>
                     <td colspan="2">${loginMember.memberAddress }</td>
                     <td colspan="2">${OrderVO.request }</td>
                  </tr>

            </tbody>
         </table>
    </div>

    <div id="div3">
    <form action="/rushwash/order/detail" method="post" id="ffom0">
    	<input type="hidden" name="orderNo" value="${orderDetailNo}">
    	<c:if test="${ orderStatus eq '1'}">
      <button type="submit" id="btn2">주문취소</button>
      </c:if>
    </form>
    <form action="/rushwash/order/cpmpleted" method="post" >
        <input type="hidden" name="orderNo" value="${orderDetailNo}">
     <c:if test="${ orderStatus eq '5' }">
      <button type="submit" id="btn2" >수령완료</button>
      </c:if>
    </form>
    </div>
</main>

<%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>

</body>
</html>
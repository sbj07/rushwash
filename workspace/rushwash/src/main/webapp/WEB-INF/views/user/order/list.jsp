<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="/rushwash/resources/css/user/order/list.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OrderList</title>
</head>
<script>
	// <c:if test="${not empty detailBtn}">
	// 	alert("${alertMsg}");
	// 	console.log(detailBtn);
	// </c:if>


</script>
<body>

	<%@ include file="/WEB-INF/views/user/common/user_header.jsp"%>

	<main id="wrap">


		<div id="btn">
			<button type="button" class="btn1" onclick="showTable('t1')">진행중인내역</button>
			<button type="button" class="btn2" onclick="showTable('t2')">지난내역</button>
		</div>


		<div id="order">
			<table id="t1">
				<thead>
					<tr>
						<th>주문번호</th>
						<th>총 수량</th>
						<th>주문일</th>
						<th>주문상태</th>
						<th>상세조회</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${ orderVoList }" var="vo">
						<tr id="trParent">
							<td>${vo.no}</td>
							<td>${vo.ea}</td>
							<td>${vo.paymentDate}</td>
							<td>${vo.laundryStatus}</td>
							<td id="trChild"><a href="/rushwash/order/detail?no=${ vo.no }">상세조회</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

			<table id="t2">
				<thead>

					<tr>
						<th>주문번호</th>
						<th>총 수량</th>
						<th>수령일</th>
						<th>주문상태</th>
					</tr>
				</thead>

				<tbody>

					<c:forEach items="${orderVoList}" var="vo">
						<tr>
							<td>${vo.no }</td>
							<td>${vo.ea }</td>
							<td>${vo.receiveDate }</td>
							<td>${vo.orderStatus }</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>


		<div id="ttn2"></div>



	</main>


	<%@ include file="/WEB-INF/views/user/common/user_footer.jsp"%>
</body>

<script>
	
	// window.onload = function() {

	// 	document.getElementById('t1').style.display = 'table';
	// 	document.getElementById('t2').style.display = 'none';

	// };

	function showTable(tableId) {
		console.log(tableId);
		//         document.getElementById('t1').style.display = 'table';
		//         document.getElementById('t2').style.display = 'none';

		if (tableId === 't1') {

			document.getElementById('t1').style.display = 'table';
			document.getElementById('t2').style.display = 'none';
			location.href="/rushwash/order/list?deleteYn=N";
		} else if (tableId === 't2') {
			console.log("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

			let parent = document.getElementById("trParent");
			let child=  document.getElementById("trChild");
			parent.removeChild(child);
			document.getElementById('t1').style.display = 'none';
			document.getElementById('t2').style.display = 'table';
			location.href="/rushwash/order/list?deleteYn=Y";

		}
	}
</script>



</html>

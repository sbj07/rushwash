<%@page import="com.rushwash.admin.app.laundry.vo.OrderVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<OrderVo> voList = (List<OrderVo>) request.getAttribute("voList");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
<%@ include file="/WEB-INF/admin/view/common/header.jsp"%>
</head>

<!-- PAGE TOP -->
<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">

		<%@ include file="/WEB-INF/admin/view/common/sidebar.jsp"%>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">
				<!-- 탑바 -->
				<%@ include file="/WEB-INF/admin/view/common/topbar.jsp"%>

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading(페이지 제목) -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">세탁물 관리</h1>
					</div>
					<p class="mb-4">정렬이 가능하며, 각 주문은 세탁상태가 모두 "세탁완료"가 될 경우, 배송이
						시작됩니다.</p>

					<!-- End of Main Content -->

					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">전체 세탁물</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>주문번호</th>
											<th>유저번호</th>
											<th>결제가격</th>
											<th>결제일</th>
											<th>수거일</th>
											<th>발송일</th>
											<th>수령완료일</th>
											<th>요청사항</th>
											<th>신청주소</th>
											<th>처리상태</th>
											<th>취소상태</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>주문번호</th>
											<th>유저번호</th>
											<th>결제가격</th>
											<th>결제일</th>
											<th>수거일</th>
											<th>발송일</th>
											<th>수령완료일</th>
											<th>요청사항</th>
											<th>신청주소</th>
											<th>처리상태</th>
											<th>취소상태</th>
										</tr>
									</tfoot>
									<tbody>
										<%
										for (OrderVo vo : voList) {
										%>
										<tr>
											<td><%=vo.getOrderNo()%></td>
											<td><%=vo.getMemberNo()%></td>
											<td><%=vo.getPrice()%></td>
											<td><%=vo.getPaymentDate()%></td>
											<td><%=vo.getCollectDate()%></td>
											<td><%=vo.getDiliveryDate()%></td>
											<td><%=vo.getReceiveDate()%></td>
											<td>
												<%if(vo.getOrderRequset() != null) { %>
													<%=vo.getOrderRequset() %>
												<%}else{ %>
													-
												<%} %>
											</td>
											<td><%=vo.getAddress()%></td>
											<td>
												<form id="statusForm_<%=vo.getOrderNo()%>">
													<select class="custom-select" name="status">
														<option class="options" value="1" <%=vo.getStatus().equals("1") ? "selected" : "" %> disabled>수거요청</option>
														<option class="options" value="2" <%=vo.getStatus().equals("2") ? "selected" : "" %>>수거완료</option>
														<option class="options" value="3" <%=vo.getStatus().equals("3") ? "selected" : "" %>>세탁중</option>
														<option class="options" value="4" <%=vo.getStatus().equals("4") ? "selected" : "" %>>배송중</option>
														<option class="options" value="5" <%=vo.getStatus().equals("5") ? "selected" : "" %>>배송완료</option>
														<option class="options" value="6" <%=vo.getStatus().equals("6") ? "selected" : "" %> disabled>수령완료</option>
													</select> 
													<input type="button" class="btn btn-primary" value="제출" onclick="submitForm(<%=vo.getOrderNo()%>)">
												</form>
											</td>
											<td><%=vo.getDelYn()%></td>
										</tr>
										<%
										}
										%>
									</tbody>
								</table>
							</div>
						</div>
					</div>

					<%@ include file="/WEB-INF/admin/view/common/footer.jsp"%>
				</div>
			</div>
		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<%@ include file="/WEB-INF/admin/view/common/logoutModal.jsp"%>

</body>
<script type="text/javascript">
     // Use querySelectorAll to select all elements with the class "custom-select"
    var statusSelects = document.querySelectorAll('.custom-select');
     console.log(statusSelects);

     function backColor(){
    	// Add event listener to each selected element
    	    statusSelects.forEach(function(statusSelect) {
    	      // Get the initial selected value
    	      var selectedValue = statusSelect.value;

    	      // Set the background color based on the initial selected value
    	      switch (selectedValue) {
			    case "1":
			    case "2":
			        statusSelect.style.backgroundColor = "#f8f9fc";
			        break;
			    case "3":
			    case "4":
			        statusSelect.style.backgroundColor = "lightblue";
			        break;
			    case "5":
			    case "6":
			        statusSelect.style.backgroundColor = "lightgreen";
			        break;
			    default:
			        statusSelect.style.backgroundColor = "";
			}
     	})
     } //backColor End
	 backColor();
 
 	//AJAX
 	function submitForm(no) {
 		  // JS오브젝트 생성
 		  let formData = {
 				no: no,
                status: document.querySelector('#statusForm_' + no + ' select[name="status"]').value
            };
 		  // 데이터를 JSON 방식으로
 		  let jsonString = JSON.stringify(formData);

 		  // URL 전달 패치 (옵션 : 포스트, json, body지정)
 		  fetch('http://127.0.0.1:8888/rushwash/admin/laundry', {
 		    method: 'POST',
 		    headers: {'Content-Type': 'application/json'},
 		    body: jsonString
 		  })
 		  .then(resp => {
 		    if (!resp.ok) {throw new Error('Network response was not ok');}
 		    return resp.json();
 		  })
 		  .then(data => {
 		  })
 		  .catch(error => {
 		    // Handle errors
 		    console.error('There was a problem with the fetch operation:', error);
 		  });
 				
 		 backColor();
 	}//confirm end
 	
</script>

</html>
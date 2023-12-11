<%@page import="com.rushwash.admin.app.laundry.vo.LaundryVo"%>
<%@page import="java.util.List"%>
<%
List<LaundryVo> voList = (List<LaundryVo>) request.getAttribute("voList");
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
						<h1 class="h3 mb-0 text-gray-800">상세 세탁물 관리</h1>
					</div>
					<p class="mb-4">각 주문은 세탁상태가 모두 "세탁완료"가 될 경우, 배송이 시작됩니다.</p>

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
											<th>세탁물번호</th>
											<th>주문번호</th>
											<th>유저이름</th>
											<th>품목명</th>
											<th>수량</th>
											<th>세탁시작일</th>
											<th>세탁완료일</th>
											<th>세탁상태</th>
											<th>취소상태</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>세탁물번호</th>
											<th>주문번호</th>
											<th>유저이름</th>
											<th>품목명</th>
											<th>수량</th>
											<th>세탁시작일</th>
											<th>세탁완료일</th>
											<th>세탁상태</th>
											<th>취소상태</th>
										</tr>
									</tfoot>
									<tbody>
										<%
										for (LaundryVo vo : voList) {
										%>
										<tr>
											<td><%=vo.getNo()%></td>
											<td><%=vo.getOrderNo()%></td>
											<td><%=vo.getMemberName()%></td>
											<td><%=vo.getItem()%></td>
											<td><%=vo.getEa()%></td>
											<td id="startDate_<%=vo.getNo()%>"><%=vo.getWashStartDate()%></td>
											<td id="endDate_<%=vo.getNo()%>"><%=vo.getWashEndDate()%></td>
											<td>
												<form id="statusForm_<%=vo.getNo()%>">
													<select class="custom-select" name="status">
														<option class="options" value="1"
															<%=vo.getStatusNo().equals("1") ? "selected" : ""%>>대기</option>
														<option class="options" value="2"
															<%=vo.getStatusNo().equals("2") ? "selected" : ""%>>세탁중</option>
														<option class="options" value="3"
															<%=vo.getStatusNo().equals("3") ? "selected" : ""%>>세탁완료</option>
													</select> <input type="button" class="btn btn-primary" value="제출"
														onclick="submitForm(<%=vo.getNo()%>)">
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

     function backColor(){
    	// Add event listener to each selected element
    	    statusSelects.forEach(function(statusSelect) {
    	      // Get the initial selected value
    	      var selectedValue = statusSelect.value;

    	      // Set the background color based on the initial selected value
    	      switch (selectedValue) {
    	        case "1":
    	          statusSelect.style.backgroundColor = "#f8f9fc";
    	          break;
    	        case "2":
    	          statusSelect.style.backgroundColor = "lightblue";
    	          break;
    	        case "3":
    	          statusSelect.style.backgroundColor = "lightgreen";
    	          break;
    	        default:
    	          statusSelect.style.backgroundColor = "";
    	      }
    	    })
     }
	 backColor();
 
	 //ajax

function submitForm(no) {
    // JS 오브젝트 생성
    let formData = {
        no: no,
        status: document.querySelector('#statusForm_' + no + ' select[name="status"]').value
    };
    // 데이터를 JSON 방식으로
    let jsonString = JSON.stringify(formData);

    // URL 전달 패치 (옵션 : 포스트, json, body지정)
    fetch('http://127.0.0.1:8888/rushwash/admin/laundry/control', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: jsonString
    })
    .then(resp => {
        if (!resp.ok) {
            throw new Error('Network response was not ok');
        }
        return resp.json();
    })
    .then((data) => {
        // addProperty한 데이터 가져오기
        const updatedStartDate = data.updatedStartDate;
        const updatedEndDate = data.updatedEndDate;

        // Update only the corresponding row
        let startDateElement = document.querySelector('#startDate_' + no);
        let endDateElement = document.querySelector('#endDate_' + no);

        // Update the content of the elements
        if (startDateElement && endDateElement) {
            startDateElement.innerHTML = updatedStartDate;
            endDateElement.innerHTML = updatedEndDate;
        }

        backColor(); // Make sure to call this after updating the elements
    });
}
 	
</script>

</html>
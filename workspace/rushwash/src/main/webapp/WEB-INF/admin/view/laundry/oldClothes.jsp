<%@page import="com.rushwash.admin.app.oldClothes.vo.OldClothesVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
		List<OldClothesVo> voList = (List<OldClothesVo>) request.getAttribute("voList");
	
	
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
						<h1 class="h3 mb-0 text-gray-800">헌옷 관리</h1>
					</div>
					<p class="mb-4">헌옷 무게당 포인트를 지급하여야 합니다.</p>

					<!-- End of Main Content -->

					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">전체 헌옷</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>번호</th>
											<th>유저번호</th>
											<th>수거요청일자</th>
											<th>수거일자</th>
											<th>무게(g)</th>
											<th>처리상태</th>
											<th>취소상태</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>번호</th>
											<th>유저번호</th>
											<th>수거요청일자</th>
											<th>수거일자</th>
											<th>무게(g)</th>
											<th>처리상태</th>
											<th>취소상태</th>
										</tr>
									</tfoot>
									<tbody>
										<%
									    for (OldClothesVo vo : voList) {
									        String statusNo = vo.getStatusNo();
									        // vo.getStatusNo가 1 또는 2인 경우에만 해당 행을 표시
									        if ("1".equals(statusNo) || "2".equals(statusNo)) {
										%>
											<td><%=vo.getNo()%></td>
											<td><%=vo.getMemberNo()%></td>
											<td><%=vo.getRequestDate()%></td>
											<td>
										    <% if (vo.getCollectDate() != null) { %>
										        <%= vo.getCollectDate() %>
										    <% } %>
											</td>
											<td><%=vo.getWeight()%></td>
											<td>
												<form id="statusForm_<%=vo.getNo()%>">
													<select class="custom-select" name="status">
														<option class="options" value="1" <%=vo.getStatusNo().equals("1") ? "selected" : "" %>>수거요청</option>
														<option class="options" value="2" <%=vo.getStatusNo().equals("2") ? "selected" : "" %>>수거완료</option>
														<option class="options" value="3" <%=vo.getStatusNo().equals("3") ? "selected" : "" %>>지급완료</option>
													</select> 
													<input type="button" class="btn btn-primary" value="제출"
														onclick="submitForm(<%=vo.getNo()%>)">
												</form>
											</td>
											<td><%=vo.getDelYn()%></td>
										</tr>
										<%
										}
										%>
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
    var statusSelects = document.querySelectorAll('.custom-select:not(.custom-select > *)');
     console.log(statusSelects);

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
 
 	//AJAX
 	function submitForm(no) {
 		  // JS오브젝트 생성
 		  let formData = {
 				no: no,
                status: document.querySelector('#statusForm_' + no + ' select[name="status"]').value
              
                
            };
 		  // 데이터를 JSON 방식으로
 		  let jsonString = JSON.stringify(formData);
 		  
 		  if (formData.status === "2") {
 	        // 수거일자 값을 현재 날짜 및 시간으로 변경합니다.
 	        var collectDateElement = document.querySelector('#statusForm_' + no + ' td:nth-child(4)');
 	        collectDateElement.textContent = new Date().toLocaleString(); // 현재 날짜 및 시간을 표시
 		  }else if(formData.status === "3"){
 			 // 제출 버튼을 비활성화하고 이벤트 리스너를 제거
              var submitButton = document.querySelector('#statusForm_' + no + ' input[type="button"]');
              submitButton.disabled = true;
              submitButton.removeEventListener('click', function () {
                  submitForm(no);
              });
 		  }
 		  
 		  // URL 전달 패치 (옵션 : 포스트, json, body지정)
 		  fetch('http://127.0.0.1:8080/rushwash/admin/clothes', {
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
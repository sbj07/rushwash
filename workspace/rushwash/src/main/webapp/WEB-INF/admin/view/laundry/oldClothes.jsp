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
											<th>처리상태</th>
											<th>수거요청일자</th>
											<th>수거일자</th>
											<th>무게(g)</th>
											<th>취소상태</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>번호</th>
											<th>유저번호</th>
											<th>처리상태</th>
											<th>수거요청일자</th>
											<th>수거일자</th>
											<th>무게(g)</th>
											<th>취소상태</th>
										</tr>
									</tfoot>
									<tbody>
										<tr>
											<td>1</td>
											<td>1</td>
											<td>
											<select class="custom-select" name="status">
													<option value="1">수거요청</option>
													<option value="2">수거완료</option>
													<option value="3">지급완료</option>
											</select>
											</td>
											<td>2023.12.4</td>
											<td>2023.12.5</td>
											<td>1200</td>
											<td>N</td>
										</tr>
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
    var statusSelects = document.querySelectorAll(".custom-select");

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
          statusSelect.style.backgroundColor = ""; // Reset to default
      }
    });
</script>

</html>
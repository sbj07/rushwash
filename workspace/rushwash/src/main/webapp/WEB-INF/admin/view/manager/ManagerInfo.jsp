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
						<h1 class="h3 mb-0 text-gray-800">전체 매니저 조회</h1>
					</div>
					<p class="mb-4">모든 관리자 계정의 정보를 확인합니다. 미사용 처리 또한 이 페이지에서 가능합니다.</p>

					<!-- End of Main Content -->

					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">전체 유저</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>NO.</th>
											<th>NAME</th>
											<th>ID</th>
											<th>PWD</th>
											<th>미사용</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>NO.</th>
											<th>NAME</th>
											<th>ID</th>
											<th>PWD</th>
											<th>미사용</th>
										</tr>
									</tfoot>
									<tbody>
										<tr>
											<td>1</td>
											<td>김관리</td>
											<td>adminkim123</td>
											<td>qqww1122@</td>
											<td>
											<form action="" method="post">
											<select class="custom-select" name="status">
													<option value="N" selected>사용</option>
													<option value="Y">미사용</option>
											</select>
											<input type="submit" class="btn btn-primary">
											</form>
											</td>
										</tr>
										<tr>
											<td>2</td>
											<td>이차장</td>
											<td>leegjo22</td>
											<td>q21ff2@</td>
											<td><form action="" method="post">
											<select class="custom-select" name="status">
													<option value="N">사용</option>
													<option value="Y">미사용</option>
											</select>
											<input type="submit" class="btn btn-primary">
											</form></td>
										</tr>
										<tr>
											<td>3</td>
											<td>박부장</td>
											<td>parkboo67</td>
											<td>qqff2!@</td>
											<td><form action="" method="post">
											<select class="custom-select" name="status">
													<option value="N">사용</option>
													<option value="Y">미사용</option>
											</select>
											<input type="submit" class="btn btn-primary">
											</form></td>
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
        case "N":
          statusSelect.style.backgroundColor = "#f8f9fc";
          break;
        case "Y":
          statusSelect.style.backgroundColor = "lightgreen";
          break;
        default:
          statusSelect.style.backgroundColor = ""; // Reset to default
      }
    });
</script>

</html>
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
						<h1 class="h3 mb-0 text-gray-800">전체 유저 조회</h1>
					</div>
					<p class="mb-4">모든 유저의 기본정보를 확인합니다. 강제탈퇴 처리 또한 이 페이지에서 가능합니다.</p>

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
											<th>유저번호</th>
											<th>유저명</th>
											<th>유저주소</th>
											<th>이메일</th>
											<th>전화번호</th>
											<th>구독일자</th>
											<th>회원등급</th>
											<th>포인트</th>
											<th>탈퇴여부</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>유저번호</th>
											<th>유저명</th>
											<th>유저주소</th>
											<th>이메일</th>
											<th>전화번호</th>
											<th>구독일자</th>
											<th>회원등급</th>
											<th>포인트</th>
											<th>탈퇴여부</th>
										</tr>
									</tfoot>
									<tbody>
										<tr>
											<td>1</td>
											<td>김첨지</td>
											<td>서울특별시 종로구</td>
											<td>cunsnd@naver.com</td>
											<td>010-5144-8874</td>
											<td>2023/11/20</td>
											<td>스탠다드</td>
											<td>1500</td>
											<td><select class="custom-select" name="status">
													<option value="N">N</option>
													<option value="Y">Y</option>
											</select></td>
										</tr>
										<tr>
											<td>2</td>
											<td>심원용</td>
											<td>서울특별시 종로구</td>
											<td>cunsnd@naver.com</td>
											<td>010-5144-8874</td>
											<td>2023/11/20</td>
											<td>스탠다드</td>
											<td>600</td>
											<td>Y</td>
										</tr>
										<tr>
											<td>3</td>
											<td>이병건</td>
											<td>서울특별시 종로구</td>
											<td>cunsnd@naver.com</td>
											<td>010-5144-8874</td>
											<td>2023/10/20</td>
											<td>스탠다드</td>
											<td>1100</td>
											<td>N</td>
										</tr>
										<tr>
											<td>4</td>
											<td>이왕건</td>
											<td>서울특별시 종로구</td>
											<td>cunsnd@naver.com</td>
											<td>010-5144-8874</td>
											<td>2023/11/20</td>
											<td>스탠다드</td>
											<td>15300</td>
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
        case "Y":
          statusSelect.style.backgroundColor = "lightcoral";
          break;
        case "N":
          statusSelect.style.backgroundColor = "lightblue";
          break;
        default:
          statusSelect.style.backgroundColor = ""; // Reset to default
      }
    });
</script>

</html>
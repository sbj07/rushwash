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
						<h1 class="h3 mb-0 text-gray-800">유저 로그인정보 조회</h1>
					</div>
					<p class="mb-4">모든 유저의 로그인정보를 확인합니다.</p>

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
											<th>ID</th>
											<th>PWD</th>
											<th>NICK</th>
											<th>가입일자</th>
											<th>정보변경일자</th>
											<th>변경사항비고</th>
											<th>사용여부</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>유저번호</th>
											<th>유저명</th>
											<th>ID</th>
											<th>PWD</th>
											<th>NICK</th>
											<th>가입일자</th>
											<th>정보변경일자</th>
											<th>변경사항비고</th>
											<th>사용여부</th>
										</tr>
									</tfoot>
									<tbody>
										<tr>
											<td>1</td>
											<td>김첨지</td>
											<td>sullungtangman</td>
											<td>1q2w3e4r!</td>
											<td>LuckyDay</td>
											<td>2008/11/28</td>
											<td>2010/10/14</td>
											<td>-</td>
											<td>Y</td>
										</tr>
										<tr>
											<td>2</td>
											<td>김첨지</td>
											<td>sullungtangman</td>
											<td>1q2w3e4r!</td>
											<td>LuckyDay</td>
											<td>2008/11/28</td>
											<td>2010/10/14</td>
											<td>-</td>
											<td>Y</td>
										</tr>
										<tr>
											<td>3</td>
											<td>김첨지</td>
											<td>sullungtangman</td>
											<td>1q2w3e4r!</td>
											<td>LuckyDay</td>
											<td>2008/11/28</td>
											<td>2010/10/14</td>
											<td>-</td>
											<td>Y</td>
										</tr>
										<tr>
											<td>4</td>
											<td>김첨지</td>
											<td>sullungtangman</td>
											<td>1q2w3e4r!</td>
											<td>LuckyDay</td>
											<td>2008/11/28</td>
											<td>2010/10/14</td>
											<td>-</td>
											<td>Y</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>

					<%@ include file="/WEB-INF/admin/view/common/footer.jsp"%>

				</div>
			</div>
			<!-- End of Content Wrapper -->
		</div>
	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<%@ include file="/WEB-INF/admin/view/common/logoutModal.jsp"%>

</body>

</html>
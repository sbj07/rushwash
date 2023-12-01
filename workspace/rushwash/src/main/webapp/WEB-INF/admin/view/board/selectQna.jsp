<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<%@ include file="/WEB-INF/admin/view/common/header.jsp"%>
<link rel="stylesheet" href="/admin01/resources/css/board.css">
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

					<form action="" method="">
						<table border="1">
							<tr id="titleHead">
								<td>번호</td>
								<td id="title">제목</td>
								<td>작성자</td>
								<td>작성일자</td>
								<td>문의상태</td>
								<td>공개여부</td>
								<td>답변 관리자</td>
							</tr>
							<tr>
								<td>번호</td>
								<td>제목</td>
								<td>작성자</td>
								<td>작성일자</td>
								<td>문의상태</td>
								<td>공개여부</td>
								<td>답변 관리자</td>
							</tr>
						</table>
					</form>
					
				</div>
				<!-- End of Main Content -->

				<%@ include file="/WEB-INF/admin/view/common/footer.jsp"%>

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


</html>
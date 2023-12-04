<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
						class="d-sm-flex align-items-center mb-4 text-center">
						<h1 class="h3 mb-0 text-gray-800">매니저 추가</h1>
					</div>
					<p class="mb-4">새로운 관리자 계정을 생성하여 공유하십시오. 모든 기능은 로그인 후 이용해야합니다.</p>
					
					<form class="user">
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user"
                                            id="Id" placeholder="ID">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user"
                                            id="Password" placeholder="Password">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user"
                                            id="Password2" placeholder="Repeat Password">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="Name"
                                            placeholder="Name">
                                    </div>
                                </div>
                                <a href="login.html" class="btn btn-primary btn-user btn-block">
                                    계정 등록
                                </a>
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
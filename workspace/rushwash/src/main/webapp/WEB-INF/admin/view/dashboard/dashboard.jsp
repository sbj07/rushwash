<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String alertMsg = (String) session.getAttribute("alertMsg");
session.removeAttribute("alertMsg");
Map<String, String> orderStatusCount = (Map<String, String>) request.getAttribute("orderStatusCount"); 
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
						<h1 class="h3 mb-0 text-gray-800">대시보드</h1>
					</div>
					<p class="mb-4">업무에 필요한 정보를 확인하세요.</p>

					<!-- End of Main Content -->

					<div class="row">

						<!-- Earnings (Monthly) Card Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="font-weight-bold text-primary text-uppercase mb-1">
												수거중 주문건</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">
												<%=orderStatusCount.get("1") %>
											</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-calendar fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- Earnings (Annual) Card Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-success shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class=" font-weight-bold text-success text-uppercase mb-1">
												세탁대기 주문건</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">
												<%=orderStatusCount.get("2") %>
											</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- Tasks Card Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-info shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div class="font-weight-bold text-info text-uppercase mb-1">세탁중
												주문건</div>
											<div class="row no-gutters align-items-center">
												<div class="col-auto">
													<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">
														<%=orderStatusCount.get("3")%>
													</div>
												</div>
											</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- Pending Requests Card Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-warning shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="font-weight-bold text-warning text-uppercase mb-1">
												고객미수령 (배송중)</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">
												<%=Integer.parseInt(orderStatusCount.get("4"))  + Integer.parseInt(orderStatusCount.get("5")) %>
											</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-comments fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!------------------------------------------------------------------->
					<!-- CHART -->
					<!-- Donut Chart -->
					<div class="row">

						<div class="col-xl-4 col-lg-5">
							<div class="card shadow mb-4">
								<!-- Card Header - Dropdown -->
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">주문 세탁물 비율</h6>
								</div>
								<!-- Card Body -->
								<div class="card-body">
									<div class="chart-pie pt-4">
										<canvas id="myPieChart_Laundry"></canvas>
									</div>
									<!-- 라벨값 표시 -->
									<div class="mt-4 text-center small">
										<span class="mr-2"> <i class="fas fa-circle text-primary"></i> 
										상의
										</span> 
										<span class="mr-2"> <i class="fas fa-circle text-success"></i> 
										하의
										</span> 
										<span class="mr-2"> <i class="fas fa-circle text-info"></i>
										아우터
										</span>
									</div>
									<hr>
									어떤 세탁물이 많이 들어왔는지 분석해보세요.
								</div>
							</div>
						</div>

						<div class="col-xl-4 col-lg-5">
							<div class="card shadow mb-4">
								<!-- Card Header - Dropdown -->
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">회원 구독등급 비율</h6>
								</div>
								<!-- Card Body -->
								<div class="card-body">
									<div class="chart-pie pt-4">
										<canvas id="myPieChart_Plan"></canvas>
									</div>
									<!-- 라벨값 표시 -->
									<div class="mt-4 text-center small">
										<span class="mr-2"> 
										<i class="fas fa-circle text-primary"></i> 비구독
										</span> 
										<span class="mr-2"> 
										<i class="fas fa-circle text-success"></i> 브론즈
										</span> 
										<span class="mr-2"> 
										<i class="fas fa-circle text-info"></i>실버
										</span>
										<span class="mr-2"> 
										<i class="fas fa-circle text-warning"></i>골드
										</span>
									</div>
									<hr>
									회원님들의 구독 등급을 분석해보세요.
								</div>
							</div>
						</div>

						<!-- END ROW -->
					</div>

					<!-- END Page Content -->
				</div>
				<!-- END Main Content -->
			</div>
			<%@ include file="/WEB-INF/admin/view/common/footer.jsp"%>
		</div>
	</div>
	<!-- End of Content Wrapper -->
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<%@ include file="/WEB-INF/admin/view/common/logoutModal.jsp"%>

</body>
<script src="/rushwash/resources/admin/vendor/chart.js/Chart.min.js"></script>
<%@include file="/WEB-INF/admin/view/dashboard/laundryChart.jsp"%>
<%@include file="/WEB-INF/admin/view/dashboard/planChart.jsp"%>

<script>
	<%if (alertMsg != null) {%>
		alert("<%=alertMsg%>
	");
<%}%>
	
</script>

</html>
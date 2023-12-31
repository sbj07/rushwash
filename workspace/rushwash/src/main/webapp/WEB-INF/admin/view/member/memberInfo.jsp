<%@page import="com.rushwash.admin.app.member.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%List<MemberVo> memberVoList = (List<MemberVo>) request.getAttribute("memberVoList"); %>
	
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
						<h1 class="h3 mb-0 text-gray-800">전체 회원 조회</h1>
					</div>
					<p class="mb-4">모든 회원의 기본정보를 조회합니다.</p>

					<!-- End of Main Content -->

					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">전체 회원</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>유저번호</th>
											<th>성함</th>
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
											<th>성함</th>
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
									<%for (MemberVo vo : memberVoList) {%>
										<tr>
											<td><%=vo.getNo() %></td>
											<td><%=vo.getName() %></td>
											<td><%=vo.getAddress() %></td>
											<td><%=vo.getEmail() %></td>
											<td><%=vo.getTel() %></td>
											<td>
												<%if(vo.getPlanDate() != null) { %>
													<%=vo.getPlanDate() %>
												<%}else{ %>
													-
												<%} %>
											</td>
											<td>
												<%if(vo.getSubGrade() !=null ){ %>
													<%=vo.getSubGrade() %>
												<%} else{%>
													비구독												
												<%}%>
											</td>
											<td><%=vo.getPoint() %></td>
											<td>
												<%=vo.getDelYn()%>
											</td>
										</tr>
									<%} %>
										
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

</html>
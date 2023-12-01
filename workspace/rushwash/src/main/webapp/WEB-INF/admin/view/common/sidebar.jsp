
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- Sidebar -->
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="/rushwash/admin/laundry/control">
		<div class="sidebar-brand-icon">
			<i class="fa-brands fa-waze"></i>
		</div>
		<div class="sidebar-brand-text mx-3">
			세탁특공대 <sup>AD</sup>
		</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item active"><a class="nav-link" href="/rushwash/admin/dashboard">
			<i class="fas fa-fw fa-tachometer-alt"></i> <span>대시보드</span>
	</a></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">사용자 관리</div>

	<!-- Nav Item - 유저 Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true"
		aria-controls="collapseTwo"> <i class="fas fa-fw fa-cog"></i> <span>유저</span>
	</a>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">유저관리:</h6>
				<a class="collapse-item" href="/rushwash/admin/user/view">전체 유저 조회</a> 
				<a class="collapse-item" href="/rushwash/admin/user/loginInfo">유저 로그인 정보 관리</a>
			</div>
		</div></li>

	<!-- Nav Item - 매니저 Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseUtilities"
		aria-expanded="true" aria-controls="collapseUtilities"> <i
			class="fas fa-fw fa-wrench"></i> <span>매니저</span>
	</a>
		<div id="collapseUtilities" class="collapse"
			aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">매니저 관리:</h6>
				<a class="collapse-item" href="/rushwash/admin/regist">매니저 추가</a> 
				<a class="collapse-item" href="/rushwash/admin/manager/view">전체 매니저 조회</a>
			</div>
		</div></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">기능 관리</div>

	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsePages"
		aria-expanded="true" aria-controls="collapsePages"> <i
			class="fas fa-fw fa-folder"></i> <span>세탁물</span>
	</a>
		<div id="collapsePages" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">세탁 신청:</h6>
				<a class="collapse-item" href="laundryHistory.html">세탁주문 관리</a>
				<a class="collapse-item" href="/rushwash/admin/laundry/control">상세 세탁물 관리</a> 
				<div class="collapse-divider"></div>
				<h6 class="collapse-header">그외 서비스:</h6>
				<a class="collapse-item" href="clothes.html">헌옷 관리</a>
			</div>
		</div></li>

	<!-- Nav Item - 게시글 -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseBoards"
		aria-expanded="true" aria-controls="collapseBoards"> <i
			class="fas fa-fw fa-table"></i> <span>게시글 관리</span>
	</a>
		<div id="collapseBoards" class="collapse
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">게시판 조회:</h6>
				<a class="collapse-item" href="/rushwash/admin/board/notice">전체 공지사항 조회</a> <a
					class="collapse-item" href="/rushwash/admin/board/faq">전체 FAQ 조회</a> <a
					class="collapse-item" href="/rushwash/admin/board/qna">QNA 관리</a>
				<div class="collapse-divider"></div>
				
			</div>
		</div></li>

	<!-- Nav Item - Charts -->
	<li class="nav-item"><a class="nav-link" href=""> <i
			class="fas fa-fw fa-chart-area"></i> <span>배너관리</span></a></li>

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

</ul>
<!-- End of Sidebar -->
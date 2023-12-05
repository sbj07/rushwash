<%@page import="com.rushwash.admin.app.page.vo.PageVo"%>
<%@page import="com.rushwash.admin.app.board.faq.vo.FaqVo"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<% 
		List<FaqVo> FaqVoList = (List<FaqVo>) request.getAttribute("FaqVoList");
		PageVo pvo = (PageVo)request.getAttribute("pvo"); 
	%>
    
<!DOCTYPE html>
<html>

<head>
<%@ include file="/WEB-INF/admin/view/common/header.jsp"%>
<link rel="stylesheet" href="/rushwash/resources/admin/css/board.css">
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

					
					<main><h1>FAQ</h1>
					
						<table border="1">
							<thead>
								<tr id="titleHead">
									<td>번호</td>
									<td id="title">제목</td>
									<td>작성자</td>
									<td>작성일자</td>
								</tr>
							</thead>
							<tbody>
								<% for(FaqVo vo : FaqVoList){ %>
									<tr>
										<td><%= vo.getNo() %></td>
										<td><%= vo.getTitle() %></td>
										<td><%= vo.getManagerId() %></td>
										<td><%= vo.getEnrollDate() %></td>
									</tr>
								<% } %>
							</tbody>
							
						</table>
						<button onclick="location.href='/rushwash/admin/board/faqWrite'">작성하기</button>
						
						
						<div class="page-area">
			
							<% if(pvo.getStartPage() != 1){ %>
								<a href="/rushwash/admin/board/Faq?pno=<%= pvo.getStartPage()-1 %>">이전</a>
							<% } %>
							
							<% for(int i = pvo.getStartPage() ; i <= pvo.getEndPage(); i++){ %>
								
								<% if( i == pvo.getCurrentPage() ){ %>
									<span><%= i %></span>
								<% }else{ %>
									<a href="/rushwash/admin/board/Faq?pno=<%= i %>"><%= i %></a>
								<% } %>
								
							<% } %>
							
							<% if( pvo.getEndPage() != pvo.getMaxPage() ){ %>
								<a href="/rushwash/admin/board/faq?pno=<%= pvo.getEndPage()+1 %>">다음</a>	
							<% } %>
						
						</div>
						</main>
					
					
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

<script>
	const trArr = document.querySelectorAll("main > table > tbody > tr");
	for(let i = 0 ; i < trArr.length; ++i){
		trArr[i].addEventListener('click' , handleClick);
	}
	
	function handleClick(event){
		const tr = event.currentTarget;
		const no = tr.children[0].innerText;
		location.href = '/rushwash/admin/board/faq/detail?no=' + no + '&currPage=<%= pvo.getCurrentPage() %>';	
	}
</script>
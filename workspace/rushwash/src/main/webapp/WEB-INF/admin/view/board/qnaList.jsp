<%@page import="java.util.Map"%>
<%@page import="com.rushwash.admin.app.page.vo.PageVo"%>
<%@page import="com.rushwash.admin.app.board.qna.vo.QnaVo"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<% 
		String searchType = (String)request.getAttribute("searchType");
	    String searchValue = (String)request.getAttribute("searchValue");
		List<QnaVo> QnaVoList = (List<QnaVo>) request.getAttribute("QnaVoList");
		PageVo pvo = (PageVo)request.getAttribute("pvo"); 
		Map<String, String> searchMap = (Map<String, String>)request.getAttribute("searchMap");
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

					
					<main>
						<h1>QnA</h1>
						<div class="search-area">
							<form action="/rushwash/admin/board/qna/search" method="get">
								<select name="searchType">
									<option value="title">제목</option>
									<option value="content">내용</option>
								</select>
								<input type="text" name="searchValue" placeholder="검색할 내용을 입력하세요">
								<input type="submit" value="검색하기">
							</form>
						</div>
					
					
						<table border="1">
							<thead>
								<tr id="titleHead">
									<td>번호</td>
									<td id="title">제목</td>
									<td>작성자</td>
									<td>작성일자</td>
									<td>문의 취소상태</td>
									<td>공개 여부</td>
									<td>답변 매니저</td>
								</tr>
							</thead>
							<tbody>
								<% for(QnaVo vo : QnaVoList){ %>
									<tr>
										<td><%= vo.getNo() %></td>
										<td><%= vo.getTitle() %></td>
										<td><%= vo.getMemberId() %></td>
										<td><%= vo.getEnrollDate() %></td>
										<td><%= vo.getDelYn() %></td>
										<td><%= vo.getSecretYn() %></td>
										<td><%= vo.getManagerId() %></td>
									</tr>
								<% } %>
							</tbody>
							
						</table>
						
						
						
						
						<% if(searchType==null&&searchValue==null) { %>
							<div class="page-area">
			
							<% if(pvo.getStartPage() != 1){ %>
								<a href="/rushwash/admin/board/qna?pno=<%= pvo.getStartPage()-1 %>">이전</a>
							<% } %>
							
							<% for(int i = pvo.getStartPage() ; i <= pvo.getEndPage(); i++){ %>
								
								<% if( i == pvo.getCurrentPage() ){ %>
									<span><%= i %></span>
								<% }else{ %>
									<a href="/rushwash/admin/board/qna?pno=<%= i %>"><%= i %></a>
								<% } %>
								
							<% } %>
						    <% }else{ %>
								<% if( pvo.getEndPage() != pvo.getMaxPage() ){ %>
									<a href="/rushwash/admin/board/Qna?pno=<%= pvo.getEndPage()+1 %>">다음</a>	
									<div class="page-area">
								    <% if (pvo.getStartPage() != 1) { %>
								        <a href="/rushwash/admin/board/qna/search?searchType=<%= searchType %>&searchValue=<%= searchValue %>&pno=<%= pvo.getStartPage()-1 %>">이전</a>
								    <% } %>
								
								    <% for (int i = pvo.getStartPage(); i <= pvo.getEndPage(); i++) { %>
								        <% if (i == pvo.getCurrentPage()) { %>
								            <span><%= i %></span>
								        <% } else { %>
								            <a href="/rushwash/admin/board/qna/search?searchType=<%= searchType %>&searchValue=<%= searchValue %>&pno=<%= i %>"><%= i %></a>
								        <% } %>
								    <% } %>
								
								    <% if (pvo.getEndPage() != pvo.getMaxPage()) { %>
								        <a href="/rushwash/admin/board/qna/search?searchType=<%= searchType %>&searchValue=<%= searchValue %>&pno=<%= pvo.getEndPage()+1 %>">다음</a>
								    <% } %>
							<% } %>
						
								</div>
						 
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
		location.href = '/rushwash/admin/board/qna/detail?no=' + no + '&currPage=<%= pvo.getCurrentPage() %>';	
	}
	<% if(searchMap != null){ %>
	function setSearchArea(){
		
		// 옵션태그 셋팅
		const optionTagArr = document.querySelectorAll(".search-area form option");
		const searchType = "<%= searchMap.get("searchType") %>";
		for(let i = 0; i < optionTagArr.length; ++i){
			if( optionTagArr[i].value === searchType ){
				optionTagArr[i].selected = true;
				break;
			}
		}
	
	// 인풋태그 셋팅
	const searchValueTag = document.querySelector(".search-area form input[name=searchValue]");
	searchValueTag.value = "<%= searchMap.get("searchValue") %>";
	
	}
	setSearchArea();
	
	function setPageArea(){
		const aTagArr = document.querySelectorAll(".page-area a");
		for(let i = 0 ; i < aTagArr.length; ++i){
			aTagArr[i].href = aTagArr[i].href.replace("QnaList" , "search"); 
			aTagArr[i].href += "&searchType=<%= searchMap.get("searchType") %>";
			aTagArr[i].href += "&searchValue=<%= searchMap.get("searchValue") %>";
		}
	}
	setPageArea();
	<% } %>
</script>
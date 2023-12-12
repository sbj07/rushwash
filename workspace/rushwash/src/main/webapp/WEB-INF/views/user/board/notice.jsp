<%@page import="java.util.Map"%>
<%@page import="com.rushwash.admin.app.page.vo.PageVo"%>
<%@page import="java.util.List"%>
<%@page import="com.rushwash.app.board.notice.vo.UserNoticeVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	List<UserNoticeVo> boardVoList = (List<UserNoticeVo>) request.getAttribute("boardVoList");
    	PageVo pvo = (PageVo)request.getAttribute("pvo");
    	Map<String, String> searchMap = (Map<String, String>)request.getAttribute("searchMap");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/board/notice.css">
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
</head>
<body>

    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>

	<main>
    <div id="wrap">
	    <div class="main">
		      <div class="font">
		        공지사항
		      </div>
		      <div class="search-area">
		      	<form action="/rushwash/board/search" method="get">
		      		<select name="searchType">
		      			<option value="title">제목</option>
		      			<option value="content">내용</option>
		      		</select>
		      		<input type="text" name="searchValue" placeholder="검색할 내용을 입력하세요" class="text">
		      		<input type="submit" value="검색하기" class="submit">
		      	</form>
		      </div>
		      <table>
		      	<thead>
		      		<tr>
		      			<td class="title">번호</td>
		      			<td class="title">제목</td>
		      			<td>작성일자</td>
		      		</tr>
		      	</thead>
		      	<tbody>
		          <%for(UserNoticeVo vo : boardVoList){ %>
			          <tr>
			          	<td><%= vo.getNo() %></td>
			            <td><%= vo.getTitle() %></td>
			            <td><%= vo.getEnrollDate() %></td>
			          </tr>
		          <%}%> 
		         </tbody>
		          
		       </table>
	    </div>
      
       <div class="page-area">
       		<% if(pvo.getStartPage() != 1){ %>
       			<a href="/rushwash/board/notice?pno=<%= pvo.getStartPage()-1%>">이전</a>
       		<%}%>
       		<% for(int i = pvo.getStartPage(); i <= pvo.getEndPage(); i++){ %>
       			<%if( i == pvo.getCurrentPage()){%>
       				<span><%= i %></span>
       			<%}else{%>
       				<a href="/rushwash/board/notice?pno=<%= i%>"><%= i %></a>
       			<%}%>
       		<%}%>
       		
       		<%if(pvo.getEndPage() != pvo.getMaxPage()){%>
       			<a href="/rushwash/board/notice?pno=<%= pvo.getEndPage()+1 %>">다음</a>
       		<%}%>
       </div>
    </div>
        
   </main>
    </div>
    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>
    
</body>
</html>
<script>
const trArr = document.querySelectorAll("main > div > div > table > tbody > tr");
for(let i = 0 ; i < trArr.length; ++i){
	trArr[i].addEventListener('click' , handleClick);
}

function handleClick(event){
	const tr = event.currentTarget;
	const no = tr.children[0].innerText;
	location.href = '/rushwash/board/noticewrite?no=' + no + '&currPage=<%= pvo.getCurrentPage() %>';	
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
				aTagArr[i].href = aTagArr[i].href.replace("Notice" , "search"); 
				aTagArr[i].href += "&searchType=<%= searchMap.get("searchType") %>";
				aTagArr[i].href += "&searchValue=<%= searchMap.get("searchValue") %>";
			}
		}
		setPageArea();
	<% } %>
</script>

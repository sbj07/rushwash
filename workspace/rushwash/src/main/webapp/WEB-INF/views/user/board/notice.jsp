<%@page import="com.rushwash.admin.app.page.vo.PageVo"%>
<%@page import="java.util.List"%>
<%@page import="com.rushwash.app.board.notice.vo.UserNoticeVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	List<UserNoticeVo> boardVoList = (List<UserNoticeVo>) request.getAttribute("boardVoList");
    	PageVo pvo = (PageVo)request.getAttribute("pvo");
    	
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
      <div class="font">
        공지사항
      </div>
      <table>
      	<thead>
      		<tr>
      			<td class="title">제목</td>
      			<td>작성일자</td>
      		</tr>
      	</thead>
      	<tbody>
          <%for(UserNoticeVo vo : boardVoList){ %>
	          <tr>
	            <td><%= vo.getNo()%><%= vo.getTitle() %></td>
	            <td><%= vo.getEnrollDate() %></td>
	          </tr>
          <%}%> 
         </tbody>
          
       </table>
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
	const trArr = document.querySelectorAll("main > div > table > tbody > tr");
	for(let i = 0 ; i < trArr.length; ++i){
		trArr[i].addEventListener('click' , handleClick);
	}
	
	function handleClick(event){
		const tr = event.currentTarget;
		const no = tr.children[0].innerText;
		location.href = '/rushwash/board/noticewrite?no=' + no + '&currPage=<%= pvo.getCurrentPage() %>';	
	}
</script>

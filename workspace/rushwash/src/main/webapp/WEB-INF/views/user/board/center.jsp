<%@page import="com.rushwash.app.board.faq.vo.FaqVo"%>
<%@page import="com.rushwash.admin.app.page.vo.PageVo"%>
<%@page import="com.rushwash.app.board.qna.vo.QnaVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
   List<QnaVo> boardVoList = (List<QnaVo>) request.getAttribute("boardVoList");
   PageVo pvo = (PageVo)request.getAttribute("pvo");
   List<FaqVo> faqVoList = (List<FaqVo>) request.getAttribute("faqVoList");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/board/center.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>

   <main>
       <div id="wrap">
         <div class="font">
           QNA
         </div>
         <div>
	         <table class="table-wrapper">
	            <thead>
	                <tr>
	                <td>번호</td>
	                <td>제목</td>
	                <td>작성일</td>
	              </tr>
	            </thead>
	            <tbody>
	            <% for(QnaVo vo : boardVoList){ %>
	               <tr>
	                  <td><%= vo.getNo() %></td>
	                  <td><%= vo.getTitle() %></td>
	                  <% if(vo.getCommt() != null){%>
	                  	<td><%= vo.getEnrollDate() %><div class="text">답변완료</div></td>
	                  <%}else{%>
	                  	<td><%= vo.getEnrollDate() %></td>
	                  <%}%>
	                </tr>
	            <%}%>
	               
	            </tbody>             
	          </table>
          </div>
          <div class="btn">
           <button class="btn1" onclick="location.href='/rushwash/board/qnawrite'">작성하기</button>
       </div>
       </div>
       
       
        <div id="wrap">
         <div class="font">
           FAQ
         </div>
         <table class="table-wrapper">
           <thead>
                <tr>
                <td>번호</td>
                <td>제목</td>
                <td>작성일</td>
              </tr>
            </thead>
            <tbody>
            <% for(FaqVo vo : faqVoList){ %>
               <tr>
                  <td><%= vo.getNo() %></td>
                  <td><%= vo.getTitle() %></td>
                  <td><%= vo.getEnrollDate() %></td>
                </tr>
            <%}%>
               
            </tbody>   
          </table>
       </div>
        
   </main>
        
        

   
    </div>
    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>


</body>
</html>
<script>
const trArr = document.querySelectorAll("main > div > div>table > tbody > tr");
for(let i = 0 ; i < trArr.length; ++i){
   trArr[i].addEventListener('click' , handleClick);
}

function handleClick(event){
   const tr = event.currentTarget;
   const no = tr.children[0].innerText;
   location.href = '/rushwash/board/qnadetail?no=' + no + '&currPage=<%= pvo.getCurrentPage() %>';   
}
</script>
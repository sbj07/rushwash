<%@page import="com.rushwash.app.board.price.vo.PriceVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
	List<PriceVo> priceVoList = (List<PriceVo>) request.getAttribute("priceVoList");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/board/price.css">
</head>
<body>
<%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>

<main>
	<div id="wrap" class="table-wrapper">
		<img src="/rushwash/resources/img/user/img05.png" alt="이미지" class="img05">
	</div>
	 <div id="wrap">
	  <div class="font">
		가격표
	  </div>
	  <table class="table-wrapper">
	  	<thead>
	  		<tr>
			  <td>품목</td>
			  <td>기본요금</td>
			  <td>할인요금</td>
			</tr>
	  	</thead>
		<tbody>
		<% for(PriceVo vo : priceVoList){ %>
			<tr>
				<td><%= vo.getName()%></td>
				<td><%= vo.getPrice() %></td>
				<td><%= vo.getCategoryCode() %></td>
			 </tr>
		<% } %>
			
		</tbody>
	   </table>
	</div>
	
</main>
        
        

	
    <div class="footer"><%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %></div>
</body>
</html>
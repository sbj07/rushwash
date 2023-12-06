<%@page import="com.rushwash.admin.app.board.qna.vo.QnaVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    	QnaVo vo = (QnaVo)request.getAttribute("vo");
	    String currPage = (String)request.getAttribute("currPage");
		if(currPage == null){
			currPage = "1";
		}
    %>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/WEB-INF/admin/view/common/header.jsp"%>
		<link rel="stylesheet" href="/rushwash/resources/admin/css/write.css">	
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
								<h1>QnA 상세조회</h1>
								
								<table border="1">
									<tbody>
										<tr>
											<td>제목 : <%= vo.getTitle() %></td>
											<td>작성자 : <%= vo.getMemberId() %></td>
											<td>작성일자 : <%= vo.getEnrollDate() %></td>
										</tr>
										
										<tr id="content">
											<td colspan="3"><%= vo.getContent() %></td>
										</tr>
									</tbody>
								</table>
								
<!-- 								<textarea name="content" placeholder="내용을 입력하세요"></textarea> -->
								<table border="1">
									<tbody>
										<tr id="content">
											<td><%= vo.getCommt() %></td>
										</tr>
									</tbody>
								</table>
								<br>
<!-- 								<button onclick="location.href='/rushwash/admin/board/qnaCmmtWrite'">댓글 입력</button> -->
								<button onclick="location.href='/rushwash/admin/board/qnaCommtDelete?no=<%= vo.getNo() %>'">댓글 삭제</button>
								
									<div class="btn-area">
										<button onclick="location.href='/rushwash/admin/board/qnaDelete?no=<%= vo.getNo() %>'">게시글 삭제</button>
									</div>
							</main>
                            
                            <a href="/rushwash/admin/board/qna?pno=<%= currPage %>">목록으로</a>
                            
                            
                            
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
<%@page import="com.rushwash.admin.app.board.faq.vo.FaqVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	FaqVo vo = (FaqVo)request.getAttribute("vo");
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
        
							<form action="/rushwash/admin/board/faqWrite" method="post">
                            <main>
								<h1>FAQ 작성</h1>
									<table border="1">
										<tbody>
											<tr>
												<td><input type="text" name="title" placeholder="제목을 입력하세요"></td>
												<td>작성자 : </td>
												<td>작성일자 : </td>
											</tr>
											
											<tr id="content">
												<td colspan=3><textarea name="content" placeholder="내용을 입력하세요"></textarea>
	
												
											</tr>
										</tbody>
									</table>
								</main>
                            	<input type="submit" value="작성하기">
                            </form>
                            <a href="/rushwash/admin/board/faq?pno=<%= currPage %>">목록으로</a>
                            
                            
                            
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
        
        
        </script>
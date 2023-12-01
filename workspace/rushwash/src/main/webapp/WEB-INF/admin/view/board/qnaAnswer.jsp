<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/WEB-INF/admin/view/common/header.jsp"%>
		<link rel="stylesheet" href="/admin01/resources/css/qnaBoard.css">	
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
                            <table>
                                <tr>
                                	<td>제목 : </td>
                                    <td><input class="content" type="text" name="qnaTitle" id="questionTitle"></td>
                                    <td id="tdd">작성자 : 김첨지  작성일자 : 2023/11/21</td>
                                </tr>
                                <tr>
                                	<td>내용 : </td>
                                    <td colspan=2><textarea class="content" name="qnaContent" id="questionContent" cols="30" rows="10"></textarea></td>
                                    
                                </tr>
                            </table>
                            
                            <hr>

                            <table>
                                <tr class="answertitle">
                                	<td>제목 : </td>
                                    <td colspan=2><input class="content" type="text" name="qnaAnswerTitle"></td>
                                    
                                </tr>
                                <tr>
                                	<td>내용 : </td>
                                    <td colspan=2><textarea class="content" name="qnaAnswerContent" id="" cols="30" rows="10"></textarea></td>
                                    
                                </tr>
                                <tr>
                                	<td></td>
                                	<td><input type="submit" value="등록"></td>
                                	<td></td>
                               	</tr>
                            </table>
                            
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
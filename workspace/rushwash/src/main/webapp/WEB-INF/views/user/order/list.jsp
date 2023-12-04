<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="/rushwash/resources/css/user/order/list.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>

    <main id="wrap">
    
        
            <div id="btn">
                <button type="button" class="btn1" onclick="showTable('t1');">진행중인내역</button>
                <button type="button" class="btn2" onclick="showTable('t2');">지난내역</button>
            </div>


            <div id="ttn1">
                <table id="t1">
                    <thead>
                        <tr>
                            <th>주문번호</th>
                            <th>총 수량</th>
                            <th>주문일</th>
                            <th>주문상태</th>
                            <th>상세조회</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>2</td>
                            <td>22022.02.23</td>
                            <td>수거전</td>
                            <td><button type="button">상세조회</button></td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>12</td>
                            <td>22022.02.23</td>
                            <td>수거전</td>
                            <td><button type="button">상세조회</button></td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>12</td>
                            <td>22022.02.23</td>
                            <td>수거전</td>
                            <td><button type="button">상세조회</button></td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>8</td>
                            <td>22022.02.23</td>
                            <td>수거전</td>
                            <td><button type="button">상세조회</button></td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td>3</td>
                            <td>22022.02.23</td>
                            <td>수거완료</td>
                            <td><button type="button">상세조회</button></td>
                        </tr>
                    </tbody>
                </table>

                <table id="t2">
                    <thead>
                        <tr>
                            <th>주문번호</th>
                            <th>총 수량</th>
                            <th>수령일</th>
                            <th>주문상태</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>9</td>
                            <td>22022.02.23</td>
                            <td>배송완료</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>6</td>
                            <td>22022.02.23</td>
                            <td>배송완료</td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>2</td>
                            <td>22022.02.23</td>
                            <td>배송완료</td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>10</td>
                            <td>22022.02.23</td>
                            <td>배송완료</td>
                        </tr>  
                        <tr>
                            <td>5</td>
                            <td>3</td>
                            <td>22022.02.23</td>
                            <td>배송완료</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            

        <div id="ttn2">

        </div>

        

    </main>


<%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>
</body>

<script>
	window.onload = function() {
		document.getElementById('t1').style.display = 'table';
    	document.getElementById('t2').style.display = 'none';

	};
	
	function showTable(tableId) {
//         document.getElementById('t1').style.display = 'table';
//         document.getElementById('t2').style.display = 'none';

        if (tableId === 't1') {
            document.getElementById('t1').style.display = 'table';
            document.getElementById('t2').style.display = 'none';
        } else if (tableId === 't2') {
            document.getElementById('t1').style.display = 'none';
            document.getElementById('t2').style.display = 'table';
        }
	}
	
</script>



</html>

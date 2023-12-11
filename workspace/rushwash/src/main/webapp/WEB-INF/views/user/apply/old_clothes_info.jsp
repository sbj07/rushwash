<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헌옷수거</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/apply/old_clothes_info.css">

</head>

<body>
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>
    <main>
        <div class="page-name">헌옷 수거</div>
        <div class="form-box">
            <div class="form-header">수거 요청 이용안내</div>
            <div class="form-body form-content1">세탁물과 구분하기 위해<br><span>헌 옷을 담은 가방</span> 과 <span>일반 세탁물</span>을 나누어 담아 주세요</div>
            <div class="form-body form-content2">
                <div class="grey-box">
                    <span>꼭 확인해주세요!</span>
                    <ol>
                        <li>1. 일반 세탁물과 헌 옷을 각각 나누어 담아 주세요.</li>
                        <li>2. 헌 옷 가방에 “헌 옷 수거” 라고 써주세요.</li>
                        <li>3. 헌 옷 수거가 완료된 후 [헌옷무게 X 500P]로<br> 계산되어 포인트가 지급됩니다!</li>
                    </ol>
                </div>
            </div>
            <div class="form-footer">
                <button class="btn-footer" type="button" onclick="goConfirm()">
                    수거요청서 작성
                </button>
            </div>
        </div>
    </main>
    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>
</body>
</html>
<script>
    function goConfirm(){
        location.href='/rushwash/apply/request/old-clothes';
    }
</script>
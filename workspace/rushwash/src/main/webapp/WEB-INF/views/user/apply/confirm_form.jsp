<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세탁요청서</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/apply/confirm_form.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>
    <main>
        <form action="">
            <div class="form-box">

                <div class="form-body form-header">결제확인서</div>
                <div class="alert-box">
                    <span>결제가 완료되었습니다! 결제확인서를 확인해주세요!</span>
                </div>
                <div class="form-body form-content">
                    <span>수거/배송지 정보</span>
                    <hr>
                    <table class="form-table" id="addr-info">
                        <tr>
                            <td>수령인</td>
                            <td id="nameMember">${loginMember.memberName}</td>
                        </tr>
                        <tr>
                            <td>연락처</td>
                            <td id="telMember">${loginMember.memberTel}</td>
                        </tr>
                        <tr>
                            <td>주소지</td>
                            <td id="addrMember">${loginMember.memberAddress}</td>
                        </tr>
                    </table>
                </div>
                <div class="form-body form-content">
                    <span>최종 결제 금액</span>
                    <hr>
                    <table class="form-table">
                        <tr>
                            <td>수량합계</td>
                            <td>${ea}개</td>
                        </tr>
                        <tr>
                            <td>사용 포인트</td>
                            <td>${spendPoint}</td>
                        </tr>
                        <tr>
                            <td>최종 결제 금액</td>
                            <td>${lastTotalPrice}원</td>
                        </tr>
                    </table>
                </div>
                <div class="form-body form-footer">
                    <button type="button" onclick="goMain()" id="btn-go-main">메인으로</button>
                </div>
            </div>
        </form>
    </main>
    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>
</body>
</html>
<script>

    function goMain(){
        location.href='/rushwash/home';
    }
    
</script>
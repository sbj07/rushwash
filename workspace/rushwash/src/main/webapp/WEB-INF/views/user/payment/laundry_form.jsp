<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세탁요청서</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/payment/laundry_form.css">

<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script src="/rushwash/resources/js/user/payment/laundry_form.js"></script>

</head>
<body>
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>
    <main>
        <form action="/rushwash//payment/laundry-form" id="formTag" method="post">
            <div class="form-box">
                <div class="form-body form-header">세탁요청서 작성</div>
                <div class="form-body form-content">
                    <span>수거/배송지 정보</span>
                    <hr>
                    <table class="form-table" id="addr-info">
                        <tr>
                            <td>수령인</td>
                            <td><span>${ loginMember.memberName }</span></td>
                        </tr>
                        <tr>
                            <td>연락처</td>
                            <td>
                                <span>${ loginMember.memberTel }</span>
                            </td>
                        </tr>
                        <tr>
                            <td>주소지</td>
                            <td>
                                <span>${ loginMember.memberAddress }</span>
                            </td>

                        </tr>
                    </table>
                </div>
                <div class="form-body form-content">
                    <span>최종 결제 금액</span>
                    <hr>
                    <table class="form-table">
                        <tr>
                            <td>수량합계</td>
                            <td colspan="2">${ ea } 개</td>
                        </tr>
                        <tr>
                            <td>포인트 할인</td>
                            <td> 보유포인트 : <span id="myPoint"> ${ loginMember.point } </span></td>
                            <td>사용 : <input type="text" id="user-point"></td>
                        </tr>
                        <tr>
                            <td>최종 결제 금액</td>
                            <td colspan="2"> <span name="pay-price" id="pay-price" value="3"> ${ price }</span>원</td>
                        </tr>
                    </table>
                </div>
                <div class="form-body form-content">
                    <span>결제 수단</span>
                    <hr>
                    <table class="form-table">
                        <tr>
                            <td>카드사</td>
                            <td>${ cardVo.cardCompany }</td>
                        </tr>
                        <tr>
                            <td>카드번호</td>
                            <td>${ cardVo.cardNo }</td>
                        </tr>
                        <tr>
                            <td colspan="2"><button type="button" onclick="goRegist()" id="btn-card-regist">결제수단등록</button></td>
                        </tr>
                    </table>
                </div>
                <input type="text" name="totalEa" id="totalEa" value="${ ea }" style="visibility: hidden; display: none;">
                <input type="text" name="spendPoint" id="spendPoint" style="visibility: hidden; display: none;">
                <input type="text" name="totalPrice" id="totalPrice" value="${ price }" style="visibility: hidden; display: none;">
                <div class="form-body form-footer">
                    <button type="button" onclick="paymentLuandry()" id="btn-payment">결제하기</button>
                </div>
            </div>
        </form>
    </main>
    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>
</body>
</html>

<script>

    function goRegist(){
        location.href='/rushwash/payment/card-regist';
    }

    const pointBox = document.querySelector("#user-point");
    const payPrice = document.querySelector("#pay-price");
    const spendPoint = document.querySelector("#spendPoint");
    const totalPrice = document.querySelector("#totalPrice");

    const myPoint = document.querySelector("#myPoint");

    spendPoint.value = "0";

    pointBox.addEventListener("blur", changePoint);

    function changePoint(event) {
        const inputBox = event.target;
        let inputPoint = parseInt(inputBox.value); 
        let userPoint = parseInt( "${loginMember.point}" );
        
        if(inputPoint > userPoint ){
            let changeValue = userPoint.toString();
            let payIntVal = parseInt(payPrice.innerText);
            pointBox.value = changeValue;
            let calc = payIntVal - userPoint;
            if(calc > 0){
                payPrice.innerText = calc;
            } else {
                payPrice.innerText = "0";
            }
            spendPoint.value = pointBox.value;
            payPrice.value = payPrice.innerText;
            totalPrice.value = payPrice.value;
        } else {
            let payIntVal2 = parseInt(payPrice.innerText);
            let calc2 = payIntVal2 - inputPoint;

            payPrice.innerText = calc2;

            spendPoint.value = pointBox.value;
            payPrice.value = payPrice.innerText;
            totalPrice.value = payPrice.value;
        }
    }

    function paymentLuandry(){
        let userEmail = "${loginMember.memberEmail}";
        let userName = "${loginMember.memberName}";
        let totalPriceVl = totalPrice.value;
        kakaopayLundry(userEmail, userName , totalPriceVl);
        // 총가격 총개수 멤버 이메일, 이름
    }


</script>

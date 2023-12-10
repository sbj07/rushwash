<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세탁요청서</title>
<link rel="stylesheet" href="/rushwash/resources/css/user/payment/laundry_form.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>
    <main>
        <form action="/rushwash//payment/laundry-form" method="post">
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
                            <td>보유포인트 : ${ loginMember.point }</td>
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
                            <td colspan="2"><button type="button" id="btn-card-regist">결제수단등록</button></td>
                        </tr>
                    </table>
                </div>
                <input type="text" name="totalEa" id="totalEa" value="${ ea }" style="visibility: hidden; display: none;">
                <input type="text" name="spendPoint" id="spendPoint" style="visibility: hidden; display: none;">
                <input type="text" name="totalPrice" id="totalPrice" value="${ price }" style="visibility: hidden; display: none;">
                <div class="form-body form-footer">
                    <button type="submit" id="btn-payment">결제하기</button>
                </div>
            </div>
        </form>
    </main>
    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>
</body>
</html>

<script>
    const pointBox = document.querySelector("#user-point");
    const payPrice = document.querySelector("#pay-price");
    const spendPoint = document.querySelector("#spendPoint");
    const totalPrice = document.querySelector("#totalPrice");

    spendPoint.value = "0";


    console.log("사용포인트 : " + spendPoint.value  );
    console.log("총 가격 : " + totalPrice.value  );
    pointBox.addEventListener("blur", changePoint);

    function changePoint(event) {
        const inputBox = event.target;
        let inputPoint = parseInt(inputBox.value); 
        let userPoint = parseInt( ${loginMember.point} );
        
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
            console.log("사용포인트 : " + spendPoint.value  );
            console.log("총 가격 : " + totalPrice.value  );
        } 
    }
</script>
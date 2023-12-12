<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<!-- 
<script>

    var IMP = window.IMP; // 생략가능
    IMP.init('imp67223832');

    var today = new Date();   
    var hours = today.getHours(); // 시
    var minutes = today.getMinutes();  // 분
    var seconds = today.getSeconds();  // 초
    var milliseconds = today.getMilliseconds();
    var makeMerchantUid = hours +  minutes + seconds + milliseconds;

    function requestPay() {
    IMP.request_pay({
	pg : "kakaopay", // 실제 계약 후에는 실제 상점아이디로 변경
	pay_method : 'card', // 'card'만 지원됩니다.
	merchant_uid: "order_monthly_0001", // 상점에서 관리하는 주문 번호
	name : '구독결제',
	amount : 0, // 결제창에 표시될 금액. 실제 승인이 이루어지지는 않습니다. (모바일에서는 가격이 표시되지 않음)
	customer_uid : 'your-customer-unique-id', // 필수 입력.
	buyer_email : 'iamport@siot.do',
	buyer_name : '아임포트',
	buyer_tel : '02-1234-1234',
	m_redirect_url : '{모바일에서 결제 완료 후 리디렉션 될 URL}' // 예: https://www.my-service.com/payments/complete/mobile
    }, function(rsp) {
	if ( rsp.success ) {    
		alert('빌링키 발급 성공');
	} else {
		alert('빌링키 발급 실패');
	}

    });
}
</script>
         -->
</head>
<body>
        <button id="payment">결제하기</button>
</body>
</html>
<script src="/rushwash/resources/js/user/apply/pay_port.js"></script>

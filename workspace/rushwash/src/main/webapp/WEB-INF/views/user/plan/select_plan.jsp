<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PlanInfo</title>
    <link rel="stylesheet" href="/rushwash/resources/css/user/plan/select_plan.css">
    <script src="https://cdn.iamport.kr/v1/iamport.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
    <script src="/rushwash/resources/js/user/apply/pay_port.js"></script>
</head>

    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>
<body>
    <main>
        <div class="page-title">
            구독 플랜 정보
        </div>
        <div class="plan-info">
            <div class="pi" id="pi1">
                <div>구독 등급</div>
                <div>등급별 할인</div>
                <div>월 구독료</div>
            </div>
            <div class="pi" id="pi2" onclick="submitForm('2')">
                <div>STANDARD</div>
                <div>7%</div>
                <div>5,900원</div>
            </div>
            <div class="pi" id="pi3" onclick="submitForm('3')">
                <div>PLATINUM</div>
                <div>15%</div>
                <div>7,900원</div>
            </div>
            <div class="pi" id="pi4" onclick="submitForm('4')">
                <div>DIAMOND</div>
                <div>22%</div>
                <div>11,900원</div>
            </div>
        </div>
        <div class="plan-regist-info">
            <div class="pr-box">
                <h3>구독 가입 안내</h3>
                <pre>※구독 가입시 매월 최초 구독플랜 결제일로 계산하여 등록된 결제 수단으로 자동 결제합니다. <br>(31일이 최초 결제일인경우 30일이 해당 월의 마지막일이면 30일에 자동으로 결제됩니다.)</pre>
            </div>
        </div>
    </main>
</body>
    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>
</html>

<script>

    function submitForm(planvalue){
        const useremail = "${loginMember.memberEmail}";
        const username = "${loginMember.memberName}";
        if(planvalue == 2){
            let planName = "스탠다드";
            let planPrice = "5900"
            kakaopay( planName , planPrice , useremail , username ,planvalue);
        } else if (planvalue == 3){
            let planName = "플래티넘";
            let planPrice = "7900"
            kakaopay( planName , planPrice , useremail , username ,planvalue);
        } else if (planvalue == 4){
            let planName = "다이아";
            let planPrice = "11900"
            kakaopay( planName , planPrice , useremail , username ,planvalue);
        }
    }
</script>
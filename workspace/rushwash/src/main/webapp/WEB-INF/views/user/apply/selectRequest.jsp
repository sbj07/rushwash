<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>wash</title>
    <link rel="stylesheet" href="/rushwash/resources/css/user/apply/selectRequest.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>
        <main>
            <div id="wrap">
                <div class="item1">
                    <div class="click-box">
                            <div id="blue-box" onclick="redirectPremium()">
                                <div id="head-title">프리미엄 세탁</div>
                                <pre>구독플랜 가입자를 위한<br>프리미엄 세탁</pre>
                            </div>
                        <pre class="descript">구독 플랜 가입자들을 위한 전용세탁 !<br>세탁기를 구비하지 않은 세대 ,<br>집안일 스트레스로 해방을 원하는 고객님 ,<br>주기적으로 세탁서비스가 필요한 고객님!<br>가입한 플랜에 맞게 할인된 가격을<br>확인하세요!</pre>
                    </div>
                </div>
                <div class="item2">
                    <div class="click-box2">
                        <div id="blue-box2" onclick="redirectOnce()">
                            <div id="head-title2">한번 이용</div>
                            <pre>필요시만 이용하는 일회성 세탁</pre>
                        </div>

                        <pre class="descript2">빨래하기 너무 귀찮은 날!<br>너무 바빠서 세탁이 어려운 날!<br>일회 이용으로 간편하게!</pre>
                    </div>
                </div>
                <div class="item3">
                    <div class="click-box3">
                        <div id="blue-box2" onclick="redirectOldclothes()">
                            <div id="head-title2">헌옷 수거</div>
                            <pre>헌옷을 대신 버려주는 헌옷수거 서비스</pre>
                        </div>

                        <pre class="descript2">처리하기 어려운 헌옷들을 버리시면<br>포인트를 드려요 !</pre>
                    </div>
                </div>
                <div class="item4">
                    <div class="plan-box">
                        <div id="plan-text">구독플랜이 궁금하다면?</div>
                        <pre>주기적인 세탁신청 , 대량의 세탁물 , 장기간 이용이 예상되는 사용자분들에게 <br>합리적인 선택이 될수있는 구독 플랜 ! 3가지의 플랜에서 원하는 플랜을 구독!<br>플랜별 할인율이 총 세탁가격에서 할인됩니다 ! </pre>
                    </div>

                </div>
                <div class="item5">
                    <div class="plan-req">
                        <div id="plan-descript">자세한 할인율과 플랜을 알고싶다면?<br>구독을 하고싶으다면?</div>
                        <div id="plan-btn" onclick="redirectPlanSelect()">구독신청하러가기</div>
                    </div>
                </div>
            </div>
        </main>
    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>
</body>
</html>
<script>
    <c:if test = "${ not empty alertMsg}">
        alert("${alertMsg}");
        console.log("hi");
    </c:if>
    function redirectPremium() {
        location.href='/rushwash/apply/request/premium';
    }

    function redirectOnce() {
        location.href='/rushwash/apply/request/once';
    }

    function redirectOldclothes(){
        location.href='/rushwash/apply/request/old-clothes-info';
    }

    function redirectPlanSelect() {
        location.href='/rushwash/plan/select';
    }
</script>
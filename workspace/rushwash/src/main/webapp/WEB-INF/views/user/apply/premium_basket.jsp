<%@page import="com.rushwash.app.item.vo.ItemVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    List<ItemVo> itemList = (List<ItemVo>) request.getAttribute("itemList");
%>    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Premium</title>
    <link rel="stylesheet" href="/rushwash/resources/css/user/apply/premium_basket.css">
</head>

<body>
    <%@ include file="/WEB-INF/views/user/common/user_header.jsp" %>
        
    <main>
        <div id="wrap">
            <div class="price-box">
                <button data-target="top-table" class="btn-top tag-btn btn-selected" id="top-category" value="1">상의</button>
                <button data-target="bottom-table" class="btn-bottom tag-btn" id="bottom-category" value="2">하의</button>
                <button data-target="outer-table" class="btn-outer tag-btn" id="outer-category"value="3">아우터</button>

                <table class="price-table">

                    <!-- 상단 -->
                    <thead>
                        <th id="product">품목</th>
                        <th id="normal-price">일반가격</th>
                        <th id="plan-price">플랜 할인 가격</th>
                        <th id="ea">수량</th>
                    </thead>

                    <!-- 바디 -->
                    <tbody id="resultTable">
                        <tr>
                            <td>
                                와이셔츠
                            </td>
                            <td>
                                2100원
                            </td>
                            <td>1995</td>
                            <td>
                                <div class="quantity">
                                    <button class="quantity-up" id="up-btn">+</button>
                                    <input type="text" class="quantity-input" value="0" min="0" max="99">
                                    <button class="quantity-down" id="down-btn">-</button>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                와이셔츠
                            </td>
                            <td>
                                2100원
                            </td>
                            <td>1995</td>
                            <td>
                                <div class="quantity">
                                    <input type="text" class="quantity-input" value="0" min="0" max="99">
                                    <button class="quantity-up" id="up-btn">+</button>
                                    <button class="quantity-down" id="down-btn">-</button>
                                </div>
                            </td>
                        </tr>
                    </tbody>


                    <!-- 하단 -->
                    <tfoot>
                        <tr id="tfoot-top">
                            <td>수량합계</td>
                            <td>총가격</td>
                            <td>19000원</td>
                            <td rowspan="2" class="td-payment">
                                <button id="btn-payment">바로결제</button>
                            </td>
                        </tr>
                        <tr id="tfoot-bottom">
                            <td>15개</td>
                            <td>플랜 할인 가격</td>
                            <td>15000원</td>
                        </tr>
                    </tfoot>

                </table>
                <table id="bottom-table"></table>
                <table id="outer-table"></table>
            </div>
        </div>
    </main>
        
    <%@ include file="/WEB-INF/views/user/common/user_footer.jsp" %>
</body>
</html>

<script>
    getItemTable();
    
    // 버튼 클릭 시 실행되는 함수
    function handleButtonClick(event) {
        // 모든 버튼에서 btn-selected 클래스 제거
        document.querySelectorAll('.tag-btn').forEach(btn => {
            btn.classList.remove('btn-selected');
        });
        // 클릭된 버튼에 btn-selected 클래스 추가
        event.currentTarget.classList.add('btn-selected');

        getItemTable();
    }
    // 각 버튼에 클릭 이벤트 리스너 추가
    document.getElementById('top-category').addEventListener('click', handleButtonClick);
    document.getElementById('bottom-category').addEventListener('click', handleButtonClick);
    document.getElementById('outer-category').addEventListener('click', handleButtonClick);

    // 수량증감 함수
    document.addEventListener('DOMContentLoaded', function () {
        let quantityInput = document.querySelector('.quantity-input');
        let quantityUpBtn = document.querySelector('.quantity-up');
        let quantityDownBtn = document.querySelector('.quantity-down');

        quantityUpBtn.addEventListener('click', function () {
            let currentValue = parseInt(quantityInput.value, 10) || 0;
            let maxValue = parseInt(quantityInput.getAttribute('max'), 10) || Infinity;

            if (currentValue < maxValue) {
                quantityInput.value = currentValue + 1;
            }
        });

        quantityDownBtn.addEventListener('click', function () {
            let currentValue = parseInt(quantityInput.value, 10) || 0;
            let minValue = parseInt(quantityInput.getAttribute('min'), 10) || 0;

            if (currentValue > minValue) {
                quantityInput.value = currentValue - 1;
            }
        });

        // 입력값이 숫자가 아닌 경우 처리 (옵션)
        quantityInput.addEventListener('input', function () {
            let sanitizedValue = this.value.replace(/[^0-9]/g, '');
            this.value = sanitizedValue;
        });
    });

    function getItemTable() {
        const selectedBtn = document.querySelector(".btn-selected");
        const targetValue = selectedBtn.value;
        removeTable();
        fetch("/rushwash/apply/request/premium?category="+targetValue)
        .then(response => response.json())
        .then(data => {
            let parsedData = data.map(item => JSON.parse(item));
            parsedData.forEach(function(i){
                addColumn(i)
            })
        })
        .catch(error => console.log('There has been a problem with your fetch operation: ', error));
    }

    function addColumn(result) {
        let itemName = result.name;
        let itemPrice = result.price;
        const resultTable = document.querySelector("#resultTable");
        

        const trTag = document.createElement("tr");
        const nameTag = document.createElement("td");
        const normalPriceTag = document.createElement("td");
        const premiumPriceTag = document.createElement("td");
        const eaTdTag = document.createElement("td");
        const eaBtnTag = document.createElement("button");

        nameTag.innerText = itemName;
        normalPriceTag.innerText = itemPrice;
        premiumPriceTag.innerText = itemPrice;
        eaBtnTag.innerHTML = "버튼";
        
        eaTdTag.appendChild(eaBtnTag);
        trTag.appendChild(nameTag);
        trTag.appendChild(normalPriceTag);
        trTag.appendChild(premiumPriceTag);
        trTag.appendChild(eaTdTag);

        resultTable.appendChild(trTag);

        console.log("addColum끝");
    }

    function removeTable(){
        const resultTable = document.querySelector("#resultTable");
        resultTable.innerHTML = "";
    }
</script>
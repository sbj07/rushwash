
// top버튼
function topButtonClick(event) {
    // 모든 버튼에서 btn-selected 클래스 제거
    document.querySelectorAll('.tag-btn').forEach(btn => {
        btn.classList.remove('btn-selected');
    });
    // 클릭된 버튼에 btn-selected 클래스 추가
    event.currentTarget.classList.add('btn-selected');

    onTable(1);
    offTable(2);
    offTable(3);
}

// bottom버튼
function bottomButtonClick(event) {    
    // 모든 버튼에서 btn-selected 클래스 제거
    document.querySelectorAll('.tag-btn').forEach(btn => {
        btn.classList.remove('btn-selected');
    });
    // 클릭된 버튼에 btn-selected 클래스 추가
    event.currentTarget.classList.add('btn-selected');

    offTable(1);
    onTable(2);
    offTable(3);
}

// outer버튼
function outerButtonClick(event) {    
    // 모든 버튼에서 btn-selected 클래스 제거
    document.querySelectorAll('.tag-btn').forEach(btn => {
        btn.classList.remove('btn-selected');
    });
    // 클릭된 버튼에 btn-selected 클래스 추가
    event.currentTarget.classList.add('btn-selected');

    offTable(1);
    offTable(2);
    onTable(3);
}

// 각 버튼에 클릭 이벤트 리스너 추가
document.getElementById('top-category').addEventListener('click', topButtonClick);
document.getElementById('bottom-category').addEventListener('click', bottomButtonClick);
document.getElementById('outer-category').addEventListener('click', outerButtonClick);

// 시작시 데이터 받아와서 테이블 그리기
document.addEventListener("DOMContentLoaded", function() {
    fetch("/rushwash/apply/request/premium?showtable=true")
    .then(response => response.json())
    .then(data => {
        let parsedData = data.map(item => JSON.parse(item));
        let discountRate = parsedData[parsedData.length - 1];
        parsedData.forEach(function(i , idx , array){
            if(idx !== array.length-1){
                addColumn(i,discountRate);
            }
        });

        onTable(1);
        offTable(2);
        offTable(3);
    })
    .catch(error => console.log('There has been a problem with your fetch operation: ', error));

});

//칼럼생성
function addColumn(result , discountRate) {
    let itemNo = result.itemNo;
    let itemName = result.name;
    let itemPrice = result.price;
    let categoryNo = result.categoryCode;
    let rate = 100 - discountRate;
    let premiumPrice = itemPrice * (rate/100);

    const resultTable = document.querySelector("#resultTable");

    // 태그 생성
    const trTag = document.createElement("tr");
    let targetNum = 0;
    if(categoryNo == 1){
        targetNum = 1;
    } else if( categoryNo == 2){
        targetNum = 2;
    } else {
        targetNum = 3;
    }
    trTag.classList.add('columnTr' + targetNum);

    const nameTag = document.createElement("td");
    
    const normalPriceTag = document.createElement("td");
    normalPriceTag.classList.add('normalPrice');
    normalPriceTag.classList.add('tr' + itemNo);
    
    const premiumPriceTag = document.createElement("td");
    premiumPriceTag.classList.add('premiumPrice');
    premiumPriceTag.classList.add('tr' + itemNo);


    const eaTdTag = document.createElement("td");
    
    const eaDivTag = document.createElement("div");
    eaDivTag.classList.add('quantity');

    
    eaDivTag.insertAdjacentHTML("afterbegin", '<input type="text" class="quantity-input inputTag'+itemNo+' tr'+itemNo+'" value="0" min="0" max="99" name="item'+itemNo+'"> <button type="button" class="quantity-up" id="up-btn'+itemNo+'" onclick="increase(event)">+</button> <button type="button" class="quantity-down" id="down-btn'+itemNo+'" onclick="decrease(event)">-</button>');
            
    
    nameTag.innerText = itemName;

    normalPriceTag.innerText = itemPrice +'원';
    normalPriceTag.value = itemPrice;

    premiumPriceTag.innerText = premiumPrice + '원';
    premiumPriceTag.value = premiumPrice;

    eaTdTag.appendChild(eaDivTag);
    trTag.appendChild(nameTag);
    trTag.appendChild(normalPriceTag);
    trTag.appendChild(premiumPriceTag);
    trTag.appendChild(eaTdTag);
    resultTable.appendChild(trTag);
}

//테이블 보이기
function onTable(num){
    const columnTr = document.querySelectorAll(".columnTr" + num);
    columnTr.forEach(columntr => {
        columntr.style.display = "";
    });
}

//테이블 안보이기
function offTable(num){
    const columnTr = document.querySelectorAll(".columnTr" + num);
    columnTr.forEach(columntr => {
        columntr.style.display = "none";
    });
}

//수량 증가
function increase(event) {
    const upBtn = event.currentTarget;
    const qInput = upBtn.previousElementSibling;
    let currentValue = Number(qInput.value);
    if(currentValue < 99 ){
        currentValue = currentValue+1;
    }
    qInput.value = currentValue;

   
    sumEa();
    sumNormalPrice();
}

//수량 감소
function decrease(event) {
    const downBtn = event.currentTarget;
    const upbtn = downBtn.previousElementSibling;
    const qInput = upbtn.previousElementSibling;
    let currentValue = Number(qInput.value);
    if(currentValue > 0 ){
        currentValue = currentValue-1;
    }
    qInput.value = currentValue;

    sumEa();
    sumNormalPrice();
}


function sumEa() {
    const eaInputs = document.querySelectorAll(".quantity-input");
    const eaSum = document.querySelector('.eaSum');

    // 수량 변경
    let resultSum = 0;
    eaInputs.forEach(element => {
        resultSum += Number(element.value);
    });
    
    eaSum.innerText = resultSum;
}

// 총가격 변경
function sumNormalPrice() {

    const normalSum = document.querySelector(".normalPriceSum")
    const premiumSum = document.querySelector(".premiumPriceSum")

    const inputs = document.querySelectorAll(".quantity-input");

    let normarPriceValueSum = 0;
    let premiumPriceValueSum = 0;
    inputs.forEach(element => {

       if(element.value != '0'){
        let trName = element.classList.item(2);
        let trs = document.querySelectorAll("."+trName);
        let normarPriceValue = trs[0].value;
        let premiumPriceValue = trs[1].value;
        
        let normalText = Number(normarPriceValue) * Number(element.value);
        normarPriceValueSum += normalText;
        
        let premiumText = Number(premiumPriceValue) * Number(element.value)
        premiumPriceValueSum += premiumText;
        }
    });

    normalSum.innerText = normarPriceValueSum;
    premiumSum.innerText = premiumPriceValueSum;
}
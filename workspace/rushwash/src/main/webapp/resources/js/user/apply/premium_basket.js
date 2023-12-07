let topCount = 0;
let bottomCount = 0;
let outerCount = 0;

// getItemTable();

// 버튼 클릭 시 실행되는 함수
function handleButtonClick(event) {
    offTable();
    // 모든 버튼에서 btn-selected 클래스 제거
    document.querySelectorAll('.tag-btn').forEach(btn => {
        btn.classList.remove('btn-selected');
    });
    // 클릭된 버튼에 btn-selected 클래스 추가
    event.currentTarget.classList.add('btn-selected');
    
    getItemTable();
}

// top버튼
function topButtonClick(event) {
    let targetNum = event.target.value;
    console.log(targetNum);
    
    // 모든 버튼에서 btn-selected 클래스 제거
    document.querySelectorAll('.tag-btn').forEach(btn => {
        btn.classList.remove('btn-selected');
    });
    // 클릭된 버튼에 btn-selected 클래스 추가
    event.currentTarget.classList.add('btn-selected');
    
    if(topCount == 0){
        getItemTable(targetNum);
        topCount += 1;
    } else{
        onTable(1);
        offTable(2);
        offTable(3);
    }
}

// 각 버튼에 클릭 이벤트 리스너 추가
document.getElementById('top-category').addEventListener('click', handleButtonClick);
document.getElementById('bottom-category').addEventListener('click', handleButtonClick);
document.getElementById('outer-category').addEventListener('click', handleButtonClick);

// 테이블 데이터 가져오는 
function getItemTable() {
    const selectedBtn = document.querySelector(".btn-selected");
    const targetValue = selectedBtn.value;
    fetch("/rushwash/apply/request/premium?category="+targetValue)
    .then(response => response.json())
    .then(data => {
        let parsedData = data.map(item => JSON.parse(item));
        parsedData.forEach(function(i){
            addColumn(i , targetValue);
        });
    })
    .catch(error => console.log('There has been a problem with your fetch operation: ', error));
}

document.addEventListener("DOMContentLoaded", function() {
    console.log("called");
    fetch("/rushwash/apply/request/premium?showtable=true")
    .then(response => response.json())
    .then(data => {
        console.log(data);
        let parsedData = data.map(item => JSON.parse(item));
        parsedData.forEach(function(i){
            addColumn(i);
        });
    })
    .catch(error => console.log('There has been a problem with your fetch operation: ', error));
});

//칼럼생성
function addColumn(result) {
    let itemNo = result.itemNo;
    let itemName = result.name;
    let itemPrice = result.price;
    let categoryNo = result.categoryCode;
    console.log(categoryNo);
    const resultTable = document.querySelector("#resultTable");

    // 태그 생성
    const trTag = document.createElement("tr");
    if(categoryNo == 1){
        let targetNum = 1;
    } else( categoryNo == 2){
        let targetNum == 2;
    } else
    trTag.classList.add('columnTr' + targetNum);

    const nameTag = document.createElement("td");
    
    const normalPriceTag = document.createElement("td");
    normalPriceTag.classList.add('normalPrice');
    
    const premiumPriceTag = document.createElement("td");
    // premiumPriceTagPriceTag.classList.add('premiumPrice');

    const eaTdTag = document.createElement("td");
    
    const eaDivTag = document.createElement("div");
    eaDivTag.classList.add('quantity');

    
    eaDivTag.insertAdjacentHTML("afterbegin", '<input type="text" class="quantity-input inputTag'+itemNo+'" value="0" min="0" max="99" name="item'+itemNo+'"> <button type="button" class="quantity-up" id="up-btn'+itemNo+'" onclick="increase(event)">+</button> <button type="button" class="quantity-down" id="down-btn'+itemNo+'" onclick="decrease(event)">-</button>');
    // eaDivTag.insertAdjacentHTML("afterbegin", '<button data-action="decrement" type="button"> <span class="m-auto text-2xl font-thin">-</span> </button> <input type="number" name="custom-input-number" value="0"></input> <button data-action="increment" type="button"> <span class="m-auto text-2xl font-thin">+</span> </button>');
            
    nameTag.innerText = itemName;
    normalPriceTag.innerText = itemPrice +'원';
    premiumPriceTag.innerText = itemPrice + '원';
    eaTdTag.appendChild(eaDivTag);
    trTag.appendChild(nameTag);
    trTag.appendChild(normalPriceTag);
    trTag.appendChild(premiumPriceTag);
    trTag.appendChild(eaTdTag);
    resultTable.appendChild(trTag);
}

function offTable(num){
    const columnTr = document.querySelectorAll(".columnTr" + num);
    columnTr.forEach(columntr => {
        columntr.style.display = "";
    });
}

//화면 바꾸기
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
}


function sumEa() {
    const eaInputs = document.querySelectorAll(".quantity-input");
    const eaSum = document.querySelector('.eaSum');

    let resultSum = 0;
    eaInputs.forEach(element => {
        resultSum += Number(element.value);
    });
    
    eaSum.innerText = resultSum;
}
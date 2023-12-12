var IMP = window.IMP;

let today = new Date();
let hours = today.getHours(); // 시
let minutes = today.getMinutes();  // 분
let seconds = today.getSeconds();  // 초
let milliseconds = today.getMilliseconds();
let makeMerchantUid = `${hours}` + `${minutes}` + `${seconds}` + `${milliseconds}`;

function kakaopayLundry(userEmail, userName , totalPrice){
    if (confirm("결제 하시겠습니까?")) { // 구매 클릭시 한번 더 확인하기
        if (userName != null) { // 회원만 결제 가능
            IMP.init("imp67223832"); // 가맹점 식별코드
            IMP.request_pay({
                pg: 'kakaopay.TC0ONETIME', // PG사 코드표에서 선택
                pay_method: 'card', // 결제 방식
                merchant_uid: "RUSHWASHLAUNDRY" + makeMerchantUid , // 결제 고유 번호
                name: '세탁신청', // 제품명
                amount: totalPrice, // 가격
                buyer_email: userEmail,
                buyer_name: userName,
            }, async function (rsp) { // callback
                if (rsp.success) { //결제 성공시
                    let formTag = document.getElementById("formTag");
                    formTag.submit();
                } else if (rsp.success == false) { // 결제 실패시
                    alert(rsp.error_msg)
                }
            });
        }
        else { // 비회원 결제 불가
            alert('로그인이 필요합니다!');
        }
    } else { // 구매 확인 알림창 취소 클릭시 돌아가기
        return false;
    }
}
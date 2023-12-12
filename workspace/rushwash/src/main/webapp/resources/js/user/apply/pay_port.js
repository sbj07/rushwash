var IMP = window.IMP;

var today = new Date();
var hours = today.getHours(); // 시
var minutes = today.getMinutes();  // 분
var seconds = today.getSeconds();  // 초
var milliseconds = today.getMilliseconds();
var makeMerchantUid = `${hours}` + `${minutes}` + `${seconds}` + `${milliseconds}`;

function kakaopay( planName , planPrice , useremail , username ,planvalue){
    if (confirm("해당플랜을 구독 하시겠습니까?")) { // 구매 클릭시 한번 더 확인하기
        if (username != null) { // 회원만 결제 가능
            IMP.init("imp67223832"); // 가맹점 식별코드
            IMP.request_pay({
                pg: 'kakaopay.TCSUBSCRIP', // PG사 코드표에서 선택
                pay_method: 'card', // 결제 방식
                merchant_uid: "RUSHWASHPLAN" + makeMerchantUid , // 결제 고유 번호
                name: planName, // 제품명
                amount: planPrice, // 가격
                buyer_email: useremail,
                buyer_name: username,
            }, async function (rsp) { // callback
                if (rsp.success) { //결제 성공시
                    let postForm = document.createElement('form');

                    let plan;
                    plan = document.createElement('input');
                    plan.setAttribute('type','hidden');
                    plan.setAttribute('name', 'planName');
                    plan.setAttribute('value', planvalue);

                    postForm.appendChild(plan);
                    postForm.setAttribute('method','post');
                    postForm.setAttribute('action', '/rushwash/plan/select');
                    document.body.appendChild(postForm);
                    postForm.submit();
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
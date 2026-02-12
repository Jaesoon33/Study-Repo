// 1. 전역 변수 오염 문제 체험
console.log("=== 1. 전역 변수 오염 문제 체험 ===");

// 나쁜 예: 전역 변수 남용
// 어디서든 접근/수정 가능해서 버그 추적이 어려움

var globalUserName = "이순신";  // 전역 변수 (함수 밖에서 선언)

function showBadExample() {
    globalUserName = "원균";    // let 없이 사용 --> 전역 변수 수정
    console.log("[나쁜 예] 전역 변수 수정됨:", globalUserName);
}

showBadExample();

// 좋은 예: 지역 변수 사용
// 함수 내부에서만 유효, 외부 영향 X
function showGoodExample() {
    let userName = "손흥민";
    let userAge = 30;
    let userEmail = "son@example.com";

    console.log("[좋은 예] 지역변수:", userName);
    return {userName, userAge, userEmail}; // 단축 속성명으로 객체 반환
}

const localUser = showGoodExample();        // return 값을 받아서 사용
console.log("[결과] 반환된 객체: ", localUser);



// 2. 블록 스코프로 변수 격리하기
console.log("=== 2. 블록 스코프로 변수 격리하기 ===");

// 실무 상황 : 여러 조건에서 같은 이름의 변수 사용해야 할때
const userType = "premiun";     // 회원 등급 (전역 상수)

if(userType === "premiun"){ 
    let discount = 0.2;           // 블록 스코프 변수
    let message = "프리미엄 회원 20% 할인!";
    console.log("[프리미엄]", message), "할인율:", discount;
}   // 블록이 끝나면 discount, message 소멸 (메모리 상 존재 X)


if(userType === "basic"){ 
    let discount = 0.2;           // 블록 스코프 변수
    let message = "기본 회원 5% 할인!";
    console.log("[기본]", message), "할인율:", discount;
}   // 블록이 끝나면 discount, message 소멸 (메모리 상 존재 X)

console.log(discount);  // 블록 밖에서 접근 불가
console.log("각 블록의 변수들은 서로 독립적(이름이 같아도 충돌이 없음)")
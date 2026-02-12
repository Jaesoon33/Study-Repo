// 1. 전역 변수 접근
console.log("=== 1. 전역 변수 접근 ===");

let appName = "My App"; // 전역 변수

function showAppName() {
    console.log("앱 이름", appName);    // 전역 변수 호출
}

showAppName();

// 2. 지역 변수 접근
function createUser() {
    let userName = "이순신";    // 지역 변수
    console.log("함수 내부에서:", userName);
}
// console.log(userName); -> ReferenceError
createUser();

// 3. 같은 이름, 다른 스코프 
let count = 100;    // 전역 변수

function updateCount() {
    let count = 50;    // 지역 변수 (같은 이름)
    console.log("함수 내부에서:", count);   // 50
}

console.log("호출 전 전역 count: ", count);
updateCount();  // 지역 변수가 전역 변수를 가림(shadowing) at 함수 내부
console.log("함수 후 전역 count: ", count);

// 4. 전역 변수 수정하기
// 함수 내부에서 let/const 없이 변수에 접근하면 전역 변수를 참조
console.log("=== 4. 전역 변수 수정하기 ===");

let score = 0;  // 전역 변수

function addScore() {
    score += 10;    // 전역 변수 수정
}

console.log("초기 점수:", score);   // 0
addScore();
console.log("증가 후 점수:", score);   // 10
addScore();
console.log("한번 더 증가 후 점수:", score);   // 20

// 5. 지역 변수로 계산하고 반환하기
// 지역 변수는 함수 실행이 끝나고 만료됨 따라서 return으로 값을 반환하여 외부에서 사용 가능
// 매번 새로운 result가 생성되고 사라짐
console.log("=== 5. 지역 변수로 계산하기 반환하기 ===");

function calculateSum(a, b){
    let result = a + b; // 지역 변수
    return result;

}

const sum1 = calculateSum(10, 20);
console.log("10 + 20 = ", sum1);

const sum2 = calculateSum(100, 200);

// 6. 전역 변수 최소화 
// 전역 네임스페이스를 최적으로 유지
console.log("=== 6. 전역 변수 최소화  ===");

function calculatePrice(price, taxRate = 0.1){ // param : 가격과 세율
    // 세금 계산
    let tax = price * taxRate;  // 세금 계산 (지역 변수)
    let total = price + tax;    // 총액 계산 (지역 변수)
    return {price, tax, total}; // 객체로 반환 (단축 속성명 사용)
}

const result = calculatePrice(10000);
console.log(`가격: ${result.price} \n세금: ${result.tax} \n총합: ${result.total}`)
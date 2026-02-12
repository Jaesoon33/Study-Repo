console.log("=== 쇼핑몰 시스템 시뮬 레이션 ===");

/*
    1. 회원 등급별 할인 계산
        1) 스코프 포인트: const로 전역 상수 정의
            - 여러 함수에서 공통으로 사용하는 값은 전역 상수로 관리
            - 실수로 값을 변경하는 것을 방지
*/
console.log("=== 1. 회원 등급별 할인 ===");

const DISCOUNT_RATES = {
    BRONZE: 0.03,
    SILVER: 0.05,
    GOLD: 0.1,
    VIP:0.15
}

function calculateDiscount (price, memberGrade) { 
    // 지연 변수 : 함수 내부에서만 유효
    // 함수가 끝나면 메모리에서 소멸됨
    // 다른 함수의 변수와 이름이 같아도 충돌 없음
    let discountRate = 0;
    let discountAmount = 0;

    // 전역 상수 DISCOUNT_RATES에 접근 (스코프 체인)
    // -> 현재 스코프에 있으면 상위(전역)

    if(memberGrade == "BRONZE"){
        discountRate = DISCOUNT_RATES.BRONZE;
    }
    else if(memberGrade == "SILVER"){
        discountRate = DISCOUNT_RATES.SILVER;
    }
    else if(memberGrade == "GOLD"){
        discountRate = DISCOUNT_RATES.GOLD;
    }
    else if(memberGrade == "VIP")
        discountRate = DISCOUNT_RATES.VIP;

    discountAmount = price * discountRate;
    let finalPrice = price - discountAmount;

    return{discountAmount, finalPrice , discountRate};
}

// 테스트
let order1 = calculateDiscount(100000, "GOLD");
console.log("[골드 회원] 10만원 상품 구매");
console.log(` 할인율: ${order1.discountRate * 100}%`);
console.log(` 할인액: ${order1.discountAmount.toLocaleString()}원`);    // toLocaleString은 메소드 타입으로 ()필요함
console.log(` 결제액: ${order1.finalPrice.toLocaleString()}원`);

/*
    2. 장바구니 총액 계산
        - 스코프 포인트: 함수 내부의 지역 상수
        - 이 함수에서만 사용하는 상수는 함수 내부에 선언
        - 전역 스코프를 깔끔하게 유지
*/

console.log("=== 2. 장바구니 총액 계산 ===");

const cart = [ // 전역 상수: 장바구니 데이터
    {name: "맥북 프로", price: 2500000, quantity: 1},
    {name: "에어팟", price: 200000, quantity: 2},
    {name: "애플워치", price: 500000, quantity: 1},
]

function calculateCartTotal (cartItems) {
    let subtotal = 0;   // 지역 변수: 상품 합계 누적용
    let itemCount = 0;  // 지역 변수: 수량 누적용

    const FREE_SHIPPING = 50000;  // 지역 상수: 무료배송 기준
    const SHIPPING_FEE = 3000;    // 지역 상수: 배송비

    // for문의 블록 스코프
    for(let i=0; i<cartItems.length; i++) {
        // 블록 스코프 변수: 각 반복에서만 유효
        let item = cartItems[i];        // 이 반복에서만 존재(row76~85)
        let itemTotal = item.price * item.quantity;

        subtotal += itemTotal;  // 외부 지역 변수 수정 가능
        itemCount += item.quantity;

        console.log(`${item.name}: ${item.price.toLocaleString()}원 x ${item.quantity}개 = ${itemTotal.toLocaleString()}원`);
    }

    let shipping = subtotal >= FREE_SHIPPING ? 0 : SHIPPING_FEE;
    let total = subtotal + shipping;

    return {subtotal, shipping, itemCount, total};
}

console.log("[장바구니 내역]");
const cartResult = calculateCartTotal(cart);
console.log("-".repeat(40));
console.log(`상품 합계: ${cartResult.subtotal.toLocaleString()}원`);
console.log(`배송비: ${cartResult.shipping}원`, cartResult.shipping == 0 ? "(무료)" : `` );
console.log(`총 결제액: ${cartResult.total.toLocaleString()}원 `);
console.log(`총 ${cartResult.itemCount}개 상품`);

/*
    1. const로 전역 상수 정의
        - 여러 함수에서 공통으로 사용하는 값
    2. 함수 내부 const로 지역 상수 정의
        - 해당 함수에서만 사용하는 값
    3. let 으로 지역 변수 선언
        - 함수 밖에 영향 없음
        - 각 함수 호출마다 새로운 변수 생성
    4. for/if 블록 내 let 변수
        - 블록 내에서만 유효
        - 반복마다 독립적인 변수 생성
    5. 객체로 여러 값 반환
        - return {a, b, b};
        - 지역 변수 값을 외부에서 사용 가능
*/


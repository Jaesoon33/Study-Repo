console.log("=== 할인가 계산기 ===\n");

// 상품 정보
const product = {
    name: "나이키 에어맥스",        
    originalPrice: 159000,         // 정가 (원)
    discountRate: 20,              // 할인율(%)
    couponDiscount: 5000           // 쿠폰 할인 (원)
}

console.log("=== 상품 정보 ===");
console.log("상품명: ", product.name);
console.log("정가: ", product.originalPrice.toLocaleString() + "원");      // toLocaleString: 천단위로 , 표시
console.log("할인율: ", product.discountRate + "%");
console.log("쿠폰: ", product.couponDiscount + "원");

// 문제 1: 할인 금액 계산
console.log("=== 문제 1: 할인 금액 ===");
const discountPrice = product.originalPrice * (product.discountRate / 100);

// 할인 금액: 31,800원
console.log("할인 금액: ",discountPrice.toLocaleString()+"원");
console.log(Math.round(product.originalPrice));

// 문제 2: 할인 적용 가격
console.log("=== 문제 2: 최종 가격 ===");

// 최종 가격: 122,200원
const finalPrice = product.originalPrice - discountPrice - product.couponDiscount;
console.log("최종 가격: ",finalPrice.toLocaleString()+"원");

// 문제 3: 실제 할인율
console.log("=== 문제 3: 실제 할인율 ===");

// ((정가 - 최종가) / 정가) * 100
// 총 할인금액: 36,800원
// 실제 할인율 23.1%
const discountedPrice = product.originalPrice - finalPrice; 
const realDiscount = ((product.originalPrice - finalPrice) / product.originalPrice) * 100;

console.log("총 할인금액: ", discountedPrice.toLocaleString(),"원");
console.log("실제 할인율: ", realDiscount.toFixed(1) ,"%");

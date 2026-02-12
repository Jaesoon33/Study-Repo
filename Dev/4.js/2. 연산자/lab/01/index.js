/*
    1. 쇼핑몰 주문 금액 계산
        - 노트북(1,200,000)을 2대 주문하고, 마우스(35,000)를 3개 주문했습니다.
          총 주문 금액을 계산해보세요.
*/

console.log(`쇼핑몰 주문 금액 계산`);

let labtop_price = 1200000;
let mouse_price = 35000;
let labtop_ea = 2;
let mouse_ea = 3;


console.log(`노트북 가격: %d 마우스 가격: %d`, labtop_price, mouse_price);
console.log("case 1: 노트북 2대, 마우스 3개 주문");
console.log("\n총 주문금액: %d", labtop_price*labtop_ea + mouse_price*mouse_ea);


/*
    2. 할인 금액 계산
      - 원가 50,000원인 상품에 20% 할인을 적용합니다.
        할인 금액과 최종 가격을 각각 계산해보세요.
*/

let item_price = 50000; //원가
let sale_rate = 20;     // 할인율

let sale_price = item_price*(sale_rate/100);
let final_price = item_price-sale_price;

console.log("\n\n할인 금액: %d, 최종 가격: %d",sale_price,final_price);


// 연결 연산자와 논리 연산자 (Concatenation Operartior & Logical Operators)
console.log("[연결 연산자] 문자열 + 문자열");

let price = 10000;
console.log("'가격: ' + price + '원' ->",'가격: '+price+'원');

let firstName = "순신";
let lastName = "이";

console.log("firstName + lastName -> ", firstName, + lastName);

// 템플릿 리터널
let price1 = 500
console.log("\n[권장] 템플릿 리터럴 사용");
//console.log('\ 가격: \ ${price}원 \ ->', `가격: ${price1}원');


// 2. 논리 연산자

// 2-1. BOX 연산자 (!)
console.log("\n [NOT 연산자] ! (반전)");

let = isClicked = true;
let isOpened = false;

// 2-2. OR 연산자 (||)
console.log("\n [OR 연산자] || (하나라도 true면 true)");
console.log("true || true ->", true||true);
console.log("true || true ->", false||true);
console.log("true || true ->", false||false);
console.log("true || true ->", false||false);

// 2-3. AND 연산자 (&&)
console.log("\n [AND 연산자] && (둘다 true면 true)");
console.log("true && true ->", true&&true);
console.log("true && true ->", false&&true);
console.log("true && true ->", false&&false);
console.log("true && true ->", false&&false);



// 3. 삼항 연산자
console.log("\n [삼항 연산자] 조건 ? 참 : 거짓");

let num = 100;
// num = 101;
let result = num % 2 === 0 ? 'even' : 'odd';
console.log(`num = ${num}, result = ${result}`);
console.log(`num = ${num} | num % 2 === 0 ? 짝수 : 홀수 -> `, result);

console.log("\n 삼항 연산자 활용");
let age = 20;
let status = age >= 18 ? "성인" : "미성년자";
console.log(`age = ${age} | age >= 18 ? "성인" : "미성년자" -> `, status);

let score = 95;
let grade = score >= 90 ? 'A' : score >= 80
 ? 'B' : score >= 70 ? 'C' : score >= 60 ? 'E' : 'F'
console.log(`\n 등급 출력 | 중첩 삼항 연산자 =>`, grade);

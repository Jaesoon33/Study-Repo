// 1. 함수 선언문
function addDeclaration(a, b) {
    return a + b;
}

console.log("addDeclaration(10,20) = ", addDeclaration(10,20));

// 2. 함수 표현식
const addExpression = function(a, b) {
    return a + b;
};  // 세미콜론 필수 (변수 할당)

console.log("addExpression(100, 200) = ", addExpression(100, 200)); // 변수명으로 함수 호출

// 3. 화살표 함수 (Arrow Function) - 기본
// 형태: (Parameters) => {Function}
const addArrow = (a,b) => {return a + b};
console.log("addArrow(20, 30) = ", addArrow(20, 30));

// 4. 화살표 함수 (Arrow Function) - 간결한 표현
// 본문이 한 줄(표현식이 하나)일 때 더 짧게 작성 가능
const addShort = (a, b) => a + b;   // 한줄로 가장 많이 쓰는 형태

console.log("addShort(40, 50) = ", addShort(40, 50));

// 5. 화살표 함수 (Arrow Function) - 매개변수가 하나인 경우
const doubleVar = x => x * 2;
console.log("doubleVar(5) = ", doubleVar(5));

// 6. 화살표 함수 (Arrow Function) - 매개변수가 없는 경우
// 빈 괄호 () 반드시 필요함
const sayHello = () => "안녕하세요.";
console.log("sayHello() = ", sayHello());

/*
    세가지 형태 비교
        1) 함수 표현식: function 키워드 사용, 가장 일반적인 방식
        2) 화살표 함수(기본): => 사용, 중괄호 return 표현
        3) 화살표 함수(간결): => 사용, 한 줄로 축약
*/

// 7. 실용적인 예

// map method
const numbers = [1, 2, 3, 4, 5];
console.log("numbers = ", numbers);
const doubleVar2 = numbers.map(n => n * 2);
console.log("numbers.map(n => n * 2) = ", [...doubleVar2]);

// filter method
const evens = numbers.filter(n => n % 2 === 0);
console.log("numbers.filter(n => n % 2 === 0) = ", [...evens]);

// reduce method - 누산기
const sum = numbers.reduce((acc, n) => acc + n, 0); 
console.log("numbers.reduce((acc, n) => acc + n, 0) = ", sum);
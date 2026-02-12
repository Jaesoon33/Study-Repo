// 함수 (Function)


// 1. 함수 없이 덧셈하기 
console.log("\n[1. 함수 없이 덧셈 하기]");

let num1=10, num2=15;
let sum = num1 + num2;
   
console.log("num1 = %d, num2 = %d \n-> sum = %d", num1, num2, sum);

let num3=1, num4=5;
let sum2 = num3 + num4;

console.log("num3 = %d, num4 = %d \n-> sum2 = %d", num3, num4, sum2);


// 2. 기본 함수 선언
console.log("\n[2. 기본 함수 선언]");

function add (num1, num2){
    console.log(`-> 함수 호출됨: add(${num1}, ${num2})`);
    console.log(`-> 결과: ${num1 + num2}`)
}
add(10, 15);
add(1, 5); 


// 3. return 문 사용 하기
console.log("\n[3. return 문 사용하기]");

function addWithReturn (num1, num2,){
    let sum = num1 + num2;
    return sum;
}

let result = addWithReturn(10, 15);
console.log(`addWithReturn(10, 15) 호출 \n-> 두 숫자를 더한 결과는 ${result}입니다.`);


// 4. return 후의 코드는 실행되지 않음
console.log("\n[4. return 후의 코드는 실행되지 않음]");
function addWithLog (num1, num2,){
    let sum = num1 + num2;
    return sum;
    console.log("함수 호출");
}

let result2 = addWithLog(20, 30);
console.log("addWithLog(20, 30) 호출 \n-> 결과: ", result2);

/*
    5. 매개변수(Parameter)와 인수(Argument)
        매개변수 : 함수 정의 시 선언하는 변수
        인수    : 함수 호출 시 전달하는 실제 값
*/

console.log("\n[5. 매개변수(Parameter)와 인수(Argument)]");

function greet(name) {  // name -> 매개변수(parameter)
    console.log(`안녕하세요 ${name}님`);
}

greet("이순신");  // "이순신" -> 인수(argument)
greet("신사임당");

// 6. 여러개의 매개변수 사용

console.log("\n[6. 여러개의 매개변수 사용]");

/*
function introduce(name, age, city){
    console.log(`introduce('${name}', ${age}, '${city}') 호출 \n-> 이름: ${name}, 나이: ${age}, 도시: ${city}`);
}

introduce('홍길동', 25, '서울');
*/

console.log("introduce('홍길동', 25, '서울') 호출");
introduce('홍길동', 25, '서울') // args val

function introduce(name, age, city){    // param val
    console.log(`-> 이름: ${name}, 나이: ${age}, 도시: ${city}`);
}

// 7. 기본 매개변수 (Default Parameters)
console.log("\n[7. 기본 매개변수 (Default Parameters)]");

function greetWithDefault(name = '손') {
    console.log(`-> 환영합니다. ${name}님`);
}

console.log("greetWithDefault() 호출 (인수없음)");
greetWithDefault(); // 인수없음 -> 기본값: '손님' 사용됨

console.log("greetWithDefault() 호출 ('회원')");
greetWithDefault('회원');   // '회원' -> 인수(argument), 기본값 대신 사용됨
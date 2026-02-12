// 숫자형(Number) - JavaScript는 정수와 실수를 구분하지 않음

let num1 = 125;         // integer
let num2 = 10.00012;    // floating point

console.log("[숫자형] 정수 num 1 = ",  num1, "-> typeof: ", typeof(num1));
console.log("[숫자형] 정수 num 2 = ", num2, "-> typeof: ", typeof(num2));

/*
    JavaScript는 정수와 소수가 따른 구분 없이 'number' 타입임   ->  모든 숫자를 부동소숫점(floating point, 64bit)로 처리함
    다른 lang(Java, C++)는 int, float, double로 구분함
 */
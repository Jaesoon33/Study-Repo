// 변수 호이스팅 (Variable Hoisting)
console.log("[1. var 변수 호이스팅 (Variable Hoisting)]");

console.log("-> num1 = ", num1); 
var num1 =123;
console.log("-> num1 = ", num1);


console.log("[2. let/const 변수의 TDZ(Temporal Dead Jone)]");
console.log(num2); 
let num2 = 213;

// col. let,const는 변수가 선언되고 값이 초기화되어야 메모리에 할당되기 때문에
//      변수를 선언하지 않고 바로 사용하면 레퍼런스(참조) 오류가 발생
        
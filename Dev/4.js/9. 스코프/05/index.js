// 변수 재선언 (var vs let)

// 1. let은 재선언 불가 (let은 같은 scope에서 재선언 불가)
let num1 = 10;
// let num = 100; --> occur SyntaxError 

/* function에서는 재선언 가능 (another scope)
function test (){
    num1 = 20;
}
test();
console.log(num1); // console창 결과로는 20이 출력됨
*/


// 2. var는 재선언 가능
var num2 = 10;
var num2 = 100;

// 3. let은 재할당은 가능
let num3 = 10;
num3 = 100; // 재할당 (재선언 X)

// 4. const는 재선언, 재할당 모두 불가
const PI = 3.141592;
// const PI = 3.141592; - 재선언
// PI = 3.14; - 재할당

// 5. var 재선언의 문제점
var count = 1;
var count = 100;
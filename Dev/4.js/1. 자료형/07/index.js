// boolean - 참/거짓을 나타내는 자료형

let isClicked = false;
let isLoggedIn = true;

console.log("[Boolean] isClicked ->",isClicked,"| typeof: ",typeof isClicked);
console.log("[Boolean] isLoggedIn ->",isLoggedIn,"| typeof: ",typeof isLoggedIn);

// 조건문에서 boolean 사용
console.log("\n[조건문 예시]");

if(isClicked){
    console.log("-> isClicked가 true: 클릭 O");
} 
else{
    console.log("-> isClicked가 false: 클릭 X");
}

// Truthy와 Falsy 값
console.log("\n[Falsy 값들] - false로 평가되는 값");

// Falsy 값: false로 평가되는 6가지
console.log(`false -> ${Boolean(false)}
0 -> ${Boolean(0)}    

null -> ${Boolean(null)}
undefined -> ${Boolean(undefined)}
NaN -> ${Boolean(NaN)} 
`)

// Truthy 값
console.log("\n[Truthy 값들] - true로 평가되는 값");
console.log(`hello -> ${Boolean("hello")}
    123 -> ${Boolean(123)}
[] (빈 배열) -> ${Boolean ([])}
{} (빈 객체) -> ${Boolean ({})}
`);
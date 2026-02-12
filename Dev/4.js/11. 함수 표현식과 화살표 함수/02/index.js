/*
    1. 콜백 함수란
        - 다른 함수에 인수로 전달되는 함수
        - 전달받은 함수가 나중에 호출(call back)합니다.
*/

// 2. 기본 콜백 함수 예
console.log("\n[2. 기본 콜백 함수 예]");

// [화살표 함수로 정의] printResult: 두수를 더한 결과를 출력하는 함수
const printResult = (result) => {
    console.log('-> 결과: ' + result);      // 문자열 연결(+)로 결과 출력
};

// [화살표 함수로 정의] doubleResult: 두수의 합을 2배로 만들어 출력하는 함수
const doubleResult = (result) => {
    console.log(`-> ${result} (result)에 2를 곱한 값: ` + result * 2);
};

printResult(5, 3);
doubleResult(5, 3);

// 3. 콜백 함수를 매개변수로 받기
console.log('\n[3. 콜백 함수를 매개변수로 받기]');

const addAndCallback = (a, b, callback) => {
    let result = a + b;
    callback(result); 
};

const showResult = (result) => {
    console.log('-> 결과: ' + result);
};

addAndCallback(5, 2, showResult);

const showDouble = (result) => {
    console.log('-> 결과에 2를 곱한 값: ' + result * 2);
};

addAndCallback(5, 3, showDouble); 
console.log('\n');

addAndCallback(5, 4, printResult);
addAndCallback(5, 4, doubleResult);


// 4. 익명 함수를 콜백으로 전달
console.log("\n[4. 익명 함수를 콜백으로 전달]");

// 계산 후 콜백 실행하는 고차 함수
const calculateAndProcess = (a, b, callback) => {
    let result = a + b;
    callback(result);
};

calculateAndProcess(10, 5, (result) =>{
    console.log('-> result = ' + result + ', result * result = ' + result*result); // 15 * 15
})
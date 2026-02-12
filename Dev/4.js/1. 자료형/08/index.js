// null과 undefined - "값이 없음"을 나타내는 두 가지 방법
  
/*
    null - 의도적으로 "값이 없음"을 표현
    존재하지 않는 값, 알 수 없는 값
    개발자가 명시적으로 "비어있음"을 할당
*/

let user = null;        // 사용자 정보가 아직 없음(의도적)

console.log("[null] use ->",user);
console.log("[null] === use ->",user === null);
console.log("[null] typeof null --> ", typeof null);        // 콘손창에서 확인 시에 object로 나옴 (버그)

let num;

console.log("\n", typeof num);

// 명시적으로 undefined 할당(권장하지 않음)
let value = undefined;

// null vs undefined 
console.log("\n[비교] null == undefined ->", null == undefined);    // 느슨한 비교: value
console.log("\n[비교] null === undefined ->", null === undefined);  // 엄격한 비교: value + type

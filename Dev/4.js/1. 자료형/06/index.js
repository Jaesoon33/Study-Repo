// 문자열(String) - 텍스트 데이터를 다루는 f

// 문자열 생성 방법 3가지
let str1 = "큰따옴표 문자열";
let str2 = ' 문자열';
let str3 = `백틱 문자열`;

console.log("[string] 큰따옴표 ->",str1,"| typeof: " , typeof str1);
console.log("[string] 문자열 ->",str2,"| typeof: " , typeof str2);
console.log("[string] 백틱 문자열 ->",str3,"| typeof: " , typeof str3);

// 백틱(템플릿 리터럴)의 특별한 기능
let name = `sunshin`;
let age = 25;

// ${변수}
let intro1 = `안녕하세요, ${name} 입니다. 나이는 ${age}살 입니다.`
console.log(`[템플릿 리터럴] 변수 삽입 -> `,intro1);

// 표현식 사용 가능
let calc = `10 + 20 = ${10+20}`;
console.log("[템플릿 리터럴] 표현식 -> ",calc);

// 여러 줄 문자열
let multiline =`
첫 번째 줄
두 번째 줄
세 번째 줄`;
console.log("[템플릿 리터럴] 여러줄\n", multiline);
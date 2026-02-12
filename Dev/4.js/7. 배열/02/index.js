// 배열

console.log(`배열(Array): 여러 값을 순서대로 저장하는 자료구조
             인덱스 (index)로 각 요소에 접근 (0부터 시작)`)

// 생성자 함수로 빈 배열 새애성
let arr = new Array();
console.log("arr = ",arr )


// 생성자 함수로 빈 배열 생성
let arr1 = new Array(1,2,3);
console.log("arr1 = ",arr1);


// 배열 리터럴로 생성 (recommanded)
let arr3 = [1, 2, 3];
console.log("arr3 = ", arr3);

let arr4 = [3];
console.log("arr4 = ", arr4);

// 다양한 타입의 요소

let mixed = [1, 'hello', true, null,{name: '이순신'},[1, 2, 3] ];
console.log(mixed);
console.log(`배열에는 숫자, 문자열, 불리언, null, 객체 배열 등 다양ㅌ`)

// 배열 요소 접근
let fruits = ['사과', '오렌지', '바나나'];
console.log(fruits[0]);
console.log(fruits[1]);
console.log(fruits[2]);
console.log(fruits[3]);
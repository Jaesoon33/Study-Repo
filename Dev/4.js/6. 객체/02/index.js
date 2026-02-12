// 배열(Array) - 요소 접근과 추가/수정

let arr = [     // 배열에 다양한 타입의 요소 저장
    { name: '이순신'},
    1,
    'array',
    function(){
        console.log('hello world')
    },
    null,
    undefined
]

console.log("arr = ", arr);

// 인덱스로 요소 접근
/*
let array = [1, 'hello', null];
console.log("array[0] = ". array[0]);
console.log("array[1] = ". array[1]);
console.log("array[2] = ". array[2]);
console.log("array[3] = ". array[3]);
*/

// push() - 맨 뒤에 요소 추가

let fruits = ['apple', 'orange', 'peach'] // 초기배열 3요소
console.log("초기 fruits=", fruits);
fruits.push('grape');

// unshift() - 맨 앞에 요소 추가
let fruits2 = ['apple','orange','peacg'];
console.log("초기 fruits2 = ",[...fruits] );


// 인덱스로 요소 수정
let animal = ['cat', 'dog', 'hamster'];
console.log("초기 animal",[...animal]);

animal[1] = 'rabbit';       // 인덱스 1의 dog -> rabbit으로 수정
console.log('animal[1] =', animal[1]);
console.log("수정후 animal = ", [...animal]);

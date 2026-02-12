// 1. const 배열 재할당 불가 -- const로 선언해도 요소 수정은 가능함. 변수 재할당만ㅂ
const animal1 = ['cat','dog','hamster'];
console.log("animal1 = ", [...animal1]);

//animal1 = ['cat', 'rabbit', 'hamster'];

// 2. const 배열 요소 수정 가능
const animal2 = ['cat', 'dog', 'hamster'];
console.log("초기 animal2 = ", [...animal2]);

animal2[2] = 'parrot';
console.log("수정 후 animal2 = ", [...animal2]);

// 3. pop() - 맨 뒤의 요소 삭제
const color1 = ['puple', 'skyblue', 'green'];
console.log("초기 color1 = ", [...color1]);

const removed1 = color1.pop(); 
console.log("삭제 후 color1 = ", [...color1]);
console.log("삭제된 요소 = ", removed1);
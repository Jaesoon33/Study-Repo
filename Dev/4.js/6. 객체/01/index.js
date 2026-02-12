// 객체(Object) - 생성자 함수, 리터럴

// 1. 생성자 함수로 객체 생성
console.log("[1. 생성자 함수로 객체 생성]");

let obj1 = new Object();        // 생성자 함수로 빈 객체가 생성됨 (결과: { })
console.log("obj1= ", obj1);

// 2. 객체 리터럴로 객체 생성
console.log("\n[2. 객체 리터럴로 객체 생성]");

let obj2 ={};
console.log("obj2= ", obj2);
console.log("-> 리터럴 방식이 더 간결하고 권장됨");

// 3. 속성(property)을 가진 객체
console.log("\n[3. 속성(property)을 가진 객체]");

let book = {
    title: "자바스크립트 바이블",   // 키: title 값: String
    autor: "이순신",
    category: "자바스크립트"
}

console.log('book = ', book);

// 4. 속성 접근하기 - 점 표기법 (Dot notation)
console.log("\n[속성 접근하기 - 점 표기법 (Dot notation)]");
console.log("book.title = ",book.title); 
console.log("book.autor = ",book.autor);

console.log("book['category']: ", book['category']);
console.log("book['title']: ", book['title']);

// 5. 다양한 값 타입의 속성
console.log("\n[5. 다양한 값 타입의 속성]");

let product = {
    name: "노트북",
    price: 150000,
    inStock: true,
    discount: undefined,
    tags:['전자기기', "IT"] 
}

// 6. 메서드 (객체 안의 함수)
console.log("\n[6. 메서드(객체 안의 함수)]]");

let bookWithMethod = {
    color: function(){
        console.log('=> orange');
    }    };


// 7. 속성 추가, 수정, 삭제
console.log("\n[7. 속성 추가, 수정, 삭제]");

let person = {name: '이tnstls'}


// 속성 추가
person.name = '신사임당';
console.log("=== 로그인 검증 ===");

// 저장된 사용자 정보 (DB에서 가져왔다고 가정)
/*
    객체(Object)란?
        - 여러 값을 하나로 묶어서 저장하는 "데이터 묶음"
        - {} 중괄호 안에 "이름: 값" 형태로 데이터를 저장
        - 각 데이터를 "속성(property)"라고 부름

        사용법: ObjectName.Attribute
*/

const savedUser = {
    userId: "admin",
    password: "1234",
    isActive: true,
    loginAttempts: 0,
    maxAttempts: 5
}

// 사용자 입력 (로그인 폼에서 입력받은 값)
const userInput = {
    userId: "admin",
    password: "1234",
}

console.log("=== 저장된 정보 ===");
console.log("ID: %s\nPW: %d", savedUser.userId, savedUser.password);
console.log("\n");

console.log("=== 입력된 정보 ===");
console.log("ID: %s\nPW: %d", savedUser.userId, userInput.password);

// 문제 1  : 아이디 일치 확인
// === 를 사용하여 정확히 일치하는 확인

console.log("=== 문제 1: 아이디 일치 확인 ===");
let idValid = (savedUser.userId === savedUser.userId) ? true : false;
console.log("아이디 일치: ", idValid);

let pwValid = (savedUser.password === savedUser.password) ? true : false;
console.log("패스워드 일치: ", pwValid);

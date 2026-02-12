console.log("=== 접근 권한 제어 ===");

/*
    Web application page 접근 권한 체크
    사용자의 로그인 상태와 권한에 따라 접근을 허용하거나 거부합니다.
*/

// 현재 사용자 정보
const currentUser = {
    isLoggedIn: true,
    username: "developer2026",
    role: "member",          // "guest", "member", "admin"
    isPremium: false,
    lastLoginDate: "2025-12-31"
}

console.log("\n=== 사용자 정보 ===");
console.log("로그인 상태: ", currentUser.isLoggedIn);
console.log("사용자명: ", currentUser.username);
console.log("권한: ", currentUser.role);
console.log("프리미엄: ", currentUser.isPremium);

/*
    문제 1: 로그인 상태 확인
    
    로그인이 되어있으면 "환영합니다!" 출력
    로그인이 안되어있으면 "로그인이 필요합니다"
 */


console.log("\n=== 문제 1: 로그인 상태 확인 ===");    
if(currentUser.isLoggedIn === true)
    console.log("환영합니다. ",`${currentUser.username}님!`);
else
    console.log("로그인이 필요합니다.");

/*
    문제 2: 관리자 페이지 접근

    조건: role의 값이 "admin"이어야 접근 가능
        - 관리자인지 확인.
            - 관리자 페이지에 접근합니다.(admin o)
            - 접근 권한이 없습니다.(admin x)
    
*/
console.log("\n=== 문제 2: 관리자 페이지 ===");    

if(currentUser.role === "admin")
    console.log("관리자 페이지에 접근합니다.");
else
    console.log("접근 권한이 없습니다.");

/*
    문제 3: 프리미엄 컨텐츠 접근

    조건: 로그인&프리미엄 회원
    
    프리미엄 컨텐츠 접근 가능 여부 확인
        - 프리미엄 컨텐츠를 시청합니다. 
        - 프리미엄 회원만 이용 가능합니다.
*/

console.log("\n=== 문제 3: 프리미엄 컨텐츠 접근 ===");
if(currentUser.isLoggedIn && currentUser.isPremium)
    console.log("프리미엄 컨텐츠를 시청합니다.");
else if (currentUser.isLoggedIn)
    console.log("프리미엄 회원만 이용 가능합니다.");
else
    console.log("로그인이 필요합니다.");


/*
    문제 4: 글쓰기 권한 확인

    조건: 로그인 && (member 또는 admin)

    글쓰기 권한 확인
        - "글을 작성할 수 있습니다."
        - "글쓰기 권한이 없습니다."
*/

console.log("\n=== 문제 4: 글쓰기 권한 확인 ===");
if(currentUser.isLoggedIn && currentUser.role != "guest")
    console.log("글을 작성할 수 있습니다.");
else
    console.log("글쓰기 권한이 없습니다.");


/*
    문제 5: 3항 연산자로 간단한 분기 처리

    로그인 상태에 따라 다른 버튼 텍스트 표시하기

    로그인 -> 로그아웃, 비로그인 -> 로그인

    삼항 연산자 (조건 ? 참값 : 거짓값)
        - 간단한 if-else를 한줄로 표현
*/

console.log("\n=== 문제 5: 3항 연산자 ===");
const loginButton = currentUser.isLoggedIn ? "로그아웃" : "로그인"
console.log(`버튼: ${loginButton}`);

const loginCheck = currentUser.isLoggedIn ? `안녕하세요. ${currentUser.username}님` : `로그인이 필요합니다.`;
console.log(loginCheck);

/*
    문제 6: 중첩 조건문
        - 1차: 로그인 확인
        - 2차: 관리자 여부 확인
*/

console.log("\n=== 문제 6: 중첩 조건문 ===");
if(currentUser.isLoggedIn)
    if(currentUser.role == "admin")
        console.log("관리자님 환영합니다.");
    else
        console.log("회원님 환영합니다!");

else
    console.log("로그인이 필요합니다");
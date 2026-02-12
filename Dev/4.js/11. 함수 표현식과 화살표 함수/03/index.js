console.log("=== 학생 성적 관리 시스템 ===");

// 함수 선언문
function greetStudent1(name) {
    return "안녕하세요, " + name + " 학생!";
}

// 함수 표현식 - 함수를 변수에 할당하는 방식
const greetStudent2 = function(name) {
    return "안녕하세요, " + name + " 학생!";
};

// 테스트 실행
console.log(greetStudent1("이순신"));   // 함수 선언문으로 호출
console.log(greetStudent2("신사임당")); // 함수 표현식 호출


/*
    학생 데이터와 배열 메서드
 */
console.log("=== 1. 학생 데이터와 배열 메서드 ===");

// 객체들의 배열 [{}, {}, {}, ...]

const students = [
    {id:1, name: "이순신", score: 85, grade: "B"},
    {id:2, name: "김출수", score: 92, grade: "A"},
    {id:3, name: "이영희", score: 78, grade: "C"},
    {id:4, name: "박민수", score: 95, grade: "A"},
    {id:5, name: "정수진", score: 88, grade: "B"},
];

console.log(...students);  // 배열 전체 출력

// 1. 학생 이름만 추출하기
const names = students.map(students => students.name);
console.log("\n[이름만 추출] \n결과:", names);

// 2. 점수에 보너스 5점 가산 하시오
const scorePlus = students.map(students => students.score + 5);
console.log("\n[점수 + 5 가산] \n결과:", scorePlus);

// 3. 새로운 형태의 객체로 변환
const simpleList = students.map(student => ({
    이름: student.name,         // name -> 이름
    점수: student.grade        // grade -> 점수
}));    // ()가 없으면 {}가 함수 본문으로 해석되어 undefined 반환

console.log("\n[새로운 형태의 객체로 변환] \n결과:", simpleList);

/*
    filter
        - 조건에 맞는 요소만 추출
        - 조건을 만족하는 요소만 새 배열로 생성
        - 원본 배열은 변경되지 않음
 */
// 점수가 90점 이상인 학생만 추출 
const topStudents = students.filter(student => student.score >= 90);
console.log("\n[90점 이상 학생] \n결과: ", topStudents.map(topStudents => topStudents.name));

// A등급 학생만 추출하시오
const AStudents = students.filter(student => student.grade === "A");
console.log("\n[A등급인 학생] \n결과: ", AStudents.map(AStudents => AStudents.name));

// 복합 조건 (80점 이상, 90점 미만)
const Bstudents = students.filter(student => student.score >= 80 && student.score < 90);
console.log("\n[80~89점 학생] \n결과: ", Bstudents.map(Bstudents => Bstudents.name +"("+( Bstudents.score)+")"));

// 성적처리
/*
    핵심 포인트: 화살표 함수로 유틸리티 함수 작성
        - 재사용 가능한 함수들을 만들어 사용
*/
console.log("=== 실무 패턴 - 유틸리티 함수 ===\n");

// 유틸리티 함수1: 점수를 등급으로 변환
const getGrade = score => {
    if(score >= 90) return 'A';
    if(score >= 80) return 'B';
    if(score >= 70) return 'C';
    if(score >= 60) return 'D';
    return "F";
}

// 유틸리티 함수2: 합격 여부 판단
const isPassed = score => score >= 60;

// 유틸리티 함수3: 점수 포맷팅
const formatScore = score => `${score}점`;

// 유틸리티 함수 테스트
console.log("getGrade(85): ", getGrade(85));
console.log("isPassed(55): ", isPassed(55));
console.log("isPassed(92): ", formatScore(92));

// 유틸리티 함수들을 조합해서 성적표 생성
const report = students.map(s => ({     // 각 학생을 새 형태로 변환
    이름: s.name,
    점수: formatScore(s.score),
    등급: getGrade(s.score),
    합격여부: isPassed(s.score) ? "합격" : "불합격"
}));
    console.log(...report);

console.log("\n[성적표]");
report.forEach(r => {
    console.log(` ${r.이름}: ${r.점수} (${r.등급}) - ${r.합격여부}`);
})
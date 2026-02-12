/*
    JavaScript - 포트폴리오 동적 기능

        핵심 개념: 
            - 객체(Object): 관련 데이터를 하나로 묶은 관리
            - 배열(Array): 여러 데이터를 순서대로 저장
            - forEach(): 배열의 각 요소를 순회하며 처리
            - DOM 조작: JavaScript로 HTML 요소 생성/수정
            - 이벤트 리스너: 사용자 동작(클릭 등)에 반응
*/

/*
    DOMcontentLoaded 이벤트 
*/
document.addEventListener('DOMContentLoaded', function() {
    console.log('DOM 로드 완료! 함수들을 실행합니다.');
    // HTML 순서대로 함수 실행 (Top -> Bottom)
    setupSmoothScroll();        // 네비게이션 스크롤 설정
    renderProfile();            // 프로필 카드 랜더링
    renderSkills();             // 기술 스택 카드 랜더링
});

// 부드러운 스크롤 기능
/*
    이벤트 리스너
        - 특정 이벤트(ex. 클릭, 키보드 입력 등) 발생 시 함수 실행
        - addEventListener('이벤트명', 실행할 함수)
    
    preventDefault()
        - <a href="#about"> 클릭 시 기본 동작: 페이지가 #about으로 점프
        - preventDefault() 후: 점프 안하고 우리가 원하는 동작 실행
*/
function setupSmoothScroll() {
    // 1. 네비게이션의 모든 링크 선택 --> 여러 요소를 NodeList로 변환
    const navLinks = document.querySelectorAll('.nav a');
    console.log(`네이게이션 링크${navLinks.length}개 발견`);

    // 2. 각 링크에 클릭 이벤트 등록
    navLinks.forEach(link => {
        link.addEventListener('click', function(e) {
            // e: 이벤트 객체 - 이벤트에 대한 정보를 담고 있음
            e.preventDefault();     // 기본 동작(페이지) 방지

            // this 클릭된 a태그
            // getAttribute('href'): href 속성값 가져오기
            const targetId = this.getAttribute('href');  
            console.log(`클릭됨: ${targetId}`);

            // targetId가 유효한 경우에만 실행
            if(targetId && (targetId !== '')){
                // querySelector()로 해당 섹션 찾기
                const targetSection = document.querySelector(targetId);
                if(targetSection){
                    targetSection.scrollIntoView({
                        behavior: 'smooth',     // smooth: 부드럽게, auto: 즉시 이동
                        block: 'start'          // start/center/end: 스크롤링될 요소의 위치 시작(상단)/중간/끝(하단)
                    });
                }
            }
        });
    });
    console.log('부드러운 스크롤 설정 완료');
}

/*
    프로필 정보 객체
        - 객체(Object) 
            - 중괄호 {} 안에 key: value 형태로 데이터 저장
            - 관련된 정보를 하나로 묶어서 관리할 수 있음
            - 점(.) 또는 대괄호([])로 값에 접근
*/
const profile = {
    name: "이순신",
    initials: "SJ",
    interests: ["Web", "Cloud", "Backend"],
    currentStudy: ["HTML/CSS/JS", "Java", "Spring"]
};

/*
    JavaScript DOM 조작 방법
        - createElement() - 새 HTML 요소 생성,
            appendChild() - 자식 요소로 추가,
            innerHTML - HTML 내용 설정 (태그 포함 가능),
            textContent - 텍스트만 설정(태그는 문자로 표시됨),
        - 배열 메서드 (forEach, join)
*/
function renderProfile() {

    // 1. HTML에서 .profile-card 요소 찾기
    const profileCard = document.querySelector('.profile-card');

    // 요소를 못 찾으면 함수 종료 (에러 방지, 값 유효성 검사)
    if(!profileCard){
        console.error('profile-card 요소를 찾을 수 없습니다.');
        return;
    }

    // 2. 아바타에 이니셜 표시
    const avatar = profileCard.querySelector('.avatar');  // profile-card안에서 .avatar 찾기
    if(avatar) {
        avatar.textContent = profile.initials;      // "SJ" 표시
    }
    
    // 3. 프로필 정보 리스트 생성
    const ul = profileCard.querySelector('ul');
    if(ul) 
    {
        ul.innerHTML = '';      // 기존 내용? 있다면 초기화 (unexpected한 내용 삭제)

        // li 생성 (name)
        const nameLi = document.createElement('li');       // <li> 요소 생성
        nameLi.innerHTML = `<strong>이름:</strong> ${profile.name}`;
        ul.appendChild(nameLi);     // ul의 자식으로 추가

        // li 생성 (interests)
        const interestLi = document.createElement('li');
        // join(',') : 배열을 문자열로 변환, 쉼표로 구분
        interestLi.innerHTML = `<strong>이름:</strong> ${profile.interests.join(', ')}`;
        ul.appendChild(interestLi);     // ul의 자식으로 추가

        // li 생성 (currentStudy)
        const StudyLi = document.createElement('li');
        // join(',') : 배열을 문자열로 변환, 쉼표로 구분
        StudyLi.innerHTML = `<strong>현재학습:</strong> ${profile.currentStudy.join(', ')}`;
        ul.appendChild(StudyLi);     // ul의 자식으로 추가
    }
    profileCard.append(ul);
    console.log('프로필 카드 랜더링 완료');
}

// 기술 스택 데이터 배열
const skills = [
    {
        category: "Frontend",
        items: [
            "HTML5 / CSS3",
            "JavaScript (기초)",
            "반응형 웹 이해"
        ]
    },
    {
        category: "Backend",
        items: [
            "Java 기본 문법",
            "객체지향 프로그래밍"
        ]
    },
    {
        category: "Tools",
        items: [
            "Git / Github 기본 사용",
            "VSCode / Eclipse / IntelliJ",
        ]
    }
];

function renderSkills () {
    // 1. HTML에서 .skiils-grid 요소 찾기
    const skillsGrid = document.querySelector('.skills-grid');

    if(!skillsGrid) {
        console.error('skills-grid 요소를 찾을 수 없습니다.');
        return;
    }

    // 2. 기존 내용 초기화
    skillsGrid.innerHTML = '';

    // 3. skills 배열 순회하면서 카드 생성
    /*
        forEach 콜백 함수의 매개변수
            - skill: 현재 순회중인 요소
            - index: 현재 인덱스(0, 1, 2)
    */

    skills.forEach((skill, index) => {
        console.log(`${index + 1}번쨰 카드 생성 중: ${skill.category}`);
        
        // article 요소 생성 <article class="skill-card"></article>
        const article = document.createElement('article');
        article.classname = "skill-card";    // class 속성 설정
        skillsGrid.appendChild(article);    // skills-grid 안에 article 추가

        // 카테고리 제목 생성: <h3>Frontend</h3>
        const h3 = document.createElement('h3');
        h3.textContent = skill.category;
        article.appendChild(h3);        // article안에 h3 추가

        const ul = document.createElement('ul');
        // 내부 forEach: 각 기술 항목을 li로 생성
        skill.items.forEach(item => {
            const li = document.createElement('li');
            li.textContent = item;      // 기술명 텍스트 설정
            ul.appendChild(li);         // ul 안에 li 추가
        });
        article.appendChild(ul);
    });

    console.log("기술 카드 랜더링 완료!");
}

function copyEmail(email) {
    navigator.clipboard.writeText(email)
        .then(() => {
            alert("이메일이 클립보드에 복사되었습니다.");
        })
        .catch((err) => {
            console.err('복사 실패:', err);
            alert("복사에 실패했습니다.");
        })
}
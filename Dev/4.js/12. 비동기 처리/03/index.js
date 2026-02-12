console.log('%c 3. 콜백 대신 Promise를 반환하는 패턴',
    'background: #00d9ff; color: #000; font-size: 16px; font-weight: bold; padding: 5px;'
);

/*
                       차이점 정리 
    ------------------------------------------------
        콜백 방식              Promise 반환 방식
    ------------------------------------------------
      결과를 콜백 함수의      결과를 resolve()로 반환
      인자로 전달              에러를 reject()로 반환
      에러를 콜백 첫번째      .then() 체이닝으로 평탄화
      인자로 전달, 및 중      .catch()로 모든 에러 처리
      첩되어 콜백 지옥 발생

    const token = 'token_' + Math.random().toString(36).slice(2, 11);
        - Math.random(): 0~1 사이의 랜덤 소수 (ex. 0.72911545)
        - .toString(36): 36진수 변환 (ex. 0.q74as53qwe2)
            - 36진수: 숫자(0-9) 10개 + 알파벳(a-z) 26개 ==> 36개의 문자 사용
            - 짧은 문자열로 조합 ==> 간단한 ID, PW 생성에 활용
        - .slice(2, 11): "0." 제거 및 뒤의 9글자 추출 (ex. q74as53qw)
*/

// 실제 API 함수들 - 콜백 대신 promise 반환

function loginPromise (username, password) {        // 로그인 시뮬레이션
    return new Promise((resolve, reject) => {       // Promise를 반환 --> .then()으로 체이닝 가능
        setTimeout(() => {          // 서버 응답 지연 시뮬레이션 (800ms)
            if(password.length >= 4) {      // 패스워드 유효성 검사
                const token = 'token_' + Math.random().toString(36).slice(2, 11);
                resolve(token);     // 성공 -> .then()으로 token 전달
            }
            else {
                reject(new Error('비밀번호는 4글자 이상이어야 합니다.'));       // 실패 -> .catch()로 전달
                
            }
        }, 800);
    });
}

function getUserInfoPromise (token) {       // 토큰으로 사용자 정보 조회 시뮬레이션
    return new Promise((resolve) =>{        // Promise를 반환 --- 다음 --> .then()으로 체이닝
        setTimeout(() => {
            resolve ({
                id: 1,
                name: '이개발',
                email: 'dev.lee2example.com'
            })
        }, 800);
    })
}

function getPostPromise (userId) {      // 사용자 ID로 게시글 목록 조회 시뮬레이션
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve([       // 성공 --> .then의 posts로 전달됨
                {id: 1, title: 'JavaScript Promise 이해하기'},
                {id: 2, title: 'async/await 활용법'},
                {id: 3, title: 'API 호출 패턴 정리'}
            ])
        }, 600);
    })
}

setTimeout(() => {
    console.group('Promise 체이닝 - 실행 결과');
    console.log('로그인 -> 사용자 정보 -> 게시글 순서로 실행')
    console.log('-'.repeat(50));

    // loginPromise() 호출 + 모든 .then() 등록
    loginPromise('dev.lee', 'password34') 
        .then(token => {
            console.log('1️⃣ 로그인 성공 토큰:', token.slice(0, 15) + '...');    
            return getUserInfoPromise(token);   // 새 Promoise 객체 반환
        })
        
        .then((user) => {
            console.log('2️⃣ 사용자 :',user.name);
            return getPostPromise(user); // 새 promise 객체 반환
        })

        .then((posts) => {
            console.log('3️⃣ 게시글 목록');
            console.table(posts);
            console.log('-'.repeat(50));
            console.log('모든 작업 완료!');
        })

        .catch((error) => {
            console.log("❌ 에러: ", error.message);
        })

        .finally(() => {
            console.log('📌 finally: 항상 실행됨');
            console.groupEnd();
        });

}, 500);
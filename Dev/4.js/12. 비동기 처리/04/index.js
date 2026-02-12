console.log('%c 4.Promise.all()',
    'background: #00d9ff; color: #000; font-size: 16px; font-weight: bold; padding: 5px;'
);

/*
    체이닝 vs Promise.all() 비교
        - 체이닝 (순차) : A(2s) -> B(4s) -> C(6s) = total(2+4+6 = 12s)
        - Promise.all() : A(4s) & B(2s) & C(6s) = total(6s)
    
    Promise.all([
        fetchUserById(1),
        fetchUserById(2),   --> 3개가 "동시에" 시작
        fetchUserById(3)
    ])
                            --> 모두 완료될 때까지 대기
    .then([user1, user2, user3]) <----- 결과를 배열로 전달 (.then에 사용되는 배열의 순서는 보장됨)
    
    Promise.all()이 내부적으로 "인덱스 위치"를 기억하고 있음.
*/

function fetchUserById(id) {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve({
                id,
                name: `사용자${id}` // resolve()가 호출되면 해당 Promise는 fulfilled 상태
            });
        }, 500 + Math.random()*500);        // 500~1000ms 랜덤 지연
    });
}

setTimeout(() => {
   console.group('Promise.all() - 실행 결과');
   console.log('3명의 사용자를 동시에 조회');
   
   const startTime = Date.now();
   // 1단계: Promise.all() 호출 -- 3개의 Promise가 동시에 시작
   Promise.all([
        fetchUserById(1),       // index: 0 <-- 완료 순서와 관계없이 users[0]에 저장됨
        fetchUserById(2),       // index: 1 <-- 완료 순서와 관계없이 users[1]에 저장됨
        fetchUserById(3)        // index: 2 <-- 완료 순서와 관계없이 users[2]에 저장됨
                                // 3개가 순차가 아닌 "동시에" 실행됨 (병렬 처리)                                
   ])
   .then(users => {
        // users [user1, user2, user3] <--- 배열로 결과를 받음
        // 순서보장: user[0]=id:1, user[1]=id:2, user[2]=id:3 but 각 함수들의 완료순서는 random임
        // 완료 순서는 2->3->1이어도, 정렬은 입력순서대로 된다.
        const elasped = Date.now() - startTime;
        console.log(`✅ 완료! (${elasped}ms)`);
        console.table(users);
        console.log('💡 병렬 처리로 시간 단축!')
   })
   .catch((error) => {
        console.log('❌ 에러: ', error.message); 
        // 주의: 하나라도 실패 시 전체 실패로 처리됨
   })
}, 1000);



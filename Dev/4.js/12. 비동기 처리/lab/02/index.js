console.log('%c Promise 체이닝 Lab2',
    'background: #00d9ff; color: #000; font-size: 16px; font-weight: bold; padding: 5px;'
);

// getDashboardUser() -- 사용자 정보 API (1초)
// 항상 성공하는 시뮬레이션 --> reject 생략 가능

// 사용자 정보 - object
function getDashboardUser(name) {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve({
                id: name
            });
        }, 1000);      
    });
}

// 사용자 알림 - array
function getNotification(alert) {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve([
                newComment = "새 댓글",
                newfollower = "새 팔로워"                
        ]);
        }, 1000);        
    });
}

// 알림 상태
function getStatus(num) {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve({
                times: `조회수 ${num}`
            });
        }, 1000);        
    });
}




setTimeout(() => {
    console.log('🚀대시보드 로딩 (3개 동시 호출!)...')
    const startTime = Date.now();
    Promise.all([
        getDashboardUser('김개발'),
        getNotification(),    
        getStatus(100) 
   ])
    .then(users => {
        console.log('✅사용자: ', users[0].id);
        console.log('✅알림: ', users[1][0]+', '+users[1][1]);
        console.log('✅통계: ', users[2].times);
        console.log(...users);
        const elasped = Date.now() - startTime;
        console.log(`\n⏱️총 시간: (${elasped}ms)`);
        console.log('💡 가장 느린 것(1초) 기준 = 약 1초');
   })
    .catch((error) => {
        console.log('%c❌ 에러: ', + error.message, 'color:#ff6b6b');
    })
}, 1000); 
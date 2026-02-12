console.log('%c Promise 체이닝 Lab',
    'background: #00d9ff; color: #000; font-size: 16px; font-weight: bold; padding: 5px;'
);

function login (username, password) {        
    return new Promise((resolve) => {       
        setTimeout(() => {          
            if(password.length >= 4) {      
                const token = {value: 'abc123'};
                resolve(token);     
            }
            else {
                reject(new Error('비밀번호는 4글자 이상이어야 합니다.'));  
            }
        }, 1000);
    });
}

function userInfo (token) {      
    return new Promise((resolve) =>{      
        setTimeout(() => {
            resolve ({
                id: 1,
                name: '김개발',
                email: 'dev.lee2example.com'
            })
        }, 1000);
    })
}

setTimeout(() => {
    console.log('🚀로그인 시작...')
    const startTime = Date.now();
    login ('dev_kim', 'password')
        .then(token => {
            console.log('✅ 로그인 성공! token: ', token.value);
            return userInfo(token);
        })
        
        .then(user => {
            console.log('✅ 사용자: ', user.name);
            const endtime = Date.now() - startTime;
            console.log(`\n⏱️ 총 시간: ${endtime}ms \n💡 1초 + 1초 = 약 2초 (순차)`);
        })

        .catch((error) => {
            console.log('%c❌ 에러: ', + error.message, 'color:#ff6b6b');
        })
    
    
}, 1000);
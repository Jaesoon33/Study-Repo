// DOM API - 여러 요소 선택하기
/*
    NodeList (querySelectorAll)
        - forEach() 사용 가능
        - 정적 컬렉션 (DOM 변경 시 자동 갱신 안됨)
        - CSS 선택자로 세밀한 선택 가능

    HTMLCollection (getElementsByClassName)
        - forEach() 사용 불가
        - 동적 컬렉션 (DOM 변경 시 자동 갱신)
        - 단순 선택 (클래스 또는 태그)
*/

// 1. CSS 선택자로 모든 요소 선택

let $allItem = document.querySelectorAll('.item');
console.log("document.querySelectorAll('.item') => ", $allItem.length +"개 (모든 item)");

// 2. div 중에서 item 클래스만 선택 (css 연산자)
let $divItems = document.querySelectorAll('div.item');
console.log("document.querySelectorAll('div.item') => ",$divItems.length + "개 (div이면서 item인 것만!)");
console.log($divItems);

// 3. 클래스로 선택 
let $item = document.getElementsByClassName('item');
console.log("document.getElementsByClassName('item') =>", $item.length,"개 (태그 상관없이 모두)");
console.log($item);


// 4. 태그로 선택
let $spans = document.getElementsByTagName('span');
console.log($spans);

let $divs = document.getElementsByTagName('div');
console.log($divs);

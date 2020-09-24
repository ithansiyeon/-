// ex05_function.js

/*

JavaScript Function
- 함수, 메소드 

자바 메소드
public [static] int m1(int num){
    return 10;
}

자바스크립트 함수 
function m1(num) {
    return 10;
} 

*/
function f1() {
    console.log("f1");
}

f1();
f1();

function f2(){
    // console.log(name);
    console.log(arguments); // 내장 배열(유사 배열), 매개변수 리스트를 자동으로 받아줘, 실인자 값들이 전달돼
    console.log(arguments[0]);
}
// 해석 자체가 안돼 var name 을 하면 안돼 
f2("홍길동",10,true,new Date());

function f3(name){
    console.log(name);
    // 변수가 생성이 됐지만 초기화가 이루어지지 않아서 undefined로 찍힘
}

f3(); // null 이 아닌 undefined가 찍혀 

var num;
console.log(num); // 초기화가 안되어도 쓸 수 있어, undefined 변수 선언 직후의 상황

var name = null;
console.log(name); // 의도적으로 비워둔 상태 

// 지금은.. 이렇게 생각해도 된다.
console.log(null == undefined); // true 약간의 형변환이 발생 

// 나중엔.. 이렇게 생각해야 한다.
console.log(null === undefined); //false , 더 정확한 질문, 진성 비교 연산자 , 절대 형변환이 없음 

console.log(100 != "100"); // 같다 
console.log(100 !== "100"); // 다르다, 정식으로 비교 할때 

function f4(){
    return 10;
}

console.log(f4());


//함수 호이스팅, Fucntion Hoisting
//변수 호이스팅, Variable Hoisting 

f5(); // 선언하기 전에 호출이 가능 

function f5(){
    console.log("f5");
}

// f5();

console.log(m5); // 에러가 안나 undefined
var m5 = 100; 

/*
    자바: 멤버변수 vs 지역변수
        - 클래스 영역 or 메소드 영역 or 제어문 영역 
            (넓어)
    자바스크립트: 전역변수 vs 지역변수 
        1. 전역 변수, Global Variable
            - 한페이지에서 모두 사용 가능한 변수 
        2. 지역 변수, Local Variable
            - 블록(함수)내에서 선언한 변수

*/

var m1 = 100; // 전역변수

console.log(m1);

function c1(){
    console.log(m1); // 전역변수 호출 
}
c1();

function c2(){
    var m2 = 200;
    console.log(m2);
}   // 지역
c2();
// console.log(m2);
// 난생 처음 보는 얘, m2 is not defined

function c3() {
    if(true){
        var m3 = 300;
        // m3는 함수 영역 if만 아니라...(주의~!)
        console.log(m3);
    }
    console.log(m3);
}
c3();

//자바스크립트는 var 선언문 없이 변수를 선언할 수 있다.
var nick1 = "강아지";   // 전역변수
nick2 = "고양이";   // 전역변수 

function c4(){
    var gender1 = "남자";   // 지역변수
    gender2 = "여자";   // 전역변수(*****************)
    // var을 안붙인 얘들은 모두 전역변수 
}
c4();

console.log(gender2);

// 함수가 지역 
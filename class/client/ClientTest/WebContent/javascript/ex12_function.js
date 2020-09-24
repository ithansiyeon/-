/*

자바스크립트에서의 함수 
- "함수는 1급 객체다."
- first class citizen 
- first class object
- 함수는 객체처럼 취급된다.(데이터처럼 취급이 가능하다.)

1. 함수를 변수나 데이터 구조에 담을 수 있다.
2. 함수를 매개변수에 전달 할 수 있다.
3. 함수를 반환값으로 사용할 수 있다.


*/

var m1;

function f1() {
    console.log("f1");
}

m1 = f1; // 함수 자체를 넣는다. 함수 포인터, 함수가 정의된 주소값을 복사 
// m1 = f1();  

m1(); // 함수임

function f2(m) {
    m();
}

function f3() {
    console.log("f3");
}

function f4() {
    console.log("f4");
}

//매개변수를 취급 할 수 있다.
f2(f3); //m을 호출하면 f3를 호출한 것과 같아
f2(f4); 


function f5() {
    return f3;
}

/* 함수도 반환값으로 사용 가능 */ 
f5()(); // 메소드(); f3를 호출하기 위해서 소괄호를 붙임





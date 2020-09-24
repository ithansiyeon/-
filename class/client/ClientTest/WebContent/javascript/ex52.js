//ex52.js

//ES6(ECMAScript 2015) 이후에 생긴 문법들.. 

//화살표 함수 , Arrow Function 
//- 자바 람다 유사 

// () -> {}
// () => {}


//일반 함수
//함수 선언문
function foo1(){
    console.log("foo1");
}

//2. 함수 표현식 
var foo2 = function(){
    console.log("foo2");
};

foo1(); // Ctrl + F5 -> Ctrl + `
foo2();


// 화살표 함수 (= 익명 함수)
var foo3 = () => console.log("foo3");
foo3();

//매개변수가 없는 경우 
var foo = () => console.log("bar");
foo();

//매개변수가 하나인 경우 
var foo = x => console.log(x);
foo(100);

//매개변수가 여러개인 경우 
var foo = (a,b) => console.log(a+b);
foo(10,20);

//반환값이 있는 경우 
var foo = () => {return 10;};
console.log(foo());

var foo = () => 10;
var foo = (a,b) => a+b;
console.log(foo(100,200));

//------------------------------------------


//자바스크립트의 this 키워드 
console.log(this); //객체라는 표현이 뜸



//화살표 함수내에서의 this 











































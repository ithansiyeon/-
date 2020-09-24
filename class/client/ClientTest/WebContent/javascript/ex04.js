//ex04.js

/* 
Node.js(Runtime) <-> JavaScript 
(런타임, 환경)

JavaScript 자료형

1. Number
    - 숫자형
    - 정수 + 실수 

2. String
    - 문자 + 문자열 

3. Boolean 
    - 논리
    - true, false
4. Object
    - 객체형 
    - 배열, 날짜시간, 수학 등...

5. 기타 
    - null
    - undefined // 변수는 존재하나, 어떠한 값으로도 할당되지 않아 자료형이 정해지지(undefined) 않은 상태
    - NaN(난) -> Not a Number 

변수 or 상수 
- 자바스크립트는 변수의 타입이 없다.
- var : 변수 선언문(variable)
    - 동일한 변수를 여러번 선언해도 가능하다.(덮어쓰기)

- 모든 변수는 모든 자료형을 담을 수 있다.(만능 -> 자바의 Object)

*/

var num; //변수 선언 
// 타입 체크가 안되면 실행 중에 runtime 오류가 발생 

var num1 = 100; //정수형 리터럴
var name = "홍길동";    //문자 리터럴
var name1 = '홍길동';   //문자열
var flag = true;    //논리 리터럴
var today = new Date(); // 객체 
// 공간의 자료형 타입이 없을 뿐 
// 변수의 타입이 없어 

console.log(num1);
console.log(typeof num1); //number
console.log(typeof name); //string
console.log(typeof name1); // string
console.log(typeof flag);   //boolean
console.log(typeof today); //object

num1 = "하나"; //얘때문에 헷갈림 
console.log(typeof num1); //string

console.log(typeof null); //object
console.log(typeof undefined); //undefined 
console.log(typeof NaN); // number

var a, b, c;
var d = 10, e= 20;

var kor = 10;
var kor = 90;

// 선언한 식별자를 재사용
console.log(kor);

eng = 100; //절대 하지 말것!!!!!!!!!!!!!!!!! 

console.log(eng);

//문자 이스케이프 
console.log("안녕\t하세요. \"홍길동\"입니\n다.");

// 자바스크립트는 문법이 엄격하다.(대소문자)
// 자바스크립트는 자료형에 대해서는 유연(자동 형변환을 잘한다.)


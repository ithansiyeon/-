//ex07_casting.js

// 형변환
// - 대부분 상황에서는 자바스크립트가 스스로 형변환을 한다.

console.log("100" * 2);

//형변환 함수 
// "100" -> 100
// (int)num

//주체가 없어
//1. int parseInt()
//2. float parseFloat()
// 정수로 바꿔서 리턴, 실수로 바꿔서 리턴 

var n1 = 3.14;
console.log(parseInt(n1));

var n2 = "100";
console.log(parseInt(n2));
console.log(typeof n2); //string
console.log(typeof parseInt(n2));   //number

var n3 = "200점";   //200을 추출을 해 
console.log(parseInt(n3));  //200

n3 = "점수200"; // 시작부터 추출할게 없어서 안돼 
console.log(parseInt(n3)); //NaN

n3 = "100+200";
console.log(parseInt(n3)); // 100

//HTML + CSS 
var width = "200px";
console.log(parseInt(width)+200+"px"); //400
console.log(parseFloat("1.5em")*2 + "em");

//isNaN()
// - Is not a number? 숫자가 아니니???
// - 자료형(X) -> 형식(O)
var age = "20세"; // 사용자 입력값 

if(!isNaN(age)) {
     console.log(age);
} else {
    console.log("숫자만 입력하세요.")
}




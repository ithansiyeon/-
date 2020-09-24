//ex08_string.js

//문자열 함수 
var txt = "Hello~ Hong~ Hong~";

//1. 문자열 길이 
console.log(txt.length); // 프로퍼티(Property) length 속성

//2. 검색 
//  - indexOf()
//  - lastIndexOf()
console.log(txt.indexOf("~")); //5
console.log(txt.indexOf("~",6)); //11
console.log(txt.indexOf("?")); //-1
console.log(txt.lastIndexOf("~")); //11

//3. 대소문자 변환
console.log(txt.toUpperCase());
console.log(txt.toLocaleLowerCase());

//4. 치환 
// - 처음 만나는 요소만 치환(반복X)
// 정규 표현식을 사용하면 반복 가능
console.log(txt.replace("Hong","홍길동"));
console.log(txt.replace(/Hong/gi,"홍길동"));
//따옴표를 슬래시로 대체하고 뒤에 gi 를 붙이면 모든 부분을 수정해 줌

//5. 범위 추출 (Hello~ Hong~ Hong~)
console.log(txt.substring(2,8)); //llo~ H
console.log(txt.substring(2)); // 끝까지

console.log(txt.substr(2,1)); //l
console.log(txt.substr(2)); 

//6. 공백제거 
console.log("    하나    둘    ".trim()); //하나    둘

//7. 분할 
var result = "홍길동,아무게,하하하,호호호".split(",");
console.log(typeof result); // 배열은 object에 속함, 배열인지 날짜 객체인지 구분할 수 없어
console.log(result[0]);
console.log(result[3]);
// /[ '홍길동', '아무게', '하하하', '호호호' ] 

console.log(txt.charAt(1)); // 'e' 
console.log(txt.charCodeAt(1)); //101

console.log(txt.startsWith("Hello"));
console.log(txt.startsWith("홍"));

console.log(txt.endsWith("~"));

console.log(txt.bold()); //<b>Hello~ Hong~ Hong~</b> 해당 데이터에 태그를 넣어서 돌려줘 






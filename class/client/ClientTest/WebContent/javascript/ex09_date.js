//ex09_date.js

//날짜 시간 자료형 
// new Date()
// - object(자료형)

// 현재 시각
var now = new Date(); //Calendar.getInstanece()
console.log(now.toLocaleDateString); // 2020-07-01T05:16:14.238Z

//c.get(Calendar.YEAR)

console.log(now.getFullYear); //2020
console.log(now.getMonth());    //6(0부터)
console.log(now.getDate());     //1
console.log(now.getDay());      //3(일(0) ~ 토(6))
console.log(now.getHours());    //14
console.log(now.getMinutes());  //20
console.log(now.getSeconds());  //26
console.log(now.getMilliseconds()); //0.890
console.log(now.getTime()); // 1593580826890 틱값

//출력 
console.log(now);   //2020-07-01T05:23:57.839Z
console.log(now.toString());

//조각 낸것
console.log(now.toLocaleDateString()); //현재 지역 설정 (사용자의 문화권에 맞는 시간표기법으로 객체의 시간을 리턴)
console.log(now.toLocaleTimeString());
 
//특정 시각 만들기
var christmas = new Date();
christmas.setMonth(11); // c.set(Calendar.MONTH,11);
christmas.setDate(25);

// console.log(christmas); //2020-12-25T06:59:45.968Z
console.log(christmas.toString()); //Fri Dec 25 2020 15:03:14 GMT+0900 (GMT+09:00)

var birthday = new Date(1990,5,20);
var birthday2 = new Date(1990,5,20,12,20,30);

//연산
console.log(christmas-now); //15292800010

//오늘 + 100일 
//시각 + 시간
// console.log(now+1);
//c.add(Calendar.DATE,100);

var result = new Date();
result.setTime(now.getTime()+(100*24*60*60*1000));
console.log(result.toString());




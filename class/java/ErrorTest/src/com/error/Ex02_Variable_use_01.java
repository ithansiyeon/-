package com.error;


public class Ex02_Variable_use_01 {

	public static void main(String[] args) {
		
		int a;		
		a = 10; // 문장 종결자 생략
		System.out.println(a);
		
		int b = 20;
		System.out.println(b);
		
		int c, d, e; // e를 선언하지 않아서 생기는 에러입니다.
		
		c = 30;
		d = 40;
		e = 50; // e를 변수로 선언하지 않아서 e에 50를 대입해서 생기는 에러입니다. 
		
		System.out.println(c);
		System.out.println(d);
		System.out.println(e); // e를 선언하지 않아서 50을 출력할 수 없어서 생기는 에러입니다.
		
		int f = 60, g = 70, h = 80;
		int i = 90, j; //,가 아닌 ;으로 끝나야 됨 
		long k, l = 100; 
		
		int a1 = 100; // a를 중복해서 사용해서 생기는 에러입니다.
		System.out.println(a1);
		
		int m = 5;
		int total = 100;
		System.out.println(m); // m을 초기화하지 않아서 생기는 에러입니다.
		
		System.out.println(total); // total을 정의를 안했는데 출력하는 명령어를 사용해서 생기는 에러입니다.
	
		
	}
	
}











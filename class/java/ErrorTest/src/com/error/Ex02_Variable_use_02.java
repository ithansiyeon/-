package com.error;

public class Ex02_Variable_use_02 {

	public static void main(String[] args) {
		
		byte b1;
		b1 =(byte) 1000; // byte의 범위를 벗어나므로 강제적으로 변환시 명시적인 형변환을 해야 됨 
		System.out.println(b1);
		
		short s1;
		s1 = 10;
		System.out.println(s1);
		
		int n1;
		n1 = 10;
		System.out.println(n1);
		
		long l1;
		l1 = 10000000000l; // 자바는 기본형으로 int를 쓰기 때문에 int형 범위를 넘어가는 것은 접미사 l을 붙여야 됨
		System.out.println(l1);
		
		
		
		float f1;
		f1 = 3.14f; // 실수형의 기본형은 double이므로 접미사 f를 붙여야 됨
		System.out.println(f1);
		
		double d1;
		d1 = 6.28;
		System.out.println(d1);
		
		
		
		char c1;
		c1 = 'A'; // c1은 문자형 데이터이므로 큰 따옴표가 아닌 작은 따옴표로 작성을 해야 합니다.
		System.out.println(c1);
		
		c1 = '홍'; // c1은 문자라서 하나 밖에 저장을 못하는데 문자 3개를 저장을 해서 생기는 에러입니다.
		System.out.println(c1);
		
		
		String name;
		name = "홍길동"; // name은 String 이므로 작은 따옴표가 아닌 큰 따옴표로 작성을 해야 합니다.
		System.out.println(name);
				
		
	}
	
}





















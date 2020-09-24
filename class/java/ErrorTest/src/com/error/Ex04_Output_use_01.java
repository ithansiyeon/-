package com.error;

public class Ex04_Output_use_01 {
	
	public static void main(String[] args) {
		
		String name = "홍길동";
		int age = 20;
		double pi = 3.14;
		int c = 'A'; // 대문자, 소문자로 나타내기 위해서 int를 사용함 
		
		System.out.printf("제 이름은 %s입니다.\n", name); // name은 문자열이므로 %s를 사용함 
		System.out.printf("나이는 %d살입니다.\n", age); // age,pi를 2개 섰지만 오류가 생기지 않음 무시하기 때문에
		System.out.printf("소문자 '%c'의 대문자는 '%c'입니다.\n", c+32,c); //소문자, 대문자로 바꾸기 위해서 c+32,c를 함 
		System.out.printf("원주율은 %,f입니다.\n", pi); // pi는 소수이므로 %f를 사용함 
		System.out.printf("제가 제일 좋아하는 문자는 %c입니다.\n", c); // c를 문자로 출력하고 싶기 때문에 %c를 사용함 
		System.out.print("오늘 3개의 에러를 발견하고 수정했습니다.\n");
		
		
	}

}












package com.error;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_06 {

	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문자 입력 : ");
		int input = reader.read(); // Integer.parseInt()는 문자인 숫자를 int 형으로 바꿔주기 때문에 reader.read()를 
		// 통해서 아스키 코드인 숫자를 읽어와서 넣어야 되기 때문에 reader.read()를 써야 된다.
		
		System.out.printf("소문자 '%c'의 대문자는 '%c'입니다.\n",(char)input,(char)(input-32)); // c는 int형이므로 char형으로 바꿀시 형변환을 해야 됨
		
	}
	
}









package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_If_question_05 {
	public static void main(String[] args) throws Exception {
		m1();
	}

	private static void m1() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문자 : ");
		int text = reader.read();
		if(text>='a' && text <='z')
			System.out.printf("결과 : %c",text-32);
		else if(text>='A' && text <='Z')
			System.out.printf("결과 : %c",text+32);
		else System.out.println("잘못된 값을 입력했다.");
		
	}

}

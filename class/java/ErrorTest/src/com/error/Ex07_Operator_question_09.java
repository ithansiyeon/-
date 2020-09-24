package com.error;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_09 {

	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("영문자 입력 : ");
		int c = reader.read(); // 문자를 쓰기 위해서 아스키코드로 int형을 받아야 되기 때문에 reader.read()를 쓴다.
		
		System.out.printf("입력한 문자 '%c'는 %s입니다.", c, c >= 'a' && c <= 'z' ? "소문자" : c >= 'A' && c <= 'Z' ? "대문자": "?");
		// 삼항연산자 ? : 콜론을 않쓰고 나머지를 입력을 안했음, 오류는 나지 않았지만 || 이 아니라 && 임
	}
	
}









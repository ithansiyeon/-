package com.practice1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02_question_Operation_06 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문자 입력: ");
		int num = reader.read();
		System.out.printf("소문자 '%c'의 대문자는 '%c'입니다.",num,num-32);
	
	}
}

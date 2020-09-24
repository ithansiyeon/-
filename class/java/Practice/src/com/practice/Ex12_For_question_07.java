package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_07 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String text = "";
		String result = "";
		System.out.println("아래에 입력하세요.");
		boolean loop = true;
		for(;loop;) {
			text = reader.readLine();
			if(text.equals("")) loop = false;
			result+="\n"+text;
		
		}
		System.out.printf("%s",result);
		System.out.print("프로그램을 종료합니다.");
	}

}

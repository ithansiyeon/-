package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_If_question_02 {
	public static void main(String[] args) throws Exception  {
		m1();
	}

	private static void m1() throws Exception {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("국어: ");
		int kor = Integer.parseInt(reader.readLine());
		char grade =' ';
		if(kor>=90 && kor<=100) 
			grade = 'A';
		else if(kor>=80 && kor<=89)
			grade = 'B';
		else if(kor>=70 && kor<=79)
			grade = 'C';
		else if(kor>=60 && kor<=69)
			grade = 'D';
		else grade = 'F';
		System.out.printf("입력한 %d점은 성적 %c입니다.",kor,grade);
		
	}
}

package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_08 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("누적값: ");
		int sum= Integer.parseInt(reader.readLine());
		boolean loop = true;
		int result=0;
		for(int i=1;loop;i++) {
			result+=i;
			System.out.printf("%d +",i);
			if(result>sum) loop = false;
		}
			System.out.printf("\b = %d",result);
			
			
		
			
	}

}

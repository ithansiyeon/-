package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_03 {
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자 :");
		String num = reader.readLine();
		int sum=0; 
		
		System.out.print("결과 :");
		for(int i=0;i<num.length();i++) {
			//result+=num.charAt(i);
			System.out.printf("%c +",num.charAt(i));
			sum+=(int)num.charAt(i)-48;
		}
		System.out.printf("\b = %d",sum);
	}

}

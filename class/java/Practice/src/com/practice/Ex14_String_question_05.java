package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_05 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자 : ");
		String num = reader.readLine();
		String result="";
		int i=num.length();
		for(i=num.length();i>3;i-=3) {
			result=","+num.substring(i-3,i)+result;
		}
			result=num.substring(0,i)+result;
		System.out.printf("결과: %s\n",result);
	}

}

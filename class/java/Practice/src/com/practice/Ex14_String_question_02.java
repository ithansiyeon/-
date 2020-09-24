package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_02 {
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("이메일 : ");
		String email = reader.readLine();
		System.out.printf("아이디 : %s\n",email.substring(0,email.indexOf('@')));
		System.out.printf("도메인 : %s\n",email.substring(email.lastIndexOf('@')+1));
		
		
		
	}

}

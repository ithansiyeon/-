package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_questioin_01 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문장 입력 : ");
		String text = reader.readLine();
		
		for(int i=text.length()-1;i>=0;i--) {
			System.out.printf("%c",text.charAt(i));
		}
	}
}

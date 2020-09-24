package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_If_question_11 {
	public static void main(String[] args)  throws Exception {
		m1();
	}

	private static void m1() throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자 입력: ");
		String snum = reader.readLine();
		int num = 0;
		if(snum.length()<=19) {
			num = Integer.parseInt(snum);
			if(num>=Byte.MIN_VALUE && num<=Byte.MAX_VALUE)
				System.out.println("Byte");
			if(num>=Short.MIN_VALUE && num<=Short.MAX_VALUE)
				System.out.println("Short");
			if(num>=Integer.MIN_VALUE && num<=Integer.MAX_VALUE)
				System.out.println("Integer");
			if(num>=Long.MIN_VALUE && num<=Long.MAX_VALUE)
				System.out.println("Long");
		}
		else System.out.println("long형의 길이를 벗어남");

		
		
	}
}

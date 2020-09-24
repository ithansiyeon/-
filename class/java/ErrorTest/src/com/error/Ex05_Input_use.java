package com.error;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex05_Input_use {

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader 
		= new BufferedReader(new InputStreamReader(System.in)); // BufferedReader와 InputStreamReader를 import 안함
		
		System.out.print("첫번째 숫자: ");
		String num1 = reader.readLine();
		
		System.out.print("두번째 숫자: ");
		String num2 = reader.readLine();
		
		int realNum1 = Integer.parseInt(num1); // num1은 문자열이므로 정수형 포장클래스를 사용해함 
		int realNum2 = Integer.parseInt(num2); // num2은 문자열이므로 정수형 포장클래스를 사용해함 
		
		System.out.printf("%,d + %,d = %,d\n"
								, realNum1
								, realNum2
								, realNum1 + realNum2);
				
		
		
	}
	
}














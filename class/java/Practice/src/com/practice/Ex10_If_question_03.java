package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_If_question_03 {
	public static void main(String[] args) throws Exception {
	m1();
	}

	private static void m1() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫번째 숫자: ");
		int n1 = Integer.parseInt(reader.readLine());
		System.out.print("두번째 숫자: ");
		int n2 = Integer.parseInt(reader.readLine());
		System.out.print("연산자: ");
		char operator =(char) reader.read();
		int result =0;
		double result1=0; 
		if(operator == '+') 
			System.out.printf("%d + %d =%d",n1,n2,n1+n2);
		else if(operator == '-')
			System.out.printf("%d - %d =%d",n1,n2,n1-n2);
		else if(operator == '*')
			System.out.printf("%d * %d =%d",n1,n2,n1*n2);
		else if(operator == '/')
			System.out.printf("%d / %d =%.1f",n1,n2,(double)n1/n2);
		else 
			System.out.printf("%d %% %d =%d",n1,n2,n1%n2);
		
	
	}
	
}

package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_04 {
	public static void main(String[] args)throws Exception  {
		m1();
	}

	private static void m1() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int even=0,odd=0;
		for(int i=1;i<=10;i++) {
			System.out.print("숫자: ");
			int num = Integer.parseInt(reader.readLine());
			if(num%2==0) even+=num;
			else odd+=num;
		}
		System.out.printf("짝수의 합: %d\n",even);
		System.out.printf("홀수의 합: %d\n",odd);
		
	}
}

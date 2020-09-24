package com.practice;

import java.io.BufferedReader;

import java.io.InputStreamReader;

public class Ex12_For_question_05  {
	public static void main(String[] args) throws Exception  {
		m1();
	}

	private static void m1() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int sum=0;
		for(int i=1;i<=10;i++) {
			sum+=i;
			System.out.printf("%d + ",i);
		}
		System.out.printf("\b\b = %d",sum);
	}

}

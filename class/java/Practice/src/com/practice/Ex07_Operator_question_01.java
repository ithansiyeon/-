package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_01 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("태어난 년도 : ");
		int year = Integer.parseInt(reader.readLine());
		System.out.printf("나이 : %d세",2020-year+1);
	}

	
}

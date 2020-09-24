package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_05 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("한달 수입 금액(원) : ");
		int salary = Integer.parseInt(reader.readLine());
		double profit = 0.033;
		System.out.printf("한달 수입 금액(원) : %,d원\n",salary);
		System.out.printf("세후 금액(원) : %,.0f원\n",salary*(1-profit));
		System.out.printf("세금(원) : %,.0f원\n",salary*profit);
		
	}
}

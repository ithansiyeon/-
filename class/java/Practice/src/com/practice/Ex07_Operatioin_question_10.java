package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operatioin_question_10 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("섭씨(℃) : ");
		double degrees = Double.parseDouble(reader.readLine());
		System.out.printf("섭씨 %.1f℃는 화씨 %.1f℉입니다.",degrees,degrees*1.8 + 32);
		
	}

}

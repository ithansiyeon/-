package com.practice1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex02_Operator_question_03  {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("너비(cm): ");
		double width = Double.parseDouble(reader.readLine());
		System.out.print("높이(cm): ");
		double height = Double.parseDouble(reader.readLine());
		
		System.out.printf("사각형의 넓이는 %.1f㎠입니다.\n",width*height);
		System.out.printf("사각형의 둘레는 %.1f㎝입니다.",(width+height)*2);
	}
}

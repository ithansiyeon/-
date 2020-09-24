package com.practice1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02_Operation_question_07 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫번째 숫자 : ");
		int n1 = Integer.parseInt(reader.readLine());
		System.out.print("두번째 숫자 : ");
		int n2 = Integer.parseInt(reader.readLine());
		System.out.print("세번째 숫자 : ");
		int n3 = Integer.parseInt(reader.readLine());
		System.out.printf("%d와(과) %d, %d 중에 더 큰 숫자는 %d입니다.",n1,n2,n3,n1>n2?(n1>n3?n1:n3):(n2>n3?n2:n3));
	}
}

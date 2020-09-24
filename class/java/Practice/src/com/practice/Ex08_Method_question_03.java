package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_question_03 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫번째 숫자: ");
		int num1 = Integer.parseInt(reader.readLine());
		System.out.print("두번째 숫자: ");
		int num2 = Integer.parseInt(reader.readLine());
		add(num1,num2);
		add(num1,num2);
		substract(num1,num2);
		multiply(num1,num2);
		multiply(num1,num1);
		divide(num1,num2);
		mod(num1,num2);
	}
	
	public static void add(int num1,int num2) {
		System.out.printf("%d + %d = %d\n",num1,num2,num1+num2);
		
	}
	
	public static void substract(int num1,int num2) {
		System.out.printf("%d - %d = %d\n",num1,num2,num1-num2);
	}
	
	public static void multiply(int num1,int num2) {
		System.out.printf("%d * %d = %d\n",num1,num2,num1*num2);
	}
	
	public static void divide(int num1,int num2) {
		System.out.printf("%d / %d =%.1f\n",num1,num2,num1/(double)num2);
	}
	
	public static void mod(int num1,int num2) {
		System.out.printf("%d %% %d =%d\n",num1,num2,num1 % num2);
	}
}

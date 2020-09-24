package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_question_05 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫번째 숫자: ");
		int n1 = Integer.parseInt(reader.readLine());
		System.out.print("두번째 숫자: ");
		int n2 = Integer.parseInt(reader.readLine());
		int result = add(n1,n2);
		System.out.printf("%d + %d = %d\n",n1,n2,result);
		result = add(n1,n1);
		System.out.printf("%d + %d = %d\n",n1,n1,result);
		result = substract(n1,n2);
		System.out.printf("%d + %d = %d\n",n1,n2,result);
		result = multiply(n1,n2);
		System.out.printf("%d * %d =%d\n",n1,n2,result);
		result = multiply(n1,n1);
		System.out.printf("%d * %d =%d\n",n1,n1,result);
		double result1 = divide(n1,n2);
		System.out.printf("%d * %d =%.1f\n",n1,n2,result1);
		result = mod(n1,n2);
		System.out.printf("%d %% %d = %d\n",n1,n2,result);
		
		
		
		
	}
	public static int add(int n1,int n2) {
		return n1+n2;
	}
	public static int substract(int n1,int n2) {
		return n1-n2;
	}
	public static int multiply(int n1,int n2) {
		return n1*n2;
	}
	public static double divide(int n1,int n2) {
		return (double)n1/n2;
	}
	public static int mod(int n1,int n2) {
		return n1%n2;
	}
}

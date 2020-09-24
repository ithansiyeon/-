package com.error;

public class Ex06_Casting_use {
	
	public static void main(String[] args) {
		
		byte a = 10;
		byte b = 20;
		int c = 0;
		
		c = a + b; // 산술연산은 int형으로 계산을 하므로 c를 int로 선언해야 됨
		 
		System.out.printf("%d + %d = %d\n", a, b, c);
		
		
		int n1 = 1234567;
		int n2 = 654321;
		
		System.out.printf("%,d * %,d = %,d\n", n1, n2, n1 * n2);
		
		
	}

}













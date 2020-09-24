package com.practice;

public class Ex09_Method_question_10 {
	public static void main(String[] args)  {
		sum(10);
		sum(10,20);
		sum(10,20,30);
		sum(10,20,30,40);
		
	}
	public static void sum(int n1) {
		System.out.printf("%d = %d\n",n1,n1);
	}
	
	public static void sum(int n1,int n2) {
		System.out.printf("%d + %d = %d\n",n1,n2,n1+n2);
	}
	
	public static void sum(int n1,int n2,int n3) {
		System.out.printf("%d + %d + %d = %d\n",n1,n2,n3,n1+n2+n3);
	}
	
	public static void sum(int n1,int n2,int n3,int n4) {
		System.out.printf("%d + %d + %d + %d = %d\n",n1,n2,n3,n4,n1+n2+n3+n4);
	}

	
}

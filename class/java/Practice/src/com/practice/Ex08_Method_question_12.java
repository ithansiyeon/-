package com.practice;

public class Ex08_Method_question_12 {
public static void main(String[] args) {
	System.out.printf("양수 %d개\n",positive(5));
	System.out.printf("양수 %d개\n",positive(5,-1));
	System.out.printf("양수 %d개\n",positive(5,-1,4));
	System.out.printf("양수 %d개\n",positive(5,1,4));
	System.out.printf("양수 %d개\n",positive(5,1,4,5));
	
}

public static int positive(int a) {
	return a>0?1:0;
}

public static int positive(int a,int b) {
	int result  = a > 0  ? 1:0;
	int result1 = b >0 ? 1:0;
	return result+result1;
}

public static int positive(int a, int b, int c) {
	int result  = a > 0  ? 1:0;
	int result1 = b >0 ? 1:0;
	int result2 = c>0 ? 1:0;
	return result+result1+result2;
	
}

public static int positive(int a,int b, int c,int d) {
	int result  = a > 0  ? 1:0;
	int result1 = b >0 ? 1:0;
	int result2 = c>0 ? 1:0;
	int result3 = d>0 ? 1:0;
	return result+result1+result2+result3;
}

public static int positive(int a,int b, int c,int d, int e) {
	int result  = a > 0  ? 1:0;
	int result1 = b >0 ? 1:0;
	int result2 = c>0 ? 1:0;
	int result3 = d>0 ? 1:0;
	int result4 = e>0 ? 1:0;
	return result+result1+result2+result3+result4;
}
}

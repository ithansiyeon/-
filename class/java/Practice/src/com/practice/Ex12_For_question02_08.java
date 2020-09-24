package com.practice;

public class Ex12_For_question02_08 {
	public static void main(String[] args) {
		for(int i=2;i<=3;i++) {
			for(int j=1;j<=9;j++) {
				for(int k=i;k<=(i+3);k++)
					System.out.printf("%d x %d = %d\n",k,j,k*j);
			}
		}
		System.out.println();
	}
}

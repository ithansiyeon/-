package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question02_06 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행의 갯수");
		int row = Integer.parseInt(reader.readLine());
		for(int i=1;i<=row;i++) {
			for(int j=1;j<=i;j++)
				System.out.print(" ");
			System.out.println("*");
		}
	}

}

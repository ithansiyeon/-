package com.practice1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02_Operation_quetion_05 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("한달 수입 금액(원) : ");
		int salary = Integer.parseInt(reader.readLine());
		System.out.printf("세후 금액(원) : %,.1f원\n",salary*(1-0.033));
		System.out.printf("세금(원) : %,.1f원",salary*0.033);
		
	}
}

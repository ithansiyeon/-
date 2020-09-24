package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_question_04 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("이름 : ");
		String name = reader.readLine();
		String customer = getName(name);
		System.out.printf("고객 : %s",customer);
	}
	public static String getName(String name) {
		return name + "님";
		
	}
}

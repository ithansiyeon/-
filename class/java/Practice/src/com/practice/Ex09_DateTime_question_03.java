package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Ex09_DateTime_question_03 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Calendar birth = Calendar.getInstance();
		System.out.print("태어난 년도 : ");
		int year = Integer.parseInt(reader.readLine());
		birth.set(Calendar.YEAR, year);
		Calendar now = Calendar.getInstance();
		System.out.printf("나이: %d세",now.get(Calendar.YEAR)-birth.get(Calendar.YEAR)+1);
	}
}

package com.practice;

import java.util.Calendar;

public class Ex09_DateTime_question_02 {
	public static void main(String[] args) {
		Calendar birth = Calendar.getInstance();
		birth.add(Calendar.DATE, 100);
		System.out.printf("백일 : %tF\n",birth);
		birth.add(Calendar.DATE, 265);
		System.out.printf("첫돌 : %tF",birth);
	}
}

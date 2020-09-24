package com.practice;


import java.util.Scanner;

public class Ex14_String_question_11 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("금액(원) : ");
		String money = scan.nextLine();
		String[] result = new String[money.length()];
		for (int i = 0; i < money.length(); i++) {
			result[i]= new String();
			switch (money.charAt(i)) {
			case '1':
				result[i] = "일";
				break;
			case '2':
				result[i] = "이";
				break;
			case '3':
				result[i] = "삼";
				break;
			case '4':
				result[i] = "사";
				break;
			case '5':
				result[i] = "오";
				break;
			case '6':
				result[i] = "육";
			case '7':
				result[i] = "칠";
			case '8':
				result[i] = "팔";
			case '9':
				result[i] = "구";
			case '0':
				result[i] = "영";
				break;
			}
		}
		
		for(int i=0;i<result.length;i++) {
			System.out.printf("%s",result[i]);
		}

	}

}

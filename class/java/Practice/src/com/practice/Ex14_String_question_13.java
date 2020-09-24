package com.practice;

import java.util.Scanner;

public class Ex14_String_question_13 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("연산식 : ");
		String txt = scan.nextLine();
		txt = txt.replace(" ", "");
		boolean loop = true;
		while (loop) {
			if (txt.length() >= 2) {
				char c = txt.charAt(1);
				switch (c) {
				case '+':
					if (txt.length() != 3) {
						System.out.println("피연산자가 부족합니다.");
					} else {
						int a = (int) txt.charAt(0) - 48;
						int b = (int) txt.charAt(2) - 48;
						System.out.printf("%d %c %d = %d", a, c, b, a + b);
					}
					loop = false;
					break;
				case '-':
					if (txt.length() != 3) {
						System.out.println("피연산자가 부족합니다.");
					} else {
						int a = (int) txt.charAt(0) - 48;
						int b = (int) txt.charAt(2) - 48;
						System.out.printf("%d %c %d = %d", a, c, b, a - b);
					}
					loop = false;
					break;

				case '*':
					if (txt.length() != 3) {
						System.out.println("피연산자가 부족합니다.");
					} else {
						int a = (int) txt.charAt(0) - 48;
						int b = (int) txt.charAt(2) - 48;
						System.out.printf("%d %c %d = %d", a, c, b, a * b);
					}
					loop = false;
					break;

				case '/':
					if (txt.length() != 3) {
						System.out.println("피연산자가 부족합니다.");
					} else {
						int a = (int) txt.charAt(0) - 48;
						int b = (int) txt.charAt(2) - 48;
						System.out.printf("%d %c %d = %.1f", a, c, b, (double) a / b);
					}
					loop = false;
					break;

				case '%':
					if (txt.length() != 3) {
						System.out.println("피연산자가 부족합니다.");
					} else {
						int a = (int) txt.charAt(0) - 48;
						int b = (int) txt.charAt(2) - 48;
						System.out.printf("%d %c %d = %d", a, c, b, a % b);
					}
					loop = false;
					break;
				default:
					System.out.println("연산자가 올바르지 않습니다.");
					loop = false;
				}
			} else {
				System.out.println("연산자와 피연산자가 부족합니다.");
				loop = false;
			}

		}

	}

}

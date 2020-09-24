package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_12 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String result = "";
		boolean loop = false;
		for (int i = 1; i <= 10; i++) {
			System.out.print("숫자: ");
			int num = Integer.parseInt(reader.readLine());
			if (num >= 0 && num <= 9) {
				switch (num) {
				case 0:
					result += "영";
					break;
				case 1:
					result += "일";
					break;
				case 2:
					result += "이";
					break;
				case 3:
					result += "삼";
					break;
				case 4:
					result += "사";
					break;
				case 5:
					result += "오";
					break;
				case 6:
					result += "육";
					break;
				case 7:
					result += "칠";
					break;
				case 8:
					result += "팔";
					break;
				case 9:
					result += "구";
					break;
				default:
					return;
				}
			}

			else {
				loop = true;
				break;
			}
		}

		if (loop) {
			System.out.println("2자리 이상 숫자여서 프로그램이 종료되었습니다.");
		} else {
			System.out.printf("결과: %s", result);
		}

	}

}

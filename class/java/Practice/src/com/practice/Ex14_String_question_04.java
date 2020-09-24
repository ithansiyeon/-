package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_04 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0;
		for (int i = 0; i < 10; i++) {
			System.out.print("파일명 :");
			String name = reader.readLine();
			switch (name.substring(name.lastIndexOf('.') + 1)) {
			case "gif":
				count1 += 1;
				break;
			case "jpg":
				count2 += 1;
				break;
			case "png":
				count3 += 1;
				break;
			case "hwp":
				count4 += 1;
				break;
			case "doc":
				count5 += 1;
				break;
			default:
				System.out.println("확장자를 잘못입력했습니다.");
			}
		}

		System.out.printf("gif : %d개\n", count1);
		System.out.printf("jpg : %d개\n", count2);
		System.out.printf("png : %d개\n", count3);
		System.out.printf("hwp : %d개\n", count4);
		System.out.printf("doc : %d개\n", count5);

	}

}

package com.practice;

import java.io.BufferedReader;

import java.io.InputStreamReader;

public class Ex14_String_question_09 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("주민등록번호 : ");
		String jumin = reader.readLine();
		jumin = jumin.replace("-", "");
		int k = 2, sum = 0, i = 0;
		boolean loop = true;
		while (loop) {
			sum += (jumin.charAt(i)-48) * k;
			//System.out.printf("%d %d = %d\n",i,k,sum);
			i++;
			k++;
			if (k == 10)
				k = 2;
			if (i == 12) {
				int c=sum%11;
				int val = jumin.charAt(12)-48;
				//System.out.println(c);
				switch (c) {
					case 0:
						if (1==val) {
							System.out.println("올바른 주민등록번호입니다.");
							loop = false;
						} else {
							System.out.println("올바르지 않는 주민등록번호입니다.");
							loop = false;
						}
						break;
					case 1:
						if (0==val) {
							System.out.println("올바른 주민등록번호입니다.");
							loop = false;
						} else {
							System.out.println("올바르지 않는 주민등록번호입니다.");
							loop = false;
						}
						break;
					case 10:
					case 11:
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
					case 9:
						if (val == 11-c) {
							System.out.println("올바른 주민등록번호입니다.");
							loop = false;
						} else {
							System.out.println("올바르지 않는 주민등록번호입니다.");
							loop = false;
						}
						break;

				}

			}

		}

	}
}

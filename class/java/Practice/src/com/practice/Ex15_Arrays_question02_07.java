package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_Arrays_question02_07 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("국어 점수 : ");
		int kor = Integer.parseInt(reader.readLine());
		System.out.print("영어 점수 : ");
		int eng = Integer.parseInt(reader.readLine());
		System.out.print("수학 점수 : ");
		int math = Integer.parseInt(reader.readLine());

		String[][] score = new String[10][3];

		for (int i = 0; i < score[0].length; i++) {
			for (int j = 0; j < score.length; j++) {
				score[j][i] = "";
			}
		}
		for (int i = 0; i < score[0].length; i++) {
			if (i == 0) {
				int grade = kor / 10 - 1;
				for (int j = grade ; j >= 0; j--) {
					score[j][i] = "■";
				}
			} else if (i == 1) {
				int grade = eng / 10 - 1;
				for (int j = grade ; j >= 0; j--) {
					score[j][i] = "■";
				}
			} else {
				int grade = math / 10 - 1;
				for (int j = grade ; j >= 0; j--) {
					score[j][i] = "■";
				}
			}
		}

		print(score);

	}

	private static void print(String[][] score) {
		for (int i = score.length-1; i >= 0; i--) {
			for (int j = 0; j < score[i].length; j++) {
				System.out.printf(" %s ", score[i][j]);
				//System.out.printf("%d %d\n",i,j);
			}
			System.out.println();
		}
	}

}

package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_Arrays_question02_08 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행 : ");
		int row = Integer.parseInt(reader.readLine());
		System.out.print("열 : ");
		int col = Integer.parseInt(reader.readLine());
		int[][] list = new int[row][col];
		int cnt = 1;
		int count = list.length * 2;

		if (row > col) {
			for (int l = 0; l < count - 1; l++) {
				for (int k = 0; k < list.length; k++) {
					if ((l - k) >= 0 && (l - k) < list[0].length) {
						list[k][l - k] = cnt;
						cnt++;
					}

				}
			}
		} else {

			for (int l = 0; l <= count+2; l++) {
				for (int k = 0; k < list.length; k++) {
					if ((l - k) >= 0 && (l - k) < list[0].length) {
						list[k][l - k] = cnt;
						cnt++;
					}

				}
			}
		}

		print(list);
	}

	private static void print(int[][] list) {
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				System.out.printf("%3d ", list[i][j]);
			}
			System.out.println();
		}
	}

}

package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_Arrays_question02_03 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행 : ");
		int row = Integer.parseInt(reader.readLine());
		System.out.print("열 : ");
		int col = Integer.parseInt(reader.readLine());
		int[][] list = new int[row][col];
		int cnt = 1;

		for (int i = 0; i < list[0].length; i++) {
			for (int j = 0; j < list.length; j++) {
				list[j][i] = cnt;
				cnt++;

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
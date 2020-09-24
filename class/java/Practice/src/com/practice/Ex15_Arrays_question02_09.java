package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_Arrays_question02_09 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행 : ");
		int row = Integer.parseInt(reader.readLine());
		System.out.print("열 : ");
		int col = Integer.parseInt(reader.readLine());
		int[][] list = new int[row][col];
		int cnt = 1;
		
		int sero = 0;
		int garo = -1;
		
		int direction = 1;
		int size = list[0].length;
		int size1 = list.length;
		
		while(0<=size1) { //size1,size 둘다 상관없음
			for(int i=0;i<size;i++) {
			garo+=direction;
			list[sero][garo]=cnt;
			cnt++;
			}
			size--;
			size1--;
			for(int i=0;i<size1;i++) {
				sero+=direction;
				list[sero][garo]=cnt;
				cnt++;
			}
			direction*=(-1);
		}
		
		print(list);
	}

	private static void print(int[][] list) {
		for(int i=0;i<list.length;i++) {
			for(int j=0;j<list[i].length;j++) {
				System.out.printf("%3d ",list[i][j]);
			}
			System.out.println();
		}
	}

}

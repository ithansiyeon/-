package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_Arrays_question02_05 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행 : ");
		int row = Integer.parseInt(reader.readLine());
		System.out.print("열 : ");
		int col = Integer.parseInt(reader.readLine());
		int[][] list = new int[row][col];
		int cnt = 1;
		int k=list.length/2;
		int l=list.length/2;
		for(int i=0;i<list.length/2+1;i++) {
			for(int j=k;j<=l;j++) {
				list[i][j]=cnt;
				cnt++;
			}
			k--;
			l++;
		}
		k+=2;
		l-=2;
		for(int i=list.length/2+1;i<list.length;i++) {
			for(int j=k;j<=l;j++) {
				list[i][j]=cnt;
				cnt++;
			}
			k++;
			l--;
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

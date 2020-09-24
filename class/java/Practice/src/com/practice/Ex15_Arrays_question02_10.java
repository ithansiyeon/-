package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_Arrays_question02_10 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행 : ");
		int row = Integer.parseInt(reader.readLine());
		System.out.print("열 : ");
		int col = Integer.parseInt(reader.readLine());
		int[][] list = new int[row][col];
		int cnt = 1;
		boolean loop = true;
		int i=row/2,j=col-1;
		list[i][j]=1;
		int k=0,p=0;
		while(loop) {
			k=i;
			p=j;
			
			i--;
			j++;
			cnt++;
			if(j==list.length) {
				j=0;
			}
			if(i==-1) {
				i=list.length-1;
			}
			
			if(list[i][j]!=0) {
				p--;
				list[k][p]=cnt;
				i=k;
				j=p;
			}
			else {
				list[i][j]=cnt;
			}
			
			if(cnt==list.length*list.length) {
				loop = false;
			}
			
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

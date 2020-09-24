package com.practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex15_Arrays_question_07 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random rnd = new Random();
		System.out.print("최소 범위 : ");
		int range1 = scan.nextInt();
		scan.nextLine();
		System.out.print("최대 범위 : ");
		int range2 = scan.nextInt();
		scan.nextLine();
		System.out.print("배열 크기 : ");
		int size = scan.nextInt();
		scan.nextLine();

		int[] list = new int[size];
		int count=0;
		int i=0;
		boolean loop = true;
		while(loop) {
			int k = rnd.nextInt(range2 - range1) + range1;
			for (int j = 0; j < i; j++) {
				if (list[j] == k) {
					count+=1;
				}

			}
			if(count==0) {
				list[i]=k;
				i++;
			}
			count=0;
			if(i==list.length) loop=false;
		}

		System.out.println(Arrays.toString(list));
	
	
	}

}

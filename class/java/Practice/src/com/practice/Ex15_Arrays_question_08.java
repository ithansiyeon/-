package com.practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex15_Arrays_question_08 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rnd = new Random();
		System.out.print("삽입 위치 : ");
		int insert = scan.nextInt();
		scan.nextLine();
		System.out.print("값 : ");
		int value = scan.nextInt();
		scan.nextLine();
		int[] list = new int[10];
		
		for(int i=0;i<list.length;i++) {
			list[i]=rnd.nextInt(10);
		}
		System.out.print("원본 : ");
		System.out.println(Arrays.toString(list));
		for(int i=list.length-1;i>insert;i--) {
			list[i]=list[i-1];
		}
		list[insert]=value;
		System.out.print("결과 : ");
		System.out.println(Arrays.toString(list));
		
	}

}

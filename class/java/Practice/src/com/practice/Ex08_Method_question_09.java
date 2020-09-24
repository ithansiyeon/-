package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_question_09 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("맑은 날: ");
		int niceday = Integer.parseInt(reader.readLine());
		System.out.print("흐린 날: ");
		int Cloudyday = Integer.parseInt(reader.readLine());
		System.out.printf("사과가 총 %d개 열렸습니다.",getApple(niceday,Cloudyday));
	
	}
	
	public static int getApple(int good,int bad) {
		return (good*5+bad*2-100)/10;
	}
}


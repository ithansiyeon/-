package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question02_04 {
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행의 갯수: ");
		int row = Integer.parseInt(reader.readLine());
		String text ="";
			for(int i=1;i<=row;i++) {
				text = "";
				for(int j=1;j<=i;j++) {
					text+="*";
				}
				System.out.printf("%10s\n",text);
			}
		}

	}
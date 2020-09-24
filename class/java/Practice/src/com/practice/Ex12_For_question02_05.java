package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question02_05 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행의 갯수: ");
		int row = Integer.parseInt(reader.readLine());
		int k=1;
		String result = "";
		for(int i=1;i<=row;i++) {
			result="";
			for(int j=1;j<=k;j++) 
				result+="*";
				for(int l=row;l>=i;l--)
					System.out.print(" ");
					
		System.out.printf("%s\n",result);
		k+=2;
		}
		
			
	}

}

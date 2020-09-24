package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_07 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("단어 : ");
		String txt = reader.readLine();
		String result = "";
		int k=0;
		int i=1;
	
		for(i=1;i<txt.length();i++) {
			if(txt.charAt(i)>='A' && txt.charAt(i)<='Z') {
				result+=txt.substring(k,i)+" ";
				k=i;
				//System.out.println(k);
				}
		}
		//System.out.println(i);
		result+=txt.substring(k,txt.length());
		
		System.out.printf("결과 : %s",result);
		
	}

}

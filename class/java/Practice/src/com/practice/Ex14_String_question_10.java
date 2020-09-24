package com.practice;

import java.util.Scanner;

public class Ex14_String_question_10 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("문자열 : ");
		String txt = scan.nextLine();
		
		String ban1="바보";
		String ban2="멍청이";
		
		int index1=-1,index2=-1;
		index1=-ban1.length();
		index2=-ban2.length();
		int count=0;
		boolean loop = true;
		while(loop) {
			index1=txt.indexOf(ban1,index1+ban1.length());
			index2= txt.indexOf(ban2,index2+ban2.length());
			if(index1>-1 && index2>-1) {
				count+=2;
				txt.replace(ban1,"**");
				txt.replace(ban2, "***");
				
			}
			else if(index1>-1 || index2>-1) {
				count+=1;
				txt=txt.replace(ban1,"**");
				txt=txt.replace(ban2, "***");
			}
			
			else {
				loop=false;
			}
		
		}

		System.out.printf("%s\n금지어를 %d회 마스킹했습니다.\n",txt,count);
		
	}

}

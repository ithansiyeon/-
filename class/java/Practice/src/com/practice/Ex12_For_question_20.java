package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_20 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자: ");
		int n1 = Integer.parseInt(reader.readLine());
		System.out.print("두번째 숫자: ");
		int n2 = Integer.parseInt(reader.readLine());
		System.out.println();
		String result="";
	
		int i=1;
		//n1의 약수
			for(i=1;i<=n1;i++) 
				if(n1%i==0) {
					result+=i+", ";
				}
				System.out.printf("%d의 약수 : %s\b\n",n1,result);
				result="";
		//n2의 약수
			for(i=1;i<=n2;i++) 
				if(n2%i==0) {
					result+=i+", ";
				}
				System.out.printf("%d의 약수 : %s\b\n",n2,result);
				result="";
		//n1,n2의 공약수	
				if(n1>n2) {
					for(i=1;i<=n2;i++) 
						if(n1%i==0 && n2%i==0) {
							result+=i+", ";
						}
						System.out.printf("%d와 %d의 공약수 : %s\b\n",n1,n2,result);
					
				}
				else {
					for(i=1;i<=n1;i++) 
						if(n1%i==0 && n2%i==0) {
							result+=i+", ";
						}
						System.out.printf("%d와 %d의 공약수 : %s\b\n",n1,n2,result);
					
				}
		
		
		
	}

}

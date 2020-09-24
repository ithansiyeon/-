package com.practice;

public class Ex12_For_question_18 {
	public static void main(String[] args) {
		for(int i=2;i<100;i++) {
			for(int j=2;j<=i;j++) {
				if(i!=j && i%j==0) break;
		if(i==j) System.out.printf("%d, ",i); //끝까지 가는 경우는 i==j가 같은 경우에만 자연적으로 빠져간거라서 
					
			}
			
		}
		
	
		
		
		
		
		

		
		
	}	
}

package com.example;

import java.util.Scanner;

public class Student_Output {

	public void begin() {
		
		System.out.println();
		System.out.println("■■■■■ 프로그램을 시작합니다. ■■■■■");
		System.out.println();	
			
	}
	
	public void menu() {
		
		System.out.println("□□□□□□□□□□□□□□□");
		System.out.println("수강생 정보 관리");
		System.out.println("1. 수강생 등록");
		System.out.println("2. 수강생 목록");
		System.out.println("3. 수강생 삭제");
		System.out.println("4. 수강생 검색");
		System.out.println("5. 수강생 수정");
		System.out.println("6. 종료");
		System.out.println("□□□□□□□□□□□□□□□"); 
		System.out.print("선택(번호) : ");
		
	}
	
	public void end() {
		
		System.out.println();
		System.out.println("■■■■■ 프로그램을 종료합니다. ■■■■■");
		System.out.println();	
			
	}

	public void title(Student_Title type) {
		
		String title = "";
		
		if (type == Student_Title.ADD) {
			title = "수강생 추가하기";			
		} else if (type == Student_Title.LIST) {			
			title = "수강생 목록보기";			
		} else if (type == Student_Title.DELETE) {			
			title = "수강생 삭제하기";			
		} else if (type == Student_Title.SEARCH) {
			title = "수강생 검색하기";
		} else if (type == Student_Title.CORRECT) {
			title = "수강생 수정하기";
		}
		
		System.out.println();
		System.out.println("▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
		System.out.println(title);
		System.out.println("▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
		System.out.println();
		
	}

	public void pause(Scanner scan) {
		
		System.out.println();
		System.out.println("완료되었습니다.");
		System.out.println("계속하려면 엔터를 입력하세요.");
		
		scan.nextLine();
		
	}

}

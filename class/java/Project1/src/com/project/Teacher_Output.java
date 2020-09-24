package com.project;

import java.util.Scanner;

public class Teacher_Output {

	public void menu() {
		
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("        강사 정보 관리");
		System.out.println("1. 강사 추가");
		System.out.println("2. 강사 목록");
		System.out.println("3. 강사 삭제");
		System.out.println("4. 강사 수정");
		System.out.println("5. 강사 검색(이름)");
		System.out.println("6. 강사 검색(교과목)");
		System.out.println("7. 강사 검색(연락처)");
		System.out.println("8. 이전 화면");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.print("선택(번호): ");
		
		
	}

	public void title(Teacher_Title type) {
		String title = "";
		if(type == Teacher_Title.ADD) {
			title = "강사 추가하기";
		} else if(type == Teacher_Title.LIST) {
			title="강사 목록보기";
		} else if(type == Teacher_Title.DELETE) {
			title="강사 삭제하기";
		} else if(type == Teacher_Title.SEARCH) {
			title="강사 검색하기";
		} else if(type == Teacher_Title.CORRECT)	{
			title="강사 수정하기";
		} 
		
		System.out.println();
		System.out.println("▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨");
		System.out.println(title);
		System.out.println("▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨");
		System.out.println();
	}

	public void pause(Scanner scan) {
		
		System.out.println();
		System.out.println("완료되었습니다.");
		System.out.println("계속하려면 엔터를 입력하세요.");
		
		//Scanner scan = new Scanner(System.in);
		
		scan.nextLine();
		
	}
}

package com.project;

import java.util.Scanner;

public class Member_Consultation_Output {
public void menu() {
		
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("         수강생 상담 문의");
		System.out.println("1. 상담 문의 등록");
		System.out.println("2. 상담 답변 확인");
		System.out.println("3. 상담 목록 검색(수강생 이름)");
		System.out.println("4. 이전 페이지");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.print("선택(번호): ");
		
		
	}

	public void title(Member_Consultation_Title type) {
		String title = "";
		if(type == Member_Consultation_Title.REGISTRATION) {
			title = "상담 문의 등록하기";
		} else if(type == Member_Consultation_Title.LIST) {
			title="상담 답변 확인하기";
		} else if(type == Member_Consultation_Title.SEARCH) {
			title="상담 목록 검색(이름)하기";
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

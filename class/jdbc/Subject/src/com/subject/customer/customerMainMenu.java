package com.subject.customer;

import java.util.Scanner;

public class customerMainMenu {
	static Scanner scan;
	static {
		scan = new Scanner(System.in);
	}
	public static void main(String[] args) {
		customerMainMenu m = new customerMainMenu();
		m.mainMenu();
	}

	public void mainMenu() {
		 while(true) {
			 System.out.println("\t\t\t====================");
			 System.out.println("\t\t\t        MENU");
			 System.out.println("\t\t\t====================");
			 System.out.println("\t\t\t1. 노선도");
			 System.out.println("\t\t\t2. 검색내역 조회");
			 System.out.println("\t\t\t3. 즐겨찾기");
			 System.out.println("\t\t\t4. 불편사항 접수");
			 System.out.println("\t\t\t5. 경로 검색");
			 System.out.println("\t\t\tb. 뒤로 가기");
			 System.out.println("\t\t\t====================");
			 System.out.print("\t\t\t▶입력 :");
			 String sel = scan.nextLine();
			 if(sel.equals("1")) {
				 
			 } else if(sel.equals("2")) {
				 
			 } else if(sel.equals("3")) {
				 
			 } else if(sel.equals("4")) {
				 
			 } else if(sel.equals("5")) {
				 
			 } else if(sel.equals("b")) {
				 break;
			 } 
		 }
	}
}

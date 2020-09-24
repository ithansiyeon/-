package com.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Login_Data {
public static void main(String[] args) throws IOException {
		
		login_student();
		
	}

	private static void login_student() throws IOException {
		
		Scanner scan = new Scanner(System.in);
		
		
		
		Main m1 = new Main();
		File file = new File("C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\student\\수강생.txt");
		BufferedWriter stream = new BufferedWriter(new FileWriter(file,true));
		Scanner in = new Scanner(file);
		
		String text = null;
		
		System.out.println("/t/t수강생 로그인/t/t");
		System.out.println("1. 로그인 ");
		System.out.println("2. 회원가입");
		System.out.println("숫자를 입력하세요..");
		String get = scan.nextLine();
		
		if(get.equals("1")) {
			System.out.print("ID 입력: ");
			String id = scan.nextLine();
			System.out.println("PassWord 입력 : ");
			String passWord = scan.nextLine();
			
			System.out.println();
			
			while(in.hasNextLine())
			{
				text = in.nextLine();
				if(text.contains(id)&&text.contains(passWord)) {
					System.out.println("로그인 성공");
					//메인 화면으로 이동
					m1.s1();
					
				}				
			} 
				System.out.println("로그인 실패");
				login_student();
			
		}
		
		if(get.equals("2")) {
		System.out.println("===================");
		System.out.print("ID를 입력하세요 : ");
		String id = scan.nextLine();
		System.out.print("PassWord 를 입력하세요 : ");
		String passWord = scan.nextLine();
		
		
		
		
		//if() 일치하는 회원 목록이 없을 경우
		if(!(text.contains(id))&&!(text.contains(passWord))) {
		
		
//		FileWriter stream = new FileWriter(file, true);	
		
		stream.write( id + passWord );
		stream.newLine();//줄바꿈
		
		stream.close();
		System.out.println();
		System.out.println("로그인 화면으로 돌아갑니다.");
		login_student();
			}//if일치 회원 검사
		}
		
	}

}

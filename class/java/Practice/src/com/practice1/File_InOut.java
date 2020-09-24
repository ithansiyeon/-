package com.practice1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

// 연습문제 시작~!!!
public class File_InOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// m1();
		// m2();
		// m3();
		// m4();
		// m5();
		//m6();
		//m7();
		//m8();
		//m9();
		m10();
	}
	
//	소스 파일에서 예약어가 총 몇회 사용되었는지 검사하시오.
//
//	리소스
//
//	자바소스.java
//	자바예약어.dat
//	파일 다운로드
//	출력
//
//	[결과] 
//	if : 5회 
//	continue : 2회 
//	.. 
//	abstract : 0회 
	
	private static void m10() {
		File file = new File("D:\\파일_입출력_문제\\자바소스.java");
		File file1 = new File("D:\\파일_입출력_문제\\자바예약어.dat");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			BufferedReader reader1 = new BufferedReader(new FileReader(file1));
			String line = null;
			HashMap<String,Integer> map = new HashMap<String,Integer>();
			
			while((line=reader1.readLine())!=null) {
				map.put(line,0);
			}	
			Set <String> set = map.keySet();
			
			while((line=reader.readLine())!=null) {
				for(String item:set) {
					int index = -item.length();
					while(true) {
					//System.out.println(item);
				
					//index=content.indexOf(word,index+word.length());
					//index = line.indexOf(item,index+item.length());
					System.out.println(index);
					if(index>0 && !((line.charAt(index+item.length()) >= 'a' && line.charAt(index+item.length()) <= 'z') 
							|| (line.charAt(index+item.length()) >= 'A' && line.charAt(index+item.length()) <= 'Z'))) {
						map.put(item,map.get(item)+1);
						} else if(index==-1) {
							break;
						}
					}
				}
			}
			System.out.println("[결과]");
			for(String item:set) {
				System.out.printf("%s : %d회\r\n",item,map.get(item));
			}
			
		} catch (Exception e) {
			System.out.println("File_InOut.m10()");
			e.printStackTrace();
		}
		
		
	}

//	요구사항.009
//	사용자로부터 임의의 숫자를 10개 입력받아 파일에 저장하시오.
//
//	입력
//
//	숫자 : 5 
//	숫자 : 3 
//	숫자 : 99 
//	..
//	숫자 : 20 
//	데이터형식(입력 순서대로)
//
//	5
//	3
//	99
//	.. 
//	20
//	데이터형식(입력 반대 순서대로)
//
//	20
//	..
//	99
//	3
//	5
//	데이터형식(내림차순 정렬)
//
//	99 
//	20 
//	.. 
//	5 
//	3 
	
	private static void m9() {
		
		Scanner scan = new Scanner(System.in);
		File file = new File("D:\\number.txt");
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			writer.write("입력 숫자대로.");
			writer.newLine();
			for(int i=0;i<10;i++) {
				System.out.print("숫자:");
				 list.add(Integer.parseInt(scan.nextLine()));
				 writer.write(list.get(i)+"\r\n");
			}	
			System.out.println("입력 숫자대로");
			for(int i=0;i<10;i++) {
				System.out.println(list.get(i));
			}
			System.out.println();
			System.out.println("입력 반대로");
			writer.write("입력 반대로.");
			writer.newLine();
			for(int i=9;i>=0;i--) {
				writer.write(list.get(i)+"\r\n");
				System.out.println(list.get(i));
			}	
			System.out.println();
			Collections.sort(list); // List<T> <- ArrayList<T>
			Collections.reverse(list);
			
			writer.write("내림차순으로.");
			writer.newLine();
			System.out.println("내림차순으로");
			for(int i=0;i<list.size();i++) {
				writer.write(list.get(i)+"\r\n");
				System.out.println(list.get(i));
			}
			writer.close();
		}
	catch(IOException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}


//	요구사항.008
//	모든 괄호가 서로 짝이 맞는지 검사하시오.
//
//	리소스
//
//	괄호.java
//	파일 다운로드
//	출력
//
//	올바른(올바르지 않은) 소스입니다. 
//	조건
//
//	대상 괄호 : (), {}
//	도움
//
//	Stack 사용
	
	private static void m8() {
		
		File file = new File("D:\\파일_입출력_문제\\괄호.java");
		
		BufferedReader reader = null;
		Stack<String> stack = new Stack<String> ();
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			String line = null;
			reader = new BufferedReader(new FileReader(file));
			while((line=reader.readLine())!=null){
				for(int i=0;i<line.length();i++) {
					list.add(i,line.charAt(i)+"");
				
				}
			}
			reader.close();
			boolean loop = false;
			int count=0;
			for(int i=0;i<list.size();i++) {
				if(list.get(i).equals("(") || list.get(i).equals("{")) {
					stack.add(list.get(i));
				} else if(list.get(i).equals(")")) {
					if(stack.pop().equals("(")){
						loop = true;
					} else {
						loop = false;
						break;
					}
				} else if(list.get(i).equals("}")) {
					count++;
				}
				
			}
			
			if(stack.size()==count && loop) {
				System.out.println("올바른 소스입니다.");
			} else {
				System.out.println("올바르지 않는 소스입니다.");
			}
			
		} catch (Exception e) {
			System.out.println("File_InOut.m8()");
			e.printStackTrace();
		}
	
	}

//	요구사항.007
//	직원들의 지각 횟수와 조퇴 횟수를 카운트해서 출력하시오.
//
//	리소스
//
//	출결.dat
//	파일 다운로드
//	출력
//
//	[이름]    [지각]    [조퇴] 
//	홍길동       4회       0회 
//	아무개       0회       0회 
//	하하하       2회       3회 
//	조건
//
//	출근 : 오전 9시
//	퇴근 : 오후 6시
//	추가조건
//
//	날짜별로 카운트하시오.
	
	private static void m7() {
		File file = new File("D:\\파일_입출력_문제\\출결.dat");
		
		BufferedReader reader = null;
	
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		try {
			
			reader = new BufferedReader(new FileReader(file));
			String line = null;
		
			while((line=reader.readLine())!=null) {
				String[] item = line.split(",");
				map.put(item[0],0);
			}
			line = null;
			reader = new BufferedReader(new FileReader(file));
			while((line=reader.readLine())!=null) {
				String[] item = line.split(",");
				int count = 0;
				count = map.get(item[0])+1;
				map.put(item[0],count);
			}
			Set<String> s = map.keySet();
			System.out.println("[날짜]\t\t[갯수]");
			for(String item : s) {
				System.out.printf("%s\t",item);
				System.out.printf("%d",map.get(item));
				System.out.println();
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("File_InOut.m7()");
			e.printStackTrace();
		}
		
	}

//	요구사항.006
//	검색할 이름을 입력받아 해당 회원의 주문 정보를 출력하시오.
//
//	리소스
//
//	검색_회원.dat
//	검색_주문.dat
//	파일 다운로드
//	입력
//
//	이름 : 홍길동 
//	출력
//
//	==== 구매내역 ==== 
//	[번호]    [이름]    [상품명]    [개수]    [배송지]
//	    3    홍길동     마우스          3    서울시 강동구 천호동
	    
	private static void m6() {
		
		File file = new File("D:\\파일_입출력_문제\\검색_회원.dat");
		File file1 = new File("D:\\파일_입출력_문제\\검색_주문.dat");
		Scanner scan = new Scanner(System.in);
		ArrayList<String>list = new ArrayList<String>();
		ArrayList<String>list1 = new ArrayList<String>();
		try {

			BufferedReader reader = new BufferedReader(new FileReader(file)); 
			BufferedReader reader1 = new BufferedReader(new FileReader(file1));
			
			System.out.print("이름:");
			String name = scan.nextLine();
			String line = "";
			while((line=reader.readLine())!=null) {
				String[] item = line.split(",");
				if(item[1].equals(name)) {
					list.add(line);
				}
			}
			
			while((line=reader1.readLine())!=null) {
				String[] item = line.split(",");
				for (int i = 0; i < list.size(); i++) {
					String[] item1 = list.get(i).split(",");
					if (item1[0].equals(item[3])) {
						list1.add(line);
					}
				}
			}
			
			System.out.println("=======구매내역========");
			System.out.println("[번호]\t[이름]\t[상품명]\t[개수]\t[배송지]");
			for(int i=0;i<list.size();i++) {
				String[] item = list.get(i).split(",");
				for(int j=0;j<list1.size();j++) {
					String[] item1 = list1.get(j).split(",");
					if(item[0].equals(item1[3])) {
						System.out.printf("%s\t",item[0]);
						System.out.printf("%s\t",item[1]);
						System.out.printf("%s\t",item1[1]);
						System.out.printf("%s\t",item1[2]);
						System.out.printf("%s\t",item[2]);
						System.out.println();
					}
				}
			}
			
		} catch (Exception e) {
			System.out.println("File_InOut.m6()");
			e.printStackTrace();
		}
		
		
	}

//	검색할 이름을 입력받아 해당 회원의 모든 정보를 출력하시오.
//	리소스
//
//	단일검색.dat
//	파일 다운로드
//	입력
//
//	이름 : 홍길동 
//	출력
//
//	[홍길동] 
//	번호 : 33 
//	주소 : 서울시 강남구 역삼동 
//	전화 : 010-2345-6789 

	private static void m5() {
		File file = new File("D:\\파일_입출력_문제\\단일검색.dat");
		Scanner scan = new Scanner(System.in);
		System.out.print("이름:");
		String name = scan.nextLine();
		BufferedReader reader = null;
		ArrayList<String> list = new ArrayList<String>();
		try {

			reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] item = line.split(",");
				if (item[1].equals(name)) {
					list.add(line);
				} else {
					System.out.println("일치하는 이름이 없습니다.");
				}
			}

			System.out.println("[" + name + "]");
			for (int i = 0; i < list.size(); i++) {
				String[] item = list.get(i).split(",");
				System.out.printf("번호:%s\r\n", item[0]);
				System.out.printf("주소:%s\r\n", item[2]);
				System.out.printf("번호:%s\r\n", item[3]);

			}

		} catch (Exception e) {
			System.out.println("File_InOut.m5()");
			e.printStackTrace();
		}

	}

//	요구사항.004
//	파일내의 성적을 확인 후 합격자/불합격자 명단을 출력하시오.
//
//	리소스
//
//	성적.dat
//	파일 다운로드
//	출력
//
//	[합격자] 
//	홍길동 
//	하하하 
//	아무개 
//	[불합격자] 
//	호호호 
//	후후후 
//	조건
//
//	합격 조건 : 3과목 평균 60점 이상
//	과락 조건 : 1과목 40점 미만
//	데이터형식
//
//	//이름,국어,영어,수학
//	홍길동,50,60,70
//	아무개,100,80,50
//	하하하,98,48,56

	private static void m4() {

		File file = new File("D:\\파일_입출력_문제\\성적.dat");
		BufferedReader reader = null;
		ArrayList<String> pass = new ArrayList<String>();
		ArrayList<String> fail = new ArrayList<String>();
		// System.out.println(file.exists());
		try {
			String line = null;
			reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {
				String[] item = line.split(",");

				int kor = Integer.parseInt(item[1]);
				int eng = Integer.parseInt(item[2]);
				int math = Integer.parseInt(item[3]);

				if ((kor + eng + math) / 3.0 >= 60 && kor > 40 && eng > 40 && math > 40) {
					pass.add(item[0]);
				} else {
					fail.add(item[0]);
				}
			}

			reader.close();
			System.out.println("[합격자]");
			for (int i = 0; i < pass.size(); i++) {
				System.out.println(pass.get(i));
			}
			System.out.println("[불합격자]");
			for (int i = 0; i < fail.size(); i++) {
				System.out.println(fail.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * 메모장을 구현하시오.
	 * 
	 * 조건
	 * 
	 * 쓰기 이름 작성시간 메모 내용(단일 라인) 메모 내용(다중 라인) 읽기 메모를 목록으로 출력 추가
	 * 
	 * 최신 메모를 먼저 출력
	 */

	private static void m3() {

		File file = new File("D:\\notepad.txt");
		BufferedWriter writer;
		BufferedReader reader;
		Scanner scan = new Scanner(System.in);
		String line;
		Calendar c = Calendar.getInstance();
		ArrayList<String> list = new ArrayList<String>();
		try {
			while (true) {
				System.out.println("===================");
				System.out.println("1. write");
				System.out.println("2. read");
				System.out.println("3. 종료");
				System.out.println("===================");
				System.out.print("입력▷");
				int sel = scan.nextInt();
				scan.skip("\r\n");
				reader = new BufferedReader(new FileReader(file));

				if (sel == 1) {
					String txt = "";

					while ((line = reader.readLine()) != null) {
						txt += line + "\r\n";
					}

					boolean loop = true;
					writer = new BufferedWriter(new FileWriter(file));

					System.out.print("이름:");
					String name = scan.nextLine();
					writer.write(name + "\r\n");

					writer.write(String.format("%tF\r\n", c));

					System.out.print("내용:");
					String content = "";
					while (true) {
						content = scan.nextLine();
						if (content.equals("q")) {
							break;
						}

						writer.write(content + "\r\n");

					}

					writer.write("-----------------------\r\n");

					writer.write(txt);

					writer.close();

				} else if (sel == 2) {
					System.out.println("[name]\t[date]\t\t[content]");

					line = null;

					while ((line = reader.readLine()) != null) {
						if (line.equals("-----------------------")) {
							System.out.println();
						} else {
							System.out.printf("%s\t", line);
						}
					}

				} else if (sel == 3) {
					reader.close();
					break;
				} else {
					System.out.println("번호를 잘못입력했습니다.");
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private static void m2() {

		File file = new File("D:\\파일_입출력_문제 (1)\\숫자.dat");
		String line = null;
		ArrayList<String> list = new ArrayList<String>();
		BufferedReader reader;
		BufferedWriter writer;

		try {
			reader = new BufferedReader(new FileReader(file));
			if (file.exists()) {
				while ((line = reader.readLine()) != null) {
					list.add(line);
				}
			}

			reader.close();

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).contains("0")) {
					list.set(i, list.get(i).replace("0", "영"));
				}
				if (list.get(i).contains("1")) {
					list.set(i, list.get(i).replace("1", "일"));
				}
				if (list.get(i).contains("2")) {
					list.set(i, list.get(i).replace("2", "이"));
				}
				if (list.get(i).contains("3")) {
					list.set(i, list.get(i).replace("3", "삼"));
				}
				if (list.get(i).contains("4")) {
					list.set(i, list.get(i).replace("4", "사"));
				}
				if (list.get(i).contains("5")) {
					list.set(i, list.get(i).replace("5", "오"));
				}
				if (list.get(i).contains("6")) {
					list.set(i, list.get(i).replace("6", "육"));
				}
				if (list.get(i).contains("7")) {
					list.set(i, list.get(i).replace("7", "칠"));
				}
				if (list.get(i).contains("8")) {
					list.set(i, list.get(i).replace("8", "팔"));
				}
				if (list.get(i).contains("9")) {
					list.set(i, list.get(i).replace("9", "구"));
				}
			}

			writer = new BufferedWriter(new FileWriter(file));

			for (int i = 0; i < list.size(); i++) {
				writer.write(list.get(i));
				writer.write("\r\n");
			}
			writer.close();
			System.out.println("완료");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private static void m1() {
		// 파일내에서 특정 이름을 찾아 다른 이름으로 변환 후 해당 파일을 다른 이름으로 저장하시오.
		File file = new File("D:\\파일_입출력_문제 (1)\\이름수정.dat");
		String line = null;
		ArrayList<String> list = new ArrayList<String>();
		BufferedReader reader;
		BufferedWriter writer;

		try {
			reader = new BufferedReader(new FileReader(file));

			if (file.exists()) {
				while ((line = reader.readLine()) != null) {
					list.add(line);
				}

			}
			reader.close();
			boolean loop = true;

			for (int i = 0; i < list.size(); i++) {
				String word = "유재석";
				int index = -word.length();
				for (int j = 0; j < list.get(i).length(); j++) {
					index = index + word.length();
					if (list.get(i).indexOf(word, index) > 0) {
						list.set(i, list.get(i).replace(word, "메뚜기"));
					}
				}

				System.out.println(list.get(i));
			}

			writer = new BufferedWriter(new FileWriter(file));

			for (int i = 0; i < list.size(); i++) {
				writer.write(list.get(i));
				writer.write("\r\n");
			}
			writer.close();
			System.out.println("완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

package com.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;



public class Teacher_Test {

	private static Teacher_Output output;
	private static Scanner scan;
	private static HashMap<Integer, Teacher> map;

	static {
		output = new Teacher_Output();
		scan = new Scanner(System.in);
		map = new HashMap<Integer, Teacher>();
	}

	public static void Teacher_Management() {
		try {
			String path = "C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\선생님";
			File dir = new File(path);
			boolean loop = false;
			for(File list:dir.listFiles()) {
				if(list.isFile()) {
					loop = true;
				} else {
					loop = false;
				}
			}
			
			if(!loop) {
				dummy();
			} /*
				else {
				String path1 = "C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\선생님\\선생님.txt";
				BufferedReader reader = new BufferedReader(new FileReader(path1));
				String line = null;
				while((line=reader.readLine())!=null) {
					Teacher.temp++;
					String[] item = line.split(",");
					map.put(Teacher.temp,new Teacher());
					//System.out.println(Integer.parseInt(item[0]));
					//int num = Integer.parseInt(item[0]);
					map.get(Teacher.temp).setSeq(Integer.parseInt(item[0]));
					map.get(Teacher.temp).setName((item[1]));
					map.get(Teacher.temp).setAge((Integer.parseInt(item[2])));
					map.get(Teacher.temp).setSubject(((item[3])));
					map.get(Teacher.temp).setAddress((item[4]));
					map.get(Teacher.temp).setTel((item[5]));
					map.get(Teacher.temp).setGender((Integer.parseInt(item[6])));
					map.get(Teacher.temp).setKey(Integer.parseInt(item[7]));
					map.get(Teacher.temp).setClassroom(Integer.parseInt(item[8]));
					
					
					
				}
			map.clear();
			Teacher.temp=0;
			}
			*/
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		boolean loop = true;

		while (loop) {

			output.menu();

			String sel = scan.nextLine();

			if (sel.equals("1")) {
				// 강사 추가
				add();
			} else if (sel.equals("2")) {
				// 강사 목록
				list();
			} else if (sel.equals("3")) {
				// 강사 삭제
				delete();
			} else if(sel.equals("4")) {
				correct();
			} else if (sel.equals("5")) {
				// 강사 검색(이름)
				search();
			} else if (sel.equals("6")) {
				// 강사 검색(교과목)
				search2();
			} else if(sel.equals("7")) {
				search3();
			} else if(sel.equals("8")) {
				loop = false;
			}

		}

	} // main
	
	private static void search3() {
		output.title(Teacher_Title.SEARCH);
		
		System.out.print("검색(전화번호): "); // 홍길동 > 길동 검색률을 높임 
		String word = scan.nextLine();

		listName(word);
		
		output.pause(scan);
	}
	

	private static void filewrite() {	
		
		Set<Integer> set = map.keySet(); 

		String path = "C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\선생님\\선생님.txt";
		File file = new File(path);
	//	int key=1;
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (Integer key : set) {

				writer.write(map.get(key).getSeq() + "," + map.get(key).getName() + "," + map.get(key).getAge() + ","
						+ map.get(key).getSubject() + "," +map.get(key).getAddress() +"," + map.get(key).getTel() + "," 
						+ map.get(key).getGender() + "," + map.get(key).getKey() + ","
						+ map.get(key).getClassroom()+ "," + map.get(key).getId() + "," + map.get(key).getPwd() + "\r\n");
				//key++;
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void correct() {
		output.title(Teacher_Title.CORRECT);
		System.out.println("강사 수정: ");

		list();

		Set<Integer> set = map.keySet();
		System.out.print("수정할 강사 번호: ");
		int num = scan.nextInt();
		scan.nextLine();
//		int find = 0;
//		for (Integer key : set) {
//			if (map.get(key).getKey() == num) {
//				find = key;
//			}
//		}
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("1. 이름");
		System.out.println("2. 나이");
		System.out.println("3. 연락처");
		System.out.println("4. 주소");
		System.out.println("5. 성별");
		System.out.println("6. 과목");
		System.out.println("7. 강의실");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.print("수정할 번호: ");
		int num1 = scan.nextInt();
		scan.nextLine();
		boolean loop = true;
		try {
			read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (loop) {
			switch (num1) {
			case 1:
				System.out.print("이름: ");
				String name = scan.nextLine();
				map.get(num).setName(name);
				loop = false;
				break;
			case 2:
				System.out.print("나이: ");
				int age = scan.nextInt();
				scan.skip("\r\n");
				map.get(num).setAge(age);
				loop = false;
				break;
			case 3:
				System.out.print("연락처: ");
				String tel = scan.nextLine();
				map.get(num).setTel(tel);
				loop = false;
				break;
			case 4:
				System.out.print("주소: ");
				String address = scan.nextLine();
				map.get(num).setAddress(address);
				loop = false;
				break;
			case 5:
				System.out.print("성별: ");
				int gender = scan.nextInt();
				scan.skip("\r\n");
				map.get(num).setGender(gender);
				loop = false;
				break;
			case 6:
				System.out.print("과목: ");
				String subject = scan.nextLine();
				map.get(num).setSubject(subject);
				loop = false;
				break;
			case 7:
				System.out.print("강의실: ");
				int classroom = scan.nextInt();
				map.get(num).setClassroom(classroom);
				loop = false;
				break;
			default:
				System.out.println("잘못된 숫자를 입력하셨습니다.");
			}
		}
		filewrite();
		map.clear();
		Teacher.temp=0;
	}

	private static void search2() {

		output.title(Teacher_Title.SEARCH);

		System.out.print("검색(교과목): "); // 홍길동 > 길동 검색률을 높임
		String word = scan.nextLine();
		try {
			read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listName(word);
		Set<Integer> set = map.keySet();
		for (Integer key : set) {

			// if(s.getName().contains(word)) {
			// if(s.getName().toUpperCase().contains(word.toUpperCase())) // 대소문자 구분 없이 한쪽으로
			// 몰아야 돼 그걸 안하면 철저하게 찾는 거임
			if (map.get(key).getSubject().toUpperCase().indexOf(word.toUpperCase()) > -1) {
				System.out.printf("%5d\t%s\t%d\t%s\t%s\t%s\t%-10s\t\t%d\n",
						map.get(key).getSeq(), 
						map.get(key).getName(),
						map.get(key).getAge(),
						map.get(key).getTel(), 
						map.get(key).getAddress(),
						map.get(key).getGender() == 1 ? "남자" : "여자", 
						map.get(key).getSubject(),
						map.get(key).getClassroom());
			}

		}
		map.clear();
		Teacher.temp=0;
		output.pause(scan);

	}

	private static void listName(String word) {
		System.out.println("[번호]\t[이름]\t[나이]\t[연락처]\t[주소]\t\t[성별]\t[과목]\t\t\t[강의실]");
		Set<Integer> set = map.keySet();
		for (Integer key : set) {
			if (map.get(key).getTel().replace("-", "").contains(word)) {
				System.out.printf("%5d\t%s\t%d\t%s\t%s\t%s\t%-10s\t\t%d\n",
						map.get(key).getSeq(), 
						map.get(key).getName(),
						map.get(key).getAge(),
						map.get(key).getTel(), 
						map.get(key).getAddress(),
						map.get(key).getGender() == 1 ? "남자" : "여자", 
						map.get(key).getSubject(),
						map.get(key).getClassroom());
			}
		}
	}

	private static void search() {
	
		output.title(Teacher_Title.SEARCH);

		// 검색?
		// -> list() 작업과 유사
		// 1. list(): 모든 데이터 출력
		// 2. search(): 일부 데이터 출력. 조건부 list()

		System.out.print("검색(강사명): "); // 홍길동 > 길동 검색률을 높임
		String word = scan.nextLine();
		try {
			read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("[번호]\t[이름]\t[나이]\t[연락처]\t[주소]\t\t[성별]\t[과목]\t\t\t[강의실]");
		Set<Integer> set = map.keySet();
		for (Integer key : set) {

			// if(s.getName().contains(word)) {
			// if(s.getName().toUpperCase().contains(word.toUpperCase())) // 대소문자 구분 없이 한쪽으로
			// 몰아야 돼 그걸 안하면 철저하게 찾는 거임
			if (map.get(key).getName().indexOf(word) > -1) {
				System.out.printf("%5d\t%s\t%d\t%s\t%s\t%s\t%-10s\t\t%d\n",
						map.get(key).getSeq(), 
						map.get(key).getName(),
						map.get(key).getAge(),
						map.get(key).getTel(), 
						map.get(key).getAddress(),
						map.get(key).getGender() == 1 ? "남자" : "여자", 
						map.get(key).getSubject(),
						map.get(key).getClassroom());
				
			}

		}
		map.clear();
		Teacher.temp=0;
		output.pause(scan);

	}

	private static void delete() {
		

		output.title(Teacher_Title.DELETE);
		
		list();
		try {
			read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.print("삭제할 번호: ");
		int seq = scan.nextInt();
		scan.skip("\r\n");
	
		Set<Integer> keys = map.keySet(); 
		Iterator<Integer> kiter = keys.iterator();
		
		while(kiter.hasNext()) {
			Integer key = kiter.next();
			if (map.get(key).getSeq() == seq) {
				map.remove(key);
				break; 
			}
		}
		//System.out.println(map.size());
		filewrite();
		
		map.clear();
		Teacher.temp=0;
		output.pause(scan);
		
		
	}
	
	private static void read() throws Exception {
		
		String path = "C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\선생님\\선생님.txt";
		//File file = new File(path);
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line = null;
			int i=1;
			while((line=reader.readLine())!=null) {
				Teacher.temp++;
				String[] item = line.split(",");
				map.put(Teacher.temp,new Teacher());
				//map.get(Teacher.temp).setSeq(Integer.parseInt(item[0]));
				map.get(Teacher.temp).setSeq(i);
				map.get(Teacher.temp).setName((item[1]));
				map.get(Teacher.temp).setAge((Integer.parseInt(item[2])));
				map.get(Teacher.temp).setSubject(((item[3])));
				map.get(Teacher.temp).setAddress((item[4]));
				map.get(Teacher.temp).setTel((item[5]));
				map.get(Teacher.temp).setGender((Integer.parseInt(item[6])));
				map.get(Teacher.temp).setKey((Integer.parseInt(item[7])));
				map.get(Teacher.temp).setClassroom(Integer.parseInt(item[8]));
				map.get(Teacher.temp).setId(item[9]);
				map.get(Teacher.temp).setPwd(item[10]);
				
				i++;
				
			}
			reader.close();
		
	}

	private static void list() {
		output.title(Teacher_Title.LIST);
		try {
			read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("[번호]\t[이름]\t[나이]\t[연락처]\t[주소]\t\t[성별]\t[과목]\t\t\t[강의실]");
		
		Set<Integer> set = map.keySet();
		for (Integer key : set) {
			System.out.printf("%5d\t%s\t%d\t%s\t%s\t%s\t%-10s\t\t%d\n",		
					map.get(key).getSeq(), 
					map.get(key).getName(),
					map.get(key).getAge(),
					map.get(key).getTel(), 
					map.get(key).getAddress(),
					map.get(key).getGender() == 1 ? "남" : "여", 
					map.get(key).getSubject(),
					map.get(key).getClassroom());
		}
		map.clear();
		Teacher.temp=0;
		output.pause(scan); 
		
	}

	private static void add() {

		output.title(Teacher_Title.ADD);

		System.out.print("이름: ");
		String name = scan.nextLine();

		System.out.print("나이: ");
		int age = scan.nextInt();
		scan.skip("\r\n");

		System.out.print("연락처: ");
		String tel = scan.nextLine();

		System.out.print("주소: ");
		String address = scan.nextLine();

		System.out.print("성별(1 : 남자, 2: 여자): ");
		int gender = scan.nextInt();
		scan.skip("\r\n");

		System.out.print("과목: ");
		String subject = scan.nextLine();
		
		System.out.print("배정받은 강의실(1~10): ");
		int classroom = scan.nextInt();
		scan.skip("\r\n");
		
		try {
			read();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Teacher.temp++; // 공용변수, 살아있는 변수
		
		map.put(Teacher.temp, new Teacher());
		map.get(Teacher.temp).setSeq(Teacher.temp); // 자기 개인 번호로 받아
		map.get(Teacher.temp).setName(name);
		map.get(Teacher.temp).setAge(age);
		map.get(Teacher.temp).setAddress(address);
		map.get(Teacher.temp).setTel(tel);
		map.get(Teacher.temp).setAddress(address);
		map.get(Teacher.temp).setGender(gender);
		map.get(Teacher.temp).setSubject(subject);
		map.get(Teacher.temp).setClassroom(classroom);

		try {
			String path = "C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\선생님\\선생님.txt";
			File file = new File(path);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
			writer.write(map.get(Teacher.temp).getSeq() + "," + map.get(Teacher.temp).getName() + "," + map.get(Teacher.temp).getAge() + ","
					+ map.get(Teacher.temp).getSubject() + "," +map.get(Teacher.temp).getAddress() +"," + map.get(Teacher.temp).getTel() + "," 
					+ map.get(Teacher.temp).getGender() + "," + map.get(Teacher.temp).getKey()	+ "," + map.get(Teacher.temp).getClassroom() + "," +
					map.get(Teacher.temp).getId() + "," + map.get(Teacher.temp).getPwd() + "\r\n");
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 잠시 멈춤
		map.clear();
		Teacher.temp=0;
		output.pause(scan); // 매개변수로 scan하면 복잡성이 증가

	}
	public static void dummy() throws Exception {
		// 테스트용 데이터 x 30명
		
		int length = 10;
		String[] temp1 = { "김", "이", "박", "최", "정", "진","홍" };
		String[] temp2 = { "유", "정", "석", "인", "지", "은", "형", "순", "성", "민" };
		String[] temp3 = { "서울시", "인천시", "부산시", "대전시", "광주시" };
		String[] temp4 = { "강남구", "강서구", "강북구", "강동구" };
		String[] temp5 = { "Java", "Pthyon", "C#", "Android", "Linux", "HTML", "WML", "Javascript"};
		Random rnd = new Random();
		String path = "C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\선생님";
		File file = new File(path);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\선생님\\선생님.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		for(int i=0;i<length;i++) {
			Teacher s = new Teacher();
			map.put(i, s);
		}
		
	
		ArrayList<Integer> classroom = new ArrayList<Integer>();
		
		
		
//		while(classroom.size()<length) {
//			int temp = rnd.nextInt(10)+1;
//			System.out.println(temp);
//			classroom.add(temp);
//			num.add(temp);
//		}
		
		while(classroom.size()<length) {
			int temp = rnd.nextInt(length)+1;
			classroom.add(temp);
			for(int i=0;i<classroom.size()-1;i++) {
				if(classroom.get(i)==temp) {
					classroom.remove(i);
				}
			}
		}
		
		//System.out.println(classroom);
		
		
		//if문 전에 열어야 돼~
		int cnt=1;
		if (file.exists()) {
			for (int i=0;i<length;i++) {
				
				Teacher.temp++;
				map.get(i).setSeq(Teacher.temp);

				String name = temp1[rnd.nextInt(temp1.length)] + temp2[rnd.nextInt(temp2.length)]
						+ temp2[rnd.nextInt(temp2.length)];

				int age = rnd.nextInt(20) + 30;

				String address = temp3[rnd.nextInt(temp3.length)] + " " + temp4[rnd.nextInt(temp4.length)];
				String tel = "010-" + (rnd.nextInt(9000) + 1000) + "-" + (rnd.nextInt(9000) + 1000);
				
				
				map.get(i).setKey(cnt);
				map.get(i).setName(name);
				map.get(i).setAge(age);
				map.get(i).setAddress(address);
				map.get(i).setTel(tel);
				map.get(i).setSubject(temp5[rnd.nextInt(temp5.length)]);
				map.get(i).setGender(rnd.nextInt(2)+1);
				map.get(i).setClassroom(classroom.get(i));
				//System.out.print(num.get(i) );
				try {
					//BufferedReader reader = new BufferedReader(new FileReader(file));
					File file1= new File("C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\로그인_강사.txt");
					System.out.println(file1.getAbsolutePath());
					BufferedReader reader=null;
					if(file1.exists())
						reader = new BufferedReader(new FileReader(file1));
					else {
						System.out.println("파일이 존재 안함");
					}
					String line = null;
					ArrayList<String> id = new ArrayList<String>();
					ArrayList<String> pwd = new ArrayList<String>();
					while((line=reader.readLine())!=null) {
						String[] item = line.split(",");
						id.add(item[0]);
						pwd.add(item[1]);
					}
					reader.close();
					System.out.println(3);
					writer.write(map.get(i).getSeq() + "," + map.get(i).getName() + "," + map.get(i).getAge() + ","
							+ map.get(i).getSubject() + "," +map.get(i).getAddress() +"," + map.get(i).getTel() + "," 
							+ map.get(i).getGender() + "," + map.get(i).getKey()
							+ "," + map.get(i).getClassroom() + "," + id.get(i) + "," + pwd.get(i) + "\r\n");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				cnt++;
			}
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
		
		writer.close();
		map.clear();
		Teacher.temp=0;

	}
	
	
	

}

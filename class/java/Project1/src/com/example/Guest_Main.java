package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Guest_Main {
	private static Output output; //전역
	private static Scanner scan;
	private static ArrayList<Guest> list;
	
	static {
		
		output = new Output();
		scan = new Scanner(System.in);
		list = new ArrayList<Guest>();
		
	}
	
	public static void main(String[] args) {
		
		output.begin();
		
		boolean loop = true;
		
		while (loop) {
			
			output.guestMenu();
			
			String sel = scan.nextLine();
			
			if (sel.equals("1")) {
				//전체 데이터 조회
				try {
					seeCurriculum();
				} catch (Exception e) {
					e.printStackTrace();
				}
				output.guestCurriculum();
				String sel2 = scan.nextLine();
				if (sel2.equals("1")) {
					//과정 검색
					searchCurriculum();
				} else {
					//프로그램 종료
					loop = false;
				}				
			} else if (sel.equals("2")) {
				//수강 추천순 조회
//				curriculumList();
			} else if (sel.equals("3")) {
				//1 : 1 문의
//				question();
			} else {
				//프로그램 종료
				loop = false;
			}
			
		}		
		
		output.end();
		
		
	}

	private static void searchCurriculum() {
		
		output.title(Title.SUBJECTSEARCH);
		
		System.out.print("검색(과정명) : ");
		String word = scan.nextLine();
		
		System.out.println("[번호]\t\t[교과목]\t\t[교육과정]\t[교육장소]\t\t[교육기간]\t\t\t[교육일정]\t\t[모집인원]");
		
		for (Guest g : list) {
			
			if (g.getName().contains(word)) {
			
				System.out.printf("%4d\t%s\t%10s\t%s\t\t%s ~ %s\t\t%s\t\t   %d\n"
						, g.getSeq()
						, g.getName()
						, g.getSubject()
						, g.getArea()
						, g.getC_1()
						, g.getC()
						, g.getTime()
						, g.getPeople());
			}
			
		}
		
	}

	private static void seeCurriculum() throws Exception {
		
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\pc\\Desktop\\subject.txt"));
		
		File file = new File("C:\\Users\\pc\\Desktop\\subject.txt");
		String line = null;
		
		if (file.exists()) {
			while ((line = reader.readLine()) != null) {
				
				Guest g = new Guest();
				String[] temp = line.split(",");
				
				int seq = Integer.parseInt(temp[0]);
				int Room_num = Integer.parseInt(temp[5]);
				int people = Integer.parseInt(temp[11]);
				
				g.setSeq(seq);
				g.setName(temp[1]);
				g.setSubject(temp[2]);
				g.setC(temp[3]);
				g.setC_1(temp[4]);
				g.setRoom_num(Room_num);
				g.setPlace(temp[6]);
				g.setTime(temp[7]);
				g.setStd_satisfy(temp[8]);
				g.setArea(temp[9]);
				g.setEmp_ratio(temp[10]);
				g.setPeople(people);
				
				list.add(g);
				
			}
		}
		
		reader.close();
		
		output.title(Title.SUBJECTLIST);
		
		curriculum();
		
		output.pause(scan);	
		
	}

	private static void curriculum() {
		
		System.out.println("[번호]\t\t[교과목]\t\t[교육과정]\t[교육장소]\t\t[교육기간]\t\t\t[교육일정]\t\t[모집인원]");
		
		for (Guest g : list) {
			
			System.out.printf("%4d\t%s\t%10s\t%s\t\t%s ~ %s\t\t%s\t\t   %d\n"
					, g.getSeq()
					, g.getName()
					, g.getSubject()
					, g.getArea()
					, g.getC_1()
					, g.getC()
					, g.getTime()
					, g.getPeople());
			
		}
				
	}
}

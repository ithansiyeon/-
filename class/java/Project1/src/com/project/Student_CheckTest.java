package com.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Student_CheckTest {
	private static HashMap<Integer, CheckTest_Data> map;

	static {
		map = new HashMap<Integer, CheckTest_Data>();
	}

	public static void main(String[] args) {

		File file = new File("C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\수강생\\수강생.txt");
		File file1 = new File("C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\과목\\과목.txt");
		
		Set<String> subject = new HashSet<String>();

		String line = null;
		if (file1.exists()) {
			try {
				BufferedReader reader1 = new BufferedReader(new FileReader(file1));
				reader1.readLine();
				while ((line = reader1.readLine()) != null) {
					String[] item1 = line.split(",");
					subject.add(item1[1]);
				}
			}catch (Exception e1) {
				e1.printStackTrace();
				}
			} else {
				System.out.println("파일이 존재하지 않습니다.");
			}
		
		ArrayList<String> subject1 = new ArrayList <String>(); 
		
		Iterator<String> kiter = subject.iterator();
		
		while(kiter.hasNext()) {
			String key = kiter.next();
			subject1.add(key);
			}
		
			Random rnd = new Random();
			BufferedReader reader = null;
			System.out.println("                                    [성적 확인]\n");
			if (file.exists()) {
				try {
					reader = new BufferedReader(new FileReader(file));
					String line1 = null;
					reader.readLine();
					
					System.out.println("[번호]\t[이름]\t[강좌명]\t\t\t\t\t[성적]\t[프로젝트 점수]");
					System.out.println("=============================================================================================");
					while ((line1 = reader.readLine()) != null) {
						String[] item = line1.split(",");
						CheckTest_Data.temp++;
						CheckTest_Data c = new CheckTest_Data();
						map.put(CheckTest_Data.temp, c);
						map.get(CheckTest_Data.temp).setName(item[1]);
						map.get(CheckTest_Data.temp).setGrade(item[7]);
						map.get(CheckTest_Data.temp).setProject(Integer.parseInt(item[6]));
						map.get(CheckTest_Data.temp).setSeq(CheckTest_Data.temp);
						map.get(CheckTest_Data.temp).setSubject(subject1.get(rnd.nextInt(subject1.size())));
						System.out.printf("%3d\t%-3s\t%-20s\t\t\t%s\t\t%-3d\n",
										   map.get(CheckTest_Data.temp).getSeq(),
										   map.get(CheckTest_Data.temp).getName(),
										   map.get(CheckTest_Data.temp).getSubject(),
										   map.get(CheckTest_Data.temp).getGrade(),
										   map.get(CheckTest_Data.temp).getProject());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				System.out.println("파일이 존재하지 않습니다.");
			}
			
			
			

		} //main

	}


class CheckTest_Data {
	public static int temp;
	private String name;
	private String subject;
	private String grade;
	private int project;
	private int seq;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getProject() {
		return project;
	}

	public void setProject(int project) {
		this.project = project;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
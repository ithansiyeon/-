package com.project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

import com.project.DummySubject;

public class SubjectData {

	public static void main(String[] args) throws IOException {
		
		HashMap<Integer, DummySubject> sub = new HashMap<Integer, DummySubject>();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\PC\\OneDrive\\바탕 화면\\프로젝트1\\subject\\subject.txt"));
		
		Calendar c = Calendar.getInstance();	//끝나는 날
		c.set(2020, 5, 15);
		c.add(Calendar.MONTH, 5);
		
		Calendar c_1 = Calendar.getInstance();	//시작하는 날
		c_1.set(2020, 5, 15);
		
		Calendar c1 = Calendar.getInstance();
		c1.set(2020, 6, 15);
		c1.add(Calendar.MONTH, 5);
		
		Calendar c1_1 = Calendar.getInstance();
		c1_1.set(2020, 6, 15);
		
		Calendar c2 = Calendar.getInstance();
		c2.set(2020, 7, 15);
		c2.add(Calendar.MONTH, 5);
		
		Calendar c2_1 = Calendar.getInstance();
		c2_1.set(2020, 7, 15);
		
		String[] temp1 = {"100%정부지원▶ 자바를 활용"
				           , "100%정부지원▶ JAVA"
				           , "100%정부지원▶ Java&"};	//교육과정
		
		String[] temp2 = {"Java", "Python", "C#", "Android", "Linux", "HTML", "WHL", "JavaScript"};	//교과목
		
		Calendar[] temp3 = { c, c1, c2 };
		Calendar[] temp3_1 = { c_1, c1_1, c2_1 };
		
		String[] temp4 = { "쌍용교육센터(역삼역 3번출구)" };
		
		String[] temp5 = { "월 ~ 금" };
		
		String[] temp6 = { "(09:00 ~ 18:00)" };
		
		String[] temp7 = { "1.0", "2.0", "3.0", "4.0", "5.0" };
		
		String[] temp8 = { "88.5%", "74%", "90%", "82%" };
		
		String[] temp9 = { "서울", "인천", "부산", "대전" };
		
		Random rnd = new Random();
		
		int count = 1;
		int count2 = 1;
		
		for(int i=0;i<=9;i++) {
			DummySubject s = new DummySubject();
			sub.put(i, s);
		}
		
		for (int i = 0; i <= 9; i++) {
			
			//Subject s = new Subject();
			
			//번호
			int num = count++;
			
			//교육과정
			String name = temp1[rnd.nextInt(temp1.length)];
			
			//교과목
			String s_name = temp2[rnd.nextInt(temp2.length)];
			
			//교육기간
			String date = String.format("%tF", temp3[rnd.nextInt(temp3.length)]);
			String date_1 = String.format("%tF", temp3_1[rnd.nextInt(temp3_1.length)]);
			
			//교육장소
			String place = temp4[rnd.nextInt(temp4.length)];
			
			//교육일정(월~금 09:00 ~ 18:00)
			String time = temp5[rnd.nextInt(temp5.length)]
			              + temp6[rnd.nextInt(temp6.length)];
			
			//강의실번호
			int room_num = rnd.nextInt(10) + 1;
			
			//모집인원
			int people = rnd.nextInt(10) + 20;
			
			//선호지역
			String area = temp9[rnd.nextInt(temp9.length)];
			
			//학생 만족도
			String std_satisfy = temp7[rnd.nextInt(temp7.length)];
			
			//취업률
			String emp_rate = temp8[rnd.nextInt(temp8.length)];
			
			//고유번호
			int key = count2++;
			
			sub.get(i).setSeq(num);
			sub.get(i).setName(name);
			sub.get(i).setSubject(s_name);
			sub.get(i).setC(date);
			sub.get(i).setC_1(date_1);
			sub.get(i).setRoom_num(room_num);
			sub.get(i).setPlace(place);
			sub.get(i).setTime(time);
			sub.get(i).setPeople(people);
			sub.get(i).setArea(area);
			sub.get(i).setStd_satisfy(std_satisfy);
			sub.get(i).setEmp_ratio(emp_rate);
			sub.get(i).setKey(key);
			
			writer.write(sub.get(i).getSeq() + "," + sub.get(i).getName() + "," + sub.get(i).getSubject() + ","
					     + sub.get(i).getC() + "," + sub.get(i).getC_1() + "," + sub.get(i).getRoom_num() + "," 
					     + sub.get(i).getPlace() + "," + sub.get(i).getTime() + "," + sub.get(i).getStd_satisfy() + "," 
					     + sub.get(i).getArea() + "," +sub.get(i).getEmp_ratio() + "," +sub.get(i).getPeople() + "," + sub.get(i).getKey() + "\r\n");
		}//for
		writer.close();
		
	}//main
	
}
package com.test.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Exam {
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> list = new ArrayList<Integer>();
		BufferedReader reader = new BufferedReader(new FileReader("d:\\과목.txt"));
		String line = null;
		ArrayList <Integer>list1 = new ArrayList<Integer>();
 		while ((line = reader.readLine()) != null) {
			String[] item = line.split(",");
			list.add(Integer.parseInt(item[1]));
			list1.add(Integer.parseInt(item[0]));
		}
		
		reader.close();
		BufferedWriter writer = new BufferedWriter(new FileWriter("d:\\test.txt"));
	
		Random rnd = new Random();
		// 뷰만들때 하면 되지 우선 테이블에 값을 대입
		//System.out.println(1);
		for(int i=0;i<12;i++) {
			int writtenRatio = rnd.nextInt(10)+35;
			int performanceRatio = rnd.nextInt(10)+35;
			int attendanceRatio = 100-(writtenRatio+performanceRatio);
			for(int j=0;j<list.size();j++){
				if(list1.get(j)==(i+1))
				{
			System.out.printf(
					"insert into tblexam values(examseq.nextVal,"
					+ "(select num from tblopenCourse where num=%d),(select num from tblSubjectByCourse where num = %d), "
					+ "(select p.endDate from tblopenCourse o "
						+ "inner join tblperiodBySubject p on p.openCourseNum = o.num "
							+ "inner join tblSubjectByCourse s on p.subjectByCourseNum = s.num "
					+ "where p.openCourseNum = %d and p.subjectByCourseNum = %d)"
					+ ",%.2f,%.2f,%.2f);\r\n",i+1,
					list.get(j),i+1,list.get(j),writtenRatio/100.0,performanceRatio/100.0,attendanceRatio/100.0);
			
			writer.write(String.format(
					"insert into tblexam values(examseq.nextVal,"
					+ "(select num from tblopenCourse where num=%d),(select num from tblSubjectByCourse where num = %d), "
					+ "(select p.endDate from tblopenCourse o "
						+ "inner join tblperiodBySubject p on p.openCourseNum = o.num "
							+ "inner join tblSubjectByCourse s on p.subjectByCourseNum = s.num "
					+ "	where p.openCourseNum = %d and p.subjectByCourseNum = %d)"
					+ ",%.2f,%.2f,%.2f);\r\n",i+1,
					list.get(j),i+1,list.get(j),writtenRatio/100.0,performanceRatio/100.0,attendanceRatio/100.0));
			}
		}
		
	}
		writer.close();
		
		
		
	}
}

package com.test.project;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Question_By_Exam_problem {
	public static void main(String[] args) {
		String[] type = {"필기","실기"};
		// 문제 내용을 맞출려면 과목당 문제 테이블을 만들어야 되지 않을까??
		String[] writtenTest = {"추상메소드는 구현부가 없다?","static은 동적 변수이다.","클래스를 생성을 통해 나온 값은 객체이다?","자료형에는 실수형이 없다?"};
		
 		String[] practicalExamination = {"다량의 데이터나 복잡한 자료들 속에서 핵심적인 내용 또는 기능을 요약하는 작업은?","html 뼈대 역할을 하는 것은?","인간의 지능을 갖고 있는 것은?",
 											"consists of flip-flops in the CPU and is the fastest in memory"};
 		
 		
 		String[] answer = {"O","X"};
 		String[] answer1 = {"딥 러닝","CSS","AI","Register"};
		
 		Random rnd = new Random();
 		
 		Set<String> question = new HashSet<String>();
		
		//for(int i=0;i<6;i++) {
//		while(lotto.size()<6) {
//			lotto.add(rnd.nextInt(45)+1);
//		}
//		
//		System.out.println(lotto);
		
		for(int i=0;i<2;i++) {
			for(int j=0;j<writtenTest.length;j++)	{
 			System.out.printf("insert into tblquestionByExam values(questionByExamseq.nextVal,(Select num from tblexam where num = %d),'%s','%s','%s');\r\n",
					i+1,type[0],writtenTest[rnd.nextInt(writtenTest.length)],answer[rnd.nextInt(answer.length)]);
				}
			}
		System.out.println();
		for(int i=0;i<2;i++) {
			for(int j=0;j<practicalExamination.length;j++)	{
 			System.out.printf("insert into tblquestionByExam values(questionByExamseq.nextVal,(Select num from tblexam where num = %d),'%s','%s','%s');\r\n",
					i+1,type[1],practicalExamination[rnd.nextInt(practicalExamination.length)],answer1[rnd.nextInt(answer1.length)]);
				}
			}
		
		
	}

}

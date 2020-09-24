package com.practice1;

public class Student {
	private String name;
	private int age;
	private int grade;
	private int classNumber;
	private int number;
	private static String school;
	
	public Student() {
		this("미정",0,0,0,0);
	}
	public Student(String name, int age, int grade, int classNumber, int number) {
		this.name=name;
		this.age=age;
		this.classNumber=classNumber;
		this.grade=grade;
		this.number=number;
	}
	public Student(String name,int age) {
		this(name,age,0,0,0);
	}
	public Student(int grade, int classNumber, int number) {
		this("미정",0,0,classNumber,number);
	}
	static {
		Student.school="역삼 중학교";
	}
	public String info() {
		String info="";
		info+=this.name+"(";
		info+=String.format("나이 : %d세",this.age);
		info+=String.format(", 학년 : %d",this.grade);
		info+=String.format(", 반 : %d",this.classNumber);
		info+=String.format(", 번호 : %d)",this.number);
		return info;
	}
}

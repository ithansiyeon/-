package com.practice;

public class Ex16_Class_question_01 {
	public static void main(String[] args) {
		Book book = new Book();
		book.setTitle("이것이 자바이다.");
		book.setAuthor("신용권");
		book.setIsbn("adb12345");
		book.setPage(365);
		book.setPrice(35000);
		book.setPublisher("한빛아카데미");
		
		System.out.println(book.getTitle());
		System.out.println(book.getAuthor());
		System.out.println(book.getIsbn());
		System.out.println(book.getPage());
		System.out.println(book.getPrice());
		System.out.println(book.getPubYear());
		System.out.println(book.info());
	}

}

package com.practice1;

public class MyQueue_question {
	public static void main(String[] args) {
		
		//배열 생성
		MyQueue queue = new MyQueue();

		//추가
		queue.add("빨강");
		queue.add("노랑");
		queue.add("파랑");
		queue.add("주황");
		queue.add("검정");
		System.out.println(queue.toString());
		//읽기
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.toString());
		//개수
		System.out.println(queue.size());

		//확인
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		System.out.println(queue.size());

		//크기 조절
		queue.trimToSize();
		System.out.println(queue.toString());
		//초기화
		queue.clear();
		System.out.println(queue.size());
		
	}

}

package com.practice1;

public class ArrayList {
	public static void main(String[] args) {
		
		//배열 생성
		MyArrayList list = new MyArrayList();
		MyArrayList list1 = new MyArrayList(2);
		//추가
		list.add("홍길동");
		list.add("아무개");
		list.add("하하하");

		list1.add("홍길동");
		list1.add("아무개");
		list1.add("하하하");
		System.out.println(list1);
		
		//읽기
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list);
		//개수
		System.out.println(list.size());

		//탐색 + 읽기
		for (int i=0; i<list.size(); i++) {
		    System.out.println(list.get(i));
		}
		System.out.println();
		//수정
		list.set(0, "우하하");
		System.out.println(list.get(0));
		System.out.println(list);
		System.out.println();
		//삭제
		list.remove(1);
		for (int i=0; i<list.size(); i++) {
		    System.out.println(list.get(i));
		}
		System.out.println(list);
		System.out.println();
		//삽입
		list.add(1, "호호호");
		for (int i=0; i<list.size(); i++) {
		    System.out.println(list.get(i));
		}
		System.out.println(list);
		//검색(indexOf)
		if (list.indexOf("홍길동") > -1) {
		    System.out.println("홍길동 있음");
		} else {
		    System.out.println("홍길동 없음");
		}

		//초기화
		list.clear();
		System.out.println(list.size());

		//----------------------------------------

		//다시 추가
		list.add("홍길동");
		list.add("아무개");
		list.add("하하하");
		System.out.println(list);
		//검색(contains)
		System.out.println(list.contains("홍길동"));
		System.out.println(list.contains("호호호"));

		//빈 배열 확인
		System.out.println(list.isEmpty());
		list.clear();
		System.out.println(list.isEmpty());

		//다시 추가
		list.add("빨강");
		list.add("주황");
		list.add("노랑");
		list.add("초록");
		list.add("파랑");
		list.add("남색");
		list.add("보라");
		System.out.println(list);
		//부분 배열 추출
		MyArrayList rainbow = list.subList(2, 5);

		for (int i=0; i<rainbow.size(); i++) {
		    System.out.println(rainbow.get(i));
		}

	}
}

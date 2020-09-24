package com.test.dummy;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

public class concertPlaceDummy {
	public static void main(String[] args) {
		// 공연장 
		// 공연장 번호 seq => nextVal
		String name[] = {"노들섬 라이브하우스","벡스코 제1전시장 1홀","김화생활체육공원","그린플러그드","노천극장","농소운동장"
				,"한국소리문화의전당 야외공연장","베리어스 재즈클럽","대학로 아티스탄홀","예술의전당 앙상블홀","예스24스테이지 2관"
				,"광림아트센터 BBCH홀","블루스퀘어 인터파크홀","세종문화회관 S씨어터","동양예술극장2관","구세군아트홀","대학로 해피씨어터",
				"한해랑아트홀","예술의전당 자유소극장","롯데콘서트홀","예술의전당 IBK 챔버홀","뮤지엄 다","경복궁","오션플레이","코엑스 D홀"};
		ArrayList <String> addr = new ArrayList<String>();
		ArrayList <String> region = new ArrayList<String>();
		String[] a1 = {"서울시","인천시","대전시","광주시","부산시"};
		String[] a2 = {"동대문구","서대문구","중구","남대문구","북구"};
		String[] a3 = {"력삼동","대치동","논현동","양재동","도곡동"};
		for(int i=0;i<25;i++) {
			addr.add(a1[(int)(Math.random()*a1.length)]+ " "
					+a2[(int)(Math.random()*a2.length)] + " "
					+a3[(int)(Math.random()*a3.length)] + " "
					+((int)(Math.random()*30)+1)+"번지");
		}
		for(int i=0;i<25;i++) {
			region.add(addr.get(i).substring(0,2));
		}
//		String addr[] = {"서울특별시 용산구 양녕로 445","부산시 해운대구 APEC로 55벡스코 제1전시장 1홀","강원 철원군 김화읍 청양리",""};
//		String region[] = {"서울","부산","강원도","경주"};
		DBUtil util = new DBUtil();
		Connection conn = null;
		Statement stat = null;
		String sql = null;
		
		try {
//			conn = util.open("yoginolja.ccyezlxmksh2.ap-northeast-2.rds.amazonaws.com","Atticket","java1234");
//			stat = conn.createStatement();
			for(int i=0;i<25;i++) {
				System.out.println(String.format("insert into tblHall values(hallSeq.nextVal,'%s','%s','%s',default);",name[i],addr.get(i),region.get(i)));
//				sql = String.format("insert into tblHall values(hallSeq.nextVal(),%s,%s,%s,default)",name[i],addr.get(i),region.get(i));
//				stat.executeUpdate(sql);
			}
//			stat.close();
//			conn.close();
			
			
		} catch (Exception e) {
			System.out.println("concertDummy.main()");
			e.printStackTrace();
		}
		
	}
}

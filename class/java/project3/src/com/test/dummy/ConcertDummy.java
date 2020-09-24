package com.test.dummy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.Statement;

public class ConcertDummy {
	public static void main(String[] args) {
		
		//공연 이름
		// 콘서트 
		String name[] = {"Select Shop 콘서트","NELLA FANTASIA 포레스텔라","PHANTASTIC 노들섬 라이브 하우스","GREENPLUGGED GYEONGJU 2020","SEOUL FOREST JAZZ FESTIVAL 2020","팬텀싱어3 Concert","태사자 콘서트",
				"그랜드 민트 페이스티벌 2020","Christopher Live in Seoul 크리스토퍼 내한 공연","뻔하지않는듯 뻔한 페스티벌","SURL (설) concert 'Ah, ah, ah, ah What can I do?'",""};

//	File file = new File("D:\\파일_입출력_문제\\notepad.dat");
//		
//		BufferedWriter writer = null;
		
		//reader = new BufferedReader(new FileReader(file));
		
		DBUtil util = new DBUtil();
		Connection conn = null;
		Statement stat = null;
		String sql = null;
		String [] price = {"60000","70000","80000","90000","100000"};
		String [] post = {"concertpost","musicalpost","playpost","classicpost","displaypost"};
		String [] title = {"concert","musical","play","classic","display"};
		String [] genre = {"콘서트","뮤지컬","연극","클래식","전시"};
		File file = new File("D:\\프로젝트3\\공연더미.txt");
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//			conn = util.open("yoginolja.ccyezlxmksh2.ap-northeast-2.rds.amazonaws.com","Atticket","java1234");
//			stat = conn.createStatement();
			
//				insert into tblShow values(showSeq.nextVal,'제목',to_date('2020-07-01','YYYY-MM-DD'),to_date('2020-08-10','YYYY-MM-DD'),80000,music1.jpeg', 'music1post.jpeg',to_date('2020-06-29','YYYY-MM-DD'),15,'뮤지컬',10,default,1);
				int j = 0;
		
					for(int i=0;i<20;i++) {
						
						writer.write(String.format("insert into tblShow values(showSeq.nextVal,'%s',to_date('2020-07-01','YYYY-MM-DD'),to_date('2020-09-30','YYYY-MM-DD'),%s,'%s%d.jpeg','%s%d.jpeg',to_date('2020-06-29','YYYY-MM-DD'),15,'%s',%d,default,%d);"
																									,"공연제목",price[0],title[0],i+1,post[0],i+1,genre[0],(int)(Math.random()*10)+1,i+1));
						writer.newLine();
						
					}
					
					for(int i=0;i<20;i++) {
					
						writer.write(String.format("insert into tblShow values(showSeq.nextVal,'%s',to_date('2020-07-01','YYYY-MM-DD'),to_date('2020-09-30','YYYY-MM-DD'),%s,'%s%d.jpeg','%s%d.jpeg',to_date('2020-06-29','YYYY-MM-DD'),15,'%s',%d,default,%d);"
																									,"공연제목",price[1],title[1],i+1,post[1],i+1,genre[1],(int)(Math.random()*10)+1,i+21));
						writer.newLine();
					}
					
					for(int i=0;i<20;i++) {
					
						writer.write(String.format("insert into tblShow values(showSeq.nextVal,'%s',to_date('2020-07-01','YYYY-MM-DD'),to_date('2020-09-30','YYYY-MM-DD'),%s,'%s%d.jpeg','%s%d.jpeg',to_date('2020-06-29','YYYY-MM-DD'),15,'%s',%d,default,%d);"
																									,"공연제목",price[2],title[2],i+1,post[2],i+1,genre[2],(int)(Math.random()*10)+1,i+41));
						writer.newLine();
						
					}
					

					for(int i=0;i<20;i++) {
						
						writer.write(String.format("insert into tblShow values(showSeq.nextVal,'%s',to_date('2020-07-01','YYYY-MM-DD'),to_date('2020-09-30','YYYY-MM-DD'),%s,'%s%d.jpeg','%s%d.jpeg',to_date('2020-06-29','YYYY-MM-DD'),15,'%s',%d,default,%d);"
																									,"공연제목",price[3],title[3],i+1,post[3],i+1,genre[3],(int)(Math.random()*10)+1,i+61));
						writer.newLine();
					}
					

					for(int i=0;i<20;i++) {
						writer.write(String.format("insert into tblShow values(showSeq.nextVal,'%s',to_date('2020-07-01','YYYY-MM-DD'),to_date('2020-09-30','YYYY-MM-DD'),%s,'%s%d.jpeg','%s%d.jpeg',to_date('2020-06-29','YYYY-MM-DD'),15,'%s',%d,default,%d);"
																									,"공연제목",price[4],title[4],i+1,post[4],i+1,genre[4],(int)(Math.random()*10)+1,i+81));
						writer.newLine();
					}
					int l=0;
					for(int i=0;i<5;i++) {
						for(int k=0;k<20;k++) {
							l++;
							writer.write(String.format("update tblShow set  poster = '%s%d.jpeg' where seq = %d;",title[i],(k+1),l));
							writer.newLine();
						}
					}
					
					writer.close();
					System.out.println("완료");
//				sql = String.format("insert into tblHall values(hallSeq.nextVal(),%s,%s,%s,default)",name[i],addr.get(i),region.get(i));
//				stat.executeUpdate(sql);
			
//			stat.close();
//			conn.close();
			
			
		} catch (Exception e) {
			System.out.println("concertDummy.main()");
			e.printStackTrace();
		}
		
		
	}

}

package com.subway;

import java.util.ArrayList;

/**
 * 
 * @author siyeon
 * 5호선 까치산 - 마천 방면 더미 데이터 클래스 입니다.
 */
public class SubwayDummy {
	public static void main(String[] args) {
		Station sta127 = new Station();
		Station sta128 = new Station();
		Station sta129 = new Station();
		Station sta130 = new Station();
		Station sta131 = new Station();
		Station sta132 = new Station();
		Station sta133 = new Station();
		Station sta134 = new Station();
		Station sta135 = new Station();
		Station sta136 = new Station();
		Station sta137 = new Station();
		Station sta138 = new Station();
		Station sta139 = new Station();
		Station sta140 = new Station();
		Station sta141 = new Station();
		Station sta142 = new Station();
		Station sta143 = new Station();
		Station sta144 = new Station();
		Station sta145 = new Station();
		Station sta146 = new Station();
		Station sta147 = new Station();
		Station sta148 = new Station();
		Station sta149 = new Station();
		Station sta150 = new Station();
		Station sta151 = new Station();
		Station sta152 = new Station();
		Station sta153 = new Station();
		Station sta154 = new Station();
		Station sta155 = new Station();
		Station sta156 = new Station();
		Station sta157 = new Station();
		Station sta158 = new Station();
		Station sta159 = new Station();
		Station sta160 = new Station();
		Station sta161 = new Station();
		Station sta162 = new Station();
		Station sta163 = new Station();
		Station sta164 = new Station();
		Station sta165 = new Station();
		
		
		sta127.line = 5;
		sta127.name = "까치산";
		sta127.next = sta128;
		sta127.transfer = false;
		
		sta128.line = 5;
		sta128.name = "신정";
		sta128.next = sta129;
		sta128.prev = sta128;
		sta128.transfer = false;
		
		sta129.line = 5;
		sta129.name = "목동";
		sta129.next = sta130;
		sta129.prev = sta128;
		sta129.transfer = false;
		
		sta130.line = 5;
		sta130.name = "오목교";
		sta130.next = sta131;
		sta130.prev = sta129;
		sta130.transfer = false;
		
		sta131.line = 5;
		sta131.name = "양평";
		sta131.next = sta132;
		sta131.prev = sta130;
		sta131.transfer = false;
		
		sta132.line = 5;
		sta132.name = "영등포구청";
		sta132.next = sta133;
		sta132.prev = sta131;
		sta132.transfer = false;
		
		sta133.line = 5;
		sta133.name = "영등포구청";
		sta133.next = sta134;
		sta133.prev = sta132;
		sta133.transfer = false;
		
		sta134.line = 5;
		sta134.name = "영등포시장";
		sta134.next = sta135;
		sta134.prev = sta133;
		sta134.transfer = false;
		
		sta135.line = 5;
		sta135.name = "신길";
		sta135.next = sta136;
		sta135.prev = sta134;
		sta135.transfer = false;
		
		sta136.line = 5;
		sta136.name = "여의도";
		sta136.next = sta137;
		sta136.prev = sta135;
		sta136.transfer = false;
		
		sta137.line = 5;
		sta137.name = "여의나루";
		sta137.next = sta138;
		sta137.prev = sta136;
		sta137.transfer = false;
		
		sta138.line = 5;
		sta138.name = "마포";
		sta138.next = sta139;
		sta138.prev = sta137;
		sta138.transfer = false;
		
		sta139.line = 5;
		sta139.name = "공덕";
		sta139.next = sta140;
		sta139.prev = sta138;
		sta139.transfer = false;
		
		sta140.line = 5;
		sta140.name = "애오개";
		sta140.next = sta141;
		sta140.prev = sta139;
		sta140.transfer = false;
		
		sta141.line = 5;
		sta141.name = "충정로";
		sta141.next = sta142;
		sta141.prev = sta141;
		sta141.transfer = false;
		
		sta142.line = 5;
		sta142.name = "서대문";
		sta142.next = sta143;
		sta142.prev = sta141;
		sta142.transfer = false;
		
		sta143.line = 5;
		sta143.name = "광화문";
		sta143.next = sta144;
		sta143.prev = sta142;
		sta143.transfer = false;
		
		sta144.line = 5;
		sta144.name = "종로3가";
		sta144.next = sta145;
		sta144.prev = sta143;
		sta144.transfer = false;
		
		sta145.line = 5;
		sta145.name = "을지로4가";
		sta145.next = sta146;
		sta145.prev = sta144;
		sta145.transfer = false;
		
		sta146.line = 5;
		sta146.name = "동대문역사문화공원";
		sta146.next = sta147;
		sta146.prev = sta145;
		sta146.transfer = false;
		
		sta147.line = 5;
		sta147.name = "청구";
		sta147.next = sta148;
		sta147.prev = sta146;
		sta147.transfer = false;
		
		sta148.line = 5;
		sta148.name = "신금호";
		sta148.next = sta149;
		sta148.prev = sta147;
		sta148.transfer = false;
		
		sta149.line = 5;
		sta149.name = "행당";
		sta149.next = sta150;
		sta149.prev = sta148;
		sta149.transfer = false;
		
		sta150.line = 5;
		sta150.name = "왕십리";
		sta150.next = sta151;
		sta150.prev = sta149;
		sta150.transfer = false;
		
		sta151.line = 5;
		sta151.name = "마장";
		sta151.next = sta152;
		sta151.prev = sta150;
		sta151.transfer = false;
		
		sta152.line = 5;
		sta152.name = "답십리";
		sta152.next = sta153;
		sta152.prev = sta151;
		sta152.transfer = false;
		
		sta153.line = 5;
		sta153.name = "장한평";
		sta153.next = sta154;
		sta153.prev = sta152;
		sta153.transfer = false;
		
		sta154.line = 5;
		sta154.name = "군자";
		sta154.next = sta155;
		sta154.prev = sta153;
		sta154.transfer = false;
		
		sta155.line = 5;
		sta155.name = "아차산";
		sta155.next = sta156;
		sta155.prev = sta154;
		sta155.transfer = false;
		
		sta156.line = 5;
		sta156.name = "광나루";
		sta156.next = sta157;
		sta156.prev = sta155;
		sta156.transfer = false;
		
		sta157.line = 5;
		sta157.name = "천호";
		sta157.next = sta158;
		sta157.prev = sta156;
		sta157.transfer = false;
		
		sta158.line = 5;
		sta158.name = "강동";
		sta158.next = sta159;
		sta158.prev = sta157;
		sta158.transfer = true;
		
		sta159.line = 5;
		sta159.name = "둔촌동";
		sta159.next = sta160;
		sta159.prev = sta158;
		sta159.transfer = false;
		
		sta160.line = 5;
		sta160.name = "올림픽공원";
		sta160.next = sta161;
		sta160.prev = sta159;
		sta160.transfer = false;
		
		sta161.line = 5;
		sta161.name = "방이";
		sta161.next = sta162;
		sta161.prev = sta160;
		sta161.transfer = false;
		
		sta162.line = 5;
		sta162.name = "오금";
		sta162.next = sta163;
		sta162.prev = sta161;
		sta162.transfer = false;
		
		sta163.line = 5;
		sta163.name = "개롱";
		sta163.next = sta164;
		sta163.prev = sta162;
		sta163.transfer = false;
		
		sta164.line = 5;
		sta164.name = "거여";
		sta164.next = sta165;
		sta164.prev = sta163;
		sta164.transfer = false;
		
		sta165.line = 5;
		sta165.name = "마천";
		sta165.prev = sta164;
		sta165.transfer = false;
		
		ArrayList<Station> line51 = new ArrayList<Station>();
		//127 ~ 165
		for(int i=127;i<=165;i++) {
			String m = "sta"+i;
			System.out.println("line51.add("+m+");");
			
		}
		line51.add(sta127);
		line51.add(sta128);
		line51.add(sta129);
		line51.add(sta130);
		line51.add(sta131);
		line51.add(sta132);
		line51.add(sta133);
		line51.add(sta134);
		line51.add(sta135);
		line51.add(sta136);
		line51.add(sta137);
		line51.add(sta138);
		line51.add(sta139);
		line51.add(sta140);
		line51.add(sta141);
		line51.add(sta142);
		line51.add(sta143);
		line51.add(sta144);
		line51.add(sta145);
		line51.add(sta146);
		line51.add(sta147);
		line51.add(sta148);
		line51.add(sta149);
		line51.add(sta150);
		line51.add(sta151);
		line51.add(sta152);
		line51.add(sta153);
		line51.add(sta154);
		line51.add(sta155);
		line51.add(sta156);
		line51.add(sta157);
		line51.add(sta158);
		line51.add(sta159);
		line51.add(sta160);
		line51.add(sta161);
		line51.add(sta162);
		line51.add(sta163);
		line51.add(sta164);
		line51.add(sta165);

		
	}
	

}

class Station {

	   public int line; //호선
	   public String name; //이름
	   public Station next; //다음역
	   public Station prev; //이전역
	   public boolean transfer; //환승여부
}
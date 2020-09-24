package com.test.project;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.test.jdbc.DBUtil;

import oracle.jdbc.OracleTypes;
// result로 에러처리했음
public class adminManagement {
	public static void main(String[] args) {
		
		//vwopenCourseSubject(); /*특정 개설 과정 선택시 개설 과정에 등록된 개설 과목 정보(과목명, 과목기간(시작 년월일, 끝 년월일), 교재명, 교사명) 및 등록된 교육생 정보(교육생 이름, 주민번호 뒷자리, 전화번호, 등록일, 수료 및 중도탈락)을 확인할 수 있어야 한다.*/
		//vwopenCourseInfo(); /*개설 과정 정보 출력시 개설 과정명, 개설 과정기간(시작 년월일, 끝 년월일), 강의실명, 개설 과목 등록 여부, 교육생 등록 인원을 출력한다.*/
		//procopenCourse(); /*과정 정보는 과정명, 과정기간(시작 년월일, 끝 년월일), 강의실 정보를 입력한다.*/
		//procopenCourseInsert(); /*개설 과정 정보에 대한 입력, 출력, 수정, 삭제 기능을 사용할 수 있어야 한다.*/ // => 입력
		//procopenCourseUpdate(); /*개설 과정 정보에 대한 입력, 출력, 수정, 삭제 기능을 사용할 수 있어야 한다.*/ // => 수정
		//procopenCourseDelete(); /*개설 과정 정보에 대한 입력, 출력, 수정, 삭제 기능을 사용할 수 있어야 한다.*/ // => 삭제
		//vwopenCourse(); /*개설 과정 정보에 대한 입력, 출력, 수정, 삭제 기능을 사용할 수 있어야 한다.*/ // => 출력
		//procBasicClassroom(); /*강의실 정보는 기초 정보 강의실명에서 선택적으로 추가할 수 있어야 한다.*/ 
		vwopenCourseSelectEndDate(); /*특정 개설 과정이 수료한 경우 등록된 교육생 전체에 대해서 수료날짜를 지정할 수 있어야 한다. 단, 중도 탈락자는 제외한다. */ 
	}

	private static void vwopenCourseSelectEndDate() {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		Statement stat1 = null;
		DBUtil util = new DBUtil();
		Scanner scan = new Scanner(System.in);
		String sql = null;
		System.out.println("*** 특정 개설 과정이 수료한 경우 등록된 교육생 전체에 대해서 수료날짜를 지정 ***");
		try {
			conn = util.open("211.63.89.64","project","java1234");
			
			sql = "{call  procstudentEndDate(?,?)}";
			stat = conn.prepareCall(sql);
			stat1 = conn.createStatement();
			sql = "select * from vwopenCourseSelectEndDate";
			rs = stat1.executeQuery(sql);
			
			while(rs.next()) {
				System.out.printf("%s\t",rs.getString("courseHistoryNum"));
				System.out.printf("%s\t",rs.getString("openCourseNum"));
				System.out.printf("%s\t",rs.getString("status"));
				System.out.printf("%s\t",rs.getString("student name"));
				System.out.printf("%s\t",rs.getString("endDate"));
				System.out.println();
				
			}
			
			System.out.print("특정 개설 과정 번호(courseHistoryNum):");
			String openCourseNum = scan.nextLine();
			System.out.println("[과정 수료 날짜]");
			System.out.print("과정 수료 년(yyyy):");
			String endyear = scan.nextLine();
			System.out.print("과정 수료 월(mm):");
			String endmonth = scan.nextLine();
			System.out.print("과정 수료 일(dd):");
			String endday = scan.nextLine();
		
			stat.setString(1, endyear+endmonth+endday);
			stat.setString(2, openCourseNum);
			
			stat.executeUpdate();
			
			stat.close();
			conn.close();
			System.out.println("완료");
		} catch (Exception e) {
			System.out.println("adminManagement.vwopenCourseSelectEndDate()");
			e.printStackTrace();
		}
	}

	private static void procBasicClassroom() {
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		CallableStatement stat1 = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("*** 강의실 정보는 기초 정보 강의실명에서 선택적으로 추가 ***");
		try {
			conn = util.open("211.63.89.64","project","java1234");
			
			stat = conn.createStatement(); 
			String sql = "select * from vwopenCourseClassRoom";
			rs = stat.executeQuery(sql);
			System.out.println("[개설 강좌 번호]\t[시작 날짜]\t[종료 날짜]\t[강의실 번호]");
			while(rs.next()) {
				System.out.printf("%s\t",rs.getString("opening course number"));
				System.out.printf("%s\t",rs.getString("startDate"));
				System.out.printf("%s\t",rs.getString("endDate"));
				System.out.printf("%s\t",rs.getString("classRoomNum"));
				System.out.println();
			}
			sql = "{ call procBasicClassroom(?,?) }";
	
			stat1 = conn.prepareCall(sql);
			System.out.print("수정할 개설 강좌번호:");
			String num = scan.nextLine();
			stat1.setString(1,num);
			System.out.print("강의실 번호:");
			String classroom = scan.nextLine();
			stat1.setString(2, classroom);
			stat1.executeUpdate();
			
			conn.close();
			stat.close();
			stat1.close();
			rs.close();
			System.out.println("완료");
		} catch (Exception e) {
			System.out.println("adminManagement.procBasicClassroom()");
			e.printStackTrace();
		}
	}

	private static void vwopenCourse() {
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		System.out.println("*** 개설 과정 정보에 대한 출력 기능 ***");
		try {
			conn = util.open("211.63.89.64","project","java1234");
			//conn = util.open("localhost","project","java1234");
			stat = conn.createStatement(); //쿼리를 날릴 수 있는 개체
			String sql = "select * from vwopenCourse";
			rs = stat.executeQuery(sql);
			System.out.println("[openCourseNum]\t[startDate]\t[endDate]\t[classRoomNum]\t[teacherNum]\t[allCourseNum]\t[status]");
			while(rs.next()) {
				//System.out.printf("%s\t",rs.getString("num"));
				System.out.printf("%s\t",rs.getString("num"));
				System.out.printf("%s\t",rs.getString("startDate"));
				System.out.printf("%s\t",rs.getString("endDate"));
				System.out.printf("%s\t",rs.getString("classRoomNum"));
				System.out.printf("%s\t",rs.getString("teacherNum"));
				System.out.printf("%s\t",rs.getString("allCourseNum"));
				System.out.printf("%s\t",rs.getString("status"));
				System.out.println();
			}
			stat.close();
			conn.close();	
			rs.close();
		} catch (Exception e) {
			System.out.println("adminManagement.vwopenCourse()");
			e.printStackTrace();
		}
	}

	private static void procopenCourseDelete() {

		Connection conn = null;
		CallableStatement stat = null;
		DBUtil util = new DBUtil();
		
		Scanner scan = new Scanner(System.in);
		
		String num = null;
		System.out.println("*** 개설 과정 정보에 대한 삭제 기능 ***");
		try {
			vwopenCourse();
			conn = util.open("211.63.89.64","project","java1234");
			
			//conn = util.open("localhost","project","java1234");
			String sql = "{ call procopenCourseDelete(?) }";
			stat = conn.prepareCall(sql);
			System.out.print("삭제할 시행 과정 번호:");
			num = scan.nextLine();
			stat.setString(1,num);
			stat.executeUpdate();
			
			stat.close();
			conn.close();
			System.out.println("완료");
			
		} catch (Exception e) {
			System.out.println("adminManagement.procopenCourseDelete()");
			e.printStackTrace();
		}
		
	}

	private static void procopenCourseUpdate() {
		
		Connection conn = null;
		CallableStatement stat = null;
		DBUtil util = new DBUtil();
		ResultSet rs = null;
		Statement stat1 = null;
		
		Scanner scan = new Scanner(System.in);
		
		String sql = null;
		
		String ostartDate = null;
		String oendDate = null;
		String oclassRoomNum = null;
		String oteacherNum = null;
		String oallCourseNum = null;
		
		System.out.println("개설 과정 정보에 대한 수정 기능");
		try {
			conn = util.open("211.63.89.64","project","java1234");
		
			sql = "select * from vwopenCourseSelect";
			stat1 = conn.createStatement();
			rs = stat1.executeQuery(sql);
			System.out.println("[openCourseNum]\t[openCourse name]");
			while(rs.next()) {
				System.out.printf("%s\t",rs.getString("openCourseNum"));
				System.out.printf("%s\t",rs.getString("openCourse name"));
				System.out.println();
			}
			stat1.close();
			sql = "{ call procopenCourseSelect(?,?) }";
			stat = conn.prepareCall(sql);
			System.out.print("시행 과정 번호:");
			String num = scan.nextLine();
			stat.setString(1, num);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			rs = (ResultSet)stat.getObject(2); 
			String a = null;
			String b = null;
			if (rs.next()) {
				ostartDate=rs.getString("startDate");
				oendDate=rs.getString("endDate");
				oclassRoomNum=rs.getString("classRoomNum");
				oteacherNum=rs.getString("teacherNum");
				oallCourseNum=rs.getString("allCourseNum");
			}
			
		
			rs.close();
			

			System.out.println("----------------------");
			System.out.println("1. 과정 시작 날짜 수정");
			System.out.println("2. 과정 종료 날짜 수정");
			System.out.println("3. 과정 강의실 번호 수정");
			System.out.println("4. 선생님 번호 수정");
			System.out.println("5. 과정 번호 수정");
			System.out.println("----------------------");
			System.out.print("번호(선택):");
			String n = scan.nextLine();
			System.out.println("----------------------");
			//질문
			switch(n) {
				case "1":
					System.out.print("과정 시작 년(yyyy):");
					String start_year = scan.nextLine();
					System.out.print("과정 시작 월(mm):");
					String start_month = scan.nextLine();
					System.out.print("과정 시작 일(dd):");
					String start_day = scan.nextLine();
					////String sql = "update tblAddress set age = age + 1";
					//String startDate = start_year + start_month + start_day;
					
					sql = "{call procopenCourseUpdate(?,?,?,?,?,?)}";
					stat = conn.prepareCall(sql);
					stat.setString(1,num);
					stat.setString(2, start_year+start_month+start_day);
					a = oendDate.substring(0,10);  //yyyy-mm-dd hh:mm:ss
					oendDate = a.replace("-","");
					stat.setString(3, oendDate);
					stat.setString(4, oclassRoomNum);
					stat.setString(5, oteacherNum);
					stat.setString(6, oallCourseNum);
					stat.executeUpdate();
					
					stat.close();
					System.out.println("완료");
					break;
				case "2":
					System.out.print("과정 종료 년(yyyy):");
					String end_year = scan.nextLine();
					System.out.print("과정 종료 월(mm):");
					String end_month = scan.nextLine();
					System.out.print("과정 종료 일(dd):");
					String end_day = scan.nextLine();
					////String sql = "update tblAddress set age = age + 1";
					//String endDate = end_year + end_month + end_day;
					
					sql = "{call procopenCourseUpdate(?,?,?,?,?,?)}";
					stat = conn.prepareCall(sql); // 질문
					stat.setString(1,num);
					b = ostartDate.substring(0,10);
					ostartDate = b.replace("-","");
					stat.setString(2, ostartDate);
					stat.setString(3, end_year+end_month+end_day);
					stat.setString(4, oclassRoomNum);
					stat.setString(5, oteacherNum);
					stat.setString(6, oallCourseNum);
					stat.executeUpdate();
					
					stat.close();
					System.out.println("완료");
					break;
				case "3":
					System.out.print("과정 강의실 번호:");
					String classRoomNum = scan.nextLine();
					sql = "{call procopenCourseUpdate(?,?,?,?,?,?)}";
					stat = conn.prepareCall(sql);
					a = oendDate.substring(0,10);
					oendDate = a.replace("-","");
					b = ostartDate.substring(0,10);
					ostartDate = b.replace("-","");
					stat.setString(1,num);
					stat.setString(2, ostartDate);
					stat.setString(3, oendDate);
					stat.setString(4, classRoomNum);
					stat.setString(5, oteacherNum);
					stat.setString(6, oallCourseNum);
					stat.executeUpdate();
					
					stat.close();
					System.out.println("완료");
					break;
				case "4":
					System.out.print("선생님 번호:");
					String teacherNum = scan.nextLine();
					sql = "{call procopenCourseUpdate(?,?,?,?,?,?)}";
					stat = conn.prepareCall(sql);
					a = oendDate.substring(0,10);
					oendDate = a.replace("-","");
					b = ostartDate.substring(0,10);
					ostartDate = b.replace("-","");
					stat.setString(1,num);
					stat.setString(2, ostartDate);
					stat.setString(3, oendDate);
					stat.setString(4, oclassRoomNum);
					stat.setString(5, teacherNum);
					stat.setString(6, oallCourseNum);
					stat.executeUpdate();
					
					stat.close();
					System.out.println("완료");
					break;
				case "5":
					System.out.print("과정 번호:");
					String allCourseNum = scan.nextLine();
					sql = "{call procopenCourseUpdate(?,?,?,?,?,?)}";
					stat = conn.prepareCall(sql);
					a = oendDate.substring(0,10);
					oendDate = a.replace("-","");
					b = ostartDate.substring(0,10);
					ostartDate = b.replace("-","");
					stat.setString(1,num);
					stat.setString(2, ostartDate);
					stat.setString(3, oendDate);
					stat.setString(4, oclassRoomNum);
					stat.setString(5, oteacherNum);
					stat.setString(6, allCourseNum);
					stat.executeUpdate();
					
					stat.close();
					System.out.println("완료");
					break;
			
			}
			stat.close();
			conn.close();
			//20101009 'yyyymmdd'
		} catch (Exception e) {
			System.out.println("adminManagement.procopenCourseUpdate()");
			e.printStackTrace();
		}
		
		
	}

	private static void procopenCourseInsert() {
		
		Connection conn = null;
		CallableStatement stat = null;
		DBUtil util = new DBUtil();
		System.out.println("*** 과정 정보는 과정명, 과정기간, 강의실 정보를 입력 ***");
		System.out.println("개설 과정 정보에 대한 입력 기능");
		Scanner scan = new Scanner(System.in);
		System.out.println("[개설 과정 정보 시작날짜]");
		
		System.out.print("시작날짜 년(yyyy):");
		String startyear = scan.nextLine();
		System.out.print("시작날짜 월(mm):");
		String startmonth = scan.nextLine();
		System.out.print("시작날짜 일(dd):");
		String startday = scan.nextLine();

		System.out.println("[개설 과정 정보 종료날짜]");
		System.out.print("종료날짜 년(yyyy):");
		String endyear = scan.nextLine();
		System.out.print("종료날짜 월(mm):");
		String endmonth = scan.nextLine();
		System.out.print("종료날짜 일(dd):");
		String endday = scan.nextLine();
		
		System.out.print("개설 과정 반 번호:");
		String classroom = scan.nextLine();
		System.out.print("선생님 번호:");
		String teacherNum = scan.nextLine();
		System.out.print("과정 정보: ");
		String allCourseNum = scan.nextLine();
		
		try {
			
			conn = util.open("211.63.89.64","project","java1234");
			
			String sql = "{ call procopenCourseInsert(?,?,?,?,?) }";
			stat = conn.prepareCall(sql);
			stat.setString(1, startyear+startmonth+startday);
			stat.setString(2, endyear+endmonth+endday);
			stat.setString(3, classroom);
			stat.setString(4, teacherNum);
			stat.setString(5, allCourseNum);
			
			stat.executeUpdate();
			
			stat.close();
			conn.close();
			
			System.out.println("완료");
		} catch (Exception e) {
			System.out.println("adminManagement.procopenCourseInsert()");
			e.printStackTrace();
		}
		
		
	}

	private static void procopenCourse() {
		Connection conn = null;
		CallableStatement stat = null;
		DBUtil util = new DBUtil();
		System.out.println("*** 과정 정보는 과정명, 과정기간(시작 년월일, 끝 년월일), 강의실 정보를 입력 ***");
		Scanner scan = new Scanner(System.in);
		System.out.println("개설 과정 정보 시작날짜");

		System.out.print("시작날짜 년(yyyy):");
		String startyear = scan.nextLine();
		System.out.print("시작날짜 월(mm):");
		String startmonth = scan.nextLine();
		System.out.print("시작날짜 일(dd):");
		String startday = scan.nextLine();
	
		
		System.out.println("개설 과정 정보 종료날짜");
		System.out.print("종료날짜 년(yyyy):");
		String endyear = scan.nextLine();
		System.out.print("종료날짜 월(mm):");
		String endmonth = scan.nextLine();
		System.out.print("종료날짜 일(dd):");
		String endday = scan.nextLine();
	
		
		System.out.print("강의실 번호:");
		String classRoomNum = scan.nextLine();
		System.out.print("과정 번호:");
		String allCourseNum = scan.nextLine();
		
		try {
		
			conn = util.open("211.63.89.64","project","java1234");
			
			String sql = "{ call procopenCourse(?,?,?,?) }";
			stat = conn.prepareCall(sql);
			//num,startDate,endDate,classRoomNum,allCourseNum,status
			stat.setString(1,startyear+startmonth+startday);
			stat.setString(2,endyear+endmonth+endday);
			stat.setString(3,classRoomNum);
			stat.setString(4,allCourseNum);
			
			stat.executeUpdate();
			
			stat.close();
			conn.close();
			
			System.out.println("완료");
		} catch (Exception e) {
			System.out.println("adminManagement.procopenCourse()");
			e.printStackTrace();
		}
		
	}

	private static void vwopenCourseInfo() {
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		System.out.println("*** 개설 과정 정보 출력시 개설 과정명, 개설 과정기간, 강의실명, 개설 과목 등록 여부, 교육생 등록 인원을 출력 ***");
		System.out.println("[opening course name]\t[opening course period]\t[classroom name]\t[register opening course]\t[trainee registration personnel]");
		try {
			conn = util.open("211.63.89.64","project","java1234");
			stat = conn.createStatement(); //쿼리를 날릴 수 있는 개체
			String sql = "select * from vwopenCourseInfo";
			
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				System.out.printf("%s\t",rs.getString("opening course name"));
				System.out.printf("%s\t",rs.getString("opening course period"));
				System.out.printf("%s\t",rs.getString("classroom name"));
				System.out.printf("%s\t",rs.getString("register opening course"));
				System.out.printf("%s\t",rs.getString("trainee registration personnel"));
				System.out.println();
			}
			conn.close();
			stat.close();
			rs.close();
			System.out.println("완료");
		} catch (Exception e) {
			System.out.println("adminManagement.vwopenCourseInfo()");
			e.printStackTrace();
		}
		
	}

	private static void vwopenCourseSubject() {
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		System.out.println("특정 개설 과정 선택시 개설 과정에 등록된 개설 과목 정보(과목명, 과목기간 및 등록된 교육생 정보");
		System.out.println("[subjectname]\t[Subject duration]\t[textbook name]\t[teacher name]\t[student name]\t[ssn]\t[tel]\t[registration date]\t[completion status]");
		try {
			conn = util.open("211.63.89.64","project","java1234");
			stat = conn.createStatement(); //쿼리를 날릴 수 있는 개체
			String sql = "select * from vwopenCourseSubject";
			
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				System.out.printf("%s\t",rs.getString("subjectname"));
				System.out.printf("%s\t",rs.getString("Subject duration"));
				System.out.printf("%s\t",rs.getString("textbook name"));
				System.out.printf("%s\t",rs.getString("teacher name"));
				System.out.printf("%s\t",rs.getString("student name"));
				System.out.printf("%s\t",rs.getString("ssn"));
				System.out.printf("%s\t",rs.getString("tel"));
				System.out.printf("%s\t",rs.getString("registration date"));
				System.out.printf("%s\t",rs.getString("completion status"));
				System.out.println();
			}
			conn.close();
			rs.close();
			stat.close();
			
		} catch (Exception e) {
			System.out.println("adminManagement.vwopenCourseSubject()");
			e.printStackTrace();
		}
		
	}

}

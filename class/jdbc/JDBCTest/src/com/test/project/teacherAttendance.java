package com.test.project;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.test.jdbc.DBUtil;

import oracle.jdbc.OracleTypes;

//예외처리 할게 없음
public class teacherAttendance {
	public static void main(String[] args) {
		procteacherAttendance1(3); /*출결 현황을 기간별(년, 월, 일) 조회할 수 있어야 한다.*/
		//procteacherAttendanceSelect(3); /*특정(특정 과정, 특정 인원) 출결 현황을 조회할 수 있어야 한다.*/ 
		//procteacherAttendanceStatus(3); /*모든 출결 조회는 근태 상황을 구분할 수 있어야 한다.(정상, 지각, 조퇴, 외출, 병가(결석) 단서가 관리자 업무 수정하는 업무, 기타)*/ 
		//procteacherAttendance(4); /*교사가 강의한 과정에 한해 선택하는 경우 모든 교육생의 출결을 조회할 수 있어야 한다.*/
	} 
//아주 중요한 것 아니면 유효성 검사를 해야 돼 , 에러 처리 result 
	
	private static void procteacherAttendanceStatus(int pteacherNum) {
		
		Connection conn = null;
		ResultSet rs = null;
		CallableStatement stat = null;
		DBUtil util = new DBUtil();
		Scanner scan = new Scanner(System.in);
		String sql = null;
		System.out.println("*** 선생님 출결 조회 ***");
		try {
			conn = util.open("211.63.89.64","project","java1234");
			sql = "{call procteacherAttendanceStatus(?,?,?,?)}";
			stat = conn.prepareCall(sql);
			stat.registerOutParameter(1,OracleTypes.CURSOR); 
			System.out.print("년(yyyy):");
			String year = scan.nextLine();
			System.out.print("월(mm):");
			String month = scan.nextLine();
			
			stat.setString(2, year);
			stat.setString(3, month);
			stat.setInt(4, pteacherNum);
			stat.executeQuery();
			rs = (ResultSet)stat.getObject(1);
		
			System.out.println("[student name]\t[enterTime]\t[outTime]\t[attendance status]\t[openCourseNum]");
			while(rs.next()) {				
				System.out.printf("%s\t",rs.getString("student name"));
				System.out.printf("%s\t",rs.getString("enterTime"));
				System.out.printf("%s\t",rs.getString("outTime"));
				System.out.printf("%s\t",rs.getString("attendance status"));
				System.out.printf("%s\t",rs.getString("openCourseNum"));
				System.out.println();
			}
			
			
		} catch (Exception e) {
			System.out.println("teacherAttendance.procteacherAttendanceStatus()");
			e.printStackTrace();
		}
		
		
	}

	private static void procteacherAttendanceSelect(int pteacherNum) {
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		Statement stat1 = null;
		DBUtil util = new DBUtil();
		
		String sql = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("*** 선생님 특정과정,특정인원 출결현황 조회 ***");
		try {
			conn = util.open("211.63.89.64","project","java1234");
			
			sql =String.format("select * from vwcourseHistory where teacherNum = %d",pteacherNum);
			stat1 = conn.createStatement();
			rs=stat1.executeQuery(sql);
			
			System.out.println("[student name]\t[openCourseNum]\t[student num]");
			while(rs.next()) {
				System.out.printf("%s\t",rs.getString("student name"));
				System.out.printf("%s\t",rs.getString("openCourseNum"));
				System.out.printf("%s\t",rs.getString("student num"));
				System.out.println();
			}
			
			System.out.print("개설 강좌 번호(특정 과정):");
			String num = scan.nextLine();
			System.out.print("학생 번호:");
			String name = scan.nextLine();
			
			sql = "{call procteacherAttendanceSelect(?,?,?,?)}";
			stat=conn.prepareCall(sql);
			stat.registerOutParameter(1,OracleTypes.CURSOR); 
			stat.setString(2, num);
			stat.setString(3, name);
			stat.setInt(4, pteacherNum);
			
			stat.executeQuery();
			rs = (ResultSet)stat.getObject(1);
			System.out.println("[course period]\t[course name]\t[enterTime]\t[outTime]\t[student name]");
			while(rs.next()) {
				System.out.printf("%s\t",rs.getString("course period"));
				System.out.printf("%s\t",rs.getString("course name"));
				System.out.printf("%s\t",rs.getString("enterTime"));
				System.out.printf("%s\t",rs.getString("outTime"));
				System.out.printf("%s\t",rs.getString("student name"));
				System.out.println();
			}
			rs.close();
			conn.close();
			stat.close();
			
		} catch (Exception e) {
			System.out.println("teacherAttendance.procteacherAttendanceSelect");
			e.printStackTrace();
		}
		
		
	}

	private static void procteacherAttendance1(int pteacherNum) {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		
		String sql = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("*** 선생님 출결 현황을 기간별(년, 월, 일) 조회 ***");
		System.out.println("------------------------");
		System.out.println("1. 년 조회");
		System.out.println("2. 월 조회");
		System.out.println("3. 일 조회");
		System.out.println("------------------------");
		System.out.print("번호: ");
		String num = scan.nextLine();
		System.out.println("------------------------");
		try {
			conn = util.open("211.63.89.64","project","java1234");
			
			switch(num) {
			case "1": 
				sql = "{call procteacherAttendance1(?,?,?)}";
				stat = conn.prepareCall(sql);
				stat.registerOutParameter(1,OracleTypes.CURSOR); 
				System.out.print("년(yyyy):");
				String year = scan.nextLine();
				stat.setString(2,year);
				stat.setInt(3, pteacherNum);
				stat.executeQuery(); // 다 넣고 업데이트임
				rs = (ResultSet)stat.getObject(1);
				System.out.println("[openCourseNum]\t[student name]\t[enterTime]\t\t\t[outTime]\t\t[attendance status]\t[course status]");
				while(rs.next()) {
					System.out.printf("%s\t\t",rs.getString("openCourseNum"));
					System.out.printf("%s\t\t",rs.getString("student name"));
					System.out.printf("%s\t\t",rs.getString("enterTime"));
					System.out.printf("%s\t\t",rs.getString("outTime"));
					System.out.printf("%s\t\t",rs.getString("attendance status"));
					System.out.printf("%s\t\t",rs.getString("course status"));
					System.out.println();
				}
				break;
			case "2":
				sql = "{call procteacherAttendance2(?,?,?)}";
				stat = conn.prepareCall(sql);
				stat.registerOutParameter(1,OracleTypes.CURSOR); 
				System.out.print("월(mm):");
				String month = scan.nextLine();
				stat.setString(2,month);
				stat.setInt(3, pteacherNum);
				stat.executeQuery(); 
				rs = (ResultSet)stat.getObject(1);
				System.out.println("[courseHistoryNum]\t[student name]\t[enterTime]\t\t\t[outTime]\t\t[attendance status]\t[course status]");
				while(rs.next()) {
					System.out.printf("%s\t\t",rs.getString("openCourseNum"));
					System.out.printf("%s\t\t",rs.getString("student name"));
					System.out.printf("%s\t\t",rs.getString("enterTime"));
					System.out.printf("%s\t\t",rs.getString("outTime"));
					System.out.printf("%s\t\t",rs.getString("attendance status"));
					System.out.printf("%s\t\t",rs.getString("course status"));
					System.out.println();
				}
				break;
			case "3":
				sql = "{call procteacherAttendance3(?,?,?)}";
				stat = conn.prepareCall(sql);
				stat.registerOutParameter(1,OracleTypes.CURSOR); 
				System.out.print("일(dd):");
				String day = scan.nextLine();
				stat.setString(2,day);
				stat.setInt(3, pteacherNum);
				stat.executeQuery(); // 다 넣고 업데이트임
				rs = (ResultSet)stat.getObject(1);
				System.out.println("[openCourseNum]\t[student name]\t[enterTime]\t\t\t[outTime]\t\t[attendance status]\t[course status]");
				while(rs.next()) {
					System.out.printf("%s\t\t",rs.getString("openCourseNum"));
					System.out.printf("%s\t\t",rs.getString("student name"));
					System.out.printf("%s\t\t",rs.getString("enterTime"));
					System.out.printf("%s\t\t",rs.getString("outTime"));
					System.out.printf("%s\t\t",rs.getString("attendance status"));
					System.out.printf("%s\t\t",rs.getString("course status"));
					System.out.println();
				}
				break;
			}
			System.out.println("완료");
			stat.close();
			conn.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("teacherAttendance.procteacherAttendance1()");
			e.printStackTrace();
		}
		
		
	}

	private static void procteacherAttendance(int teacherNum) {
		
		Connection conn = null;
		CallableStatement stat1 = null;
		Statement stat = null;
		DBUtil util = new DBUtil();
		String sql = null;
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);
		try {
			conn = util.open("211.63.89.64","project","java1234");
			stat = conn.createStatement();
			sql = String.format("select * from vwteacherAttendance where teacherNum = %d",teacherNum);
			rs = stat.executeQuery(sql);
			System.out.println("*** 선생님 교육생의 출결 조회 ***");
			System.out.println("[openCourseNum]\t[allCourseNum]\t[subject name]\t[teacher name]\t[teacherNum]");
			while(rs.next()) {
				System.out.printf("%s\t",rs.getString("openCourseNum"));
				System.out.printf("%s\t",rs.getString("allCourseNum"));
				System.out.printf("%s\t",rs.getString("subject name"));
				System.out.printf("%s\t",rs.getString("teacher name"));
				System.out.printf("%s\t",rs.getString("teacherNum"));
				System.out.println();
			}
			stat.close();
			
			sql = "{procteacherAttendance(?,?,?)}";
			stat1 = conn.prepareCall(sql);
			
			System.out.print("개설 과정 번호:");
			String num = scan.nextLine();
			System.out.print("선생님 번호:");
			String teacher = scan.nextLine();
			
			stat1.setString(1,num);
			stat1.setString(2, teacher);
			
			stat1.registerOutParameter(3,OracleTypes.CURSOR); 
			stat1.executeQuery();
			
			rs = (ResultSet)stat1.getObject(3); 
			System.out.println("[student name]\t[teacher name]\t[course period]\t[course status]\t[attendance status]\t[enter time]\t[out time]");
			while(rs.next()) {
				System.out.printf("%s\t",rs.getString("student name"));
				System.out.printf("%s\t",rs.getString("teacher name"));
				System.out.printf("%s\t",rs.getString("course period"));
				System.out.printf("%s\t",rs.getString("course status"));
				System.out.printf("%s\t",rs.getString("attendance status"));
				System.out.printf("%s\t",rs.getString("enter time"));
				System.out.printf("%s\t",rs.getString("out time"));
				System.out.println();
				
			}
			conn.close();
			stat1.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("teacherAttendacne.procteacherAttendance()");
			//e.printStackTrace();
		}
		
	}
	

}

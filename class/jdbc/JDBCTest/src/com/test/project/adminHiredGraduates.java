package com.test.project;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.test.jdbc.DBUtil;

import oracle.jdbc.OracleTypes;
// result 예외 처리 완료
public class adminHiredGraduates {
	public static void main(String[] args) {
		//prochiredGraduatesUpdate(); /*관리자는 수료생의 고용보험 여부를 조회 후 그 결과를 입력할 수 있다.*/
		//prochiredGraduatesUpdate1(); /*추가적으로 회사이름과 연봉을 기입할 수 있다.(선택적)*/
		//vwhiredGradesManSelect(); /*관리자가 취업 완료 수료생 관리를 할 수 있다. (추가,삭제,출력) */ //출력 
		//prochiredGradesManDelete(); /*관리자가 취업 완료 수료생 관리를 할 수 있다. (추가,삭제,출력) */ //삭제
		//prochiredGradesManInsert();  /*관리자가 취업 완료 수료생 관리를 할 수 있다. (추가,삭제,출력) */ //추가 
		//prochiredgradesSalarySelect(); /*관리자는 취업 완료 수료생 리스트 조회 시 연봉별 검색이 가능하다. */ 
		prochiredGradesSelectName(); /*관리자는 회사명으로 조회 가능*/
	}

	private static void prochiredGradesSelectName() {
		Connection conn = null;
		ResultSet rs = null;
		CallableStatement stat = null;
		DBUtil util = new DBUtil();
		String sql = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("*** 관리자 회사명으로 조회 ***");
		try {
			
			conn = util.open("211.63.89.64","project","java1234");
			sql = "{call prochiredGradesSelectName(?,?)}";
			stat = conn.prepareCall(sql);
			stat.registerOutParameter(2,OracleTypes.CURSOR);
			
			System.out.print("회사 이름:");
			String company = scan.nextLine();
			stat.setString(1, company);
			stat.executeQuery();
			rs =(ResultSet)stat.getObject(2);
			System.out.println("[hiredGraduatesNum]\t[courseHistoryNum]\t[company]\t[salary]\t[status]");
			while(rs.next()) {
				System.out.printf("%s\t",rs.getString("num"));
				System.out.printf("%s\t",rs.getString("courseHistoryNum"));
				System.out.printf("%s\t",rs.getString("company"));
				System.out.printf("%s\t",rs.getString("salary"));
				System.out.printf("%s\t",rs.getString("status"));
				System.out.println();
			}
			conn.close();
			rs.close();
			stat.close();
			
		} catch (Exception e) {
			System.out.println("adminHiredGraduates.prochiredGradesSelectName()");
			e.printStackTrace();
		}
		
		
	}

	private static void prochiredgradesSalarySelect() {
		Connection conn = null;
		ResultSet rs = null;
		CallableStatement stat = null;
		DBUtil util = new DBUtil();
		String sql = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("*** 관리자 취업 완료 수료생 리스트 조회 시 연봉별 검색 ***");
		try {
			
			conn = util.open("211.63.89.64","project","java1234");
			sql = "{call prochiredgradesSalarySelect(?,?,?)}";
			
			stat = conn.prepareCall(sql);
			System.out.print("조회할 시작 연봉:");
			String start = scan.nextLine();
			System.out.print("조회할 끝 연봉:");
			String end = scan.nextLine();
			
			stat.setString(1,start); 
			stat.setString(2, end);
			stat.registerOutParameter(3,OracleTypes.CURSOR);
			stat.executeQuery();
			rs = (ResultSet)stat.getObject(3);
			
			while(rs.next()) {
				System.out.printf("%s\t",rs.getString("coursehistorynum"));
				System.out.printf("%s\t",rs.getString("company"));
				System.out.printf("%s\t",rs.getString("salary"));
				System.out.printf("%s\t",rs.getString("status"));
				System.out.println();
			}
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("adminHiredGraduates.prochiredgradesSalarySelect()");
			e.printStackTrace();
		}
		
	}

	private static void prochiredGradesManInsert() {
		Connection conn = null;
		ResultSet rs = null;
		CallableStatement stat = null;
		DBUtil util = new DBUtil();
		String sql = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("*** 관리자가 취업 완료 수료생 관리 추가 ***");
		try {
			conn = util.open("211.63.89.64","project","java1234");
			sql = "{call prochiredGradesManInsert(?,?,?,?)}";
			
			stat = conn.prepareCall(sql);
			vwhiredGradesManSelect();
			
			System.out.print("강좌 번호(pcourseHistoryNum):");
			String num = scan.nextLine();
			System.out.print("회사이름:");
			String company = scan.nextLine();
			System.out.print("연봉:");
			String salary = scan.nextLine();
			System.out.print("고용 상태(재직중,퇴사):");
			String status = scan.nextLine();
			
			stat.setString(1, num);
			stat.setString(2, company);
			stat.setString(3, salary);
			stat.setString(4, status);
			
			System.out.println("완료");
			
			stat.executeUpdate();
			
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println("adminHiredGraduates.prochiredGradesManInsert()");
			e.printStackTrace();
		}
		
	}

	private static void prochiredGradesManDelete() {
		Connection conn = null;
		ResultSet rs = null;
		CallableStatement stat = null;
		DBUtil util = new DBUtil();
		String sql = null;
		Scanner scan = new Scanner(System.in);
		vwhiredGradesManSelect();
		System.out.println("*** 관리자가 취업 완료 수료생 관리 삭제 ***");
		try {
			conn = util.open("211.63.89.64","project","java1234");
		
			sql = "{call prochiredGradesManDelete(?)}";
			System.out.print("삭제할 번호(hiredGraduatesNum): ");
			String num = scan.nextLine();
			
			stat = conn.prepareCall(sql);
			stat.setString(1, num);
			stat.executeUpdate();
			
	
			System.out.println("완료");
			
			conn.close();
			stat.close();
			
			
		} catch (Exception e) {
			System.out.println("adminHiredGraduates.prochiredGradesManDelete()");
			e.printStackTrace();
		}
		
	}

	private static void vwhiredGradesManSelect() {
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		DBUtil util = new DBUtil();
		String sql = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("*** 관리자가 취업 완료 수료생 관리 출력 ***");
		try {
			conn = util.open("211.63.89.64","project","java1234");
			//conn = util.open("localhost","project","java1234");
			sql = "select * from vwhiredGradesManSelect";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			int count=0;
			System.out.println("[hiredgraduates num]\t[courseHistoryNum]\t[company]\t[salary]\t[status]");
			while(rs.next()) {
				System.out.printf("%s\t",rs.getString("num"));
				System.out.printf("%s\t",rs.getString("courseHistoryNum"));
				System.out.printf("%s\t",rs.getString("company"));
				System.out.printf("%s\t",rs.getString("salary"));
				System.out.printf("%s\t",rs.getString("status"));
				System.out.println();
		
				count++;
				if(count%100==0) {
					System.out.println("---------------");
					System.out.println("-1을 누르면 종료");
					System.out.println("---------------");
					System.out.print("번호:");
					int k = scan.nextInt();
					scan.skip("\r\n");
					if(k==-1) {
						break;
					} else {
						pause();
					}
				}
			}
			rs.close();
			conn.close();
			stat.close();
			
		}	
		catch (Exception e) {
			System.out.println(".vwhiredGradesManSelect()");
			e.printStackTrace();
		}
		
	}

	private static void pause() {
		System.out.println("10개를 계속 출력하실려면 엔터를 누르세요...");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
	}
// 프로시저에 DML이 2개 이상일때 서로 관계 있는 관계일때 성공 실패일 관계일때 하나를 rollback할려고
	private static void prochiredGraduatesUpdate1() {
		
		Connection conn = null;
		ResultSet rs = null;
		CallableStatement stat = null;
	
		DBUtil util = new DBUtil();
		Scanner scan = new Scanner(System.in);
		String sql = null;
		
		String pcourseHistoryNum = null;
		String pcompany = null;
		String psalary = null;
		String pstatus = null;
		System.out.println("*** 추가적으로 회사이름과 연봉을 기입 ***");
		vwhiredGradesManSelect();
		try {
			conn = util.open("211.63.89.64","project","java1234");
			conn.setAutoCommit(false);
			//conn = util.open("localhost","project","java1234");
			sql = "{call prochiredGraduatesUpdateSelect(?,?)}";
			stat = conn.prepareCall(sql);
			System.out.print("수정할 번호(hiredGraduatesNum):");
			String num = scan.nextLine();
			stat.setString(1,num);
			stat.registerOutParameter(2,OracleTypes.CURSOR);
			stat.executeQuery();
			rs = (ResultSet)stat.getObject(2);
		
			if(rs.next()) {
				pcourseHistoryNum = rs.getString("courseHistoryNum");
				pcompany = rs.getString("company");
				psalary=rs.getString("salary");
				pstatus=rs.getString("status");
			}
			rs.close();
			
			sql = "{call prochiredGraduatesUpdate1(?,?,?,?,?)}";
			stat = conn.prepareCall(sql);
		
			System.out.println("--------------");
			System.out.println("1. 수강내역 번호");
			System.out.println("2. 회사명");
			System.out.println("3. 연봉");
			System.out.println("4. 재직 상태");
			System.out.println("--------------");
			System.out.print("수정할 번호(선택):");
			String a = scan.nextLine();
			System.out.println("--------------");
			switch(a) {
			case "1" : System.out.print("수강내역 번호(courseHistoryNum):");
					   String courseHistoryNum = scan.nextLine();
					   stat.setString(1, num);
					   stat.setString(2, courseHistoryNum);
					   stat.setString(3, pcompany);
					   stat.setString(4, psalary);
					   stat.setString(5, pstatus);
					   //System.out.println(stat.getString("courseHistoryNum"));
					   
			break;
			case "2" :System.out.print("회사이름:");
					  String company = scan.nextLine();
					   stat.setString(1, num);
					   stat.setString(2, pcourseHistoryNum);
					   stat.setString(3, company);
					   stat.setString(4, psalary);
					   stat.setString(5, pstatus);
					   
			break;
			case "3" :
						System.out.print("연봉:");
						String salary = scan.nextLine();
						stat.setString(1, num);
						stat.setString(2, pcourseHistoryNum);
						stat.setString(3, pcompany);
						stat.setString(4, salary);
						stat.setString(5, pstatus);
			break;
			case "4": System.out.print("취업 상태:");
					  String status = scan.nextLine();
					  stat.setString(1, num);
					  stat.setString(2, pcourseHistoryNum);
					  stat.setString(3, pcompany);
					  stat.setString(4, psalary);
					  stat.setString(5, status);
			break;
			} 
			stat.executeUpdate();
			//System.out.println(result);
			
			vwhiredGradesManSelect();
			stat.close();
			conn.close();
			
			System.out.println("완료");
		} catch (Exception e) {
			System.out.println("project_test_tblhiredGraduates_Select.m2()");
			e.printStackTrace();
		}
		
	}
//같은 값을 입력할때 에러 재직중 -> 재직중
	private static void prochiredGraduatesUpdate() {
		Connection conn = null;
		ResultSet rs = null;
		CallableStatement stat = null;
		Statement stat1 = null;
		DBUtil util = new DBUtil();
		Scanner scan = new Scanner(System.in);
		String sql = null;
		System.out.println("*** 관리자는 수료생의 고용보험 여부를 조회 후 그 결과를 입력 ***");
		try {
			conn = util.open("211.63.89.64","project","java1234");
			conn.setAutoCommit(false);
			stat1=conn.createStatement();
			sql = "select * from vwhiredGraduatesSelect";
			rs = stat1.executeQuery(sql);
				System.out.println("[hiredgraduates num]\t[courseHistoryNum]\t[company]\t[salary]\t[status]\t[employment insurance]");
			while(rs.next()) {
				System.out.printf("%s\t",rs.getString("num"));
				System.out.printf("%s\t",rs.getString("courseHistoryNum"));
				System.out.printf("%s\t",rs.getString("company"));
				System.out.printf("%s\t",rs.getString("salary"));
				System.out.printf("%s\t",rs.getString("status"));
				System.out.printf("%s\t",rs.getString("employment insurance"));
				System.out.println();
			}
			stat1.close();
			rs.close();
			System.out.print("고용보험 여부를 재직중으로 수정할 취직 번호:");
			String num = scan.nextLine();
			sql = "{call prochiredGraduatesUpdate(?)}";
			stat = conn.prepareCall(sql);
			stat.setString(1,num);
			stat.executeUpdate();
			
			stat.close();
			conn.close();
			System.out.println("완료");
		} catch (Exception e) {
			System.out.println("adminHiredGraduates.prochiredGraduatesUpdate()");
			e.printStackTrace();
		}
		
	}

}

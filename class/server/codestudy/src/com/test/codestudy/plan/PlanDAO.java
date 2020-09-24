package com.test.codestudy.plan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.codestudy.DBUtil;

public class PlanDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public PlanDAO() {
		
		//DB 연결 
		DBUtil util = new DBUtil();
		conn = util.open();
			
		
	}
	
	public void close() {
		try {
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int add(PlanDTO dto) {
		
		try {
			
			String sql = "insert into tblPlan(seq,mseq,regdate,content) values (seqPlan.nextVal,?,?,?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getMseq());
			pstat.setString(2, dto.getRegdate());
			pstat.setString(3, dto.getContent());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("PlanDAO.add()");
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<PlanDTO> list(HashMap<String, Integer> map) {
		
		try {
			//2020-08-20 -> 2020-08
			String date = String.format("%04d-%02d", map.get("year"),map.get("month")+1);
			String sql = "select p.*, (select name from tblMember where seq = p.mseq) as name from tblPlan p where regdate like ? || '%'";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, date);
			
			rs = pstat.executeQuery();
			
			ArrayList<PlanDTO> list = new ArrayList<PlanDTO>();
			
			while(rs.next()) {
				PlanDTO dto = new PlanDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setName(rs.getString("name"));
				dto.setMseq(rs.getString("mseq"));
				dto.setContent(rs.getString("content"));
				list.add(dto);
			}
			return list;
			
		} catch (Exception e) {
			System.out.println("PlanDAO.list()");
			e.printStackTrace();
		}
		
		return null;
	}
}

package com.test.codestudy.member;

public class MessageDTO {
	
	private String seq;
	private String smeq;
	private String[] rmseq; //???
	private String content;
	private String regdate;
	private String state;
	private String sname;
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSmeq() {
		return smeq;
	}
	public void setSmeq(String smeq) {
		this.smeq = smeq;
	}
	public String[] getRmseq() {
		return rmseq;
	}
	public void setRmseq(String[] rmseq) {
		this.rmseq = rmseq;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
	
}

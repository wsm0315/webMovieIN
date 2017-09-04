package model;

public class MembershipVO {
	private int seq_ID;
	private String id;
	private String name;
	private String email;
	private String pw;
	private String pnum;
	private String joindate;
	
	public int getSeq_ID() {
		return seq_ID;
	}
	public void setSeq_ID(int seq_ID) {
		this.seq_ID = seq_ID;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
}

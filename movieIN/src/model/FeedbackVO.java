package model;

public class FeedbackVO {
	private int seq_FNO;
	private int seq_PID;
	private String f_contents;
	private String f_date;
	private int depth;
	private int f_group;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSeq_FNO() {
		return seq_FNO;
	}
	public void setSeq_FNO(int seq_FNO) {
		this.seq_FNO = seq_FNO;
	}
	public int getSeq_PID() {
		return seq_PID;
	}
	public void setSeq_PID(int seq_PID) {
		this.seq_PID = seq_PID;
	}
	public String getF_contents() {
		return f_contents;
	}
	public void setF_contents(String f_contents) {
		this.f_contents = f_contents;
	}
	public String getF_date() {
		return f_date;
	}
	public void setF_date(String f_date) {
		this.f_date = f_date;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getF_group() {
		return f_group;
	}
	public void setF_group(int f_group) {
		this.f_group = f_group;
	}
	
	
}

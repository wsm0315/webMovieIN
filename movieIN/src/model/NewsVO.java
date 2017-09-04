package model;

public class NewsVO {
	private int seq_NNO;
	private int seq_PID;
	private String id;
	private String n_contents;
	private String n_date;
	private int n_depth;
	private int n_group;
	private String n_imgurl;
	private String n_videourl;
	
	public int getSeq_NNO() {
		return seq_NNO;
	}
	public void setSeq_NNO(int seq_NNO) {
		this.seq_NNO = seq_NNO;
	}
	public int getSeq_PID() {
		return seq_PID;
	}
	public void setSeq_PID(int seq_PID) {
		this.seq_PID = seq_PID;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getN_contents() {
		return n_contents;
	}
	public void setN_contents(String n_contents) {
		this.n_contents = n_contents;
	}
	public String getN_date() {
		return n_date;
	}
	public void setN_date(String n_date) {
		this.n_date = n_date;
	}
	public int getN_depth() {
		return n_depth;
	}
	public void setN_depth(int n_depth) {
		this.n_depth = n_depth;
	}
	public int getN_group() {
		return n_group;
	}
	public void setN_group(int n_group) {
		this.n_group = n_group;
	}
	public String getN_imgurl() {
		return n_imgurl;
	}
	public void setN_imgurl(String n_imgurl) {
		this.n_imgurl = n_imgurl;
	}
	public String getN_videourl() {
		return n_videourl;
	}
	public void setN_videourl(String n_videourl) {
		this.n_videourl = n_videourl;
	}
}

package model;

public class FilterVO {
	private int seq_PID;
	private String inv_type;
	private String genre1;
	private String genre2;
	private String genre3;
	private String id;
	private String proj;
	private String imgurl;
	@Override
	public String toString() {
		return "FilterVO [seq_PID=" + seq_PID + ", inv_type=" + inv_type + ", genre1=" + genre1 + ", genre2=" + genre2
				+ ", genre3=" + genre3 + ", id=" + id + ", proj=" + proj + ", imgurl=" + imgurl + ", purpose=" + purpose
				+ "]";
	}
	private String purpose;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProj() {
		return proj;
	}
	public void setProj(String proj) {
		this.proj = proj;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public int getSeq_PID() {
		return seq_PID;
	}
	public void setSeq_PID(int seq_PID) {
		this.seq_PID = seq_PID;
	}
	public String getInv_type() {
		return inv_type;
	}
	public void setInv_type(String inv_type) {
		this.inv_type = inv_type;
	}
	public String getGenre1() {
		return genre1;
	}
	public void setGenre1(String genre1) {
		this.genre1 = genre1;
	}
	public String getGenre2() {
		return genre2;
	}
	public void setGenre2(String genre2) {
		this.genre2 = genre2;
	}
	public String getGenre3() {
		return genre3;
	}
	public void setGenre3(String genre3) {
		this.genre3 = genre3;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
}

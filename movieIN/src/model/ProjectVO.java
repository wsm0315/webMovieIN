package model;

public class ProjectVO {
	private int seq_PID;
	private String id;
	private String proj;
	private int m_target;
	private int m_collected;
	private String enddate;
	private int cnt;
	private String writedate;
	private int m_min;
	@Override
	public String toString() {
		return "ProjectVO [seq_PID=" + seq_PID + ", id=" + id + ", proj=" + proj + ", m_target=" + m_target
				+ ", m_collected=" + m_collected + ", enddate=" + enddate + ", cnt=" + cnt + ", writedate=" + writedate
				+ ", m_min=" + m_min + ", m_max=" + m_max + ", inv_type=" + inv_type + ", pna=" + pna + ", level_="
				+ level_ + ", purpose=" + purpose + ", status=" + status + ", imgurl=" + imgurl + "]";
	}
	private int m_max;
	private String inv_type;
	private int pna;
	private int level_;
	private String purpose;
	private int status;
	private String imgurl;
	
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
	public int getM_target() {
		return m_target;
	}
	public void setM_target(int m_target) {
		this.m_target = m_target;
	}
	public int getM_collected() {
		return m_collected;
	}
	public void setM_collected(int m_collected) {
		this.m_collected = m_collected;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public int getM_min() {
		return m_min;
	}
	public void setM_min(int m_min) {
		this.m_min = m_min;
	}
	public int getM_max() {
		return m_max;
	}
	public void setM_max(int m_max) {
		this.m_max = m_max;
	}
	public String getInv_type() {
		return inv_type;
	}
	public void setInv_type(String inv_type) {
		this.inv_type = inv_type;
	}
	public int getPna() {
		return pna;
	}
	public void setPna(int pna) {
		this.pna = pna;
	}
	public int getLevel_() {
		return level_;
	}
	public void setLevel_(int level_) {
		this.level_ = level_;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}

package model.dto;

public class MemberDto {
	private int mno;
	private String mid;
	private String mpwd;
	private String ming;
	private String memail;
	
	public MemberDto() {
		super();
	}

	public MemberDto(int mno, String mid, String mpw, String ming, String memail) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpwd = mpw;
		this.ming = ming;
		this.memail = memail;
	}

	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpw=" + mpwd + ", ming=" + ming + ", memail=" + memail
				+ "]";
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpwd;
	}

	public void setMpw(String mpw) {
		this.mpwd = mpw;
	}

	public String getMing() {
		return ming;
	}

	public void setMing(String ming) {
		this.ming = ming;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}
	
	
	
}

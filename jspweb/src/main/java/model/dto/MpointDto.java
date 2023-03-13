package model.dto;

public class MpointDto {
	private int mpno;
	private String mpcomment;
	private int mpamount;
	private String mpdate;
	private int mno;
	private int mpoint;	//보유포인트 : DB테이블에 존재하지 않는 필드[통계]
	
	
	public int getMpoint() {
		return mpoint;
	}

	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}

	public int getMpno() {
		return mpno;
	}

	public void setMpno(int mpno) {
		this.mpno = mpno;
	}

	public String getMpcomment() {
		return mpcomment;
	}

	public void setMpcomment(String mpcomment) {
		this.mpcomment = mpcomment;
	}

	public int getMpamount() {
		return mpamount;
	}

	public void setMpamount(int mpamount) {
		this.mpamount = mpamount;
	}

	public String getMupdate() {
		return mpdate;
	}

	public void setMupdate(String mupdate) {
		this.mpdate = mupdate;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "MpointDto [mpno=" + mpno + ", mpcomment=" + mpcomment + ", mpamount=" + mpamount + ", mupdate="
				+ mpdate + ", mno=" + mno + "]";
	}

	public MpointDto(int mpno, String mpcomment, int mpamount, String mupdate, int mno) {
		super();
		this.mpno = mpno;
		this.mpcomment = mpcomment;
		this.mpamount = mpamount;
		this.mpdate = mupdate;
		this.mno = mno;
	}

	public MpointDto() {
		super();
	}
	
	
	
}

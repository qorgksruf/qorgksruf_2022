package MVCB연습;

public class Memberdto {
	private int mno;
	private String mid;
	private String mpw;
	
	public Memberdto(int mno, String mid, String mpw) {
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
	}

	
	public Memberdto() {
		super();
	}

	
	
	@Override
	public String toString() {
		return "Memberdto [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + "]";
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
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	

	
}

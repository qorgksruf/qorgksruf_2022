package 과제.과제11;

public class BoardDto {
	
	//필드생성
	private int mno;
	private String mid;
	private int mprice;
	private String msave;
	
	public BoardDto() {
	}

	public BoardDto(int mno, String mid, int mprice, String msave) {
		this.mno = mno;
		this.mid = mid;
		this.mprice = mprice;
		this.msave = msave;
	}

	
	public BoardDto( String mid, int mprice, String msave) {
		
		this.mid = mid;
		this.mprice = mprice;
		this.msave = msave;
	}
	
	@Override
	public String toString() {
		return "BoardDto [mno=" + mno + ", mid=" + mid + ", mprice=" + mprice + ", msave=" + msave + "]";
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

	public int getMprice() {
		return mprice;
	}

	public void setMprice(int mprice) {
		this.mprice = mprice;
	}

	public String getMsave() {
		return msave;
	}

	public void setMsave(String msave) {
		this.msave = msave;
	}

	public static Object getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}

package Day15.EX9.MVC패턴;

public class MemberDto {
	//필드->db필드와 일치화
	private int mno;
	private String mid;
	private String mpw;
	
	//생성자
	public MemberDto(int mno, String mid, String mpw) {
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
	}

	public MemberDto() {
	}
	
	
	public void signup() {
		
	}
	
	public void list() {
		
	}
	
	
	
	//메소드[무조건 get/ set /tostring 만들기]
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

	
	
	@Override
	public String toString() {
		return "BoardDto [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + "]";
	}
	

	
	
	
	
	
}

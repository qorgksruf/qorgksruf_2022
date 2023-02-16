package shin컴퓨터실예약.model;

public class Computer {
	public int comNo;		// 자리 번호
	public String resName;	// 예약자 이름
	public boolean state;	// 예약 상태
	
	
	
	//빈생성자
	public Computer() {

	}
	//생성자
	public Computer(int comNo, String resName, boolean state) {
		this.comNo = comNo;
		this.resName = resName;
		this.state = state;
	}
	
}

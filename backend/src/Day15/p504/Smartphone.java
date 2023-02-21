package Day15.p504;

public class Smartphone {

	private String company;
	private String os;
	
	public Smartphone(String company, String os) {
		this.company = company;
		this.os = os;
	}

	@Override	//tostring 내가 출력하고싶은데로 꾸미던가 자동생성하던가 맘대루
	public String toString() {
		return company + ","+os;
	}
	
}

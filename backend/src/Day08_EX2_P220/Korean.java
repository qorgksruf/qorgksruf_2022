package Day08_EX2_P220;

public class Korean {
	//필드
	String nation="대한민국";
	String name;
	String ssn;
	//빈 생성자
	public Korean() {}
	
	public Korean(String name, String ssn) {
		//이렇게 대입을 해줘야 실행했을때 실행이됨
		this.name=name;
		this.ssn=ssn;
	}
	
	//메소드
	@Override
	public String toString() {
		return "Korean [nation=" + nation + ", name=" + name + ", ssn=" + ssn + "]";
	}
	

}

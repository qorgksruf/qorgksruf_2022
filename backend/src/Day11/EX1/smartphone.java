package Day11.EX1;

public class smartphone  extends phone{
			//자식클래스명 extends 부모클래스
			//부모클래스의 멤버들을 자식클래스가 사용할 수 있다.
	
	public boolean wifi;
	
	public smartphone() {
		
	}
	
	public smartphone(String model, String color) {
		super(model,color);
		System.out.println("--자식클래스생성자 실행");
	}
	
	
	public void setwifi(boolean wifi) {
		System.out.println("와이파이 상태를 변경했습니다");
		
	}
	
	public void internet() {
		System.out.println("인터넷에 연결합니다");
	}
	
	
	
}

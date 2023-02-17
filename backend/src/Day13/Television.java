package Day13;

public class Television implements RemoteController{
	//클래스명 implements 인터페이스명 : 구현하다 여기가 실제임
		//인터페이스 안에 추상된 메소드를 해당 클래스가 구현하겠다
		// 필수작업: !!추상메소드 구현 @Override 필수로 해야함
	
	//1. 인터페이스 추상메소드 구현
	@Override
	public void turnOn() {
		System.out.println("Tv를 켭니다");
		
	}
	
}

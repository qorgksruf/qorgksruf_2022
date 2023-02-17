package Day13.EX2.P348;

public interface Remotecontrol {
	
	//상수 필드 [인터페이스는 변수 못씀 1.인스턴스필드 2.정적멤버 ]
		//new 연산자 [ 생성자 x ] => 객체 x => 인스턴스멤버 x => static 멤버만 가능
		//상수 : static final -> 변수 선언시 값 넣어줘야함
		//인터페이스에서는 생략
	public static final int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;	//자동으로 public static final
	
	//추상메소드
		//리턴타입, 메소드명, 매개변수 만 선언
		//{ } 선언 안한다.
		//public abstract 생략가능 =-> 자동으로 선언됨
		//해당 클래스들이 implements 했을때 오버라이딩 필수
	//1.
	public abstract void turnOn();	//{ } 없다
	void turndff();	//public abstract void 생략 가능
	void setVolume(int volume);
	
	//default 메소드
		//클래스에서 사용하는 메소드와 동일
		//선언부 앞에 default 선언
	//2.
	default void setMute( boolean mute) {
		if( mute) {
			System.out.println("무음 처리합니다");
			setVolume(MIN_VOLUME);
		}else {
			System.out.println("무음해제합니다");
			
		}
	}
	
	
	
	//정적메소드는 구현객체가 필요없다 즉 implement 없이 가능
		//static 선언
		
	//3.
	static void changeBattery() {
		System.out.println("리모콘 건전지를 교환합니다");
	}
	
	
	
	
}

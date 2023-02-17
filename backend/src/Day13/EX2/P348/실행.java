package Day13.EX2.P348;



public class 실행 {
	public static void main(String[] args) {
		
		//인터페이스 상수 호출
		System.out.println("리모콘 최대볼룸:"+ Remotecontrol.MAX_VOLUME);
		
		
		//1.인터페이스 변수 선언
		Remotecontrol rc;
		
		//2. 인터페이스[리모콘]에 텔레비전 구현객체 연결
		rc = new Television();
		
		//인터페이스 기능 [메소드]사용
		rc.turnOn();
		rc.setVolume(8);
		rc.turndff();
		
		//인터페이스 리모콘에 오디오 연결
		rc = new Audio();
		rc.turnOn();
		rc.setVolume(30);
		rc.turndff();
		
		//디폴트 매소드 호출
		rc.setMute(true);
		rc.setMute(false);
		
		//4.디폴트 메소드 호출
		Remotecontrol.changeBattery();
		
		
		
	}
}

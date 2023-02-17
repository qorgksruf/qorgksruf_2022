package Day13;

public class 실행 {
	public static void main(String[] args) {
		//인터페이스를 사용하는 구현객체
			//1.인터페이스는 타입 이므로 변수처럼 사용 가능
			//2. 참조하지 않고 있는 변수는 null 대입

		RemoteController control1 = null;
			String s =null;
			//3. 해당 인터페이스를 implements 선언한 객체의 주소 대입 ㅇ
		RemoteController control2 = new Television();
			//4.해당 인터페이스르 implements 선언하지 않는 객체의 주소 대입 x
		//RemoteController control3 = new Audio();
		
		//구현객체 만들기
		RemoteController rc; //인터페이스 변수 선언
		rc = new Television(); // 힙 영역에 객체 선언하고 주소를 반환
			//new Television
		//
		rc.turnOn();
		
		
		
		//얘 하나써도 됨
		new Television().turnOn(); 
		
		//리모콘 교체
		rc = new Audio();
		rc.turnOn();
	}
}

package Day11.EX1;

public class phone {
	//클래스 맴버
		//인스턴스멤버:객체를 이용한 멤버 사용
			//클래스 객체명=new 샛엉자()-->객체명.멤버
		//2.정적멤버[static] 객체없이 이용하는 멤버
			//클래스명.멤버
	//1.멤버 종류
		//1.필드	:객체의 데이터 저장하는곳
			//접근제한자(static/final) 타입 변수명:
		public String model;
		public String color;
		
		
		//생성자: 객체 생성시 초기화 담당 [지역변수]
			//접근제한자 클래스명(매개변수1, 매개변수){ }
			//생성자는 항상 기본으로 깡통과 풀은 꼭 만들고가라~!!! 
			//생성자가 1개 이상이면 기본생성자 직접추가
		
		public phone() {
			
		}
		
		
		public phone(String model, String color) {
			this.model=model;
			this.color=color;
			System.out.println("--부모클래스 생성자 실행;;");
		}
		
		
		//메소드: 객체의 행위[vs 지역변수]
			//접근제한자 (static/final) 반환타입 메소드명(매개변수1,매개변수2){ }
		public void bell( ) {	//모든곳에서 호출 가능한 함수, 매개변수 x 리턴값 x
			System.out.println("벨이 올립니다");
		}
		public void sendVoice( String message) {	//모든 곳에서 호출가능 매개변수1 리턴값x
			System.out.println("자기:"+message);
		}
		
		public void receiveVoice(String message) { //모든 곳에서 호출가능 매개변수1 리턴값x
			System.out.println("상대방:"+message);
		}
		
		public void hangup() {	//모든곳에서 호출 가능한 함수, 매개변수 x 리턴값 x
			System.out.println("전화를 끊습니다");
		}
		
		
		
		
		//2.접근제한자
			//public: 	 모든 곳에서 호출 가능
			//private: 	 해당 클레스에서만 사용 가능
			//default:	 패키지내에서만 호출 가능 
			//protected: 동일한 패키지내에서만 호출 가능[*자식예외]
		
}

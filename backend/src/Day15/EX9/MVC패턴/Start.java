package Day15.EX9.MVC패턴;

public class Start {
	
	public static void main(String[] args) {
		View.getInstance().index();
	}

}



	/*
	 * 
	 * 내부에서 메소드[멤버]호출하는 방법	[ 메모리 할당 전]
	 * 		메소드명();
	 * 
	 * ********************8
	 * 외부에서 메소드[멤버]호출하는 방법 	[메모리 할당]
	 * 		1.인스턴스 메소드	
	 * 			클래스명 객체명 = new 생성자();		
					 * -> View view = new View(); 
					 * 		 view.index();
	 * 			객체명.메소드명();
	 * 
	 * 
	 * 
	 * 		2.정적 메소드->static , 이거 없으면 instance
	 * 			클래스명.메소드명();	
	 * 				static가 있으면 view.index();
	 * 				index 작성한 페이지에 static 없기때매 사용할 수 없음
	 * 
	 * 
	 * 		3.싱글톤내 메소드 호출
	 * 			클래스명.get싱글톤.메소드();	
	 * 				view.getinstance.index();
	 * 		
	 * 
	 * 			JVM
	 * 
	 * 				[현재 사용중인 메모리[클래스]: 컴파일한 클래스 + import ]
	 * 
	 * 	
	 * 	메소드영역 					 스택영역						 힙영역	-> 여기에 메소드가 있는것임
	 * 	: 클래스 멤버정보					기본자료형데이터		
	 * 	:	static									
	 *  클래스명.메소드명()					힙주소저장					
	 *  	-정적필드							클래스객체명		=		new 생성자();
		static 타입필드명														new 생성자(). 메소드명(); 
		static View view
		
															= 		new View();
		
	 * */

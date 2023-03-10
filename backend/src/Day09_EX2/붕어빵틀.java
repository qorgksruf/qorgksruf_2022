package Day09_EX2;

import java.util.ArrayList;

//2.생성자:객체를 생성할때 초기화 담당
/* new 생성자()
 생성자 선언이 없을경우 기본생성자 자동으로 생성됨
생성자 이름은 클래스명과 동일하게 해야함 꼭

*메소드영역
*	인수: 함수 안으로 들어오는 데이터
*	반환: 함수 조욜시 호출했던 곳으로 리턴되는 데이터
*
*
*	1.선언형태
*	리턴타입 함수명(타입(int같은거) 매개변수1, 매개변수2){
*		return 리턴타입허용범위내 데이터
*	}
*
*
*	2.호출
*	내부:함수명(데이터,데이터)
*	외부: 객체명.함수명(데이터,데이터)
*	
*
*
*
*
*/





public class 붕어빵틀 {
	//1.필드
	
	String 붕어빵재료1;
	String 붕어빵재료2;
	
	//2.생성자
		//1)기본생성자
	붕어빵틀(){}
	
	
		//2) 필드1개 생성자
	붕어빵틀(String 재료1){
		붕어빵재료1=재료1;
	}
		
	
		//3) 필드2개 생성자
	붕어빵틀(String 재료1, String 재료2){
		붕어빵재료1=재료1;
		붕어빵재료2=재료2;
	}
	
	//3.메소드
		//toString함수 (source->밑에서 네번쨰)-> 
	//	이것의 역활은 검사, 초기화등
	@Override
	public String toString() {
		return "붕어빵틀 [재료1=" + 붕어빵재료1 + ", 재료2=" + 붕어빵재료2 + "]";
	} 
	
	
		//2.붕어빵굽기
	void 굽기() {	//리턴 타입없다 , 인수도없다 
		System.out.println("붕어빵 굽습니다");
	}
	
		//3.붕어빵속 변경	//리턴타입없다 인수2개
	void 변경(String 재료1, String 재료2) {
		붕어빵재료1=재료1;
		붕어빵재료2=재료2;
		System.out.println("붕어빵 속 변경되었습니다");
	}
	
		// 리턴타입 있다[타입] 인수는 x 4.붕어빵 판매
	int 판매가() {
		return 3000;
	}
	
	
	붕어빵틀 판매() {	//5.붕어빵 판매
		붕어빵틀 붕어빵=new 붕어빵틀();
		return 붕어빵;
		
	}
	
	void 확인(붕어빵틀 붕어빵) {
		System.out.println(붕어빵);
	}
	
	ArrayList<붕어빵틀> 여러개판매 (int 개수){
		
		ArrayList<붕어빵틀> 붕어빵포장종이 = new ArrayList<>();
		
		for(int i=1; i<=개수; i++) {
			붕어빵포장종이.add(판매());
		}
		return 붕어빵포장종이;
	}
	
	
	
	
	
	
	
}

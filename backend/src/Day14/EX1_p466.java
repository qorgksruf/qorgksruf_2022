package Day14;

public class EX1_p466 {
	//1.p466
		//2.한수선언
		//접근제한자 키워드 반환타입 함수명(타입 매개변수1, 타입 매개변수2...){return 데이터;}
			//접근제한자:public private, default, protected
			//반환타입 return 할 데이터의 타입
			//키워드[생략] static[정적], final->얘는 오버라이딩 못하게 막는다
			//함수명: 카멜
			//매개변수: 타입에 맞춰서 선언
	//여기 static 쓰는 이유는 main함수에서 static 썻기때매
	public static void printLength(String data) {
		try {	//예외가 발생할 것 같은 코드를 try 안에 넣기
			int result = data.length();	//문자열 길이
			System.out.println("문자수;;"+result);
		}	
		catch(NullPointerException e) {
			//만약에 try 안에서 예외가 발생했을때 실행되ㅐ는 catch 코드
				//만약 try 안에서 예외가 발생하지 않으면 catch 실행안됨
				//e: 에외객체명[아무거나]	 예외정보가 남겨져 있는 객체
			System.out.println(e.getMessage() );
		}
		finally {	//예외가 있던말던 실행되는 코드
			System.out.println("마무리 실행");
		}
	}
	//1.main 함수선언: main 스레드가 포함된 함수-> 스레드:코드를 읽어주는 흐름단위[단일스레드] 
	public static void main(String[] args) {
		System.out.println("프로그램시작");
		printLength("ThisJava");
		printLength(null);		//실행예외가 발생 할 것 같은코드, nullpointException: 데이터가 null이라서 length 사용 못한다
		System.out.println("프로그램종료"); 
		
	}//main e
	
	
	
}

/*
 * 에러: 하드웨어의 고장으로 인해 응용프로그램 실행 오류 발생
 * 예외: 에러 이외 예외라는 오류발생
 * 		* 잘못된 사용[사용자] 또는 코딩[개발자]으로 인한 발생
 * 		* 잘못된 사용: 사용자가 비정상적이 행동했을떄  -> 경험바탕
 * 		*		1.일반예외: 컴파일전에 발생 할 수 있는 예외검사[ *자바 외부와 통신] 
 * 				2.실행예외: 컴파일후에 발생하는 예외->경험 , 사용자들이 여기서 오류 많이 낼 것 같은곳
 * 	예외클래스
 * 		Exception 클래스: 모든 예외를 받을 수 있는 예외중에 최상위 클래스
 * 		
 * 문법
 * 		try{
 * 			1.예외가 발생할 것 같은 코드 -> 경험필요
 * 		}
 * 		catch(예외클래스 e){
 * 			2.try에서 예외가 발생했을때 실행되는코드[ 만일 예외 발생했을때 이후 실행코드]
 * 		}
 * 		finally{
 * 			3.예외가 있던말던 실행되는코드 [*생략가능]
 * 		}
 * 
 * 						
 */

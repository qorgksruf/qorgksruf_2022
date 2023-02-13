package Day09_EX6;

/*
 * 정적멤버:
 * 		1.static 키워드
 * 		2.jvm 메소드 영역 저장
 * 		3.객체 없이 사용 가능
 * 		4.사용방법
 * 			클래스명, 정적멤버
 * 		5. 프로그램 시작시 생성, 프로그램 종료시 초기화
 * 		-모든 클래스에서 공통이되는 메모리 사용시
 * 
 * */


public class Carculator {
	
	//1.필드
		//1.인스턴스멤버
	int no;
		//2.정적멤버
	static double pi=3.14159;
	//2.생성자
		//-static 생성자 없
	
	//3.메소드
	int getNo() {
		return no;
	}
	
	static int plus(int x,int y) {
		return x+y;
	}
	static int minus(int x,int y) {
		return x-y;
	}
	static String info;
	
	//정적블록 p.248
	static {
		info =pi+"파이 입니다.";
	}
	
}

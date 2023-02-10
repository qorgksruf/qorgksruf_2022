package Day08_EX4_P230;
//설계도, *****내부
public class Calculator {
	//1.필드
	//2.생성자
	//3.매소드
		//1. 반환x 인수x
	void powerOn() {
		System.out.println("전원을켭니다.");
	}

		// 인수 x 반환 x
	void powerOff() {
		System.out.println("전원을 끕니다");
	}
	//인수 0 반환0
	int plus (int x,int y) {
		int result=x+y;
		return result;
	}
	
	
	//4.인수 x,y /반환:double
	double divide(int x,int y) {
		double result=(double)x	/(double)y;
		return result;
				
	}
	//5.인수: x,y		/반환x
	void multiply(int x, int y) {
		double result=(double)x* (double)y;
		System.out.println(result);
	}
	//6.인수x		/반환o
	String info() {
		return"이젠 계산기";
	}
	
	//7.내부에서 함수호출시
	void 함수호출() {
		powerOn();//*****내부에서 함수 호출시: 함수명();*****
		
	}
	
	
/*
 * 
 * 함수=메소드
 * 
 * js 선엄부					java 선언부
 * funxtion 함수명(인수명)	{	리턴타입 합수명(인수1,인수2)
 * 
 * }
 * 
 * js호출						java 내부호출
 * 함수명(인수1, 인수2)			함수명(인수1,인수2) 
 * 
 * 							java외부호출-객체명 필요
 * 							객체명.함수명(인수1, 인수2)
 * */	
	
}

package 연습장4;

public class Calculator {

	
	void poewrOn() {
		System.out.println("전원을켭니다");
	}
	
	void powerOff() {
		System.out.println("전원을끕니다");
	}
	
	int plus(int x,int y) {
		int result=x+y;
		return result;
	}
	
	double divide(int x, int y) {
		double result=(double)x /(double)y;
		return result;
				
	}
	void multiply(int x, int y) {
		double result=(double)x* (double)y;
		System.out.println(result);
	}
	
	String info() {
		return"이젠계산기";
	}
	
	void 함수호출() {
		poewrOn();
	}
	
	
}

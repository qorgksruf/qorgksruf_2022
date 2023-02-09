//클래스 목적2.실행

package Day07_EX_02;

public class 실행 {

	public static void main(String[] args) {
		
		//클래스를 이용한 객체 생성
		Car myCar=new Car();
		//클래스명 변수명=new 생성자명();
		
		//2. 객체의 필드 호출[.접근연산자]
		System.out.println("모델명;;;"+myCar.model);
		System.out.println("시동여부;;;"+myCar.start);
		System.out.println("현재속도;;;"+myCar.speed);
		//왜 null같은거 뜨냐면 설계도만 만들었어서;;;; 인스턴스화해야 뜸;;;
		
		
		//3.
		Car yourCar=new Car();
		yourCar.model="현대자동차";
		
		System.out.println("my car모델명;;;"+myCar.model);
		System.out.println("your car모델명;;;"+yourCar.model);
	}
}

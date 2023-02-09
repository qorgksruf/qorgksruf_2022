package 연습장;

public class 객체연습 {
	public static void main(String[] args) {
		
		Car mycar=new Car();
		
		System.out.println("모델명;;;"+mycar.model);
		System.out.println("시동여부;;;"+mycar.start);
		System.out.println("현재속되;;;"+mycar.speed);
		
		
		Car yourcar=new Car();
		yourcar.model="현대자동차";
		System.out.println("dd"+mycar.model);
		System.out.println("dd"+yourcar.model);
		
		
	}
}//class e

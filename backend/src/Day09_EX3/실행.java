package Day09_EX3;

public class 실행 {
	
	public static void main(String[] args) {

		
		
		//세가지 다 같은 법인데 얘는 잘 안씀
		Car car=new Car();
		car.gas=5;
		
		//간접: 객체의 필수데이터
		Car yourCar=new Car(5);
		
		
		//간접: 객체 생성후 데이터
		Car myCar=new Car();
		myCar.setGas(5);
		
		
		if(myCar.isLetfGas()) {
			System.out.println("출발합니다");
			myCar.run();
		}
		System.out.println("가스를 주입하세요");
	}
}

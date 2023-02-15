package Day11.EX6;

public class 실행 {
	public static void main(String[] args) {
		
		//타이어
		Tire tire =new Tire();	//기본타이어
		
		//자동차 객체 만들기
		Car myCar=new Car();
			//자동차 객체에 타이어 객체 1개 포함
		//2.기본타이어 정착
		myCar.tire=new Tire();
		myCar.run();
		

			
		//한국타이어 교체
		myCar.tire=new HankookTire();
		myCar.run();
		
		//부모가 자식이되기위해 () 로 강제타입변환해줌
		HankookTire hankookTire=new HankookTire();
			myCar.parking(hankookTire);
			HankookTire result2 = (HankookTire) myCar.parking(tire);
		
			System.out.println(result2 instanceof Tire);			
			System.out.println(result2 instanceof Object);
		//금호타이어 교체
		myCar.tire=new KumhoTire();
		myCar.run();
		
		KumhoTire kumhoTire=new KumhoTire();
			myCar.parking(kumhoTire);
		
		
			
			
	}
}

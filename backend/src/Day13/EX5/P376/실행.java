package Day13.EX5.P376;

public class 실행 {
	public static void main(String[] args) {
		Car mycar = new Car();
		mycar.run();
		
		mycar.tire1 = new KumhoTire();
		mycar.tire2 = new KumhoTire();
		
		mycar.run();
	}
}

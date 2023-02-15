package Day11.EX6;

public class Car {	//부모만 써주면 자식들 나중에 이거 사용가능함
	public Tire tire;
	
	public void run() {
		tire.roll();
	}
	public Tire parking(Tire tire) {
		tire.stop();
		return tire;
	}	
	
}

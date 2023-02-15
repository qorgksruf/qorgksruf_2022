package Day11.EX3;

public class SportCar extends Car {

	@Override
	public void speedUp() {
		speed++;
	}
	
	
	@Override
	public final void stop() { 
		System.out.println("차 멈춤");
		speed=0;
	}
	
	//stop 메소드가 final 있으니까
	
}

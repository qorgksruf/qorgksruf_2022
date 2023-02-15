package Day11.EX2;

public class Computer extends Calculator {

	@Override
	public double areaCircle (double r) {
		System.out.println("자식 객체가 재정의");
		return Math.PI*r*r;
		
	}
	
	
	
}

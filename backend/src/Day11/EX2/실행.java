package Day11.EX2;

public class 실행 {
	public static void main(String[] args) {
		
		
		int r=10;
		
		//부모객체
		Calculator calculator=new Calculator();
		System.out.println( calculator.areaCircle(r));
		
		//자식객체
		Computer computer=new Computer();
		System.out.println(computer.areaCircle(r));
		
		
	}
}

package 연습장4;

public class 실행 {

	public static void main(String[] args) {
		
		Calculator myCalc=new Calculator();
		
		myCalc.poewrOn();
		
		int result1=myCalc.plus(5, 6);
				System.out.println(result1);
				
		int x=10;
		int y=4;
		double result2=myCalc.divide(x,y);
		System.out.println(result2);	
		
		
		myCalc.powerOff();
		
		System.out.println(myCalc.info());
		
	}//main e
}//class e

package Day08_EX4_P230;
//******외부
public class 실행 {

	public static void main(String[] args) {
		//외부에서 함수 호출-->객체필요
		 Calculator myCalc=new  Calculator();
		
		 //******객체를 통한 멤버 함수 호출*****
		 myCalc.powerOn( );
		 
		 //3.
		int result1= myCalc.plus(5, 6);
		System.out.println(result1);
		
		
		int x=10;
		int y=4;
		double result2=myCalc.divide(x, y);
		System.out.println(result2);
		
		myCalc.powerOff();
		
		
		myCalc.info();
		System.out.println(myCalc.info());
	}//main e
}//class e

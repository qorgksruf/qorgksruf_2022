package Day09_EX6;

public class 실행 {
	void 함수(){}
	public static void main(String[] args) {
		
		실행 실행=new 실행();
		실행.함수();
		
		Carculator mycal=new Carculator();
		System.out.println(mycal.no);
		mycal.no=10;
		System.out.println(mycal.getNo());
		
		
		
		System.out.println(Carculator.pi); 
		double result1=10*10*Carculator.pi;
		
		Carculator.plus(10,5);
		Carculator.minus(10, 5);
		
		System.out.println(Carculator.info);
	}

}


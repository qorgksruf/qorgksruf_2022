package Day09_EX2;

public class 실행 {

	public static void main(String[] args) {
		//붕어빵객체=지역변수
		//스택영역=힙영역주소-> 힙이 다르다=집주소 다르다
		붕어빵틀 붕어빵1=new 붕어빵틀();
		System.out.println("붕어빵1:"+붕어빵1);
		붕어빵1.굽기();
		
		//2.
		붕어빵틀 붕어빵2=new 붕어빵틀("반죽");
		System.out.println("붕어빵2:"+붕어빵2);
		붕어빵2.변경("반죽", "슈크림");
		System.out.println("붕어빵2:"+붕어빵2);
		
		//3.
		붕어빵틀 붕어빵3=new 붕어빵틀("반죽","팥");
		System.out.println("붕어빵3:"+붕어빵3);
		System.out.println("붕어빵판매가:"+붕어빵3.판매가());
		
		
		//4.붕어빵 새로 만드는 것도 함수 가능
		System.out.println("붕어빵4 판매:"+붕어빵3.판매());
		
		//5.
		붕어빵3.확인(붕어빵3);
		
		//6.
		System.out.println(붕어빵3.여러개판매(5));
		
		
	}//main e
}//class e

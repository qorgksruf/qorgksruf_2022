package Day09_EX8.package1;

public class B {
	
	
	//1. A클래스가 public 일떄
	A a;	//기능 : 같은 패키지는 아니지만 import 위에 해서 가능
		//2. A클래스가 public 아닐떄
				//불가능
	A a1=new A(true);
	A a2=new A(1);
	//A a3=new A("문자열");  private는 무조건 내부에서만 사용
	
	public static void main(String[] args) {
		A a4=new A(true);
		a4.field1=10; 
		a4.field2=10; //같은 패키지 가능
		//a4.field3=10;	//private 필드는 외부에서 사용불가능
	}
}

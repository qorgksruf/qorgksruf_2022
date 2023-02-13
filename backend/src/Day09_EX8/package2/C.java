package Day09_EX8.package2;

import  Day09_EX8.package1.A;

public class C {
	
	//1. A클래스가 public 일떄
	A a;	//기능 : 같은 패키지는 아니지만 import 위에 해서 가능
		//2. A클래스가 public 아닐떄
				//불가능
	A a1=new A(true);	//public 가능
	//A a2=new A(1); //default 다른 패키지일경우 발가능
	//A a3=new A("문자열");	//private x
	
	public static void main(String[] args) {
		A a4=new A(true);
		a4.field1=10;	//public은 다른 패키지여도 됨
		//a4.field2=10; 걍 무조건 같은 패키지일떄만 됨
		//a4.field3=10; default나 private는 안됨
	}
}

package Day11.EX4.package2;

import Day09_EX8.package1.A;

//-----------페키지2--------------------//
public class C {
	public void method() {
		A a=new A();	//x
		a.field="value";	//x
		a.method;//x
	}
}

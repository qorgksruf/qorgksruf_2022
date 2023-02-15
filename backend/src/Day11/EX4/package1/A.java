package Day11.EX4.package1;
//-----------페키지1--------------------//
//A의 상속을 받아도 protect때문에 new는 안됨 부모꺼 그대로 쓸 수는 있음
//A의 protected 생략하면 같은 패키지만 가능함 즉 B class만 적용됨
//A에 private쓰면 자기 class만 적용됨
public class A {

	
	protected String field;
	protected A() {}
	protected void method() {}
}

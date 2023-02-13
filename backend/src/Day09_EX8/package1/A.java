package Day09_EX8.package1;

/*
 * 접근제한자: 해당 클래스,필드,생성자,메소드 접근을 제한하는
 * 	public 			vs private
 * 모든곳에서 사용			현재클래스에서만사용
 * 
 * 생략(default)		vs protected
 * 같은패키지내에서		같은패키지내에서
 * 					+다른 패키지일경우,자식 클래스는 가능
 * */


public class A {
	
	A a1=new A(true);
	A a2=new A(1);
	A a3=new A("문자열");
	
	//public 생성자
	public A(boolean b) {}
	
	//default생성
	A(int b){}
	
	//private생성자
	private A(String s) {}
	
	//public필드
	public int field1;
	
	//default 필드
	int field2;
	
	//private 필드
	private int field3;
}

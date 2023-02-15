package Day11.EX5;

public class 실행 {
	public static void main(String[] args) {
		
		//자식 객체 만들기
		Child child=new Child();
		child.name="유재석";
		child.job="방송인";
		
		//자식 객체를 부모 객체로 이동 즉 타입변환,타입변경되면 자신꺼 못씀
		Parent parent=child;
		Object object=child;//child가 무슨 타입인지 모를때 object사용해서 Member 만들고해
	//	Member member=(Member) object;
		
		
		
		parent.method1();
		parent.method2();
		//부모넨버인데  parent.method3(); 자식멤버는 사용불가능
		
		System.out.println(parent.name);
		
		
		//------강제변환------------//
		//1.부모 객체를 자식 객체로 이동[강제타입변환]
		Child child2=(Child)parent;
		
		child2.method1();
		child2.method2();
		child2.method3();
		
		System.out.println(child2.name);
		System.out.println(child2.job);
		
		
	}
}

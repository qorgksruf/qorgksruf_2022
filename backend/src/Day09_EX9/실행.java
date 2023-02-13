package Day09_EX9;
//외부~!!!!!!!!!!!!!!!!!!!
public class 실행 {

	public static void main(String[] args) {
		
	
	//생성자가 private여서 객체 생성불가능함
	//객체없이 메소드[ static]호출하기위해
	
	Member m1= Member.getInstance();
	Member m2=Member.getInstance();

	System.out.println(m1);
	System.out.println(m2);
	}
}

package Day09_EX7;

public class 실행 {

	
	public static void main(String[] args) {
		
		//객체생성
		Korean k1=new Korean("123456-1234567", "김자바");
		
		//객체 멤버 호출
		System.out.println(k1.nation);
		System.out.println(k1.ssn);
		System.out.println(k1.name);
		
		//3.객체 멤버 변경
		k1.nation="미국";	//final은 변경불가
		k1.ssn="880420-1234567";
		k1.name="유재석"; //얘는 final 아니여서 변경 가능함
		
		
		System.out.println(Korean.EARTH_RADIUS);
		System.out.println(Korean.EARTH_SURFACE_AREA);
	}//main e
}//class e

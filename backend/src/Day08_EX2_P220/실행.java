package Day08_EX2_P220;

public class 실행 {
	public static void main(String[] args) {
		
		
		
		//1.객체 생성[빈생성자]
		Korean k1=new Korean();
			//객체정보[객체명.toString]
		System.out.println(k1.toString());
		
			//객체필드호출[객체명.필드명]
		System.out.println(k1.nation);
		System.out.println(k1.name);
		System.out.println(k1.ssn);
		//2.객체생성
		Korean k2=new Korean("빅자바", "011225-1234567");
		System.out.println(k2.toString());
		
		System.out.println(k2.nation);
		System.out.println(k2.name);
		System.out.println(k2.ssn);
	}
}

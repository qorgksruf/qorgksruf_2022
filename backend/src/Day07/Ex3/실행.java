package Day07.Ex3;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		

		//*객체활용
		System.out.println("아이디;;");		String id= scanner.next();
		System.out.println("비밀번호;;;");		String password=scanner.next();
		
		//1.아이디와 비밀번호 , 로 구분해서 하나의 문자열 합치기
		String[]배열= new String[3];	//객체 3개를 저장할 수 있는 배열, 문자열 1개 저장하는 클래스/객체
		배열[0]=id+","+password;	//아이디와 비밀번호를','로 구분해서 하나의 문자열로 합치기
								//배열에 합친 문자열 대입
		System.out.println( 배열[0].split(",")[0]);
		

		//2. 회원 클래스 만들어서 회원객체 만들자 ==============주로 이걸사용===================
		Member[]배열2=new Member[3];	//멤버 객체 3개를 저장할 수 있는 배열 
		//Member 문자열 2개 저장할 수 있는 클래스/객체		
		Member m1=new Member();
		m1.id=id;//입력받은 아이디를 객체내 필드인 ID에 대입
		m1.password=password;
		배열2[0] = m1;	//배열2에 m1객체 대입
		System.out.println(배열2[0].id);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//main e
}//class e

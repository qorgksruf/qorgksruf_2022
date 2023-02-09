package 연습장;

import java.util.Scanner;

public class 연습22 {

	public static void main(String[] args) {
		
		Scanner scanner =new Scanner(System.in);
		
		
		
		System.out.println("아이디;;;");
		String id=scanner.next();
		
		System.out.println("비밀번호;;;");
		String password=scanner.next();
		
		String[]배열=new String[3];
		배열[0]=id+","+password;

		System.out.println(배열[0].split(",")[0]);
		
		Member[]배열2=new Member[3];
		
		Member m1=new Member();
		m1.id=id;
		m1.password=password;
		배열2[0]=m1;
		System.out.println(배열2[0].password);
	}//main e
}//class e

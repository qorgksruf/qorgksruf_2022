package 미니팀프로젝트.View;

import java.util.Scanner;

import 미니팀프로젝트.Controller.Controller;

public class Front {
	Scanner scanner=new Scanner(System.in);
	Controller c=new Controller();
	
	
	
	public void index(){
		System.out.println("이름입력하세요");
		String id = scanner.next();
		System.out.print("비밀번호 : ");
		String pw = scanner.next();
		System.out.print("전화번호 : ");
		String phone = scanner.next();
		
		int result 
			= c.signup(id, pw, phone);
		if(result==1) {
			System.err.println("[알림]회원가입성공");
		}
		
	}
	
	
	
	

}//class e

package 연습장6;


import java.util.Scanner;

public class Front {

	Scanner scanner=new Scanner(System.in);
	Mcontroller mc=new Mcontroller();
	
	public void index() {
		while(true) {
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			int ch =scanner.nextInt();
			if(ch==1) {
				signUp();
			}else if(ch==2) {
				login();
			}else if(ch==3) {
				finId();
			}else if(ch==4) {
				findPasswowrd();
			}else {}
		}
		
		
	}//index e
	
	
	void signUp() {
		System.out.println("아이디입력;;");
		String id=scanner.next();
		System.out.println("비밀번호입력");
		String pwd=scanner.next();
		System.out.println("비번확인입력");
		String confirmpwd=scanner.next();
		System.out.println("이름입력");
		String name=scanner.next();
		System.out.println("폰번입력입력");
		String phone=scanner.next();
		
		
		int result=
				mc.signUp(id, pwd, confirmpwd,name, phone );
		if(result==1) {
			System.out.println("회원가입실패");
		}else if(result==0) {
			System.out.println("히원가입성공");
		}

	}
	
	
	
	void login() {
		System.out.println("아이디입력");
		String id=scanner.next();
		System.out.println("비밀번호입력");
		String pwd=scanner.next();
		
		int result=
		mc.login( id,pwd);
		
		if(result>=0) {
			System.out.println("로그인성공");
		}else if(result==-2) {
			System.out.println("일치하는 아이디가 없습니다");
		}
	}
	
	
	void finId() {
		System.out.println("이름입력");
		String name=scanner.next();
		System.out.println("전번입력");
		String phone=scanner.next();
		
		String result=
				mc.finId(name,phone);
		
		if(result==null) {
			System.out.println("일치하는 정보가 없음");
			
		}else {
			System.out.println("회원의 아이디"+ result);
		}
	
	}
	
	
	
	void findPasswowrd() {
		
	}
	
	
	
	
	
}//class e

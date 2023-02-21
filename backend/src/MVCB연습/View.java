package MVCB연습;

import java.util.Scanner;

public class View {
	Scanner scanner = new Scanner(System.in);
	//싱글톤
	private static View view = new View();
	public View() {
	}
	public static View getInstance() {
		return view;
	}
	
	
	public void index() {
		while(true) {
			System.out.println("1.회원등록 2.출력 3.수정 4.삭제");
			int ch=scanner.nextInt();
			if(ch==1) {
				signup();
			}else if(ch==2) {
				
			}else if(ch==3){
				
			}else if(ch==4) {
				
			}
		}//while e
	}//index e
	
	
	public void signup() {
		System.out.println("------등록-------");
		System.out.println("아이디;;");
		String mid = scanner.next();
		System.out.println("비밀번호;;");
		String mpw = scanner.next();
		
//		Controller con = new Controller();
//		boolean result = con.signup(mid, mpw);
		
		boolean result=
				Controller.getInstance().signup(mid,mpw);
		
		if(result==true) {
			System.out.println("회원가입성공");
		}else {
			System.out.println("회원가입실패");
		}
	}
	
	
}//class e

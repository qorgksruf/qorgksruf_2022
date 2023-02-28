package Day20.gallery.View;

import java.util.Scanner;

import Day20.gallery.Controller.MController;
import MVC연습.Controller.Mcontroller;

public class indexView {
	private static indexView indexview = new indexView();
	private indexView() { }
	public static indexView getInstance( ) {
		return indexview;
	}
	
	
	 private Scanner scanner = new Scanner(System.in);
	
	//메인패아자
	public void index() {
		while(true) {
			System.out.println("1. 로그인  2.회원가입");
				try {
							int ch = scanner.nextInt();
							if (ch==1){
								
							}else if(ch==2) {
								signup();
							}
					}		
					catch (Exception e) {
							System.out.println("잘못된 입력");
							scanner = new Scanner(System.in);
					}		
				}

				
			
	}//index e
	
	// 회원가입페이지
	public void signup() throws Exception {// 오류 발생하면 해당 메소드를 호출했던 곳으로 예외이동
		System.out.println("아이디");
		String mid = scanner.next();
		System.out.println("비밀번호");
		String mpw = scanner.next();
		System.out.println("이름");
		String mname = scanner.next();
		System.out.println("전화번호");
		String mphone = scanner.next();	
		
		int result = 
			MController.getInstance().signup(mid, mpw, mname, mphone);
		if(result==1) {
			System.out.println("회원가입성공");
		}else if(result==2) {
			System.out.println("사용중인아이디");
		}else if(result==3) {
			System.out.println("시스템오류");
		}
		
	}
	
	//로그인페이지
	
	public void login() {
		System.out.println("아이디입력");
		String mid = scanner.next();
		
		System.out.println("비밀번호입력");
		String mpw = scanner.next();
		
		boolean result =
				MController.getInstance().login(mid , mpw);
		if(result==true) {
			System.out.println("로그인에성공하였습니다");	
			//게시물 초기메뉴로이동 BoardView페이지로 이동 
			BoardView.getInstance().index();
		}else if(result==false) {
			System.out.println("아이디와 패스와드가 일치하지 않습니다");
		}
	}
	
	
	
	
	
	
	
}//class e

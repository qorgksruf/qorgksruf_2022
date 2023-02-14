package 과제4_강사풀이;

import java.util.Scanner;

import 과제4_강사풀이_controller.Mcontroller;

public class Front {

	private static Front front =new Front();
	private Front() {}
	private static Front getInstance() {
		return front;
	}
	
	private Scanner scanner =new Scanner(System.in);
	
	//메인페이지
	public void index() {
		while(true) {
			System.out.println("-------------이젠 커뮤니티------------");
			System.out.println("1.회원가입 2.로그인 3.아디찾기 4.비번찾기" );
			int ch=scanner.nextInt();
			if(ch==1) { signup_page(); } 
			if(ch==2) { login_page(); } 
			if(ch==3) { findid_page(); } 
			if(ch==4) { findpw_page();} 
	
		}
	}	
	//회원가입
	public void signup_page() {
		System.out.println("아이디");
		String id=scanner.next();
		
		System.out.println("비번");
		String pw=scanner.next();
		
		System.out.println("비번확인");
		String confirmpw=scanner.next();
		
		System.out.println("이름");
		String name=scanner.next();
		
		System.out.println("전화번호");
		String phone=scanner.next();
		
		int result=	//Mcontroller에 값 전달해주는거임
				Mcontroller.getInstance().signup(id, pw, confirmpw, name, phone);
		if(result==1) {
			System.out.println("회원가입실패");
			
		}else if(result==0) {
			System.out.println("회원가입성공");
		}
	}
		
	//로그인
	public void login_page() {
		//입력부
		System.out.println("아이디");
		String id=scanner.next();
		
		System.out.println("비번");
		String pw=scanner.next();
		//컨트롤에게 전달 후 결과 받기
		int result=
				Mcontroller.getInstance().login(id, pw);
		
		if(result==-1) {
			System.out.println("로그인실패 비밀번호 틀림 ");
		}else if(result==-2) {
			System.out.println("로그인실패 아이디 없습니다");
		}else {
			System.out.println("로그인 성공");
			board_page(); //로그인 성공시 게시물패이지로 이동하도록;;;;;;;
		}
	}
	
	//아이디찾기
	public void findid_page() {
		//입력부
		System.out.println("이름");
		String name=scanner.next();
		
		System.out.println("전화번호");
		String phone=scanner.next();
		//컨트롤에게 전달 후 결과 받기
		String result= Mcontroller.getInstance().findId(name, phone);
		if(result==null) {
			System.out.println("아이디 찾기 실패");
		}else {
			System.out.println("회원님아이디:"+result+"입니다");
		}
	}
	
	
	//비밀번호찾기 
	public void findpw_page() {
		System.out.println("아이디");
		String id=scanner.next();
		System.out.println("전화번호");
		String phone=scanner.next();
		
		String result=
				Mcontroller.getInstance().findpw(id, phone);
		if(result==null) {
			System.out.println("비밀번호 찾기 실패");
		}else {
			System.out.println("회원님의 비밀번호:"+result+"입니다");
		}
		
	}
	
	
	
	//로그인 성공시 게시뭂출력페이지
	public void board_page() {}
	
	//게시물 쓰기 페이지 
	public void write_page() {}
	
	//게시물 상세페이지
	public void view_page() {}
	
	//게시물 수정페이지
	public void update_page() {}
	
	
}

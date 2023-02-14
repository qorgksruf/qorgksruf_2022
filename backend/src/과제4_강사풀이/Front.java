package 과제4_강사풀이;

import java.util.Scanner;

import 과제4_강사풀이_Model.Board;
import 과제4_강사풀이_controller.Bcontroller;
import 과제4_강사풀이_controller.Mcontroller;

public class Front {

	private static Front front =new Front();
	private Front() {}
	public static Front getInstance() {
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
	public void board_page() {
		while(true) {//무한루프를 쓰는 이유는 로그아웃을 할떄까지 게시물 계속 보여주겠다는 뜻
			
			System.out.println("======커뮤니티========");
			System.out.println("번호\t조회수\t작성자\t제목");
			
			
			//출력부[전체출력]
			int i=0;	//얘는 전체글
			for( Board b: 과제4_강사풀이_controller.Bcontroller.getInstance().getList()) {
				System.out.println( i+"\t"+b.getView()+"\t"+b.getMember().getId()+"\t"+b.getTitle());
				i++;
			}
			
			//메뉴
			System.out.println("1.쓰기 2.글보기 3.로그아웃");	
			int ch2=scanner.nextInt();
			if(ch2==1) {
				write_page();
			}else if(ch2==2) {
				view_page();
			}else if(ch2==3) {
				Mcontroller.getInstance().logOut(); 
				break;
			}
			
		}//while e
	}//함수끝
	
	
	//게시물 쓰기 페이지 
	public void write_page() {
		System.out.println("==========글쓰기페이지==========");
		System.out.println("제목");
		String title=scanner.next();
		
		System.out.println("내용");
		String content=scanner.next();
		boolean result=과제4_강사풀이_controller.Bcontroller.getInstance().write(title, content);
		if(result) {
			System.out.println("글 작성 성공");
		}else {
			System.out.println("글 작성 실패");
			
		}
		
		
	}
	
	//게시물 상세페이지
	public void view_page() {
		System.out.println("이동할 게시물 번호[인덱스]");
		int bno=scanner.nextInt();
		Board result=
				Bcontroller.getInstance().getBoard(bno);
		System.out.println("제목"+result.getTitle());
		System.out.println("작성자"+result.getMember().getId()+"\t조회수"+result.getView() );
		System.out.println("내용"+result.getContent());
		
		System.out.println("1.삭제 2.수정 3.뒤로가기");
		int ch3=scanner.nextInt();
		if(ch3==1) {
			delete_page(bno);
		}else if(ch3==2) {
			 update_page(bno);
		}else if(ch3==3) {
			return;
		}
		
	}
	
	
	// 게시물 삭제페이지
	public void delete_page(int bno) {
		//현재 보고있는 글의 작성자와 현재 로그인된 회원이 같으면 
		if(Bcontroller.getInstance().getBoard(bno).getMember().equals(
				Mcontroller.getInstance().getLogSession() )
		)	{
			Bcontroller.getInstance().delete(bno);
			System.out.println("삭제가 되었습니다");
			return;
		}
		System.out.println("삭제권한이 없습니다");
	}
	
	//게시물 수정페이지
	public void update_page(int bno) {
		if(Bcontroller.getInstance().getBoard(bno).getMember().equals(
			Mcontroller.getInstance().getLogSession() )
				)	{
			System.out.println("새로운제목");
			String title=scanner.next();
			
			System.out.println("새로운내용");
			String content=scanner.next();
			Bcontroller.getInstance().update(bno, title, content);
			System.out.println("수정완료");
			return;
		}
		
	}
	
}

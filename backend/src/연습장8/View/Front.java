package 연습장8.View;

import java.util.Scanner;

import 연습장8.Controller.Bcontroller;
import 연습장8.Controller.Mcontroller;

public class Front {
	Scanner scanner=new Scanner(System.in);
	Mcontroller mc=new Mcontroller();
	Bcontroller bc=new Bcontroller();
	
	public void index() {
		while(true) {
			System.out.println("1.회원가입/ 2.로그인/ 3.아이디찾기/4.비밀번호찾기>>>");
			int ch=scanner.nextInt();
			if(ch==1) {
				signup();
			}else if(ch==2) {
				login();
			}else if(ch==3) {
				findId();
			}else if(ch==4) {
				findPassword(); 
			}else {
				System.out.println("알 수 없는 번호임");
			}
			
			
			
		}//while e	
		
	}//index e
	
	//회원가입페이지함수
	void signup() {
		System.out.println("아이디입력하세요");
		String id=scanner.next();
		System.out.println("비밀번호입력");
		String pwd=scanner.next();
		System.out.println("비번확인입력");
		String confirmed=scanner.next();
		System.out.println("이름입력");
		String name=scanner.next();
		System.out.println("폰번호입력");
		String phone=scanner.next();
		
		
	int result=
				mc.signup( id, pwd, confirmed, name, phone );
		if(result == 1) {
			System.err.println("회원가입실패");
		}else if(result == 0) {
			System.err.println("회원가입성공");
		}
		
	}
	
	//로그인함수
	void login() {
		System.out.println("아이디입력");
		String id=scanner.next();
		System.out.println("비밀번호입력");
		String pwd=scanner.next();
		
		int result= mc.login(id,pwd);
		
			if(result>=0) {
					String writer= mc.findwriter(result);
					System.out.println("로그인성공");
					System.out.println(writer+"님 환영합니다");
					
					while(true) {
						System.out.println("=======커뮤니티==========");
						System.out.println("번호\t\t조회수\t\t작성자\t제목");
						totalView();
						System.out.println();
						System.out.println("메뉴>>1.글쓰기/2.게시물보기/3.로그아웃");
						int ch=scanner.nextInt();
						
						
						if(ch==1) {//글쓰기
							System.out.println("화긴");
						}else if(ch==2) {//게시판
							System.out.println("화긴");
						}else if(ch==3) {//게시물보기
							System.out.println("로그아웃");
							break;				
						}else { 
							System.out.println("알수없는 행동입니다");
						}
				
					}
						
			}else if(result==-1) {
				System.out.println("비밀번호가 다릅니다");
			}else if(result==-2) {
				System.out.println("존재하지 않는 아이디입니다.");
			}
		
	}
	//아이디찾기
		void findId() {
			System.out.println("이름;;;");
			String name = scanner.next();
			System.out.print("전화번호 : ");
			String phone = scanner.next();
			
			
			String result=
					 mc.findId(name,phone);
			if(result.equals("Y")) {
				System.out.println("전화번호노일치");
			}else if(result.equals("N")) {
				System.out.println("존재하지 않는회원");
			}else {
				System.out.println("아이디:"+result);
			}
			
		}
	
	//비밀번호 찾기
		void findPassword() {
			System.out.print("아이디 : ");	String id = scanner.next();
			System.out.print("전화번호 : ");	String phone = scanner.next();
			
			String result=
					mc.findPassword(id, phone);
			
			if(result.equals("Y")) {
				System.err.println("전화번호가 일치하지 않습니다.");
			}else if(result.equals("N") ) {
				System.err.println("존재하지 않는 회원입니다 않습니다.");
			}else {
				System.out.println("패스워드;;"+result);
			}
			
		}
		//전체게시물출력
		void totalView() {
			for(int i=0; i<bc.boardDb.size(); i++) {
				System.out.println(i+"\t\t"+bc.boardDb.get(i).count+"\t\t"+bc.boardDb.get(i).id+
						"\t\t"+bc.boardDb.get(i).title );
			}
		}	
		
		
		//게시물작성하기
		void writePost(int i) {
			System.out.println("================새 글 작성하기======================");
			System.out.println("제목;;");
			String title = scanner.next(); 
			System.out.print("내용 : ");
			String content = scanner.nextLine();
			
			String id =mc.findwriter(i);
			String result
					=bc.savePost(title, content, id);
			
			if(result==null) {
				System.out.println(id +"님의 글이 작성되었습니다");
			}
		}
		
		
		//게시물보기
		void viewPost(String writer) {
			String id=writer;
			System.out.println("열람할 글 번호 입력");
			int ch=scanner.nextInt();
			
			Board post = bc.viewPost(ch, id);
			
			
			
		}
	
		
		
}//class e

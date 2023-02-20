package MVC연습장.view;

import java.util.Scanner;

import MVC연습.Controller.Bcontroller;
import MVC연습.Controller.Mcontroller;
import MVC연습.Model.Board;

public class Front {
	Scanner scanner = new Scanner(System.in);
	Mcontroller mc = new Mcontroller();
	Bcontroller bc= new Bcontroller();
	
	public void index(){
		while(true) {
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			int ch=scanner.nextInt();
			if(ch==1) {
				signup();
			}else if(ch==2) {
				login();
			}else if(ch==3) {
				findid();
			}else {
				findpassword();
			}
		}//while e
		
	}//index e
	
	public void signup() {
		System.out.println("아이디입력");
		String id = scanner.next();
		System.out.println("비밀번호");
		String pwd = scanner.next();
		System.out.println("비밀번호 확인");
		String confirmed = scanner.next();
		System.out.println("이름입력");
		String name = scanner.next();
		System.out.println("폰번호입력");
		String phone = scanner.next();
		
		int result=
				mc.signup(id, pwd,confirmed,name,phone);
		if(result==1) {
			System.out.println("회원가입실패");
		}else if(result==2) {
			System.out.println("회원가입성공");
		}
		
	}
	
	
	public void login() {
		System.out.println("아이디입력");
		String id= scanner.next();
		System.out.println("비밀번호입력");
		String pwd=scanner.next();
		
		int result=
				mc.login(id, pwd);
		if(result==1) {
			System.out.println("로그인성공");
			while(true) {
				System.out.println("============커뮤니티=================");
				System.out.println("번호\t\t조회수\t\t작성자\t\t제목");
				totalview();
				System.out.println("메뉴>> 1.글쓰기 2. 게시물보기 3.로그아웃");
				int ch=scanner.nextInt();
				
				if(ch==1) {
					writepost(result);
				}else if(ch==2) {
					viewpost(id);
				}else if(ch==3) {
					System.out.println("로그아웃");
					break;
				}
				
			}
			
		}else if(result==-2) {
			System.out.println("로그인실패");
		}else if(result==-2){
			System.out.println("존재하지 않는아이디입니다");
		}
	}
	
	//게시물전체출력
	void totalview() {
		for(int i=0; i<bc.boardDB.size(); i++) {
			System.out.println(i+"\t\t"+bc.boardDB.get(i).count+"\t\t"+
		bc.boardDB.get(i).id+"\t\t"+ bc.boardDB.get(i).title);
		}
	}
	
	void writepost(int i) {
		System.out.println("제목입력");
		String title= scanner.next();
		System.out.println("내용입력");
		String content=scanner.next();
		
		String id=
				mc.findwriter(i);
		
		String result=
				bc.savepost(title, id, content);
		if(result.equals("2") ) {
			System.err.println(id+"님의글이작성되었습니다");
		}
	}
	
	
	//게시물보기
	void viewpost(String writer){
		String id=writer;
		
		System.out.println("열람할 글번호를 입력하세요");
		int ch=scanner.nextInt();
	
		Board post=bc.viewPost(ch, id);
		System.out.println("제목"+post.title);
		System.out.println("작성자"+post.content);
		System.out.println("내용"+post.content);
		
		System.out.println("1.삭제하기2.수정하기 3.뒤로가기");
		int postch=scanner.nextInt();
		
		if(postch==1){
			String delete =bc.delpost(postch, id);
			if(delete.equals("del")) {
				System.out.println("글 삭제완료");
			}else {
				System.out.println("본인글만 삭제가능함");
			}
		}else if(postch==2) {
			System.out.println("수정하기");
			System.out.println("수정할 내용입력");
			scanner.next();
			String editcontent=
					scanner.next();
			
			String edit=bc.editpost(postch, id, editcontent);
			if(edit.equals("edit")) {
				System.out.println(" 글 수정완료"); 
				
			}else {
				System.out.println("본인글작성글만 수정가능");
			}
		}else if(postch==3){
			//뒤로가기
		}
	}
	
	//아이디찾기로직
	void findid() {
	System.out.println("이름입력");
	String nme=scanner.next();
	System.out.println("폰번호입력");
	String phone=scanner.next();
	
	String result=
			mc.findId(nme, phone);
	
	if(result.equals("Y")) {
		System.out.println("전화번호일치");
	}else if(result.equals("N")) {
		System.out.println("존재하지 않는회원");
	}else {
		System.out.println("아이디:"+result);
	}
		
	}
	
	//비밀번호찾기로직
	void findpassword() {
		System.out.println("아이디입력");
		String id=scanner.next();
		
		System.out.println("전화번호입력");
		String phone=scanner.next();
		
		String result=
				mc.findId(id, phone);
		if(result.equals("Y")) {
			System.out.println("전화번호불일치");
		}else if(result.equals("N")) {
			System.out.println("존재하지않는회원");
		}else {
			System.out.println("패스워드값;;;"+result);
		}
	}
	
	
	
}//class e

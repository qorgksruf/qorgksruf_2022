package MVC연습.View;

import java.util.Scanner;


import MVC연습.Controller.Bcontroller;
import MVC연습.Controller.Mcontroller;
import MVC연습.Model.Board;

public class Front {
	
	Scanner scanner = new Scanner(System.in);
	Mcontroller mc = new Mcontroller();
	Bcontroller bc = new Bcontroller();
	
	public void index() {
		while(true) {
			System.out.println("1.회원가입 2.로그인 3. 아이디찾기 4.비밀번호찾기");
			int ch=scanner.nextInt();
			if(ch==1) {
				signup();
			}else if(ch==2) {
				login();
			}else if(ch==3) {
				findId();
			}else {
				findpassword();
			}
		}//while e
	}///index e
	
	
	//회원가입로직
	public void signup() {
		System.out.println("아이디입력");
		String id = scanner.next();
		System.out.println("비밀번호");
		String pwd = scanner.next();
		System.out.println("비밀번호 확인");
		String confirmed = scanner.next();
		String name = scanner.next();
		String phone = scanner.next();
		
		int result=
				mc.signup( id, pwd,confirmed,name, phone);
		if(result==1) {
			System.out.println("회원가입실패");	
		}else if(result==2) {
			System.out.println("회원가입성공");
		}
		
	}//signup 완료
	
	//로그인로직
	public void login() {
		System.out.println("아이디입력;;");
		String id = scanner.next();
		System.out.println("비밀번호입력");
		String pwd = scanner.next();
		
		int result=
					mc.login(id,pwd);
		if(result>=0) {// 로그인성공
			String writer=
					mc.findwriter(result);
			System.out.println("로그인성공하였습니다");
			System.out.println(writer+"환영함니다");
			
			while(true) {
				System.out.println("==============커뮤니티=================");
				System.out.println("번호\t\t조회수\t\t작성자\t\t제목");
				totalView();
				System.out.println("메뉴>> 1.글쓰기 2. 게시물보기 3.로그아웃");
				int ch = scanner.nextInt();
				
				if(ch==1) {
					writePost(result);//여기모르겠음
				}else if(ch==2) {
					
				}else if(ch==3) {
					System.out.println("로그아웃임");
					break;
				}
			}
			
			
		}else if(result==-1) {
			System.out.println("비밀번호가 다릅니다");
		}else if(result==-2) {
			System.out.println("존재하지 않는아이디입니다");
		}
		
		
	}//로그인함수 끝
	
	//아이디찾기로직
	void findId() {
		System.out.println("이름");
		String name = scanner.next();
		System.out.println("폰번호");
		String phome = scanner.next();
		
		String result= 
				mc.findId(name, phome);
		
		if( result.equals("Y")) {
			System.out.println("전화번호노일치");
		}else if( result.equals("N")){
			System.out.println("존재하지 않는 회원");
		}else {
			System.out.println("아이디:'''"+ result);
		}
		
	}
	
	//비밀번호찾기
	
	void findpassword() {
		System.out.println("아이디입력");
		String id= scanner.next();
		
		System.out.println("전화번호입력");
		String phone= scanner.next();
		
		String result=
				mc.findpassword( id, phone);
		
		if(result.equals("Y")) {
			System.out.println("전화번호불일치");
		}else if( result.equals("N")) {
			System.out.println("존재하지 않는 회원");
		}else {
			System.out.println("패스워드;;;"+result);
		}
		
	}
	

	
	//전체게시물출력
	void totalView() {
		for(int i=0; i<bc.boardDB.size(); i++) {
			System.out.println(i+"\t\t"+bc.boardDB.get(i).count+"\t\t"+bc.boardDB.get(i).title );
		}
	}
	
	
	//게시물작성하기
	void writePost(int i ) {//여기~!!
		System.out.println("제목");
		String title = scanner.next();
		System.out.println("내용");
		String content = scanner.next();
		
		String id= mc.findwriter(i);
		
		String result=
				bc.savepost(title,content,id ); 
		
		if(result.equals("2")) {
			System.out.println(id+"님의 글이 작성되었습니다" );
		}
				
	}
	
	
	//게시물보기
	void viewpost(String writer) {//여기
		String id=writer;//여기
		
		System.out.println("열람하실 글 번호를 입력하세요");
		int ch=scanner.nextInt();
		
		Board post = bc.viewPost(ch,id);
		System.out.println("제목;"+post.title);
		System.out.println("작성자:"+post.id);
		System.out.println("내용:"+post.content);
		
		System.out.println("1.삭제하기 2.수정하기 3.뒤로가기");
		int postchch = scanner.nextInt();
		
		if(postchch==1) {
			String delete = bc.delpost(ch,id);
			if (delete.equals("del")){
				System.out.println("글 삭제완료");
			}else {
				System.out.println("본인 작성글만 삭제가능");
			}
			
		}else if( postchch==2) {
			System.out.println("수정하기");
			System.out.println("수정할내용"); 
			scanner.next();//여기
			String editcontent=scanner.next();
			
			String edit = bc.editpost(ch,id,editcontent);
			
			if(edit.equals("edit")) {
				System.out.println("글수정완료");
			}else {
				System.out.println("본인작성글만 수정가능");
			}
			
		}else if(postchch==3) {
			//돌아가기
		}
	}
	
	
	
	
	
	
}//class e

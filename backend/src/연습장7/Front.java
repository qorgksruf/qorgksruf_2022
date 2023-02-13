package 연습장7;

import java.util.Scanner;

public class Front {

	Scanner scanner=new Scanner(System.in);
	Bcontroller bc=new Bcontroller();
	
	
	public void index() {
		
		while(true) {
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			int ch=scanner.nextInt();
			if(ch==1) {
				signup();
			}else if(ch==2) {
				
			}else  if(ch==3) {
				
			}else if(ch==4) {
				
			}else {}
		}//while e
	}//index e
	
	
	
	//회원가입로직
	void signup() {
		System.out.println("아이디를 입력하세요");
		String id=scanner.next();
		
		System.out.println("비밀번호를 입력하세요");
		String pwd=scanner.next();
		
		System.out.println("비밀번호를 입력하세요");
		String confirmed=scanner.next();
		
		System.out.println("이름을확인하세요");
		String name=scanner.next();
		
		System.out.println("전화번호를 입력하세요");
		String phone=scanner.next();
		
		int result=
				bc.signup(id, pwd, confirmed, name, phone); 
		
		if(result==1) {
			System.out.println("회원가입실패");
		}else if(result==0) {
			System.out.println("회원가입성공");
			
		}
	}
	
	
	//로그인 페이지
	void login() {
		System.out.println("아이디입력");
		String id=scanner.next();
		System.out.println("비밀번호입력");
		String pwd=scanner.next();
		
		int result=
				bc.login( id, pwd);
		
		 if(result>=0) {
			 System.out.println("로그인성공");
		 }
		
		 else if(result==-1) {
			 System.out.println("비밀번호가ㅏㄷ릅니다");
		 }else if(result==-2) {
			 System.out.println("없는 회원입니다");
		 }
	}
	
	
	
	
	//아이디찾기페이지
	void findId() {
		System.out.println("이름입력");
		String name=scanner.next();
		System.out.println("전화번호입력");
		String phone=scanner.next();
		
		String result=
				bc.findId(name, phone);
		if(result==null) {
			System.out.println("일치하는 회원정보가 없습니다");
		}else {
			System.out.println("회원의 아이디:"+ result);
		}
		
	}
	
	
	
	//비밀번호 찾기 로직
	void findpassword() {
		System.out.println("아이디입력");
		String id=scanner.next();
		System.out.println("전화번호입력");
		String phone=scanner.next();
		
		String result=
				bc. findpassword(id,phone);
		
		if(!result.equals(null)) {
			System.out.println("비밀번호 반환해드릴게요");
		}else {
			System.out.println("아이디와 전화번호를 확인하세요");
		}
	}
	
	
	
	//로그인 성공화면
	void print() {
		while(true) {
			System.out.println("============커뮤니티=========");
			System.out.println("번호\t조회수\t작성자\t제목"); 
			System.out.println("메뉴>>>1.글쓰기 2.글수정 3.로그아웃");
			
			int ch=scanner.nextInt();
			if(ch==1) {
				System.out.println("--------글쓰기-------");
				System.out.println("제목을입력하세요");
				String title=scanner.next();
				System.out.println("내용을입력하세요");
				String content=scanner.next();
				System.out.println("작성자를 입려갛세요");
				String writer=scanner.next();
				String result=
						bc.write(title,content,writer);
				
				System.out.println(result);
				
				break;
			}else if(ch==2) {
				System.out.println("삭제할 인덱스를 입력하세요");
				int no=scanner.nextInt();
				
				String resultremove=bc.remove(no);
				
				System.out.println(resultremove);
				
			}else if(ch==3) {
				index();
				break;
			}
			
		}
	}
	
	
	
}//class e

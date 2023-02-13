package 과제.과제4.view;
// * 입출력 : print, scanner
import java.util.Scanner;



import 과제.과제4.controller.Mcontroller;

public class Front {
	Scanner scanner = new Scanner(System.in); // * 입력객체 
	Mcontroller mc = new Mcontroller();
	
	
	// 1. 메인페이지 
	
	public void index() {
		
		while(true) {
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 : ");
			int ch = scanner.nextInt();
			if( ch == 1 ) { signup(); }
			else if( ch == 2 ) { login(); }
			else if( ch == 3 ) { findId(); }
			else if( ch == 4 ) { findPassword(); }
			else { } 
		}
	}
	
	
	
	// 2. 회원가입 페이지
	void signup() {
		System.out.print("아이디 : ");			String id= scanner.next();
		System.out.print("비밀번호 : ");			String pwd=scanner.next();
		System.out.print("비밀번호 확인 : ");		String confirmpwd=scanner.next();
		System.out.print("이름 : ");				String name = scanner.next();
		System.out.print("전화번호 : ");			String phone = scanner.next();
		int result = 
				mc.signup( id , pwd , confirmpwd , name , phone );
		if( result == 1 ) {
			System.out.println("[회원가입 실패]");
		}else if( result == 0 ) {
			System.out.println("[회원가입 성공]");
		}
	}
	
	
	
	
	// 3. 로그인 페이지
	void login() {
			System.out.println("아이디입력;;;");	 String id=scanner.next();
			System.out.println("비밀번호;;;");	 	 String pwd=scanner.next();
			int result = 
					mc.login( id , pwd );		
			if(result>=0) {
				System.out.println("로그인 성공");
				
				print();
			}
				//게시판으로 이동
			 else if(result==-1) {
				System.out.println("비밀번호가 다릅니다");
			}else if(result==-2) {
				System.out.println("없는 회원입니다");
			}
			
	}
	
	
	
	
	
	
	// 4. 아이디 찾기 페이지 //이름 전화번호 같으면 ㅇㅇㅇ
	void findId() {
		System.out.println("이름 입력"); String name=scanner.next();
		System.out.println("전화번호 입력");	String phone=scanner.next();
		String result = 
				mc.findId( name , phone );	//함수 호출하는데 ㅣ름과 전화번호 전달하고 함수 결과를 result 변수에 저장	
		if(result==null) {	//만약 찾은 아이디가 없으면
			System.out.println("일치하는 회원정보가 없습니다");
		}else  {	//만약 찾은 아이디가 있으면
			System.out.println("회원의 아이디:" + result);
		}
	}
	
	
	
	
	
	// 5. 비밀번호 찾기 페이지 //
	void findPassword() {
		System.out.println("아이디 입력"); String id=scanner.next();
		System.out.println("전화번호 입력"); String phone=scanner.next();
		String result=
				mc.findPassword(id, phone);
		if(!result.equals(null)) {
			System.out.println("비밀번호 반환해드릴게요");
			System.out.println("회원의 비밀번호:" + result);
		} else {
			System.out.println("아이디와 전화번호를 확인하세요");
		}
	
		
	}
	
	
	
	
	
	
	//로그인 성공화면
	
	void print() {
		while(true) {
			System.out.println("===============커뮤니티=============");
			System.out.println("번호\t조회수\t작성자\t제목");
			System.out.println("메뉴>>1.글쓰기 2.글수정 3.로그아웃");
			
			int ch=scanner.nextInt();
			if(ch==1) {//글쓰기
				System.out.println("----------- 글 쓰기 ---------------");
				System.out.println("제목을입력하세요;;");
				String title=scanner.next();//제목
				System.out.println("내용을입력하세요;;");
				String content=scanner.next();//내용
				System.out.println("작성자이름입력하세요;;");
				String writer=scanner.next();//여기 모르겠음.......
				String result=
						mc.write(title,content,writer);
				
				System.out.println(result);
				
				break;
				
			}else if(ch==2) {//글수정
				System.out.println("삭제할 인덱스를 입력하세요");
				int fixno=scanner.nextInt();
				
				String resultRemove = mc.remove(fixno);
				
				System.out.println(resultRemove);
				
			}else if(ch==3) {//로그아웃시
				index();
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}//class e




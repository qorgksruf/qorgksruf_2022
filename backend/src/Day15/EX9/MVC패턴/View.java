package Day15.EX9.MVC패턴;

import java.util.ArrayList;
import java.util.Scanner;

public class View {

	//싱글톤
	private static View view = new View();
	private View() { }
	static View getInstance() {
		return view;
	}
	

	Scanner scanner = new Scanner(System.in);
	
	//메인화면
	public void index() {
		while(true) {
			System.out.println("1.회원등록[C] 2.출력[R] 3.수정[U] 4.삭제[D]");
			int ch = scanner.nextInt();
			if(ch==1) {
				signup();
			}else if(ch==2) {
				list();
			}else if(ch==4) {
				update();
			}
			
		}
	}//index e
	
	
	//회원가입화면
	public void signup() {
		System.out.println("----------등록[c]--------");
		System.out.println("아이디;;;");
		String mid = scanner.next();
		System.out.println("비밀번호;;;");
		String mpw = scanner.next();
		boolean result=
		Controller.getInstance().signup(mid,mpw);
		
		if(result==true) {
			System.out.println("회원가입성공");
		}else {
			System.out.println("회원가입실패");
		}
	}
	
	
	//회원목록화면-> 인수 : x , 반환할거 많으니까 여러명 ArrayList- ,
 	public void list() {
 		
 		System.out.println("================");
 		System.out.println("회원번호 \t 아이디 \t 비번");
 		//컨트롤에게 모든회원<Memverdto>들 요청
 		ArrayList<MemberDto>result=
		Controller.getInstance().list();
 		
 		for(int i=0; i<result.size(); i++) {
 			System.out.printf("%2d \t %s \t %s",
 			result.get(i).getMno() , result.get(i).getMid()	,result.get(i).getMpw() );
 		}
	}
	
	//비밀번호 수정
 	public void update() {
 		System.out.println("-------------------");
 		System.out.println("회원번호");
 		int mno=scanner.nextInt();
 		System.out.println("새로운 비밀번호");
 		String mpw = scanner.next();
 		
 		boolean result=
 				Controller.getInstance().update(mno, mpw);
 		if(result) {
 			System.out.println("수정성공");
 		}else {
 			System.out.println("수정실패");
 			 
 		}
 	}// update e
 	
 	
 	//회원삭제
 	
	public void delete() {
		System.out.println("----------------");
		System.out.println("삭제할 회원번호입력;;");
		int mno = scanner.nextInt();
		
		boolean result =
				Controller.getInstance().delete(mno);	//controller 에게 mno전달후 결과값 받기 
		if(result) {
			System.out.println("삭제성공"); //결과에따른 출력
		}else {
			System.out.println("실패");
		}
	}
	
	
}


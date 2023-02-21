package Day15.EX9.MVC패턴;

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
		
	}
	
	
	
	
}


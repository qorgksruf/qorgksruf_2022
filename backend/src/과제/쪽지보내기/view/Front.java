package 과제.쪽지보내기.view;

import java.util.Scanner;

public class Front {
	
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() {
		return front;
	}
	
	
	
	private Scanner scanner=new Scanner(System.in);
	
	
	public void index() {
		while(true) {
			System.out.println("========게시판만들기=======");
			System.out.println("1.회원가입 2.로그인 ");
			int ch=scanner.nextInt();
			if(ch==1) {
				
			}else if(ch==2) {
				System.out.println("1. 마이패이지 2.로그아웃");
			}
		}
	}
	
}



// 2. 메인페이지
// 제품출력

// 메뉴 :  마이페이지 / 제품등록 / 제품 상세보기 / 로그아웃 

// 3. 제품 등록페이지

// 4. 제품 상세페이지 

// 5. 마이페이지

// 6. 쪽지 상세페이지




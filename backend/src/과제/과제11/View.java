package 과제.과제11;

import java.util.ArrayList;
import java.util.Scanner;

public class View {

	private static View view = new View();
	private View() {}
	static View getInstance() {
		return view;
	}
	
	Scanner scanner = new Scanner(System.in);
	
	
	
		//메인화면 만들기
		public void index() {
			System.out.println(" 1.제품등록 2.제품출력 3. 제품수정 4.제품재고변경 5.제품삭제");
			int ch = scanner.nextInt();
			if(ch==1) {
				signup();
			}else if(ch==2) {
				
			}else if(ch==3) {
				
			}else if(ch==4) {
				
			}else if(ch==5) {
				
			}
			
			
		}//index e
		
		//제품등록함수화면
		public void signup() {
			System.out.println("-----------제품등록---------");
			System.out.println("제품이름");
			String mid = scanner.next();
			System.out.println("제품가격");
			int mprice = scanner.nextInt();
			System.out.println("초기재고");
			String msava=null;
			
			//등록성공, 등록실패
			boolean result =
					Controller.getInstance().signup(mid,mprice,msava);
			if(result==true) {
				System.out.println("등록성공");
			}else {
				System.out.println("등록실패");
			}
		}
		
		
		
		//제품출력함수화면
		public void print() {
			System.out.printf("%3s \t %10s \t %10s \t %10s \n" , "번호" , "제품명" , "가격","재고");
		
			
			ArrayList<BoardDto>result=
					Controller.getInstanceAlL().print();
			
			for(int i=0; i<result.size(); i++) {
				
						result.get(i).getMsave() );
			}
			
		}
		
		
		
		
		
}//class e

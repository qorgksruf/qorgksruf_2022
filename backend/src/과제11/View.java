package 과제11;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
	private static View view = new View();
	private View() {};
	public static View getInstance() {
		return view;
	}

	boolean pstate; 
	
	private Scanner scanner = new Scanner(System.in);
	
	
	
	
	
	public void choice() {
		System.out.println("1.관리자 2.사용자");
		int ch=scanner.nextInt();
			if(ch==1) {
				index();
			}else if(ch==2) {
				
			}
	}
	


	

	public void index() {
		while(true) {
			try {	
					System.out.println(" 1.등록 2.출력 3.수정 4.제고수정 5.삭제 ");
					int ch = scanner.nextInt();
					if(ch==1) {
						regist();
					}else if(ch==2) {
						getProductAll();
					}else if(ch==3) {
						update();
					}else if(ch==4) {
						saveupdate();
					}else if(ch==5) {
						delete();
					}
			}catch (Exception e) {
					scanner = new Scanner(System.in);	//입력한 값 초기화
					System.out.println("프로그램 내 오류발생");
			}		
					
					
		}//while e
	}//index e
	
	//제품등록
	public void regist() {
		System.out.println("---------------제품등록 -----------");
		System.out.println("제품이름입력");
		String pname= scanner.next();
		System.out.println("제품가격입력");
		int pprice= scanner.nextInt();
		System.out.println("초기재고입력");
		int pstock = scanner.nextInt();
		boolean result=
				Controller.getInstance().regist(pname,pprice,pstock);
		if(result) {
			 System.out.println("[[제품등록]]");
		}else{
			System.out.println("[[등록실패]]");
		}
	}
	
	
	//모둔 제품출력
	public void getProductAll() {
		System.out.printf("%3s \t %10s \t %10s \t %10s \n" , "번호" , "제품명" , "가격","재고");

			ArrayList<ProductDto> result
				=Controller.getInstance().getProductAll();	
		
		for(ProductDto dto : result) {	//변형된 리스트를 반복문돌림
			System.out.printf("%3d \t %10s \t %10d \t %10d \n" , 
					dto.getPno() , dto.getPname() , dto.getPprice() , dto.getPstock() );
		}

	}
	
	
	//제품이름 가격변경
	public void update() {
		System.out.println("-----------------------");
		System.out.println("수정할 제품번호입력");
		int pno= scanner.nextInt();
		System.out.println("새 제품이름입력");
		String pname= scanner.next();
		System.out.println("새 가격입력");
		int pprice = scanner.nextInt();
		
		
		
		int result =
				Controller.getInstance().update(pno,pname, pprice);
		if(result==1) {
			System.out.println("수정성공");
		}else {
			System.out.println("수정실패");
		}
	}
	
	
	//제품 재고수정
	public void saveupdate() {
		System.out.println("---------------");
		System.out.println("재고 수정할 제품번호입력");
		int pno = scanner.nextInt();
		System.out.println("수정할 재고 갯수입력");
		int pstock = scanner.nextInt();
		
		boolean result=
				Controller.getInstance().saveupdate(pno, pstock);
		
		if(result) {
			System.out.println("수정성공");
		}else {
			System.out.println("수정실패");
		}
	}
	
	
	//삭제
	public void delete() {
		System.out.println("--------------");
		System.out.println("삭제할 회원번호입력");
		int pno = scanner.nextInt();
		
		boolean result =
				Controller.getInstance().delete(pno);
		if(result) {
			System.out.println("삭제성공");
		}else {
			System.out.println("실패");
		}
				
	}
	
}//class e

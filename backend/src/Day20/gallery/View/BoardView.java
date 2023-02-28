package Day20.gallery.View;

import java.util.ArrayList;
import java.util.Scanner;

import Day20.gallery.Controller.Bcontroller;
import Day20.gallery.Controller.MController;
import Day20.gallery.Model.Dto.BoardDto;
import Day20.gallery.Model.Dto.CategoryDto;


public class BoardView {
	//싱글톤
	private static BoardView boardView = new BoardView();
	private BoardView() { }
	public static BoardView getInstance( ) {
		return boardView;
	}
	
	Scanner scanner = new Scanner(System.in);
	
	
	//모든 게시물 출력
	public void index() {
		while(true) {
			System.out.println("로그인성공");
			//최신 게시물 3개출력
			
			//모든 갤러리 출력
			categoryprint();
			
			System.out.println("-1로그아웃 / 0.갤러리추가/ 이동할 갤러리 번호 선택;;; ");
			int ch = scanner.nextInt();
			if(ch==-1) {
				MController.getInstance().getLogSession(); //로그인세션 초기화
				System.out.println("로그아웃되었습니다 안녕히가세요");
				break;	//while 탈출
			}
			else if(ch==0) {
				categoryAdd();//카테고리 추거
			}else if(ch>0) {
				boardPrint(ch);
			}
			
		}
	}
	
	//카테고리 추가
	public void categoryAdd() {
		System.out.println("===========갤러리추가=============");
		System.out.println("추가할 갤러리 이름");
		scanner.nextLine();
		String cname=scanner.nextLine();
		
		boolean result = Bcontroller.getInstance().categoryAdd(cname);
		if(result) {
			System.out.println("갤러리가 추가되었습니다");
		}else {
			System.out.println("등록실패 관리자에게 문의하세요");
		}
	}
	//모든 카테고리 호출=갤러리 1개당 dto /갤러리여러개면 dto를 배열이나 list로 받아야함 호출
	public void categoryprint() {
		//모든 카테고리 요청 후 리스트에 담기
		ArrayList<CategoryDto>clist = 
							Bcontroller.getInstance().categoryPrint();
		
		//출력1
		//for(int i=0; i<clist.size(); i++) {
		//	System.out.println(clist.get(i).getCno()+"-"+clist.get(i).getCname());
		//}
		
		int count=0;
		for( CategoryDto dto:clist) {
			System.out.print(dto.getCno()+"-"+dto.getCname()+"\t");
			count++;//for문 반복할때마다 1씩 증가
			if(count % 4 ==0) 
			System.out.println();//4개마다 줄바꿈
		}
		
	}	
	// 4. 게시물 쓰기 페이지 
	public void boardAdd(int cno) {
		System.out.println(" =============== 게시물 쓰기 ============== ");
		System.out.print(" 제목 : " ); 	String btitle = scanner.next();
		System.out.print(" 내용 : " );	String bcontent = scanner.next();
		
		boolean result = Bcontroller.getInstance().boardAdd( btitle, bcontent, cno );
		if( result ) { System.out.println("[글등록성공]");}
		else { 
			System.out.println("[글등록실패]");}
		}
		
		
		
		
		
		// 5. 최신 글 3개 출력 페이지
		public void boardPrintRecent() {
			System.out.println("=============== 최신글 ==============");
			ArrayList< BoardDto > blist = Bcontroller.getInstance().boardPrintRecent();
			System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s\t%10s \n" ,
								"번호" , "제목" , "작성자","갤러리","조회수","작성일" );
			for( BoardDto dto : blist  ) {
				System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s\t%10s \n" ,
						dto.getBno() , dto.getBtitle() , dto.getMid() ,
						dto.getBview() , dto.getCname(),dto.getBview(),dto.getBdate() );
			}
		}
		// 6. 선택한 갤러리의 모든 게시물 페이지 
		public void boardPrint( int cno ) {
			System.out.println("=============== 선택한 갤러리 ==============");
			ArrayList<BoardDto> blist = Bcontroller.getInstance().boardPrint(cno);
			System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s \n" ,
							"번호" , "제목" , "작성자","조회수","작성일");
			for( BoardDto dto : blist  ) {
			System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s\t%10s \n" ,
					dto.getBno() , dto.getBtitle() , dto.getMid() ,
					dto.getBdate() , dto.getBview() );
			}//for e
			while(true) {
				System.out.println("갤러리메뉴 : 1.뒤로가기 2. 게시물쓰기 3.게시물보기;;;");
				int ch = scanner.nextInt();
				if(ch==1) {
					break;
				}else if(ch==2) {
					boardAdd(cno);
				}else if(ch==3) {//미구현
					
				}
			}
			
		}	
	
		
		
		
		
}// class e

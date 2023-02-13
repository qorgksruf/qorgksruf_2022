package Day09_EX10_게시판_view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Day09_EX10_게시판_controller.Bcontroller;
import Day09_EX10_게시판_model.Board;

public class Front {

	//싱글톤 객체 만들기 -> 프로그램내 하나의 객체-공유 메모리
	private static Front front=new Front();
	private Front() {}
	public static Front getInstance() {
		return front;
	}
	//필드: 입력객체;[인스턴스 멤버]
	private Scanner scanner=new Scanner(System.in);
	
	
	//2.index함수
	public void index() {
		
		while(true) {	
			print_page(); //출력함수
			System.out.println("1.쓰기 2.상세보기");
			int ch=scanner.nextInt();
			if(ch==1) {
				write_page();
			}else if(ch==2) {
				view_page();
			}
		}
	}
	
	private void write_page() {//쓰기함수
		System.out.println("-------------글쓰기페이지 ------------");
		System.out.println("제목");
		String title=scanner.next();
		
		System.out.println("내용");
		String content=scanner.next();
		
		System.out.println("작성자");
		String writer=scanner.next();
		
		System.out.println("비밀번호");
		String password=scanner.next();
		
		Date date=new Date();//현재 날짜/시간 생성 객체
		int view= 0;	//조회수는 0부터 시작
		
		boolean result =
		Bcontroller.getInstance().write(title, content, writer, password, date, view);	
		
		if(result) {
			System.out.println("글쓰기 성공");
		}else {
			System.out.println("글쓰기 실패");
		}
	}
	
	private void print_page() {
			//싱글톤 객체를 통해 boardDb리스크를 객체 반환받기
			ArrayList<Board>result
				=Bcontroller.getInstance().print();
			
			System.out.println("번호\t제목\t작성자\t조회수\t작성일");
			//반환된 리스크객체 수 만큼 반복
				for(int i=0; i<result.size(); i++)  {
					//3. 리스크내 i번째 객체를 출력
					System.out.println(i+"\t"+result.get(i).toString());
				}
			
			
	}
	
	private void view_page() {
		//입력받기
		System.out.println("게시물번호;;;");
		int bno=scanner.nextInt();
		
		//2.입력받은 게시물번호의 게시물정보를 컨트롤에게 요청[bno넙겨주고]
		Board result = Bcontroller.getInstance().view(bno);
		System.out.println("게시물상세-----------------------------------------");
		
		System.out.println("제목"+result.getTitle() );
		System.out.println("작성자"+result.getWriter() +"\t작성일:"+result.getDete()+
							"\t조회수:"+result.getView() );
		System.out.println("내용:"+result.getContent());
		System.out.println(">>>뒤로가기 2.삭제 3.수정");
		int ch2=scanner.nextInt();
		if(ch2==1) {
			return;
		}
	}
	
	
	
	
			
}

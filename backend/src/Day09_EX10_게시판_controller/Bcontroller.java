package Day09_EX10_게시판_controller;

import java.util.ArrayList;
import java.util.Date;

import Day09_EX10_게시판_model.Board;

public class Bcontroller {
	
	//싱글톤 객체 만들기
	private static Bcontroller bc=new Bcontroller();
	private Bcontroller() {}
	public static Bcontroller getInstance() {
		return bc;
	}
	
	//필드
	private ArrayList<Board>boardDb=new ArrayList<>();
	
	
	//2.쓰기 처리함수
	public boolean write(String title, String content, String writer, String password, Date dete, int view) {
	
	
	
	//유효성검사 생략
	
	//2.저장 
		//1.객체화
	Board board=new Board(title, content, writer, dete, password, view);
	
	boardDb.add(board);
	
	return true;
	
	}
	
	//3.모든게시물 즉여러개니까 list 출력 출력 처리 함수
	public ArrayList<Board> print() {
		//유효성검사 생략
		return boardDb; //리턴하고자 한는 값의 자료형을 위에 print옆에 써주는거임
	}
	
	
	//4.특정 게시물1개 출력 처리함수
	public Board view(int bno) {
		//조회수 올리기			//객체명.set필드명(객체명.get필드명()+1); //즉 기존것에 +1하고 srtview가 조회수 추가되서 나오는 것을 말함
		boardDb.get(bno).setView(boardDb.get(bno).getView()+1 ); 
		return boardDb.get(bno);
	}
	
}

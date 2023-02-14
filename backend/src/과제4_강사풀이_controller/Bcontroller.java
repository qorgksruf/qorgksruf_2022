package 과제4_강사풀이_controller;

import java.util.ArrayList;

import 과제4_강사풀이_Model.Board;



public class Bcontroller {

	private ArrayList<Board>boardDb=new ArrayList<>();
	//글쓰기
	public boolean write(String title, String content) {
		//유효성검사 [로그인했는지] 이거때매 controller에 싱글턴 맨위 세줄 만들고 갖고옴
		if(Mcontroller.getInstance().logSession==null) {
			return false; //로그인이 안되어있는경우 false
		}
			//로그인이되면 DB저장
				//1.객체화[글작성한거임: 입력받은 데이터2개, 초기값0, 로그인한 회원 객체=글쓴이]
		Board board= new Board( title, content, 0, Mcontroller.getInstance().logSession); 
				//2.멤버객체에 내가 쓴글 등록
		boardDb.add(board);
		
		Mcontroller.getInstance().logSession.getBoardList().add(board);
			
		return true;
	}
	
	//글출력-> 전체니까 ArrayList
	public ArrayList<Board>getList(){
		
		return boardDb;
	}
	
	
	//글 상세
	public Board getBoard(int bno) {
		
		return boardDb.get(bno); //인수로 전달받은 인덱스의 게시물을 반환함
	}
	
	//글삭제 
	public boolean delete(int bno) {
		boardDb.remove(bno);	 //인수로 전달받은 인덱스의 게시물 삭제
		return true;
	}
	
	
	//글수정->새로 입력될 제목,내용 쓰기
	public boolean update(int bno, String title, String content) {
		boardDb.get(bno).setTitle(title); //인수로 전달받은 인덱스의 게시물 제목 수정
		boardDb.get(bno).setTitle(content);//인수로 전달받은 인덱스의 게시물 내용수정
		return true;
	}
	
	
	
	
	
}

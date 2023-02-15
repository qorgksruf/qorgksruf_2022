package 연습장8.Controller;

import java.util.ArrayList;

import 연습장8.Member.Board;

public class Bcontroller {
	
	public ArrayList<Board>boardDb= new ArrayList<>();
	
	//게시물저장
	public String savePost( String title, String content, String id) {
		
		Board board=new Board();
		
		boardDb.add(board);
		
		return null;
	}
	
	
	//게시물보기
	public Board viewPost(int ch, String id) {
		boardDb.get(ch).count++;
		return boardDb.get(ch);
		
	}
	
	//게시물삭제하기
	public String editPost(int ch,String id,String editContent) {
		if(boardDb.get(ch).id.equals(id)) {
			boardDb.get(ch).content=editContent;
			return "edit";
		}
		return "pass";
	}
	
	
}//class e

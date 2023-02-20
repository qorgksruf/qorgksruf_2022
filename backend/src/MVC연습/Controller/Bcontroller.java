package MVC연습.Controller;

import java.util.ArrayList;

import MVC연습.Model.Board;

public class Bcontroller {
	public ArrayList<Board>boardDB = new ArrayList<>();
	
	
	//게시물저장
	public String savepost( String title, String id, String content ) {
		
		Board board = new Board();
		boardDB.add(board);
		return "2";
	}
	
	
	//게시물보기//여기
	public Board viewPost(int ch, String id) {
		boardDB.get(ch).count++;
		return boardDB.get(ch);
	}
	
	public String delpost(int ch, String id) {
		if(boardDB.get(ch).id.equals(id)) {
			boardDB.remove(ch);
			return "del";
		}
		return "pass";
	}
	
	public String editpost( int ch, String id, String editcontent) {
		if(boardDB.get(ch).id.equals(id)) {
			boardDB.get(ch).content = editcontent;
				return "edit";
			
		}
		return "pass";
	}
	
	
	
	
}

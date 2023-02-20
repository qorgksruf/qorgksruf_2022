package MVC연습장.controller;

import java.util.ArrayList;

import MVC연습장.model.Board;

public class Bcontroller {
	ArrayList<Board>boardDB=new ArrayList<>();
	
	
	//게시물저장
	public String savepost(String id, String title, String content) {
		
		Board board = new Board(id,title,content);
		boardDB.add(board);
		return "null"; //저장성공
	}
	
	//게시물보기
	public Board viewpost(int ch, String id) {
		boardDB.get(ch).count++;
		return boardDB.get(ch);
	}
	
	
	//게시물삭제하기
	public String delpost( int ch, String id) {
		if(boardDB.get(ch).id.equals(id)) {
			boardDB.remove(ch);
			return"del";//지우기성공
		}
		return"pass";//지우기실패
	}
	
	//게시물수정
	public String editpost(int ch, String id, String editcontent) {
		if(boardDB.get(ch).id.equals(id)) {
			boardDB.get(ch).content= editcontent; 
				return "edit";//수정완료
			
		}
		return"pass";
	}
	
}//class e

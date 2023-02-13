package 연습장7;

import java.util.ArrayList;

public class Bcontroller {
	
	ArrayList<Member> memberDb=new ArrayList<>();
	ArrayList<Board> boardDb=new ArrayList<>();
	
	
	//회원가입로직
	public int signup(String id, String pwd, String confirmed, String name, String phone){
		
		if(!pwd.equals(confirmed)) {return 1;}
		
		Member member = new Member(id,confirmed,name,phone);
		
		memberDb.add(member);
		return 0;
		
	}
	
	//로그인 로직
	public int login ( String id,String pwd) {
		for(int i=0; i<memberDb.size(); i++) {
			
			if(memberDb.get(i).id.equals(id)) {
				
				if(memberDb.get(i).pwd.equals(pwd)){
					return i;
				}
			}else {
					return -1;
			}
		}//for e
		return -2;
	}
	
	//아이디찾기 로직
	
	public String findId( String name, String phone ) {
		for(int i=0; i<memberDb.size(); i++) {
			if(memberDb.get(i).name.equals(name) && memberDb.get(i).phone.equals(phone)) {
				return memberDb.get(i).id;
			}
		}
		return null;	//아이디 못 찾음
	}
	
	
	//비밀번호찾기로직
	public String findpassword( String id, String phone) {
		for(int i=0; i<memberDb.size(); i++) {
			if(memberDb.get(i).id.equals(id) && memberDb.get(i).phone.equals(phone)) {
				return memberDb.get(i).pwd;
			}
		}
		return null;
	}
	
	
	//글 출력로직 
	public String write(String title,String content,String writer ) {
		Board board=new Board(title, content, writer);
		
		boardDb.add(board);
		
		return "게시글이등록되었습니다";
	}
	
	
	public String remove(int fixno) {
		if(fixno< boardDb.size() && fixno>=0) {
			boardDb.remove(fixno);
			return "해당 글이 삭제되었습니다";
		}else {
			return "수정할 인덱스가 맞지 않습니다;";
		}

	}
}

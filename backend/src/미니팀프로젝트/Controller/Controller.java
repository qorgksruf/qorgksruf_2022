package 미니팀프로젝트.Controller;

import java.util.ArrayList;

import 미니팀프로젝트.Model.Member;

public class Controller {

	
	ArrayList<Member>memberDb=new ArrayList<>();
	
	
	//등록함수 
	public int signup(String id, String pw, String phone) {
		Member member=new Member( id, pw, phone );
		memberDb.add(member);
			return 1;
			
		
	}
	
	
	
	
	
	
	
	
	
}

package 미니팀프로젝트.Model;

import 미니팀프로젝트.Controller.Controller;

public class Member {
	String name;
	String pw;
	String phone;
	String snumber;
	
	
	
	public Member() {
	}


	
	

	public Member(String name, String pw, String phone) {
		super();
		this.name = name;
		this.pw = pw;
		this.phone = phone;
	}









	public Member(String name, String pw, String phone, String snumber) {
		this.name = name;
		this.pw = pw;
		this.phone = phone;
		this.snumber = snumber;
	}
	
	


	//등록함수 
	public int signup(Member m) {
	
		Controller.getInstance().memberDb.add(m);
		
			return 1;//회원가입성공
			
		
	}
	
	
	
	
	
	
	
	
}//class e

package 연습장6;

import java.util.ArrayList;

public class Mcontroller {//걍 여기는 기능쪽 하는듯
	
	ArrayList<Member> membeDb=new ArrayList<>();
	
	//회원가입로직
	public int signUp(String id, String pwd, String name, String phone) {
		//유효성검사
		if (!pwd.equals(confirmpwd)) {
			return 1;
		}
		Member member=new Member(id, pwd, name, phone);
		membeDb.add(member);
		return 0;
	}
	
	
	//로그인 로직
		public int login(String id, String pwd) {
			for(int i=0; i<membeDb.size(); i++) {
				if(membeDb.get(i).id.equals(id) ) {
					
					if(membeDb.get(i).pwd.equals(pwd)) {
						return i;
					}else {
						return -1;
					} 
				}//if e
		}//for e
			return -2; //일치 아이디도 없음
	}	
	
	
		
	//아이디찾기 로직
		public String finId( String name,  String phone) {
			for(int i=0; i<membeDb.size(); i++) {
				
				if(membeDb.get(i).name.equals(name) && membeDb.get(i).phone.equals(phone)) {
					return membeDb.get(i).id;
				}
			}
			
			return null;
		}
		
	//비밀번호 찾기 -> id phone
		public String findPasswowrd(String id, String phone) {
			for( int i=0; i<membeDb.size(); i++) {
				if(membeDb.get(i).id.equals(id) && membeDb.get(i).phone.equals(phone) ) {
					return membeDb.get(i).pwd;
				}
			}
			return null;
		}
		
		
		
}//class e
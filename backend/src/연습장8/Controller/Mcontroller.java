package 연습장8.Controller;

import java.util.ArrayList;

import 연습장8.Member.Member;

public class Mcontroller {

	public ArrayList<Member>memberDb=new ArrayList<>();
	
	public int signup(String id, String pwd ,String confirmed, String name, String phone ) {
		if(!pwd.equals(confirmed) ) {
			return 1;
		}
		Member member=new Member(id,confirmed,name,phone);
		
		memberDb.add(member);
		
		return 0;
	}//signup함수 끝

	
	
	// 2. 로그인 로직
	public int login( String id , String pwd ) {
		for( int i=0; i<memberDb.size(); i++ ) {
			if( memberDb.get(i).id.equals( id ) ) {
				if( memberDb.get(i).pwd.equals( pwd ) ){ 
					return i ; // 회원 번호[인덱스] 반환
				}else {
					return -1; // 비밀번호가 틀림
				}
			} // if end 
		} // for end 
		return -2; // 아이디가 없음
	}
	
	
	//아이디찾기
	public String findId(String name,String phone) {
		for(int i=0; i<memberDb.size(); i++) {
			if(memberDb.get(i).name.equals(name) ) {
				if(memberDb.get(i).phone.equals(phone)) {
					return memberDb.get(i).id;
				}else {
					return "Y";//아이디 이치하지 않으면 Y반환
				}
			}
		}
		return "N"; //아이디 못찾음
	}
	
	
	
	//비밀번호 찾기
	public String findPassword(String id,String phone) {
		for(int i=0; i<memberDb.size(); i++) {
			if(memberDb.get(i).id.equals(id)) {
				if(memberDb.get(i).phone.equals(phone)) {
					return memberDb.get(i).id;
				}else {
					return"Y";
				}
			}
		}
		return"N";
	}
	
	
	
	
	
	//작성자찾기
	public String findwriter(int i) {
		return memberDb.get(i).id;
	}
	
	
}//class e

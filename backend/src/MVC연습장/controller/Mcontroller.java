package MVC연습장.controller;

import java.util.ArrayList;

import MVC연습장.model.Member;

public class Mcontroller {
	ArrayList<Member>memberDb = new ArrayList<>();
	
	
	//회원가입로직
	public int signup(String id, String pwd, String confirmed, String name, String phone) {
		if(!pwd.equals(confirmed)) {
			return 1;	//회원가입실패
		} 
		
		Member member = new Member(id,pwd, name,phone);
		memberDb.add(member);//db에 저장함
		return 2;//회원가입성공
	}//signup함수 마무리
	
	
	//login로직
	public int login(String id, String pwd ) {
		for(int i=0; i<memberDb.size(); i++) {
			if(memberDb.get(i).id.equals(id)) {
				if(memberDb.get(i).pwd.equals(pwd)) {
					return i;//로그인완료
				}else{
					return -1;//호그인실패
				}
			}
		}
		return -2;	//완전불일치
	}
	
	//아이디찾기로직
	public String findId(String name, String phone) {
		for(int i=0; i<memberDb.size(); i++) {
			if(memberDb.get(i).name.equals(name)) {
				if(memberDb.get(i).phone.equals(phone)) {
					return memberDb.get(i).id;
				}else {
					return "Y";//폰번호가 일치하지않습니다
				}
			}
		}
		return"N";//정보가없습니다
	}
	
	//비밀번호찾기
	public String findpassword( String id, String phone) {
		for(int i=0; i<memberDb.size(); i++) {
			if(memberDb.get(i).id.equals(id)) {
				if(memberDb.get(i).phone.equals(phone)) {
					return memberDb.get(i).pwd;
				}else {
					return "Y";
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

package 과제.과제4.controller;

import java.util.ArrayList;

import 과제.과제4.model.Member;

// * 처리/제어 담당
public class Mcontroller {
	// * DB 대신할 [ 데이터 저장소 ]
	ArrayList<Member> memberDb = new ArrayList<>();
	

	
	// 1. 회원가입 로직 
	public int signup( String id , String pwd , String confirmpwd , String name , String phone ) {
		// 1. 유효성검사
		if( !pwd.equals(confirmpwd) ) { return 1; }	// 회원가입실패 1
		// 2. 객체 만들어서
		Member member = new Member(id, confirmpwd, name, phone);
		// 3. db처리[ 리스트 ]  
		memberDb.add(member);
		return 0; // 회원가입 성공 0
	}
	// 2. 로그인 로직
	
		//모든 맴버들중 동일한 아디 비번 찾기
	public int login( String id , String pwd ) {
		//만약에 i번째 회원의 아이디와 입력받은 아이디 같으면
		for(int i=0; i<memberDb.size(); i++) {
			if(memberDb.get(i).id.equals(id)) {
			
				if(memberDb.get(i).pwd.equals(pwd)) {
					return i;
				}else {
					return -1;
				}
			}//if e
		} //for e
		return -2;	//for문 다 방문했지만 동일한 아이디는 없었다
	}
	
	
	// 3. 아이디 찾기 로직
	public String findId( String name , String phone  ) {
		for(Member m : memberDb) {
			if(m.name.equals(name) && m.phone.equals(phone)) {
				return m.id;
			}	
		}//for e
		for(int i=0; i<memberDb.size(); i++) {
			if(memberDb.get(i).name.equals(name)&& memberDb.get(i).phone.equals(phone)) {
				return memberDb.get(i).id;
			}
		}
		
		
		return null; //아이디 못 찾았다;;;;
	}
	

	
	
	
	// 4. 비밀번호 찾기 로직 
	public String findPassword( String id, String phone) {
		for(Member m : memberDb)  {
			if(m.id.equals(id) && m.phone.equals(phone)) {
				return m.pwd;
			}		
			
		}//for e
		return null; //아이디 못 찾았다;;;;
	}//함수 끝
	
	
}
















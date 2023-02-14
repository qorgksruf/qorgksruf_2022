package 과제4_강사풀이_controller;

import java.util.ArrayList;

import 과제4_강사풀이_Model.Member;



public class Mcontroller {
	
	//다른곳에서 해당 객체를 공유하는 메모리 즉 이필드의 메모리를 다른곳에서도 쓰기 쉽게 하주려고 싱글톤씀
	//단 member처럼 여러명이쓰는건 안되고 기계는 한대면 되니까
		//싱글톤 만들기
			//본인 클래스로 본인 객체만들기
	private static Mcontroller mc=new Mcontroller();
	
			//외부에서 생성자를 사용할 수 없도록 PRIVATE
	private Mcontroller() {};
	
			//객체는 외부로부터 차단하고 겟인스턴스 함수를 통해 객체를 내보낸다 
	public static Mcontroller getInstance() {
		return mc;
	}
	
	
	//DB대신 Arraylist
	ArrayList<과제4_강사풀이_Model.Member>MemberDb=new ArrayList<>();
	//로그인 한 회원의 객체를 저장 [*동시접속 문제점 발생!!]
		//사용목적: 페이지가 바뀌더라도 정보저장 즉 메소드가 종료되더라도 정보는 저장
	private Member logSession = null; //회원객체를 logSession가 저장하는거임~!!!!! 개인정보가 있는건 session
	
	public Member getLogSession() {
		return logSession;
	}
	
	
	//회원가입 처리
	public int signup(String id, String pwd, String confirmes, String name, String phone) {
	//로직작성할 예정
		//유효성검사
		if(!pwd.equals(confirmes)) {return 1;}//실패
		//2.Db에 저장 -> 위를 보시요 -> 입력받은 데이터 4개와 회원마다 글을 저장할 리스트 메모리 초기화함
		Member m= new Member (id,pwd ,name,phone, new ArrayList<>() );
		//위에 네개는 스택영역에 저장된 힙주소를 전달함;;힙영역에생성된 힙 주소 전달하는게 ArrayList
		
		//이제 리스크에 저장한다
		MemberDb.add(m);
		return 0; //성공
	
	}
	
	//로그인처리
	public int login (String id, String pw) {
		
		for(int i=0; i<MemberDb.size(); i++) {	//i번쨰 객체를 찾아야함~!! 
			if(MemberDb.get(i).getId().equals(id)) {//i번쨰 인덱스의 아이디와 입력받은 아이디 같으면
				if(MemberDb.get(i).getPwd().equals(pw)) {
					//i번째 인덱스의 비밀번호와 입력받은 비밀번호같으면 로그인 성공 -> 흔적을 남겨야함
				 logSession=MemberDb.get(i); //로그인 성공한 회원 객체를 필드에 저장함 얘는 지역변수가 아니라 위 필드에 저장했으니 메소드 끝나도 정보는 남는애임
					return i;
				}else {
					return -1;
				}
			}
		}
		
		return -2;
	}
	
	
	//아이디찾기 처리
	public String findId(String name, String phone) {
		for(Member m:MemberDb) {//MemberDb에 들어있는 여러개의 객체가있는데 member객체를 하나씩 꺼내서 m에 반복적으로 대입해야함 member은 자료형이라 짝 맞춰야함
			if(m.getPhone().equals(phone) && m.getName().equals(name)) {
				return m.getId();	
			}
		}
		return null;
	}
	
	
	//비밀번호찾기 처리
	public String findpw(String id, String phone) {
		for(Member m:MemberDb) {
			if(m.getId().equals(id) && m.getPhone().equals(phone)) {
				return m.getPwd();
			}	
		}
		
		return null;

	}
	
	
	//로그아웃
	public boolean logOut() {
		logSession=null; //필드에 저장된 로그인 성공한회원 객체를 지우기
		return true;
	}
	
	
}

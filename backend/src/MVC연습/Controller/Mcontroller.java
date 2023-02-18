package MVC연습.Controller;

import java.util.ArrayList;

import MVC연습.Model.Model;

public class Mcontroller {
	public ArrayList<Model>MemberDb = new ArrayList<>();
	
	
	//회원가입로직
	public int signup(String Id, String pw ,String confirmed, String name, String phone) {
		if(!pw.equals(confirmed)) {
			return 1;
		}
			
			Model member = new Model(Id,pw,name,phone );
			MemberDb.add(member);
			return 2;	//회원가입성공

	}//signup e
	
	
	//로그인로직
	public int login( String id, String pwd) {
		for(int i=0; i<MemberDb.size(); i++) {
			if(MemberDb.get(i).id.equals(id)) {
				if(MemberDb.get(i).pwd.equals(pwd )) {
					return i; //회원번호 반환
				}else {
					return -1;//비밀번호가틀림
				}
			}
		}
		return -2;
	}
	
	//아이디찾기로직
	 public String findId(String name, String phone ) {
		 for(int i=0; i<MemberDb.size(); i++) {
			 if(MemberDb.get(i).name.equals(name)) {
				 if(MemberDb.get(i).phone.equals(phone)) {
					 return MemberDb.get(i).id;
				 }else {
					 return "Y";
				 }
			 }
		 }
		 return "N";
	 }
	
	
	//비밀번호찾기로직
	 public String findpassword( String id, String phone) {
		 for(int i=0; i<MemberDb.size(); i++) {
			 if(MemberDb.get(i).id.equals(id)) {
				 if(MemberDb.get(i).phone.equals(phone)) {
					 return MemberDb.get(i).pwd;
				 }else {
					 return "Y";
				 }
			 }
		 }
		 return "N";	 
	 }
	
	//작성자찾기
	 public String findwriter(int i ) {//여기
		 return MemberDb.get(i).id;
	 }
	
	 
	 
	 
	 
	 
}//class e

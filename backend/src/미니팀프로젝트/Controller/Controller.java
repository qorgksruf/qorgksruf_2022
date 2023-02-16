package 미니팀프로젝트.Controller;

import java.util.ArrayList;

import 미니팀프로젝트.Model.Computer;
import 미니팀프로젝트.Model.Member;
import 미니팀프로젝트.Model.회의실;

public class Controller {

	
	public ArrayList<Member>memberDb=new ArrayList<>();
	private static Controller c=new Controller();
	private Controller() {}
	public static Controller getInstance() {
		return c;
	}
	
	public int signup(String id,String pw,String phone,int ch) {
		
		String snumber = "0"+ch;
		
		if(ch==1) {
			Computer computer = new Computer(id, pw, phone, snumber);//자식객체생성
			return computer.signup(computer);
		}else if(ch==2) {
			회의실 회의실 = new 회의실(id, pw, phone,snumber);
			return 회의실.signup(회의실);
		}else if(ch==3) {
			
		}else {
			
		}
		
		return 0;
	}
	

	
	
	
	
	
	
	
	
	
}

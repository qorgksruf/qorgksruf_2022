package 미니팀프로젝트.Model;

public class Computer extends Member {
	
	

	public Computer(String name, String pw, String phone, String snumber) {
		super(name, pw, phone, snumber);
		// TODO Auto-generated constructor stub
	}
@Override
public int signup(Member m) {
	System.out.println("컴퓨터실입니다");
	
	
	
	
	return super.signup(m);
	
	
	
	
}

	



}

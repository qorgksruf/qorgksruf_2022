package 미니팀프로젝트.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Computer extends Member {
	
	Scanner scanner=new Scanner(System.in);
	ArrayList<C_member>c_memberDb=new ArrayList<>();

	public Computer(String name, String pw, String phone, String snumber) {
		super(name, pw, phone, snumber);
	
	}
	
	
@Override
public int signup(Member m) {
	System.out.println("컴퓨터실입니다");
			while(true) {
			System.out.println("무엇을도와드릴까요~? [1.컴퓨터실 예약하기 2.컴퓨터실 나가기  ");
			int chMenu=scanner.nextInt();
			
			if(chMenu==1) {//컴튜터실 예약하기
				System.out.println("=====================컴퓨터실 예약하기=====================");
				System.out.println("사용자이름입력;;;;");
				String c_name=scanner.next();
				System.out.println("사용할 시간 입력;;;");
				String c_time=scanner.next();
				boolean state=true;
				
				//새로운 자료형으로 저장함 
				C_member c_member=new C_member();
				c_member.c_name=c_name;
				c_member.c_time=c_time;
				c_member.state=state;
				c_memberDb.add(c_member);
				
				
				for(int i=0; i< c_memberDb.size(); i++) {
					System.out.println(i+"\t\t"+ (c_memberDb.get(i).state ? "사용가능" : "사용중" )+"\t\t"+ c_memberDb.get(i).c_name+"\t\t"+c_memberDb.get(i).c_time );
					
				}
				System.out.println();
				
			
			return super.signup(m);
			
			}else if(chMenu==2) {

		}//while e
	
	}//sign함수끝
	
}//class e

	


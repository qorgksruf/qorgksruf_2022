package 연습장5;

import java.util.ArrayList;
import java.util.Scanner;

public class Front {

	Scanner scanner=new Scanner(System.in);
	
	ArrayList<Member>memberList= new ArrayList<>();
	
	void index() {
	
		while(true) {
			print();
			System.out.println("1.회원등록 2.회원삭제");
			int ch=scanner.nextInt();
			if(ch==1) {
				signUp();
			}else if(ch==2) {
				 delete();
			}else {
				
			}
		}//while e

	}//index e

	//출력함수
	void print() {
		System.out.println("번호\t회원명\t전화번호");
		for(int i=0; i<memberList.size(); i++) {
			System.out.println(i+"\t"+memberList.get(i).name+"\t"+memberList.get(i).phone);
		}
	}
	
	
	//등록함수
	
	void signUp() {
		System.out.println("회원명을 입력하세요");
		String inputname=scanner.next();
		System.out.println("전화번호를 입력하세요");
		String inputphone=scanner.next();
		
		Member school=new Member();
		school.name=inputname;
		school.phone=inputphone;
		memberList.add(school);
	}
	
	
	//삭제함수
	void delete() {
		System.out.println("삭제할 인덱스를 입력하세요");
		int no=scanner.nextInt();
		memberList.remove(no);
	}
	
}//class e

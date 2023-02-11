package Day08_EX5;

import java.util.ArrayList;
import java.util.Scanner;

public class Front {
	//필드	[변수,객체,배열]
		//1.입력객체
	Scanner scanner =new Scanner(System.in);
		//리스트객체[멤버 객체에 여러개 선언할 수 있는 객체 선언]
	ArrayList<Member>memberList=new ArrayList<>();
	
	
	//생성자
	//메소드\
	void index() {//외부에 객체가 있어야 함수 호출된다 class EX6_회원시스템함수**메인 먼저->다른 class에있음
		
		//메인페이지 함수
		while(true) {
			print();
			System.out.println("1.회원등록 2.회원삭제;;;");
			int ch=scanner.nextInt();
			if(ch==1) { 
				signup();
			} else if(ch==2) {
				delete();
			} else {
				
			}
		}//while e
		
	}//index e
	
		//회원등록 페이지함수		*유재석 2023/02/10	유지보수 편하게 이런거 써놔!!!!!
		void signup() {
			System.out.println("회원명;;;");
			String name=scanner.next();
			System.out.println("전화번호;;;");
			String phone=scanner.next();
			Member member=new Member(name, phone);//빈생성자말고 자동완성으로 Member클래스에 만든거 넣어
			//배열 or리스트에 객체 저장
			memberList.add(member);
		}
		
		
		//회원삭제 페이지 함수
		void delete() {
			System.out.println("삭제할번호/인덱스");
			int no=scanner.nextInt();
			memberList.remove(no);
		}
		
	
		//회원 출력
		void print() {
			System.out.println("번호\t회원\t전화번호");
			for(int i=0; i<memberList.size(); i++) {
				System.out.println(i+"\t"+memberList.get(i).name+"\t"
										 +memberList.get(i).phone);
			}
		}
		
		
}//class e

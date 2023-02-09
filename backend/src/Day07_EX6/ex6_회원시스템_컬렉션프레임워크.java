package Day07_EX6;

import java.util.ArrayList;
import java.util.Scanner;

public class ex6_회원시스템_컬렉션프레임워크 {

	public static void main(String[] args) {
		
		Scanner scanner =new Scanner(System.in);
		
		ArrayList<Member> schoolbook=new ArrayList<>();	//가변길이	string[]한결=new string[];
			//ArrayList: 리스트 선언시 사용되는 클래스
			//<클래스명>: 리스트 안에 들어갈 항목의 클래스
		
		while(true) {
			//배열명.length : 배열내 길이	[고정길이]
			//리스트명.size(): 리스트내 요소들의 개수[가변길이]
			System.out.println("반허\t회원명\t전화번호");
			for(int i=0; i<schoolbook.size(); i++) {
				System.out.println(i+"\t"+schoolbook.get(i).name+"\t"+
						schoolbook.get(i).phone);
			}

			
			System.out.println("1.회원등록 2.회원삭제");
			int ch=scanner.nextInt();
			if(ch == 1){
				System.out.println("회원명");
				String inputname=scanner.next();
				System.out.println("전번");
				String inputphone=scanner.next();
				
				Member member = new Member();
				member.name= inputname; 
				member.phone = inputphone;
				schoolbook.add(member);//리스트에 객체 추가 push랑 같은 기능
				
			}
			else if(ch==2){
				System.out.println("삭제할 번호/인덱스를 입력하세요");
				int no=scanner.nextInt();
				schoolbook.remove(no);
				
			}
			
			else {}
		}
		
	}//main e
	
}//class e

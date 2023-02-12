package 연습장2_컬렉션연습;

import java.util.ArrayList;
import java.util.Scanner;

public class 실행 {


	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		ArrayList<Member>MemberList=new ArrayList<>();
		
		while(true) {
			System.out.println("번호\t회원명\t전화번호");
			for(int i=0; i<MemberList.size(); i++) {
				System.out.println(i+"\t"+MemberList.get(i).name+"\t"+MemberList.get(i).phone);
			}//for e
		
			System.out.println("1.회원등록 2.회원삭제");
			int ch=scanner.nextInt();
			if(ch==1) {
				System.out.println("회원명을입력하세요");
				String inputname=scanner.next();
				System.out.println("전번입력ㄱㄱ");
				String inputphone=scanner.next();
				
				Member school=new Member();
				school.name=inputname;
				school.phone=inputphone;
				MemberList.add(school);
				
			}else if(ch==2) {
				System.out.println("삭제할 인덱스 입력 ㄱ");
				int no=scanner.nextInt();
				MemberList.remove(no);
			}
			else {
				System.out.println("번호 다시입력 ㄱ");
			}
		}//while e
		
	}//main e
}//class e

package Day07.Ex04;

import java.util.Scanner;



public class 회원시스템객체 {
	
	public static void main(String[] args) {
		
		Scanner scanner =new Scanner(System.in);
		
		Member[]memberList=new Member[3];
		
		while(true) {
			
			System.out.println("번호\t회원명\t전화번호");
			for(int i=0; i<memberList.length; i++) {
				if(memberList[i] != null) {
					System.out.println(i+"\t"+memberList[i].name+"\t"+memberList[i].phone);
				}
				
			}
			
			System.out.println("1.회원등록 2.회원삭제;;");
			int ch=scanner.nextInt();
			if(ch==1) {
				System.out.println("회원명;;;;");	
				String inputname=scanner.next();
				System.out.println("전화번호;;;");
				String inputphone=scanner.next();
				
				//위에 회원명 전번 하나로 만들려면"," 방법 말고 객체로 만들기 설계 클래스로 ㄱ
					for(int i=0; i<memberList.length; i++) {
						if(memberList[i]==null) {
							Member member =new Member();
							member.name=inputname;
							member.phone=inputphone;
							memberList[i]=member;
							break;
						}	
					}	
			}
			else if(ch==2) {}
			else {} 
		}//while e
		
	}//main e
}

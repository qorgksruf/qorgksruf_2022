package 연습장;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

public class Test_20230206 {//class s

	public static void main(String[] args) {//main s
				
				Scanner scanner = new Scanner(System.in);
				
				int balance=0;
				String account ="123-1234";
				short password=123;
				
				while(true) {
					System.out.println("1.예금 2.출금 3.잔액 4.종료");
					System.out.println("원하시는 선택을하세요");
					int 메뉴 = scanner.nextInt();
					/*************************/
					if( 메뉴==1) {
						System.out.println("예금할 계좌번호를 입력하세요;;;");
						String inaccount=scanner.next();
						if( account.equals(inaccount)) {
							System.out.println("예금할 금액을 입력하세요");
							balance += scanner.nextInt();
							System.out.println("예금후 금액;;;"+balance);
						}else {
							System.out.println("계좌번호가 다릅니다");
						}
						
					}else if(메뉴==2) {
						System.out.println("출금할 통장의 계좌번호를 입력하세요");
						String inaccount= scanner.next();
						if( account.equals(inaccount)) {
							System.out.println("비밀번호입력;;;");
							short inpassword=  scanner.nextShort();
							if(password==inpassword) {
								System.out.println("출금하실 금액을 입력하세요");
								int pay= scanner.nextInt();
								if(pay<balance) {
									balance -= pay;
									System.out.println("출금되었습니다:"+pay);
									System.out.println("남은잔액은;;;;:"+ balance);
								}else if(pay>balance){
									System.out.println("잔액이 부족합니다");
								}
							}
							
						}
						
						
					}
					
					else if(메뉴==3) {
						System.out.println("잔액확인전 계좌번호를 입력해주세요");
						String inaccount = scanner.next();
						if(account.equals(inaccount)) {
							System.out.println("남은잔액은;;;"+balance);
						}else {
							System.out.println("계좌번호를 확인해주세요");
						}
						
						
					}else if(메뉴==4){
						System.out.println("시스템을 종료합니다");
						break;
					}else {
						System.out.println("알 수 없는 번호입니다");
					}
					
		}//while e
				
		
	}//class e
	 
}//main e	
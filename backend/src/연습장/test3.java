package 연습장;

import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {
		
			
				Scanner scanner = new Scanner(System.in);
				
				int balance=0;
				String 계좌= "123-1234";
				int password = 123;
				
				while(true) {
					System.out.println("1.예금 2.출금 3.잔액 4.종료");
					System.out.println("번호를 선택하세요");	
					
					/*************1.예금********************/
					
					int 메뉴= scanner.nextInt(); 
					if( 메뉴==1) {
						System.out.println("계좌번호를 입력해주세요");
						String inaccount=scanner.next();
							System.out.println("금액을 입력하세요");
								int inbalance=scanner.nextInt();
									balance+=inbalance;
										System.out.println("예금후 금액;;;"+balance);
						
						
						/*************2.출금********************/	
					}else if(메뉴==2) {
						System.out.println("계좌번호를 입력하세요;;;");
						String inaccount=scanner.next();
						if(계좌.equals(inaccount)) {
							System.out.println("비밀번호를 입력하세요;;;");
							int inpassword = scanner.nextInt();
							if(password==inpassword) {
								System.out.println("출금할 금액을 입력하세요;;;");
								int pay=scanner.nextInt();
								balance-=pay;;
								System.out.println("남은잔액은;;;;"+balance);
							}else {
								System.out.println("비밀번호가 일치하지 않습니다;;;");
							}
						}else {
							System.out.println("없는계좌입니다;;;");
						}
					
						/*************2.잔액********************/	
					}else if(메뉴==3) {
						System.out.println("계좌번호를 입력하세요;;;");
						String inaccount=scanner.next();
							if(계좌.equals(inaccount)){
								System.out.println("비밀번호를 입력하세요");
								int inpassword=scanner.nextInt();
									if(password==inpassword) {
										System.out.println("남은잔액은;;;;"+balance);
									}else {
										System.out.println("비밀번호가 일치하지 않습니다;;;");
									}
							
							}else {
								System.out.println("계좌번호가 일치하지 않습니다;;;");
							}
						
					}else if(메뉴==4) {
								System.out.println("종료합니다 이용해주셔서 감사합니다");
								balance=0;
								break;
								
								
					}else {
						System.out.println("번호가 옳지 않습니다");
					}
				}//while e
	
	}//main e	
}//class e

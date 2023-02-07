package 연습장;

import java.util.Scanner;

public class test4 {
			
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
			
				int 콜라가격=300;
				int 사이다가격=400;
				int 환타가격=500;
				
				int 콜라바구니=0;
				int 사이다바구니=0;
				int 환타바구니=0;
				
				int 콜라재고=10;
				int 사이다재고=8;
				int 환타재고=15;
				
				
				
				while(true) {
					System.out.println("1. 콜라 2.사이다 3.환타 4.결제");
					int select= scanner.nextInt();
						if(select==1) {
							System.out.println("콜라의 갯수를 정하세요");
							int 구매할콜라=scanner.nextInt();
								if(구매할콜라<=콜라재고) {
									콜라바구니+=구매할콜라;
									콜라재고-=구매할콜라;		
									System.out.println("남은콜라 재고;;;"+콜라재고);
									System.out.println("콜라바구니에 담긴 콜라;;"+구매할콜라);
								}else {
									System.out.println("콜라재고가 부족합니다");
								}
								
								
						}else if(select==2) {
							System.out.println("사이다의 갯수를 정하세요");
							int 구매할사이다=scanner.nextInt();
								if(구매할사이다<=사이다재고) {
									사이다바구니+=구매할사이다;
									사이다재고-=구매할사이다;		
									System.out.println("남은사이다 재고;;;"+사이다재고);
									System.out.println("사이다바구니에 담긴 사이다;;"+구매할사이다);
								}else {
									System.out.println("사이다재고가 부족합니다");
								}
								
								
						}else if(select==3) {
							System.out.println("환타의 갯수를 정하세요");
							int 구매할환타=scanner.nextInt();
								if(구매할환타<=환타재고) {
									환타바구니+=구매할환타;
									환타재고-=구매할환타;		
									System.out.println("남은환타재고;;;"+환타재고);
									System.out.println("환타바구니에 담긴 환타;;"+구매할환타);
								}else {
									System.out.println("환타재고가 부족합니다");
								}
							
						}else if(select==4) {
							System.out.println("1.결제 2.결제취소");
								int no=scanner.nextInt();
									if(no == 1) {
										System.out.println("지불할 돈을 입력해주세요");
											int pay=scanner.nextInt();
											int total=(콜라바구니*콜라가격)+(사이다바구니*사이다가격)+(환타바구니*환타가격);
												if(pay>=total) {
													System.out.println("결제가완료되었습니다");
														System.out.println("남은잔액은;;;"+(pay-total));
														
										
														
												}else{
													System.out.println("잔액이부족합니다");

													 콜라바구니=0;
													 사이다바구니=0;
													 환타바구니=0;
													 
													 콜라재고=10;
													 사이다재고=8;
													 환타재고=15;
												}
									}else {
										System.out.println("결제가취소되었습니다");
										
										콜라바구니=0;
										 사이다바구니=0;
										 환타바구니=0;
										 
										 콜라재고=10;
										 사이다재고=8;
										 환타재고=15;										
									}
						}else {
							System.out.println("없는번호입니다");
						}
				}//while e
		
	}//class e
}//main e

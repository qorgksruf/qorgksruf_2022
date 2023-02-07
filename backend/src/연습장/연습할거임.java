package 연습장;

import java.util.Scanner;

public class 연습할거임 {//main s

		public static void main(String[] args) {//class s
				
			Scanner scanner = new Scanner(System.in);
			
			int 콜라가격 =300;
			int 사이다가격=400;
			int 환타가격=500;
			
			int 콜라재고 =10;
			int 사이다재고=8;
			int 환타재고=15;
			
			int 콜라바구니 =0;
			int 사이다바구니=0;
			int 환타바구니 = 0;
			
			
			while(true) {
				System.out.println("메뉴를 선택하세요");
				System.out.println("1. 콜라 2.사이다 3.환타 4.결제");
				int 메뉴 = scanner.nextInt();
				if(메뉴==1) {
						System.out.println("구매하실 콜라의수량을 입력하세요");
						int 살콜라개수=scanner.nextInt();
								if(살콜라개수<=콜라재고) {
									System.out.println("콜라가 장바구니에 담겼습니다");
									콜라바구니 += 살콜라개수;
									콜라재고 -= 살콜라개수;	
									System.out.println("콜라바구니;;;"+콜라바구니);
									System.out.println("콜라재고;;;"+콜라재고);
								}else {
									System.out.println("콜라 재고가 없습니다");
									콜라재고 =10;
									사이다재고=8;
									환타재고=15;
								}
					
								
				}
				
				
				else if(메뉴==2) {
						System.out.println("구매하실 사이다의수량을 입력하세요");
						int 살사이다개수=scanner.nextInt();
							if(살사이다개수<=사이다재고) {
								System.out.println("사이다가 장바구니에 담겼습니다");
								사이다바구니+=살사이다개수;
								사이다재고-=살사이다개수;
								System.out.println("사이다바구니;;;"+사이다바구니);
								System.out.println("사이다재고;;;"+사이다재고);
							}else {
								System.out.println("사이다 재고가 없습니다");
								콜라재고 =10;
								사이다재고=8;
								환타재고=15;
							}
			
				}
				
				
				
				else if(메뉴==3) {
						System.out.println("구매하실 환타의수량을 입력하세요");
						int 살환타수량=scanner.nextInt();
						if(살환타수량<=환타재고) {
							System.out.println("환타재고가 담겼습니다");
							환타바구니 += 살환타수량;
							환타재고-= 살환타수량;
							System.out.println("환타바구니;;;"+환타바구니);
							System.out.println("환타재고;;;"+환타재고);
							
						}else {
							System.out.println("환태재고가 없습니다");
							콜라재고 =10;
							사이다재고=8;
							환타재고=15;
						}
						
				}else if(메뉴==4) {
						System.out.println("1.결제 2.취소" );
							int 선택=scanner.nextInt();
								if(선택==1) {
										System.out.println("받은돈을 입력해주세요");
										int 받은돈=scanner.nextInt();
										int 계산액=(콜라바구니*콜라가격)+(사이다바구니*사이다가격)+(환타바구니*환타가격);
										
										if( 받은돈>=계산액){
											System.out.println("거스름돈;;"+(받은돈-계산액));
											System.out.println("계산이 완료되었습니다");
											
											콜라재고 =10;
											사이다재고=8;
											환타재고=15;
											
											콜라바구니 =0;
											사이다바구니=0;
											환타바구니 = 0;
											
										}else if(받은돈<계산액) {
											System.out.println("돈이부족합니다");
											//초기화
											콜라재고 =10;
											사이다재고=8;
											환타재고=15;
										}
										
								 }else {
									 System.out.println("결제가취소되었습니다");
										 콜라재고 =10;
										 사이다재고=8;
										 환타재고=15;
										 
										 콜라바구니 =0;
										 사이다바구니=0;
										 환타바구니 = 0;
								 }
				}else {
					System.out.println("알수없는 번호입니다");
				}
				
			}
				
		}//class e
}//main e

package Day04;

import java.util.Scanner;

public class 과제2_키오스크_변수버전 { // class s 
	public static void main(String[] args) { // main s 
		// * 입력객체
		Scanner scanner = new Scanner(System.in);
		// * 가격 변수
		int 콜라가격 = 300; 	
		int 사이다가격 = 400; 	
		int 환타가격 = 500;
		// * 재고 변수 
		int 콜라재고 = 10;		
		int 사이다재고 = 8;	
		int 환타재고 = 15;
		// * 장바구니 변수 
		int 콜라바구니 = 0;	
		int 사이다바구니 = 0;	
		int 환타바구니 = 0;
		
		// * 프로그램 실행 반복
		while( true ) { // while s 
			System.out.println("-------------------------");
			System.out.print("1.콜라 2.사이다 3.환타 4.결제 >>>>  ");
			int 메뉴 = scanner.nextInt();
			// * 메뉴에 따른 제어 !!! 
			if( 메뉴 == 1 ) {
				System.out.print("콜라 개수 입력 ::: ");
				int 콜라입력한개수 = scanner.nextInt();
				if (콜라재고 >= 콜라입력한개수) {
					콜라바구니 += 콜라입력한개수;
					콜라재고 -= 콜라입력한개수;
				} else {
					System.out.println("재고부족");
				}
			} else if( 메뉴 == 2 ) {
				System.out.print("사이다 개수 입력 ::: ");
				int 사이다입력한개수 = scanner.nextInt();
				if (사이다재고 >= 사이다입력한개수) {
					사이다바구니 += 사이다입력한개수;
					사이다재고 -= 사이다입력한개수;
				} else {
					System.out.println("재고부족");
				}
			} else if( 메뉴 == 3 ) {
				System.out.print("환타 개수 입력 ::: ");
				int 환타입력한개수 = scanner.nextInt();
				if (환타재고 >= 환타입력한개수) {
					환타바구니 += 환타입력한개수;
					환타재고 -= 환타입력한개수;
				} else {
					System.out.println("재고부족");
				}
			} else if( 메뉴 == 4 ) {
				System.out.println("-----------------------------------");
				System.out.println("제품명			수량			가격");
				
				if (콜라바구니 > 0) {
					System.out.println("콜라			" + 콜라바구니 + "			" + (콜라바구니*300));
				}
				
				if (사이다바구니 > 0) {
					System.out.println("콜라			" + 사이다바구니 + "			" + (사이다바구니*400));
				}
				
				if (환타바구니 > 0) {
					System.out.println("콜라			" + 환타바구니 + "			" + (환타바구니*500));
				}
				
				if (콜라바구니 > 0 || 사이다바구니 > 0 || 환타바구니 > 0) {
					System.out.println("총가격 : " + ((콜라바구니*300) + (사이다바구니*400) + (환타바구니*500)));
				}
				
				System.out.print("1. 결제 2.취소  ::: ");
				
				int 입력한결제메뉴 = scanner.nextInt();
				
				/* 결제 기능 - 잔액 출력, 장바구니 초기화, 재고 다시 되돌리기*/
				if (입력한결제메뉴 == 1) {
					System.out.println("지불할 금액 ::: ");
					int 금액 = scanner.nextInt();
					int 총계산할금액 = (콜라가격 * 콜라바구니) + (사이다가격 * 사이다바구니) + (환타가격 * 환타바구니);
					
					if (금액 >= 총계산할금액) {
						System.out.println("결제 성공");
						금액 = 금액 - 총계산할금액;
						
						System.out.println("잔액 ::: " + 금액);
					} else {
						System.out.println("금액 부족, 결제 취소");
						
						// 재고 다시 되돌리기
						콜라재고 = 10;		
						사이다재고 = 8;	
						환타재고 = 15;
					}
					
				/* 취소 기능 - 장바구니 초기화 / 재고 다시 되돌리기*/	
				} else if (입력한결제메뉴 == 2) {
					// 재고 다시 되돌리기
					콜라재고 = 10;		
					사이다재고 = 8;	
					환타재고 = 15;
						
				} else {
						System.out.println("잘못된 입력입니다.");
				}
					
				콜라바구니 = 0;	
				사이다바구니 = 0;	
				환타바구니 = 0;
				
			} else { 
				System.err.println(" [알림] 알수 없는 번호 입니다. "); 
			}
		} // while e 
	} // main e 
} // class e 















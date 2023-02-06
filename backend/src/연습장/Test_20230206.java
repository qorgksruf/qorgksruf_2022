package 연습장;

import java.util.Scanner;

public class Test_20230206 {//class s

	public static void main(String[] args) {//main s
				
		
				Scanner scanner = new Scanner(System.in);
				
				int 콜라가격 = 30;
				int 사이다가격 =400;
				
				int 콜라재고=10;
				int 사이다재고=8;
				
				int 콜라바구니=0;
				int 사이다바구니=0;
				
				
				while(true) {
					System.out.println("1. 콜라 2.사이다 3.결제");
					int 메뉴= scanner.nextInt();
					
					if(메뉴==1) {
						if(콜라재고>0) {
							콜라바구니++;
							콜라재고--;
						}else {
							System.out.println("콜재고없어");
						}
					}else if(메뉴==2) {
						if(사이다재고>0) {
							사이다바구니++;
							사이다재고--;
						}else {
							System.out.println("재고없음");
						}
					}else if(메뉴==3) {
						System.out.println("지불할 돈 입력해");
						int 금액 =scanner.nextInt();
						int 총금액=(콜라가격*콜라바구니)+(사이다가격*사이다바구니);
						
						if(금액>=총금액) {
							System.out.println("계산완료");
							금액=금액-총금액;
							System.out.println(금액);
						}else {
							System.out.println("돈이부족합니다");
						}
					}else {
						System.out.println("번호가 다릅니다");
					}
				}//while e

	}//main e
}//class e	
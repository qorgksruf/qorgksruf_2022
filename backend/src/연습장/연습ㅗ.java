package 연습장;

import java.util.ArrayList;
import java.util.Scanner;

import shin컴퓨터실예약.model.Computer;
import shin컴퓨터실예약.model.Member;

public class 연습ㅗ {
	ArrayList<Member>memberDb = new ArrayList<>();
	ArrayList<Computer>computerDb = new ArrayList<>();
	
	Scanner sc =new Scanner(System.in);

	public void start() {
		while(true) {
			System.out.println(" 1. 예약하기 2.로그아웃하기");
			
			int menuch=sc.nextInt();
			if(menuch==1) {
				reserve();
			}else if(menuch==2) {
				logout();
			}else {
				System.out.println("번호 다시확인");
				continue;
			}
		}//while e
	}//start e
	
	
	public void reserve() {
		System.out.println("사용자입력");
		String name = sc.next();
		
		System.out.println("좌석번호입력");
		int comNum = sc.nextInt();
		
		for(int i=0; i<computerDb.size(); i++) {
			if( comNum==computerDb.get(i).comNo) {
				System.out.println("이미 대여중인 좌석입니다");
			}else {
				System.out.println("대여가능");
				
				Computer comDb = new Computer();
				comDb.comNo = comNum;
				comDb.resName = name;
				
				computerDb.add(comDb);
				System.out.println("대여완료되었습니다");
				
				 print(comNum,name );
				
			}
		}
	}
	
	
	public void logout() {
		System.out.println("좌석번호입력");
		int conMum = sc.nextInt();
		
		System.out.println("사용자이름 ");
		String writer= sc.next();
		
		for(int i=0; i<computerDb.size(); i++) {
			if(conMum==computerDb.get(i).comNo ) {
				if( computerDb.get(i).resName.equals(writer)) {
					
					System.out.println("정보확인됨 반납진행");
					computerDb.remove(i);
					
				}else {
					System.out.println("작성자 다름");
				}
			}else {
				System.out.println("좌석번호 다름");
			}
		}
	}
	
	public void print( int comNum, String name) {
		while(true) {
			System.out.println(" 1.상세내역보기 2.로그아웃");
			int ch = sc.nextInt();
			
			if(ch==1) {
				System.out.println("작성자 좌석번호를 입력하세요");
				int comNo= sc.nextInt();
				
				for(int i=0; i<computerDb.size(); i++) {
					if( comNum==computerDb.get(i).comNo ) {
						if(computerDb.get(i).resName.equals(name)) {
							System.out.println(computerDb.get(i).comNo + computerDb.get(i).resName + (computerDb.get(i).state ? "사용중" : "사용가능")  );
						}
					}
				}
				
				
			}else if(ch==2) {
				logout();
			}
			
		}
	}
	
}//class e




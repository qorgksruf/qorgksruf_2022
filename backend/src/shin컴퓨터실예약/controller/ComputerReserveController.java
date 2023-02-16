package shin컴퓨터실예약.controller;

import java.util.ArrayList;
import java.util.Scanner;

import shin컴퓨터실예약.model.Computer;
import 미니팀프로젝트.Model.Member;

public class ComputerReserveController {
	ArrayList<Member> memberDb = new ArrayList<>();
	ArrayList<Computer> computerDb = new ArrayList<>();
	
	Scanner sc = new Scanner(System.in);
	
	public String start() {

		
		while(true) {
			System.out.println("============================================================");
			System.out.println("=			1. 예약하기			2. 종료하기			  	   =");
			System.out.println("============================================================");
			
			int menuNum = sc.nextInt();
			
			if (menuNum == 1) {
				reserve();
			} else if (menuNum == 2) {
				logout();
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	public void reserve() {
		System.out.print("사용자 이름을 입력하세요 ::: ");
		String name = sc.next();
		
		System.out.print("컴퓨터 자리번호를 입력하세요 ::: ");
		int comNum = sc.nextInt();
		
		for(int i=0; i < computerDb.size(); i++) {
			if (comNum == computerDb.get(i).comNo) {
				System.out.println("자리가 차 있습니다.");
			} else {
				System.out.println("대여가 가능합니다. 진행하겠습니다.");
				
				// Computer 타입의 생성자 생성
				Computer comDb = new Computer();
				
				// comDb 생성자의 변수에 맞춰 값 세팅
				comDb.comNo = comNum;
				comDb.resName = name;
				comDb.state = true;//사용중입니다
				
				// computerDb 에 데이터 저장
				computerDb.add(comDb);
				
				System.out.println("예약이 완료되었습니다.");
				print(comNum);
			}
		}
	}
	
	public void logout() {
		System.out.print("사용자 이름을 입력하세요 ::: ");
		String name = sc.next();
		
		System.out.print("로그아웃하실 자리번호를 입력하세요 ::: ");
		int comNum = sc.nextInt();
		
		for(int i=0; i < computerDb.size(); i++) {
			if (comNum == computerDb.get(i).comNo) {
				System.out.println("자리가 차 있습니다.");
				
				if (computerDb.get(i).resName.equals(name)) {
					System.out.println("입력하신 정보를 확인하였습니다. 해당 자리를 로그아웃하겠습니다.");
					computerDb.remove(i);
				} else {
					System.out.println("입력하신 정보가 맞지 않습니다. 다시 입력하여 주세요.");
				}
				
			} else {
				System.out.println("해당 자리는 비어있습니다. 예약하기를 통해 예약을 진행해주세요.");
			}
		}
	}
	
	public void print(int comNum) {//상세예약정보보기
		for(int i=0; i<computerDb.size(); i++) {
			if(computerDb.get(i).comNo == comNum ) {
				System.out.println(  "예약좌석번호;;;"+computerDb.get(i).comNo+"에약자이름;;;" +computerDb.get(i).resName + "상태 ::: " + (computerDb.get(i).state ? "예약완료" :"사용가능"));
			}
		}
	}
}





















package Day17;

import java.util.Calendar;
import java.util.Scanner;

public class EX3_달력 {
	public static void main(String[] args) {
		//1. static은 인스턴스 맴버 호출못함
			//run메소드도 정적 멤버하자 -> static void run(); 싱글턴은 정적이라 얘도 new 안씀 외부에서 가져오기만함
			run2();
			//인스턴스 즉 객체 만들어서 run하자 바로 밑에 보삼
		
		EX3_달력 ex3_달력 = new EX3_달력();
		ex3_달력.run();
		
		
	}//main e
	
	
	//1.달력함수 - > 달력키는애
	static void run2() {}
	void run() {
		//1.현재 날짜
		Calendar cal = Calendar .getInstance();
		//현재 연도
		int year = cal.get(Calendar.YEAR);
		//현재 월
		int month = cal.get(Calendar.MONTH)+1;
		//현재 일
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		Scanner scanner = new Scanner( System.in);
		
	while(true) {
		System.out.printf("===================%d 년 %d월==================\n",year,month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		
		//한달의 수를 먼저 체크하고 해당월의 1일의 요일을 알것-> 공백을 매꿔야하니까 / 마지막 날이 몇일인지 알것 
		//현재 월의 1의 날짜 요일 필요
		cal.set(year, month-1,1);//현재 연도/월의 1일 날짜 형식으로 변경		//2023-2-1 요일 구할 수 있음 -> 2월기준 4일
		int startweek = cal.get(Calendar.DAY_OF_WEEK); //얜 오늘의 WEEK임 
		
		
		
		//현재 월의 마지막 일이 필요함->그걸로 반복문돌림
		int eday = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 2023-02월의 일수의 최대수
		
		
		
		//해당 월 1일 전까지 공백으로 채우기
		for(int i=1; i<startweek; i++) {
			System.out.print("\t"); 
			
		}
		
		for(int i=1; i<=eday; i++) {
			System.out.printf("%2d\t",i );
			if( startweek % 7 == 0) {	//7일 배수일때마다 줄바꿈처리한다
				System.out.println();	//즉 토요일마다 줄바꿈
				startweek++;	//요일증가시킴
			}
			System.out.println("=============================================");
			System.out.println("\n1.이전달 2.다음달 3.검색");
			int ch = scanner.nextInt();
			if(ch==1) {
				month--;
				if(month<1) {	//만약에 월이 0이면 월=12 연도 1차감
					month=12;
					year--;
				}
			}if(ch==2) {
				month++;
				if(month>12 ) {
					month=1; year++;
				}
			}if(ch==3) {
				System.out.println("연도;;;");
				int inputY = scanner.nextInt();
				System.out.println("월;;");
				int inputM = scanner.nextInt();
				
				if(inputY>=1900 && inputY<=9999 && inputM>=1 && inputM<=12) {
					year = inputY; //즉 정상이면 대입 즉 출력이 된다는 의미
					month = inputM;
				}else {
					System.out.println("출력할수 없는 달력입니다");
				}
			}
		}
		
	}
}	
	
	
	
	
	
	
}//class e

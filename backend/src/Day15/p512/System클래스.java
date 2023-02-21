package Day15.p512;

public class System클래스 {
	public static void main(String[] args) {
		//1.
		System.out.println("출력");	//콘솔에 출력
		System.err.println("에러");	//콘솔에 에러[빨강]출력
		
		int value = 100;	//int에 100대입 가능 [정수니까 가능]	
		//int value2 ="100";	//int에 "100"대입 불가능 
			//형변환~!!!!!!!
		//형변환
		int value3 = Integer.parseInt("100");	
		
		
		try {	//에러 발생할 것 같은애 넣어 즉 짐작사항으로
		int value4 = Integer.parseInt("1ㅇㅇ");//1ㅇㅇ얘는 변환안됨 당연히 숫자가 아니라 ㅇ이니까
		}
		catch (Exception e) {//try에서 오류가 발생했을때 catch{ } 실행
			System.err.println("에러내용");
			System.err.println( e.getMessage());
		}
		
				
		
		//514
		int speed = 0;
		int keyCode=0;
		
		while(true) {
			if(keyCode != 13 && keyCode !=10){	
				if(keyCode ==49 ) {//숫자1의 코드는 49
					speed++;
				}else if(keyCode ==50) {//숫자2의 코드는 50
					speed--;
				}else if(keyCode==51) {//숫자3의 코드는 51
					break;
					//System.exit(0); //0이면 정상종료 1,-1은 비정상종료를 뜻함 별차이없음
				}
				System.out.println("현재속도;;;"+speed);
				System.out.println("1.중속 2.감속 3.중지;;;;;");
			}

				
						try {
							keyCode=System.in.read();	//읿력받아 코드로 전환
						}catch (Exception e) {
							
						}
		}//while e
		System.out.println("프로그램종료");
		
		
		
		
		
		
		
		
		
				
	}//main e
}

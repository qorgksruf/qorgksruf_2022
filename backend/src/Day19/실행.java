package Day19;

import java.awt.Toolkit;

public class 실행 {
	//P596	
		//main메소드() : 메인 thread 싱글스레드
	public static void main(String[] args) {
		
		//--------------------------1.싱글스레드----------------------------
		//*소리코드가 실행되고 출력 코드 실행 
		//소리코드
		System.out.println("싱긅클레스시작");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0; i<5; i++) {
			toolkit.beep();	//비프음 소리내기
			try{
				Thread.sleep(500);	//스레드 0.5초 대기상태 
			}catch (Exception e) {

			}
		}//for e
		
		//출력코드
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			}catch (Exception e) {
		
			}
		}
		
		//---------------------------------------------------------------
		//-----------------------2.멀티스레드 구현----------------------------
		//위랑 다르게 소리가 나면서 출력이됨
		//Thread thread = new Thread(구현인터페이스);
		System.out.println("멀티스레드 시작");
		Thread thread = new Thread(new Runnable() {
			//run 메소드를 구현
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i=0; i<5; i++) {
					toolkit.beep();
					try {
							Thread.sleep(500);
					}catch (Exception e) {
						
					}
				}//FOR E
				
			}//run e
		});//생성자 e
		
		thread.start();//run 메소드 실행
		
		//출력 코드
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			}catch (Exception e) {
			
			}
		}
		//------------------멀티스레드 구현2 실행클래스에 상속된거 보삼-------------------
		Sound thread2 = new Sound();
		thread2.start();
		//출력코드
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			}catch (Exception e) {
			
			}
		}		
		//-------------------멀티스레드 구현3 SOUND2클래스랑 INTERFACE----------------------
		System.out.println("3.멀티스레드시작");
		Runnable runnable = new Sound2();
		Thread thread3 = new Thread(runnable);
		thread3.start();
		
		//출력코드
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			}catch (Exception e) {
			
			}
		}	
	}//main e
}

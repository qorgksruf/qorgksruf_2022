package Day19.EX2;

public class 실행 {
	
	public static void main(String[] args) {
		
		//1. Thread 자식 클래스로 멀티클래스 구현
		A a = new A();	//1.*** A 클래스 실행시킴 1번 실행됨
		a.start();
		//2. Thread 자식 클래스의 익명 객체로 구현
		Thread thread = new Thread() {
			@Override
			public void run() {
				while(true) {
					System.out.println("--익명객체 main 메소드 스레드;;;"+ Thread.currentThread() );
					try {
					Thread.sleep(1000);//스레드1초간 일시정지
					}catch (Exception e) {
				
					}
				}//while e
			}
			
		};
			thread.start();	//2.** 바로 위의 RUNABLE로 1번 더 실행
			
		//3. RUNABLE인터페이스의 구현 객체로 구현-->B class
		Runnable runnable = new B(); 
		Thread thread2 = new Thread(runnable);
		thread2.start();

			
		//4.Runable 인터페이스의 익명 객체로 구현
		Thread thread3 = new Thread( new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					System.out.println("--익명객체 main 메소드 스레드;;;"+ Thread.currentThread() );
					try {
					Thread.sleep(1000);//스레드1초간 일시정지
					}catch (Exception e) {
				
					}
				}//while e
			}
		});	
		thread3.start();
		
		//main  스레드	//3. 실행됨
		while(true) {
			System.out.println("main 메소드 스레드;;;"+ Thread.currentThread() );
			try {
			Thread.sleep(1000);//스레드1초간 일시정지
			}catch (Exception e) {
		
			}
		}//while e
		
		
		
		
	}//main e
}

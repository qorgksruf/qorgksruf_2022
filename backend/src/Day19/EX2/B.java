package Day19.EX2;

public class B implements Runnable{
	@Override
	public void run() {
		while(true) {
			System.out.println("main 메소드 스레드;;;"+ Thread.currentThread() );
			try {
			Thread.sleep(1000);//스레드1초간 일시정지
			}catch (Exception e) {
		
			}
		}//while e		
		
	}
}

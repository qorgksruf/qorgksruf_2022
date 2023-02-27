package Day19.EX6;

public class Movie extends Thread {
	
	public boolean stop = true;	//작동스위치
	
	@Override
	public void run() {
		while(stop) {	//stop true 이면 실행
			System.out.println("영화보는중");
			try {
				Thread.sleep(1000);
			}catch (Exception e) {
			
			}
		}
	}
}

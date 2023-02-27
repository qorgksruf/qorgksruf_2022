package Day19.EX6;

public class Music extends Thread {
	
	public boolean stop = true;	//작동스위치
	
	@Override
	public void run() {
			while(stop) {	//stop true이면 실행
				System.out.println("음악듣는중");
				try {
					Thread.sleep(1000);
				}catch (Exception e) {
				
				}
			}
	}
		

}

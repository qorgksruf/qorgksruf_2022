package Day19.EX3;

import java.awt.Toolkit;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class EX1 {

	public static void main(String[] args) {
		//p604
	/*	Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0; i<10; i++) {
			toolkit.beep();//비프음대기
			try {
			Thread.sleep(3000);	//3초간 해당 스레드를 일시정지 [3초간 cpu 점유불가]
			}catch (Exception e) {

			}
			//2. 콘솔에 시계 만들기
		while(true) {	
				Date date = new Date(i);	//시간 날짜 클래스 
				SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
				System.out.println( sdf.format(date) );
				i++;
				try {
					Thread.sleep(1000); // 1초간 일시정지
				}catch (Exception e) {
					
				}
			}
		}
	*/
		
	/*	//3.
		SumThread sumThread = new SumThread();
		SumThread.start();
		System.out.println(SumThread.getsum());
	*/
		SumThread sumThread = new SumThread();
		sumThread.start();	//계산시작
		try {
			sumThread.join();	// main 과 합치기 즉 조인
		}catch (Exception e) {
			System.out.println(sumThread.getSum());
		}
		
		
	}//main e
}//class e

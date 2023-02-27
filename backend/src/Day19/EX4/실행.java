package Day19.EX4;

public class 실행 {
	public static void main(String[] args) {
		WorkThread workThreadA = new WorkThread("workThreadA");	//스레드A 객체 생성
		WorkThread workThreadB = new WorkThread("workThreadB");	//스레드B
		workThreadA.start();	//스레드 A 실행
		workThreadB.start();	//스레드 B 실행
		
		try {
			Thread.sleep(5000);	//5초간 일시정지
		}catch (Exception e) {	//스레드 A 필드 변경 스레드 양보상태
			workThreadA.work = false;	
		}
		try {
			Thread.sleep(5000);//5초간 일시정지
		}catch (Exception e) {
			workThreadA.work = true;//스레드 A 필드 변경 스레드 대기상태
		}		
	}
}

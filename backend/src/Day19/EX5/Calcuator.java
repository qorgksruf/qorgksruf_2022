package Day19.EX5;

public class Calcuator {//계산기 클래스
	private int memory;	//필드
	public int getMemory() {	//getter
		return memory;
	}
	public synchronized void setMemory(int memory) {//synchronized넣으면 처음에 100 두번째 50으로뜨고 그렇지않으면 50 50 뜸
		this.memory = memory;
		try {
			Thread.sleep(1000);
			
		}catch (Exception e) {
			System.out.println(this.memory);
		}
		
	}
	
}//class e

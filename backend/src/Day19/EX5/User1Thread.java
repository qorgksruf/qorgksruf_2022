package Day19.EX5;

public class User1Thread extends Thread{
	private Calcuator calcuator;
	public User1Thread() {
		setName("User1Thread");
	}

	public void setCalcuator(Calcuator calcuator) {
		this.calcuator = calcuator;
	}
	
	@Override
	public void run() {
		calcuator.setMemory(100);
	}
	
}

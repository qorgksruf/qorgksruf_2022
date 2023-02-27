package Day19.EX5;

public class User2Thread extends Thread{
	private Calcuator calcuator;
	public User2Thread() {
			setName("User2Thread");

	}
	
	public void setCalcuator(Calcuator calcuator) {
		this.calcuator = calcuator;
	}
	@Override
	public void run() {
			calcuator.setMemory(50);
	}
	
	
}

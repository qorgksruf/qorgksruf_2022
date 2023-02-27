package Day19.EX5;

public class 실행 {
	public static void main(String[] args) {
		Calcuator calcuator = new Calcuator();
		
		User1Thread user1Thread = new User1Thread();
		user1Thread.setCalcuator(calcuator);
		user1Thread.start();

		
		User2Thread user2Thread = new User2Thread();
		user2Thread.setCalcuator(calcuator);
		user2Thread.start();
	}
}

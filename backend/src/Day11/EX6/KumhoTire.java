package Day11.EX6;

public class KumhoTire extends Tire { //하위클래스
		 @Override
		public void roll() {
			 System.out.println("금호타이어가 굴러갑니다");
		}

		 
		 @Override
			public void stop() {
			 	System.out.println("금호타이어가 멈춥니다");
			}
}

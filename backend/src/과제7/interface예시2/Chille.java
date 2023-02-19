package 과제7.interface예시2;

public class Chille implements Cook{

	@Override
	public void fire() {
		System.out.println("칠레산조리법은 돈까스를 3분30초 불로 조리한다");
		
	}

	@Override
	public void source() {
		System.out.println("칠레산조미려롤 사용한다");
		
	}

}

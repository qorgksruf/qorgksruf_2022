package 과제7.interface예시;

public class China implements Cook{

	@Override
	public void fire() {
		System.out.println("중국산조리법은 돈까스를 5분30초 불로 조리한다");
		
	}

	@Override
	public void source() {
		System.out.println("중국산조미료롤 사용한다");
		
	}

}

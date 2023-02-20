package 과제7.interface예시;

public class Korea implements Cook{

	@Override
	public void fire() {
		System.out.println("국내산조리법은 돈까스를 4분30초 불로 조리한다");
		
	}

	@Override
	public void source() {
		System.out.println("국내산조미료롤 사용한다");
		
	}

}

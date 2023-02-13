package Day09_EX9;
//내부~!!!!!!!!!!
public class Member {
	
	
	/*
	 * 싱긅톤: 프로그램내 하나의 객체를 가지는 클래스
	 * 		-1. 클래스 내부에 객체 만들기
	 * 		-2. 생성자 private
	 * 		-3. 내부객체 반환해주는함수:	getInstance()
	 * 		-4. 함수호출시 객체가 필요한데 외부에서 객체 금지->static
	 * */

	 //1.자신의 클래스에서 자신의 타입으로 객체 생성한다.
	private static Member mem =new Member();
	 //2.private로 잠그기
	
	 //3.생성자도 private로 막는다
	private Member() {}
	
	//4.
	public static Member getInstance() {
		return mem;
	}
	
	//5.static쓰는 이유는 객체없이 위에   Member getInstance() 호출하려고
	
}


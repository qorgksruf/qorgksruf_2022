package Day14;

public class EX3_p477 {//class s

	public static void findClass() throws Exception{
		Class.forName("java.lang.String2");	//일반예외
	}
	//1.
	public static void main(String[] args) throws Exception  {//아까 슈퍼클래스 쓰던가 이거 쓰던가********
		try {	
			findClass();
		}
		catch(Exception e) {
			
		}
		System.out.println("확인"); 
		
		
		
		
	}//main e
	
}//class e

/*
 * 예외 떠넘기기
 * 		-메소드 내부에서 예외발생했을떄 메소드 호출했던 곳으로 예외를 떠넘기기
 * 		-throws
 * 		=메소드 마다 예외처리하면 코드가 지져분해짐 그래서 이동 후 한곳에서 처리하도록
 * */
 
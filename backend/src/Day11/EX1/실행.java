package Day11.EX1;

public class 실행 {
	public static void main(String[] args) {
			
		//phone객체 만들기
	 phone phone=new phone();
	 phone.color="빨강";
	 System.out.println(phone.color);
	 phone.bell();
	 phone.sendVoice("안녕하세요");
	 
	 
	 
	 
	 //1.
	 Day11.EX1.smartphone smartphone=new smartphone();
	
	 
	 smartphone.color="은색";
	 System.out.println(smartphone.color);
	 smartphone.bell();
	 smartphone.sendVoice("안녕하세요");
	 
	 smartphone myphone=new smartphone("갤럭시", "은색");
	 
	 
	 //자식클래스로 부모클래스 멤버 호출
	 System.out.println("모델:"+myphone.model );
	 System.out.println("색상:"+myphone.color);
	 
	 
	 //자식클래스가 본인 멤버 호출
	 System.out.println("와이파이상태:" + myphone.wifi);
	 
	 //자식클래스로 부모클래스의 멤버 호출
	 myphone.bell();
	 myphone.sendVoice("안녕하세요");
	 myphone.receiveVoice("안녕하세요! 저는 홍길동인데요.");
	 myphone.sendVoice("아~네 반갑습니다");
	
	 //자식 클래스 본인 멤버 호출
	 myphone.setwifi(true);
	 myphone.internet();
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	}//main e
}//class e

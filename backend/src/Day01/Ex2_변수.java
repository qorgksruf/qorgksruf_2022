package Day01;	//패키지명

//[p.34변수]
public class Ex2_변수 {	//class s

		//main함수 : 코드 읽어주는 역활함수[m+c+s->enter]
	public static void main(String[] args) {//main s
		
		//[p.37예제]
		/* int value; 변수 선언: 자료형[타입] */
		//초기화되지 않은 변수는 사용불가
		//System.out.println(value);//오류발생
		
		//int result = value + 10;//오류발생
		//System.out.println(result);
		
		//[p37예제2]
		int hour=3;	//변수 선언: int형 자료형 변수에 'hour'이름으로 3 저장
		int minute=5; //int형 자료형 변수에 minute 이름으로 5 저장
		System.out.println(hour+"시간" + minute+"분");
		int totalMinute = (hour*60)+ minute;
		System.out.println("총"+ totalMinute);
		
		
		//[p38-3스왑]
		int x = 3;
		int y= 5 ;
		System.out.println("x:"+x+"y:"+y);
		//두 변수간 데이터 교체/스왑
		int temp= x;	//temp=3
		x = y;			//x=5
		y= temp;		//y=3
		System.out.println("x:"+x+"y:"+y);
	}//main e
	
}//class e

/*
 * 변수: 데이터 1개를 저장할 수 있는 메모리 공간
 * 		-변수 선언
 * 			1.자료형 2.변수명 3.대입= 4.값
 * 				int hour = 3;
 * 		1.자료형/타입
 * 		2.변수명
 * 		3.초기값
 * 		-변수선언
 * 		자료형 변수명= 초기값		//값이 존재하기 때문에 사용 가능
 * 		자료형 변수명;			//값이 존재하지않기때문에 사용불가능
 * 		-변수 호출
 * 		hour + 10
 * 
 * java : 자료형/타입 직접 선언
 * 		int 변수명 =10
 * 		char 변수명 ='A'
 * 
 * 		vs
 * JS	: 자료형/타입이 자동관리가능
 * 		let 변수명 = 10;
 * 		let 변수명 = A;
 */
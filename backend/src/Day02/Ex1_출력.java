package Day02;	//현재 클래스

//자바는 무조건 class단위	
//자바를 100% 객체지향
//클래스 기반으로 메모리 할당: 객체
//클래스 객체 설계도
public class Ex1_출력 {//class s
	
	//*main함수: main 스레드[스레드:걍 작업 수행 주체]
	public static void main(String[] args) {
		
		System.out.println();
			//system 시스템 관련 메소드
				//out: 출력 vs in: 입력
					//printIn() :출력후 자동 줄바꿈처리
					//print() 출력만
					//printf(): 형식 출력
		//2.print()
		System.out.print("print 함수");
		System.out.print("print 함수2");
		
		//2.printIn()
		System.out.println("println 함수3");// printIn은 출력후 \n 자동 적용됨 
		System.out.println("println 함수4");
		
		//4[p69].printf()
		/*형식문자열 %d: 정수
		%f: 실수
		%s:문자열
		
		*/
		int value=123;	//int자료형에 value 이름으로 123 저장했다
		System.out.println("상품의가격:"+value+"원");	
		System.out.printf("상품의가격:%d원\n",value);	//d공백으로 둠
		System.out.printf("상품의가격:%6d원\n",value);
		System.out.printf("상품의가격:%-6d원\n",value);
		System.out.printf("상품의가격:%06d원\n",value);
		
		double area =3.14159;
		System.out.println("파이출력:"+area);
		System.out.printf("파이출력:%f\n",area);	
		System.out.printf("파이출력:%.1f\n",area);	//%.소수점갯수
		System.out.printf("파이출력:%3.2f\n",area);
		System.out.printf("파이출력:%3.3f\n",area);
		System.out.printf("파이출력:%3.4f\n",area);
	
		String name="홍길동";
		String job="도적";
		System.out.printf("%6d | %-10s  | %10s \n", 1, name, job);
	}
	
	
}//class e



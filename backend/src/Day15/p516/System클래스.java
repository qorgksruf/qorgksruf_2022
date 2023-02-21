package Day15.p516;


import java.util.Arrays;
import java.util.Properties;


public class System클래스 {
	public static void main(String[] args) throws Exception { 
		
		//517
		long time1 = System.nanoTime();	//현재시간을 나노초로 표현
		System.out.println(time1);	
		int sum = 0;
		for(int i=1; i<=10000000; i++) {
			sum +=i;	//i를 sum에 누적 합계 더하기
		}
		long time2 = System.nanoTime(); 
		System.out.println((time2-time1) + "나노초가 소요 되었습니다");
	
	
		//518 걍 넘기삼
		System.out.println("-------------------------");
		System.out.println("jey     :          value");
		Properties props = System.getProperties();	//모든 시스템 속성 호출
		
		for(Object obj : props.keySet() ) {	//시스템 속성의 키를 반복문 돌리기
			System.out.println(
					(String)obj+"                     "+	//해당 키를 문자열로 변환
					System.getProperty((String)obj) );		//해당 키를 이용한 시스템 속성 정보를 호출한다
		}
		
		//520
		String data= "자바";	//문자열 저장하고 조작하는 클래스
		
		byte[] arr1 = data.getBytes();	//해당 문자열을 바이트열로 변환 인코딩타임:UTF-8
		//배열의 주소값출력
		System.out.println(arr1);
		//배열내 데이터 출력 Arrays.toString(배열명)
		System.out.println(Arrays.toString(arr1));
		
		//믄자열-> 바이트열로 변환 getBytes()
		byte[] arr2 = data.getBytes("EUC-KR");	//인코딩타임:EUC-KR
		System.out.println(Arrays.toString(arr2));
		
		//바이트열->문자열	new String(배열명);
		String str1 = new String(arr1);
		System.out.println(str1);
		
		String str2 = new String(arr2,"EUC-KR");
		System.out.println(str2);
		
	}
}	

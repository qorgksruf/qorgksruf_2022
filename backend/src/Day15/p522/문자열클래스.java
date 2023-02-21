package Day15.p522;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 문자열클래스 {

	//String vs stringbuilder
	public static void main(String[] args) {
		
		String data = "ABC";
			System.out.println(data);
		data += "DEF";		
			System.out.println(data);
			
			
		
		String data2 = new StringBuilder()
				.append("DEF")		//믄자열 끝에 추가
				.insert(0, "ABC")	//해당 인덱스 위치에 추가
				.delete(3, 4)		//해당 인덱스 삭제
				.toString();		//완성된 문자열을 리턴
		
		System.out.println(data2);
		
		StringBuilder data3 = new StringBuilder();
			System.out.println(data3.hashCode());
			data3.append("ABC");
			System.out.println(data3.hashCode());
			data3.append("BDE");
			System.out.println(data3.hashCode());
			System.out.println(data3);
		
			
			
		//p524
			String data4 = "홍길동&이수홍-박연수";
			String[] arr = data4.split("&|-");
			
			System.out.println(Arrays.toString(arr));
			
			String data5 = "홍길동/이수홍/박연수";
			StringTokenizer st = new StringTokenizer(data5,"/");
			
			System.out.println("조각수;;;"+st.nextToken());
			for(int i=1; i<=3; i++) {
				System.out.println(st.nextToken());
			}
			
			
			
	}//main e

	
	
}

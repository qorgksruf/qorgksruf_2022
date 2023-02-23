package Day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class EX1_P529 {
	public static void main(String[] args) {

		//Math 클래스 : 수학 계산에 사용할 수 있는 메소드 제공
			//ceil(값) 올림함수
			//floor(값)  버림
			//round(값) : 반올림	-- string.format() 얘는 문자로되는거임 하지만 값은 같음
			//max(값1, 값2): 최대값 
			//min(값1,값2): 최소값
			
		double v1 = Math.ceil(5.3);
		System.out.println("v1:"+v1);
		
		double v2 = Math.floor(5.3);
		System.out.println("V2:"+v2);
		
		long v3=Math.max(3, 7);
		System.out.println("v3:"+v3);
		
		long v4=Math.min(3, 7);
		System.out.println("v4:"+v4);
		
		double v5= Math.round(5.3357);
		
		System.out.println("v5:"+v5);
		
		
		//소수 셋째자리에서 반올림해서 두자리까지표시
		double value = 12.3456;
		double temp1=value*100;	//1234.56;
		long temp2=Math.round(temp1); //1235;
		double v6=temp2/100.0;	//12.35;
		System.out.println("v6:"+v6);
		
		//소수 네번째자리에서 반올림해서 세 자리까지 표시 위랑 같은데 한줄로끝남
		System.out.println("반올림:"+Math.round(12.3456*100 )/100.0); 
		
		System.out.println(String.format("%2f", 3.14159) );
		
		
		
		
		//p.531
			//클래스: 서로 다른 자료형/타입 한곳[객체]에 저장
			//배열/리스트: 동일한 자료형의 데이터 여러개 저장하기 위한 객체 리스트/배열[객체]에 저장
		//int형 변수를 6개 저장 할 수 있는 배열	
		int[]selectNumber = new int[6];	
				//vs
		ArrayList<Integer>selectNumber2 = new ArrayList<>();	//int형 변수를 6개 저장 할 수 있는 리스트
				//포장 클래스: 즉 얘는 기본자료형을 클래스로 바꾸는 것을 말함 특정 API클래스중 기본자료형 사용불가
		
		
		Random random=new Random();
		System.out.print("선택번호:  ");
		for(int i=0; i<6; i++) {
			selectNumber[i] =random.nextInt(45)+1;
			System.out.print(selectNumber[i]+"");
			
		}
		System.out.println();
		
		
		//
		int[]winningNumber = new int[6];
		random = new Random();
		System.out.print("담청번호;;;");
		for(int i=0; i<6; i++) {
			winningNumber[i]=random.nextInt(45)+1;
			System.out.print(winningNumber[i]+"");
		}
		System.out.println();
		
		
		//배열에 정렬	
			//	Arrays.sort(배열) 해당 배열내 데이터를 오른차순 정렬
			//  Arrays.toString : 해당 배열내 데이터를 출력
		Arrays.sort(selectNumber);
		System.out.println( Arrays.toString(selectNumber));
		Arrays.sort(winningNumber);
		boolean result = Arrays.equals(selectNumber, winningNumber);
		if(result) {
			System.out.println("1등");
		}else {
			System.out.println("1등 담청 x");
		}
	}//main e
	
}

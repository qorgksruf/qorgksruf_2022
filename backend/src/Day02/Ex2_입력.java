package Day02;

import java.util.Scanner;	//scanner클래스를 사용하기 위한 scanner클래서 가져오기

public class Ex2_입력 {	
	
			public static void main(String[] args) {
				
				//1.[p70]입력
					//scaner+ 자동입력
			System.out.println();
				//1.[p.70]입력
					//객체생성: 클래스명 객체명 =new 생성자명(인수);
					//입력객체
			//1.입력객체*****1개 만들기
			Scanner scanner =new Scanner(System.in);//next 띄어쓰기 안됨
			//2.입력메소드->변수저장[자료형 맞추기]
				
			
			//1-1
				String 문자열1=scanner.next();
					System.out.println("문자열1:"+문자열1);
				//1.
				scanner.next();//1.문자열 입력받기 함수[띄어쓰기 불가능]
				
				
				//2.
				String 문자열2=scanner.nextLine(); //2.문자열 [띄어쓰기 가능]
				scanner.nextLine();
					System.out.println("문자열2:"+문자열2);
				
				scanner.nextBoolean(); //3.논리입력받기
				scanner.next().charAt(0);//첫글자만 입력받기함수
				
				byte 바이트 = scanner.nextByte();//정수입력받기
				short 쇼트 = scanner.nextShort();//정수입력받기
				int 인트 = scanner.nextInt();//INT형 입력받기
				long 롱= scanner.nextLong();//정수입력받기
				
				Float 플롯= scanner.nextFloat();//실수형입력받기
				Double 더블 = scanner.nextDouble();//실수형입력받기
					
				
				
				
				
				
				//기본자료형 비교[ 비교연산자 가능]
				int 비밀번호=1234;	
					System.out.println(비밀번호 ==1234);	//true
					
					//문자열[string 객체]비교
				String 아이디="gks";	//string 객체는 비교연산자 불가능 .equals같은걸 쓰면됨
					System.out.println(아이디.equals("gks"));	//false
					
					
					
			}
	
}

/*
 
 *
 *
 */

package 과제.과제1_연산자문제;

public class 과제1 {

		public static void main(String[] args) {
				
				//문제1
				System.out.println("|w_/|");	
				
				System.out.print("|q p|");
				
				System.out.println("  /}");
				
				System.out.println("( 0 )w"); 
				
				System.out.println("||      |");
				
				System.out.println("||_/=ww_|");
	
				
				
				//문제2
				String 문자열="강호동";
				String 내용="안녕하세요";
				String 날짜="09-28";
		
				System.out.println("| 순번		|작성자 |		내용		");
				System.out.print("|");
				System.out.print( 1 );
				System.out.print( "  " );
				System.out.print("|");
				System.out.print(문자열);
				System.out.print( "      " );
				System.out.print(내용);
				System.out.print( "      " );
				System.out.print("|");
				System.out.println(날짜);
				
				
				
			//문제3급여 계산
				int 기본급=1000000;
				int 수당=300000;
	
				String 실수령액="실수령액"+(기본급+수당*0.1);
				System.out.println(실수령액);
				
			//문제4 지폐 세기
				int money=6893210;
				int m1=(int)(money/100000);	//10만원권
				int m2=(int)(money%100000)/10000;	//1만원권
				int m3=(int)(money%100000/10000)/5000;	//5천원권
				int m4=(int)(money%100000/10000/5000)/1000;	//1000원권
				int m5=(int)(money%100000/10000/5000/1000)/100;	//100원권
				System.out.println("십만원권:"+  m1  +"만원권:"+  m2 +"오천원권:"+  m3  +"천원권:"+  m4  +"백원권:"+  m5 );
				
				
			//문제5 정수를 입력받아 7의 배수인지 출력 [ox]
				int i1=28;

				String 결과 = (i1%7==0) ? "ㅇ": "x";
				
				System.out.println(결과);
			//문제6 하나의 정수를 입력받아 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력]		
				int i2=36;
				
				String 홀짝= (i2%2==0) ? "짝수" : "홀수";
				System.out.println("홀짝:"+홀짝);
				
				
			//	문제7 : 하나의 정수를 입력받아 7의 배수 이면서 짝수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]
				
				int i3=50;
				
				String 혼합= ( i3%7==0 && i2%2==0) ? "o" : "x";
			
				System.out.println("배수며 짝수니:"+혼합);
			
			//문제8 : 하나의 정수를 입력받아 7의 배수 이거나 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]	
				
				int i4= 65;
				
				String 혼합2= ( i3%7==0 || i2%2==0) ? "o" : "x";
				
				System.out.println("배수거나 짝수니:"+혼합2);
				
				
			//문제9 : 두개의 정수를 입력받아 더 큰수 출력 	
				
				int i5=70;
				int i6=81;
				
				String 큰수= (i6<i5) ? "i5"	: "i6";
				
				System.out.println("큰수:"+큰수);
			
				
			//문제10 	반지름을 입력받아 원 넓이 출력하기 ,계산식) 원 넓이 공식 => 반지름 * 반지름 * 원주율[3.14]
				
				int i7=15;
				
				double 반지름=i7*i7*3.14 ;
				
				 System.out.println("반지름:"+반지름) ;
				 
			//문제18 나이를 입력받아 나이가 10세이상이면 학생 , 20세이상이면 성인 , 40세이상이면 중년 으로 출력하기
				int 나이=53;
				
				if(나이 >= 10) {
					System.out.println("학생");
				}if(나이>=20) {
					System.out.println("성인");
				}if(나이>=40) {
					System.out.println("중년");
				}
				
			//국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점(소수점 0자리) 출력 , 평균(소수점 2자리 까지) 출력 	 
				 int 국어=100;
				 int 수학=80;
				 int 영어=65;
				 
				 int 총점=(국어+수학+영어);
				 System.out.println(총점);
				 
				 double 평균=(국어+수학+영어)/3;
				 System.out.println(평균);
				 
				 
				 
		}
	
	
}

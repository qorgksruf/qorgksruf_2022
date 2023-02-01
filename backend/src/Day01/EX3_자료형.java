package Day01;

public class EX3_자료형 {
	
		public static void main(String[] args) { //main s
			
			int var1 = 0b1011; System.out.println("2진수:"+var1);
				//2진수---> 11 [10진수]
			int var2 = 0206; System.out.println("8진수:"+ var2);
				//13[8진수]------>11[10진수]
			int var3= 365;	System.out.println("10진수:"+var3);
				//365[10진수]
			int var4= 0xb3;	System.out.println("16진수:"+ var4);
				//b3 [16진수]--->179
			
			//[p42] byte자료형
			byte b1= -128;	System.out.println("byte자료형:"+ b1);	
			byte b2= 127;	System.out.println("16진수:"+ b2);
			/* byte b3= 128; 범위 벚어나서 오류된 데이터 */
			
			// 3. short 자료형
			short s1= 32000; System.out.println("short자료형:"+s1);
			/* short s2= 33000; 범위벚어난 데이터로 오류 */
			
			//4. int 자료형	+-21억
			int i1 = 200000000; System.out.println("int자료형:"+ i1);
			/* int i2 = 300000000; 범위 벚어난 오류 */
			
			
			//5.[43p] long
			long l1 = 10; 	System.out.println("long자료형:"+ l1);
			long l2 = 10000000000L; System.out.println("long자료형:"+ l2);//오류발생 100억
			//정수 기본타입 int 변수에 저장되기전 자료형이 명시되지 않은 데이터
			// 10000000000 ---->int형이됨
			// 데이터뒤에 L붙이기: int -> long
			// 10000000000L----> long
			
			//6.[p.44] char자료형 0~65535
			//문자'' //문자열""
			char c1 = 'A'; System.out.println("char자료형:"+c1);
			char c2 = 65; System.out.println("char자료형:"+c2);
			char c3 = '가';	System.out.println("char자료형:"+c3);	
			char c4 = 44032; System.out.println("char자료형:"+c4);				
					
			
			//7. strring 클래스 [문자 여러개 저장]
			String str1 = "안녕하세요"; System.out.println("string클래스:"+str1);
			
			//8. [47p] float자료형
			float f1 = 0.123456789123456789f;	System.out.println("float자료형:"+f1); //데이터 뒤에f	붙여주기 소수 17자리까지
			double d1 = 0.123456789123456789;	System.out.println("float자료형:"+d1);
	
			
			//9.[p48] bollean 논리 [ true , false]
			boolean bol1 = true;  System.out.println("blooean자료형:"+bol1); 
			/* boolean bol2 = 1; System.out.println("blooean자료형:"+bol2); */
		} //1. java진수를 표현하는 방법[p.41]
	
	
	
}// class e

/*
 * -용량단위:
 * 	bit: 0,1		->8bit
 * 	byte: 01010101	->1024byte		: 용량 최소단위	
 *  Kbyte: 1024byte
 *  Mbyte: 1024kbyte
 *  Gbyte: 1024mbyte

 * -진수: 컴퓨터의 표현단위
 * 	2진수: 0, 1		기계어/이진코드/bit		:0b
 *  8진수: 0 ~ 7 							:0
 *  10진수:0 ~ 9			   :	사람
 *  16진수:0 ~ 9 a b c d e f:	 메모리주소체계	:0x
 */
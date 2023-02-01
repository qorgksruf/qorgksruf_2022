package Day01;

/*import javax.print.attribute.IntegerSyntax;*/

public class EX4_자료형변환 {// class s
	public static void main(String[] args) { // main s

		// 1.[p54] 자동타입변환
		byte b1 = 10;
		int i1 = b1; // byte->int가능
		char c1 = '가';
		i1 = c1; // char->int가능
		int i2 = 50;
		long l1 = i2;
		long l2 = 100;
		float f1 = 12;
		float f2 = 100.5f;
		double d1 = f2;

		// 58p
		int i3 = 2000000000;
		byte b2 = (byte) i3; // int->byte전환 불가능 [강제는 가능]
		long l3 = 300;
		int i4 = (int) l3;
		int i5 = 65;
		char c2 = (char) i5;
		double d2 = 3.14;
		int i6 = (int) d2; // double-->int불가능
		
		System.out.println("i6 ::: " + i6);

		// 3.연산시 자동 타입 변환 [p.58~64]

		// 4.문자열 타입 변환
		String str1 = "10"; // 10:int "10""string
		
		int 인수1= Integer.parseInt(str1); 
		System.out.println(인수1);
		
		short 쇼트1= Short.parseShort(str1); 
		long 롱1=Long.parseLong(str1); 
		float 플롯1=Float.parseFloat(str1);
		 
		double 더블1 = Double.parseDouble(str1);
		System.out.println("더블1 ::: " + 더블1);

		// "10"-----> 문자열타입의 숫자10---> 10: 정수형타입의 숫자10
		// "ABC": 문자열타입의 문자뮻--->불가능
		String str2 = "안녕";
		int 인트2 = Integer.parseInt(str2);
		System.out.println("인트2");
		
		
		/*
		 * int 인트3 = (Interger)str1; //불가능
		 */

	}// main e

	// (int) int로 바꿔라 안 그러면 뒤진다. : 형변환
	// Integer.parseInt int로 바꿔라 : 형변환
} // class e

/*
 * 자료형/타입 변환 크기순서 byte[1]< short, char[2] < int[4]< long[8] <float[4]<double[8]
 * 
 * 1.자동타입변환 -작은 타임=>큰 타입 자동 2. 강제 타입 변환[캐스팅] -손실 있더라도 강제로 변환 (새로운타입)변환할데이터 작은
 * 허용범위 타입=(작은 허용범위 타입) 큰 허용범위 타입[o]
 * 
 * 3.연산시 자동 타입 변환 [p.58~64] -피연산자중 큰 타입의 결과로 변환됨 1. 정수 1.int 보다 작은 byte, short
 * 연산시 무조건 int결과 byte + byte->int short + int->int 2.long연산시 int+long->long 2.
 * 실수 float + float->float float + double -> double
 * 
 * 4. 문자열 타입변환 Byte.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

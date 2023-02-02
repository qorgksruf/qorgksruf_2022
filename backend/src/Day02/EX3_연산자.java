package Day02;

import java.util.Scanner;

import javax.print.attribute.SetOfIntegerSyntax;



public class EX3_연산자 {
	
	public static void main(String[] args) {
		
		
		
		
		//1.부호/증감연산자[p.78]
		int x = +10;
		int y = -10;
		System.out.println("x:"+x);
		System.out.println("y:"+y);
		
		System.out.println("x++:"+(x++));
		System.out.println("x:"+x);
		System.out.println("++x:"+(++x));
		
		System.out.println("y--:"+(y--));
		System.out.println("y:"+y);
		System.out.println("--y:"+(--y));	
		
		//2.산술연산자[p.81]
		System.out.println(" x+y " + ( x+y) );
		System.out.println(" x-y " + ( x-y) ); //+12 - - 12
		System.out.println(" x*y " + ( x*y ) );
		System.out.println(" 5/3 " + ( 5/3 ) );	//int/int는 몫만나옴 나머지 안나옴
		System.out.println(" 5%3 "+ ( 5%3 ) );	//나머지
		
		//3.비교연산자[P.89]
		System.out.println("x==y"+ ( x==y ) );	//+12 == -12
		System.out.println("x != y"+ ( x != y ) ); //+12 != -12
		System.out.println("x > y"+ ( x > y ) );	
		System.out.println("x >= y"+ ( x >= y ) );
		System.out.println("x < y"+ ( x < y ) );
		System.out.println("x <= y"+ ( x <= y ) );
		
		//문자열 비교
		System.out.println("str1.equals(str2): " + ("유재석".equals("유재석") ) );
		System.out.println("str1.equals(str2): " + (!"유재석".equals("유재석") ) );
	
		//4.논리연산자 [p91]
		System.out.println("5<x<20:" + (x>5 && x<20) );//	x=12 true and true=true
		System.out.println("5<x<10:" + (x>5 && x<10) );//	x=12 true and false=false
		System.out.println("0<=x x>=20:" + (x<=0 || x>=20) );	
		System.out.println("0<=x x>=10:" + (x<=0 || x>=10) );
		System.out.println("!(x==y)"+ ( !(x==y) ) );
		
		//5. 대입연산자 p 102
		int z = 30;	
		z += x;	//30+=12 	1. 30+12=>42	2. 30=42=> 42 오른쪽의 값이 대입됨 ㅇㅇ
		System.out.println(z);
		z -= x;	
		z *= x;
		z%= x;
		z/=x;
		
		//6. 삼항연산자 p.103	조건? 참: 거짓
		//x >=20 ? System.out.println("합격");	: System.out.println("불합격");
		String 결과 = (x>=20) ? "합격"	: "불합격";
		System.out.println(결과);
		
		//7. 연결연산자
		String 연결문자1 ="유재석"+"10";	//문자열+문자열 => 문자열 "유재석10"
		System.out.println(연결문자1);
		String 연결문자2="유재석"+10;	//문자열+숫자열=> 문자열	"유재석10"
		String 연결문자3="유재석"+10+20;	//문자열+숫자열+숫자열 => 문자열 "유재석1020"
		String 연결문자4="유재석"+(10+20);	//유재석30
		
		Scanner scanner =new Scanner(System.in);
		
		//강사풀이
		
		/*
		 * Scanner scanner=new Scanner(System.in); String 작성자 = scanner.next();
		 * scanner.nextLine();
		 * 
		 * 
		 * String 내용 = scanner.nextLine(); System.out.print("내용:");
		 * 
		 * 
		 * String 날짜=scanner.next(); System.out.print("날짜:");
		 */
	
		
		
		
		
	}
	
}

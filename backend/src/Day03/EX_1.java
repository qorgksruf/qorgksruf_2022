package Day03;

import java.util.Random;

public class EX_1 {
			
			public static void main(String[] args) {
				//[p.116]
				
				int num =(int)(Math.random()*6)+1;	//0~1 사이 실수 난수
				
				if(num==1) {
					System.out.println("1번이 나왔습니다");
				} else if (num==2) {
					System.out.println("2번이 나왔습니다");
				} else if (num==3) {
					System.out.println("3번이 나왔습니다");
				} else if (num==4) {
					System.out.println("4번이 나왔습니다");
				} else if (num==5) {
					System.out.println("5번이 나왔습니다");
				} else{
					System.out.println("6번이 나왔습니다");
				}
				 
				//Math: 수학관련 메소드를 제공하는 클래스
				//Random: 난수 관련 메소드를 제공하는 클래스
			
				System.out.println( Math.random() ); //0~1사이의 난수
				System.out.println( Math.random()+1); //1~2사이 난수 소수점까지 나옴
				System.out.println((int) Math.random()+1); //1~2사이 정수
				System.out.println((int) (Math.random()*6)+1); //1~6사이의 정수 난수
				
				Random random = new Random();
				System.out.println( random.nextInt()); //int 표현할 수 있는 범위 내 난수
				System.out.println( random.nextInt(3));	//0~2까지 
				System.out.println( random.nextInt(6)); //0~5까지
				System.out.println( random.nextInt(6)+1); //1~6까지
				System.out.println( random.nextInt(25)+97 ); //97~122까지
				char c1 =(char)( random.nextInt(26)+97 ); 
				System.out.println(c1);
				
				/*
				 * if 중첩
				 * 
				 * if(조건식){
				 * 		if(조건식){
				 * 
				 * }else{
				 * 
				 * 	
				 * }
				 * 
				 * 
				 * */
				int score2= (int) (Math.random()*20) + 81;	//81에서 20개의 난수를 받으니 81~100
				System.out.println("점수:"+score2);
				
				String grade;
				
				if (score2 >=90) { 
					if(score2 >=95 ) {
						{grade = "A+";} 
					}else {grade = "A";}
				}
				
				
				
	}
	
}

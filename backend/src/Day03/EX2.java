package Day03;

public class EX2 {
		public static void main(String[] args) {
			
			//for(1.초기값; 2.조건식; 3.증감식){실행문}
			
			//이럴떄 for문씀 코드는 반복되고 특정 값이 1씩 증가하는 패턴이있을때,
			int sum = 0;
			sum = sum +1;
			sum = sum +2;
			sum = sum +3;
			sum = sum +4;
			sum = sum +5;
			sum = sum +6;
			
			for(int i= 1; i<=5; i++) {sum=sum+i;}
		
			// 125p 1~10까지 출력
			for (int i=1; i<=10; i++) {
				//i는 1부터 10까지 1씩증가 반복
				System.out.print(i+"");
			}
			System.out.println();
			
			
			//128p	1~100까지 누적합계
			int total =0;
			for (int i =1; i<=100; i++) {
				
				System.out.print(i+"");
				total +=i;
			}
			System.out.println("\n총 누적합계:"+total);
			
			//127p
			
			//0.1~1.0사이의 실수를 출력해보기
			for( float x = 0.1f; x<=1.0f; x+=0.1f) {
				//x는0.1부터 1.0까지 0.1씩 증가 반복
				System.out.println(x+"");
			}
			
			
		//5.127~128p 구구단
				//단: 2 3 4 5 6 7 8 9 
				//곱: 1 2 3 4 5 6 7 8 9
			
			/*곱은 단마다 반복됨 [단: 8회 곱:9회 -> 8*9: 즉 곱셈이 72회 반복됨]
			 * 
			 *  2*1	3단도 ㅇㅇ
			 *  2*2
			 *  2*3
			 *  2*4
			 * */
			//이중중첩 단이 한번돌떄마다 곱이 한바퀴또 도니까 ㅇㅇㅇㅇ 
			for(int 단 =2; 단<=9; 단++) {
				System.out.println("단:"+단);
				for( int 곱=1; 곱<=9; 곱++) {
					System.out.println("곱:"+곱);
					System.out.println("\t\t" +단+ "x" +곱+ "=" +(단*곱));
					
				}
			}
			//p.134 break; 반복문탈출 return;함수종료
			while( true ) {//무한루프
					int num = (int)(Math.random()*6)+1;
					System.out.println(num);
				if ( num == 6) {
					System.out.println("while{}탈출");
					break;
				}
			}
			
			
			첫번째for: for(char upper ='A'; upper <='z'; upper++) {
						
				System.out.println(upper);
						
			두번째for:  for( char lower ='a'; lower <='z'; lower++) {
							System.out.println(lower );
							if(lower =='g') {
							break 첫번째for; //가장 가까운 반복문 탈출 만약 위에 for문 멈추고 싶으면 for문에 이름정하기
							}
						}
					}
			//8.[p.136] continue
			
			forname :for(int i =1; i<10; i++) {
				if(i%2 !=0) {//i가 홀수이면
					continue forname;	//특정 반복문[증감식]으로 이동
				}
				System.out.println(i+"");
			}
			
			
		
			
			
			
			
			
			
		}//main e
}// classe

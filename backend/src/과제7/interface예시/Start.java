package 과제7.interface예시;

import java.util.Scanner;

public class Start {
	

	public static void main(String[] args) {
		Chille cook = new Chille();
	    Korea cook2 = new Korea();
	    China cook3 = new China();
	  	Scanner scanner = new Scanner(System.in);    
		while(true) {
        	System.out.println("----나라별 돈가쓰 레시피------");
        	System.out.println("보고싶은 국가의 돈까스 레시피 선택해주세요 1.한국 2.중국 3.칠레");
        	int ch= scanner.nextInt();
        	
        	if(ch==1) { //한국
        		cook2.fire();
        		cook2.source();

        	}else if(ch==2) {//중국
        		cook3.fire();
        		cook3.source();
        	}else if(ch==3) {//칠레
        		cook.fire();
        		cook.source();
        	}
        
        
        
        }
		

		
		
	}//main e	
}//start e		
		
		
		

		




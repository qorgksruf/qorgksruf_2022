package 과제7;

import java.util.Scanner;

public class Start {
	
	
	
	public static void main(String[] args) {
		
		  Scanner scanner= new Scanner(System.in);
	      	Dog dog = new Dog();
	        Cat cat = new Cat();

	  

	        
	       while(true) {
	    	   System.out.println("안녕하세요 애견카페에 오신것을 환영합니다><");
	    	   System.out.println("1.강아지방 들어가기 2.고양이방 들어가기");
	    	 
	    	   int ch= scanner.nextInt();
	    	   if(ch==1) {
	    		   System.out.println("1.강아지에게 먹이주는 소리듣기 2.애기 강아지 짓는소리 듣기");
	    		   int postch=scanner.nextInt();
	    		   if(postch==1) {
	    			   dog.eat();
	    		   }else if(postch==2) {
	    			   dog.bark();
	    		   }
	    	   }else if(ch==2) {
	    		   System.out.println("1.고양이에게 먹이주는 소리듣기 2.애기 고양이 야옹소리 듣기");
	    		   int postch=scanner.nextInt();
	    		   if(postch==1) {
	    			   cat.eat();
	    		   }else if(postch==2) {
	    			   cat.bark();
	    		   }	    		   
	    	   }
	    	   
	       }
	        
	        
	        
	}
}

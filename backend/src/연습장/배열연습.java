package 연습장;

import java.nio.file.attribute.AclEntry;

public class 배열연습 {

	public static void main(String[] args) {
		
		int arr[]= {1,2,3};
			System.out.println(arr[1]);
				
				for(int i=0; i<arr.length; i++) {
					System.out.println(arr[i]);
				}
			
				String [ ]arr2= {"우재석","강호동"};
					System.out.println(arr2[1]);
					
					for(int i=0; i<arr2.length; i++) {
						System.out.println(arr2[i]);
					}
				
				int[ ]arr4= null;	
					
				String str=null;
				
				
				String hobby="여행";
				hobby=null;
				
				System.out.println(hobby);
				
				
				String kind1="자동차";
				String kind2=kind1;
				
				kind1=null;
				System.out.println(kind2);
				System.out.println(kind1);	//null
				
				char 문자열[]= {'안','녕'};
				
				String 문자열2[]= {"안녕","한결아"};
				
				String 문자열3="안녕하세요";
				
				for(int i=0; i<문자열.length; i++) {
					System.out.println(문자열[i]);
				}
				
				for(int i=0; i<문자열.length; i++) {
					System.out.println(문자열2[i]);
				}				
				
				System.out.println(문자열3);
				
				
				String a="한결이";
				String b="한결이";
				
				if(a==b) {
					System.out.println("주소같음");
				}else {
					System.out.println("주소다름");
				}
				
				if(a.equals(b)) {
					System.out.println("같아");
				}
				
				
				String 한결="123456789";
				char 동원=한결.charAt(5);
				System.out.println(동원);
				
				if(동원==1 || 동원==3) {
					System.out.println("여자입니다");
				}else {
					System.out.println("남자입니다");
				}
				
				
				
				int length =한결.length();
				if(length==13) {
					System.out.println("자릿수같음");
				}else {
					System.out.println("자릿수다름");
	
				}
				
				
				String 복만="백복만은 이기적입니다. 너무너무 얄밉지만 귀엽습니다";
				String 세만=복만.replace("귀엽습","깜직함");
					System.out.println(세만);
					System.out.println(복만);
					
				String ssn2="590425-123456";
					System.out.println(ssn2.substring(7));
					System.out.println(ssn2.substring(0,5));
					
				
				String ssn3= "한결아,사랑해,함께하자";	
					String[] ssn4=ssn3.split(",");
						System.out.println( ssn4[1]);
				
				String 짜증="자바 프로그래밍";
				System.out.println(짜증.indexOf("자바"));
				System.out.println(짜증.indexOf("파이썬"));		
				
				
				
	}//class e
	
}//main e

package 연습장;

public class 배열연습2 {
	
	public static void main(String[] args) {
		
		String[]seasons= {"봄","여름","가을","겨울"};
			
		System.out.println(seasons[0]);
		System.out.println(seasons[1]);
		System.out.println(seasons[2]);
		System.out.println(seasons[3]);
		
		seasons[1]="여어름";
		System.out.println(seasons[1]);
		
		System.out.println(seasons);
		
		for(int i=0; i<seasons.length; i++) {
			System.out.println(seasons[i]);
		
		}
		
		
		int[]arr1= {1,2,3};
		int sum=0;
		for(int i=0; i<arr1.length; i++) {
				sum+=arr1[i];
				System.out.println(sum);
			
				System.out.println(sum/arr1.length);
		}
		
		int[ ]arr2=new int[3];
		
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		arr2[0]=10; arr2[1]=20; arr2[2]=30;
			System.out.println(arr2[0]);
			int summ=0;
			
			for(int i=0; i<arr2.length; i++) {
				System.out.println(arr2[i]);
				summ+=arr2[i];
				System.out.println(summ);
			}
		
		String[] arr4=new String[4];
		System.out.println(arr4[3]);
		
		arr4[0]="봄"; 
		arr4[1]="여름"; 
		arr4[2]="가을"; 
		arr4[3]="겨울"; 
		System.out.println(arr4[3]);
			for(String value :arr4) {
				System.out.println(value);
			}
	}
}

package Day15.p524;

import java.util.ArrayList;

public class 포장클래스 {
	public static void main(String[] args) {
	
		//ArrayList<int>list = new ArrayList<>(); 얘는 안되는 얘
		ArrayList<Integer>list = new ArrayList<>();
		
		int a = 10;	//System.out.println(a);
		Integer b = 10;	
		System.out.println(b.toString()); 
		
		
		//526
		//박싱
		Integer obj = 100;
		System.out.println(obj.intValue());
		
		//언박싱
		int value =obj;	//객체_-->기본자료형
		System.out.println(value);
		
		//연산시 박싱 객체는 언박싱으로 변화후 연산처리
		int result = obj + 100; 
		System.out.println(result);
		
		
	}
}



/*
 * 
 * 
 * 
 */
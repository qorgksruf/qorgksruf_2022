package Day11.EX7;

import java.util.ArrayList;

import Day11.EX6.HankookTire;
import Day11.EX6.KumhoTire;
import Day11.EX6.Tire;

public class 실행2 {

	public static void main(String[] args) {
		
		//1. 참조타입의 자동타입 변환
		Tire tire=new Tire();
		KumhoTire kumhoTire=new KumhoTire();
		HankookTire hankookTire=new HankookTire();
		
		
		//자식은 부모한테 가능함 
		Tire temp =tire;
			Tire temp2=kumhoTire;
				Tire temp3=hankookTire;
					Object temp4=temp3;
	
		//강제타입변환
		Tire tire2=(Tire)temp4;	
			KumhoTire kumhoTire2=(KumhoTire)tire;
					HankookTire hankookTire2=(HankookTire)tire2;
		//매개함수,리턴타임			
		함수1(kumhoTire2)	;		
		
		
		//배열 ,ArrayList ***이렇게 쓰지마고
		ArrayList<KumhoTire>kumhoList =new ArrayList<>();
		kumhoList.add(kumhoTire);
	//	kumhoList.add(hankookTire); x
	//	kumhoList.add(Tire); x
		
		
		// 이렇게쓰삼*******
		ArrayList<Tire>TireList =new ArrayList<>();
		TireList.add(hankookTire);
		TireList.add(kumhoTire);
	}//main e
	
	public static Tire 함수1( Tire tire ) {
		return tire;}
}

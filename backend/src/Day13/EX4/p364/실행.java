package Day13.EX4.p364;

public class 실행 {
	public static void main(String[] args) {
		interfaceCImp1 imp1 = new interfaceCImp1();
		
		
		/*
		 * 
		 * 		A엄마		B아빠
		 * 			상속
		 * 			C나
		 * 
		 * 
		 * */
		interfaceCImp1 imp12 = new interfaceCImp1();

		
		interfaceA ia = imp1;
		ia.methodA();	
		
		interfaceB ib=imp1;
		ib.methodB(); //본인꺼니까 얘 가능
		
		
		interfaceC ic = imp1;
		ic.methodA(); 
		ic.methodB();
		ic.methodC();
		
		
	}

}

package Day09_EX3;
/*
 * 
 * return 메소드의 실행을 강제 종료하고 호출한 곳으로 돌아감
 * 
 * 
 * */
public class Car {
	
	int gas;
	
	Car(){};
	Car(int gas){
		this.gas=gas;
	}
	
	
	void setGas(int gas) {//gas 필드에 데이터 저장하는 함수
		this.gas=gas;
	}
	
		//리턴타입이 0 [boolean] 인수x
	boolean isLetfGas() { //gas 여부 확인함수
		if(gas==0) {
			System.out.println("gas가 없습니다");
			return false;
		}
		System.out.println("gas가 있습니다");
		return true;
	}
	
		//리턴이 없고 이수도 없음
	void run() {	//자동차 달리는 함수->gas가 0일때까지
		while(true) {	//무한루프[종료조건:꼭넣어줘야함]//gas가 0이면 return함;;;
			if(gas>0) {//gas가 0보다 크면
				System.out.println("달립니다(gas잔량"+gas+")");
				gas--;
			}else {//가스가0이면 종료된다는 뜻
				System.out.println("멈춥니다(gas잔량"+gas+")");
				return;//함수종료됨 [while 종료]
			}
			
			
		}
	}
	
	
	
	
	
}//class e

package Day08_EX3_P225;
//설계도
public class Car {
	//1.필드
	String company="현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	
	//2.생성자
		//오버로딩: 매개변수의 타입.개수, 순서가 다르게 여러개 생성자 선언
		//오른쪽클릭->source->Generate Constructor using Fields->필드선택
	//빈생성자---->관례적으로 해놓으삼
			public Car() { }	 
			
		
			//1개 변수
			public Car(String model) {
				this.model = model;
			}
			
			
		
			//2개변수
			public Car(String model, String color) {
				this.model = model;
				this.color = color;
			}
		
		
			//3개변수
			public Car(String model, String color, int maxSpeed) {
				this.model = model;
				this.color = color;
				this.maxSpeed = maxSpeed;
			}
			
			
			//모든필드받는 매개변수---->관례적으로 해놓으삼
			public Car(String company, String model, String color, int maxSpeed) {
				super();
				this.company = company;
				this.model = model;
				this.color = color;
				this.maxSpeed = maxSpeed;
			}	
			
	//3.메소드(소스->tolstring 어쩌고넣고)
	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
	}	
	
	
	
}

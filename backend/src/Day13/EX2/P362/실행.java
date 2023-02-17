package Day13.EX2.P362;

public class 실행 {
	public static void main(String[] args) {
		//구현객체
		Remotecontrol rc = new smartTelevision();
		
		rc.turnOn();
		rc.turnOff();
		
		//구현객체
		Searchable searchable =new smartTelevision();
		searchable.search("Youtube");
		
	}

	
	
}

package Day13.EX2.P362;

public class smartTelevision implements Remotecontrol, Searchable{
	@Override
		public void turnOn() {
			System.out.println("TV를 켭니다"); 
			
			
		}
	
	@Override
	public void turnOff() {
		System.out.println("tv를 끕니다");
		
	}
	@Override
	public void search(String url) {
		System.out.println(url+"을 검색합니다");
		
		
	}
}

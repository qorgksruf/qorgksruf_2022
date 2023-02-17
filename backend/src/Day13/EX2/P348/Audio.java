package Day13.EX2.P348;

public class Audio implements Remotecontrol {
	
	//필드
	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다");
		
	}
	
	@Override
	public void turndff() {
		System.out.println("Audio를 끕니다");
		
	}
	
	@Override
	public void setVolume(int volume) {
		if(volume > Remotecontrol.MAX_VOLUME) {	//만약에 요청한 소음이 최대소음보다 크면
			this.volume= Remotecontrol.MAX_VOLUME;	//현재소음에 최대소음을 대입
			System.out.println("최대 소음보다 커질 수 없습니다. 최대소음으로 설정");
		}else if( volume<Remotecontrol.MIN_VOLUME) { //만약에 요청한 소음이 최소소음보다 작으면
			this.volume = Remotecontrol.MIN_VOLUME;
			System.out.println("최소소음보다 작아질 수 없습니다 최소소음으로 설정");
		}else {
			this.volume = volume;
		}
		System.out.println("현재 Audio볼륨;;;:"+this.volume); //현재소음 출력	
		
	}
	
	private int memoryVolume;	//추가 필드 선언
	
	//필드
	@Override//디폴트 메소드 오버라이딩
	public void setMute(boolean mute) {
		
		if(mute) {
			this.memoryVolume = this.volume;
			System.out.println("무음 처리합니다");
			setVolume(Remotecontrol.MIN_VOLUME);
			
		}else {
			System.out.println("무음 해체 합니다");
			setVolume(this.memoryVolume);
		}
	}
	
	
	
	
}

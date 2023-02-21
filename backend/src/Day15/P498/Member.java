package Day15.P498;

public class Member {
	//필드
	public String id;

	
	//생성자
	public Member(String id) {
		this.id = id;
	}

	//메소드
	//주소단지 비교가 아닌 내부 값 비교로 리모델링 즉 오버라이딩
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Member) {	//jdk 16version 이상 
			//부모객체 instanceof 자식클래스 변환객체명
			//obj를 target으로
			Member target=(Member)obj;
			
			if(id.equals(target.id)) {
				return true;
			}
				
			}
			return false;
		}
		
	}


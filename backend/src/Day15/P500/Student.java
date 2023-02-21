package Day15.P500;

public class Student {
	private int no;
	private String name;
	
	public int getNo() {
		return no;
	}
	
	public String getName() {
		return name;
	}

	
	public Student(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	
	
	@Override
	public int hashCode() {	//숫자랑 이름은 주소값없으니 해시테그 비교시 내용 비교로는 같음
		int hashCode = no +name.hashCode();
		return hashCode;
	}
	
	@Override	//내부객체비교
	public boolean equals(Object obj) {
		if(obj instanceof Student ) {
			Student target = (Student)obj;
			if(no==target.getNo() && name.equals(target.getName()) )
				return true;
		}
			
		return false;
	}
	
	
	
}//class e

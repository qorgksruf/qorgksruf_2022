package 과제4_강사풀이_Model;

import java.util.ArrayList;

//회원[객체] 여러명 만들어서 하나의 리스트에 저장
	//설계하고자하는거  즉 만들고자하는거 한글로 구체적으로 써보고,설계 ㄱ 
	//필드:private 관례적으로쓰고 외부의 직접 접근 방지시킴 ->getter, setter
	//생성자: 빈 생성자 플생성자 만들기~!!!!
	//메소드-> tostring()  주로 확인용으로 많이씀~!!!! private쓰면 getter,setter 사용함~!!!
public class Member {

	//1.인스턴스맴버: 객체있어야 사용->스택영역
	//정적멤버: static은 객체 없이 쓰는애->메소드영역
	//1.필드
	private String id;
	private String pwd;
	private String name;
	private String phone;
	//한명의 회원이 여러개의 보드객체를 갖을수있다~!!!!라는 뜻!!!!
	private ArrayList<Board>boardList;
	//2.생성자
	
	//빈
	public Member() {
		
	}

	//풀
	public Member(String id, String pwd, String name, String phone, ArrayList<Board> boardList) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.boardList = boardList;
	}

	
	
	//3.메소드
	@Override		// 얘는 toString
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone + ", boardList=" + boardList
				+ "]";
	}

	
	//얘는 getter setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ArrayList<Board> getBoardList() {
		return boardList;
	}

	public void setBoardList(ArrayList<Board> boardList) {
		this.boardList = boardList;
	}

	

	
}

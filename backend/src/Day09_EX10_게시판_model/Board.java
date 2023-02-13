package Day09_EX10_게시판_model;



import java.util.Date;

// 먼저 필드선정~!!!!!!!! 필드 할 페이지 만들고
//모든 필드는 무조건적으로 private 해버려~!!!!!
// 생성자는 빈거랑 풀 생성
//여긴 게시물 삭제 출력 변경 같은거 안하고 오직 모델링역활 어떤 형태 만드는 패이지라고 생각해~!!!!!!!!

public class Board {
	//필드 만들기-----------> 자동완성 x는 애임
	private String title;
	private String content;
	private String writer;
	private Date dete;
	private String password;
	private int view;
	
	
	//2.생성자 생성 -> 빈,풀
	public Board() {
	}

	public Board(String title, String content, String writer, Date dete, String password, int view) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.dete = dete;
		this.password = password;
		this.view = view;
	}

	
	//3.메소드=> tostring
	@Override
	public String toString() {
		return title +"\t"+writer+"\t"+view+"\t"+dete;
	}

	
	
	//3.메소드=> getter, setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getDete() {
		return dete;
	}

	public void setDete(Date dete) {
		this.dete = dete;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}
	

	
	
	
	
	
	
	
	
}

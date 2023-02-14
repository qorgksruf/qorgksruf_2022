package 과제4_강사풀이_Model;


/*
 * model 관계
 * 	1.한명의 회원이 글 작성한다-> object
 *  2.회원은 여러개의 글을 작성한다 -> ARRAY
 * 즉 member페이지는 여러명이 작성하고 board는 한명이 작성함 
 * 
 * */

public class Board {

//필드
	private String title;
	private String content;
	private int view;
	//작성자는 따로 안했음;;;;;;;;
	//하나의 게시물[객체]가 하나의 멤버객체를 갖을 수 있다;;;;;;;;
	private Member member;
	
	
//생성자	-빈
	public Board() {
	}


//생성자-풀
	public Board(String title, String content, int view, Member member) {
		this.title = title;
		this.content = content;
		this.view = view;
		this.member = member;
	}

	
	
	
//메소드
	//toString
	@Override
	public String toString() {
		return "Board [title=" + title + ", content=" + content + ", view=" + view + ", member=" + member + "]";
	}


	
	
	
	//getter setter
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



	public int getView() {
		return view;
	}



	public void setView(int view) {
		this.view = view;
	}



	public Member getMember() {
		return member;
	}



	public void setMember(Member member) {
		this.member = member;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package MVC연습장.model;

public class Board {
	public String id;
	public String title;
	public String content;
	public int count;
	
	public Board() {
	}

	public Board(String id, String title, String content, int count) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.count = count;
	}

	public Board(String id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	
	
}

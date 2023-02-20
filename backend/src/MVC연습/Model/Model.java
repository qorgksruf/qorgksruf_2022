package MVC연습.Model;

public class Model {
	// 1. 필드
	public String id;
	public String pwd;
	public String name;
	public String phone;
	
	// 2. 생성자
	public Model() {}

	public Model(String id, String pwd, String name, String phone) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
	}
}

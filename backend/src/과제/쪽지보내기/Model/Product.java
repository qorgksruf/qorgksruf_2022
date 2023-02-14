package 과제.쪽지보내기.Model;

public class Product {
	private String name; 
	private String pcontent;
	private int price;
	private Member member;
	
	
	
	public Product() {
	}

	public Product(String name, String pcontent, int price, Member member) {
		this.name = name;
		this.pcontent = pcontent;
		this.price = price;
		this.member = member;
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", pcontent=" + pcontent + ", price=" + price + ", member=" + member + "]";
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}


	
	
	
	
	
}

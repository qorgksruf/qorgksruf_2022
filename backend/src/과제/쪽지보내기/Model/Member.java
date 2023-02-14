package 과제.쪽지보내기.Model;

import java.util.ArrayList;

public class Member {

	
	private String id;
	private String pw;
	private String name; 
	private String phone;
	private ArrayList<Product> prodect;
	private ArrayList<Memo> sendmemo;
	private ArrayList<Memo> recvmemo;
	
	
	public Member() {
	}


	public Member(String id, String pw, String name, String phone, ArrayList<Product> prodect, ArrayList<Memo> sendmemo,
			ArrayList<Memo> recvmemo) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.prodect = prodect;
		this.sendmemo = sendmemo;
		this.recvmemo = recvmemo;
	}

	

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", prodect=" + prodect
				+ ", sendmemo=" + sendmemo + ", recvmemo=" + recvmemo + "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
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


	public ArrayList<Product> getProdect() {
		return prodect;
	}


	public void setProdect(ArrayList<Product> prodect) {
		this.prodect = prodect;
	}


	public ArrayList<Memo> getSendmemo() {
		return sendmemo;
	}


	public void setSendmemo(ArrayList<Memo> sendmemo) {
		this.sendmemo = sendmemo;
	}


	public ArrayList<Memo> getRecvmemo() {
		return recvmemo;
	}


	public void setRecvmemo(ArrayList<Memo> recvmemo) {
		this.recvmemo = recvmemo;
	}
	

	
	
}

package 과제3;

import java.util.ArrayList;

public class Member {
	//1.필드[기본자료형( boolean, int ,float) 참고자료형]
	String id;
	String password;
	String name;
	String phone;
	ArrayList<Book> rentList = new ArrayList<>(); //다른 설계의 멤버에 있는 북을 불러오는 것을 말함
}

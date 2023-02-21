package Day15.DB연동;


import java.sql.*;




public class DB연동 {
	
	//DriverManager.getConnection() 해당 db주소와 연결 성공시 성공한 db구현객체 반환
	private Connection conn;	//1.db연결된 구현객체를 받아서 다양한 메소드 제공
	private PreparedStatement ps; //2.연결된 sql조작 메소드 제공[? 매개변수 사용]
	private ResultSet rs;		//3. sql결과 조작 메소드 제공 인터페이스
	
	public DB연동() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/java","root","1234");
			System.out.println("[연동성공]");
		}
		catch (Exception e) {
				System.out.println(e.getMessage());
		}
		
		
		
	
	}
	
	public static void main(String[] args) {
		
		DB연동 연동 = new DB연동();
		
	}
	

}
//준비물
//1.DB서버주소 [localhost VS 개인iP vs AWS] 이 셋중하나 필요함
//2.해당 db서버의 계정
//3. 해당 계정의 비밀번호
//자바에서 DB 조작 클래스 및 JDBC

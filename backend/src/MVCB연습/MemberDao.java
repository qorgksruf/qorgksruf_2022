package MVCB연습;

import java.sql.*;

public class MemberDao {
	//싱글턴
	private static MemberDao dao = new MemberDao();
	public static MemberDao getInstance() {
		return dao;
	}
	
	private Connection conn;	//1.db연결된 구현객체를 받아서 다양한 메소드 제공
	private PreparedStatement ps; //2.연결된 sql조작 메소드 제공[? 매개변수 사용]
	private ResultSet rs;		//3. sql결과 조작 메소드 제공 인터페이스
	
	private MemberDao() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/day15","root","1234");
			System.out.println("[연동성공]");
		}
		catch (Exception e) {
				System.out.println(e.getMessage());
		}
		
	}
	
	public boolean signup(Memberdto dto) {
		String sql = "insert into member (mid,mpw) values(?,?)";
		
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			ps.executeUpdate();
			
			return true;
			
			
		}catch (Exception e) {
			System.out.println("DB오류"+e);
			return false;
		}
		
		
	}//함수끝
	
	
	
	
}//class e
	
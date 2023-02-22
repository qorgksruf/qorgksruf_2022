package 과제.과제11;

import java.sql.*;

public class BoardDao {
	
	private static BoardDao dao = new BoardDao();
	public static BoardDao getInstance() {
		return dao;
	}
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	private BoardDao() {
		try {	
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/day16","root","1234");
			
					System.out.println("연동성공");
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}// 연동작업
	
		public boolean signup(BoardDto dto) {
			String sql = "insert into product(mid, )"
		}
	
	
	
	
	
	
	
	
}//class e
	
package Day15.EX9.MVC패턴;

import java.sql.*;
import java.util.ArrayList;




public class MemberDao {
	
	//DB 연동코드- > 싱글톤으로 
	
	//싱글톤 객체 만들기
	private static MemberDao dao=new MemberDao();
	public static MemberDao getInstance() {
		return dao;
	}

	
		//필드
		//DriverManager.getConnection() 해당 db주소와 연결 성공시 성공한 db구현객체 반환
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
		
		//sql 처리 메소드
		//회원가입 메소드[ 인수는 뭐? 표만든거 id,pw 반환은 뭐? 성공실패]
		//인수 Dto(id,pw) 으로 반환은 true로 받을거니까 boolean
		public boolean signup(MemberDto dto) {
				String sql ="insert into member (mid,mpw) values(?,?)";
				//연동 db에 sql 대입한다
				try {
				
					ps = conn.prepareStatement(sql);
					//ps는 매개변수에 대한 조작가능
					ps.setString(1, dto.getMid());
					ps.setString(2, dto.getMpw());
					//ps 가 sql실행
					ps.executeUpdate();
					//결과 반환
					return true; //여기까지 문제 없었으면 저장성공
					
				} catch (SQLException e) {
			
					System.out.println("DB오류"+e);
					return false; //try문제가 있으면 실행되는 구역-> 저장 실패
				}

				
		}
		
		
		public ArrayList<MemberDao> list(){
			return null;
		}



}//class e

package practice.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class BoardDao {
	
	//싱글톤
	private static BoardDao dao= new BoardDao();
	public static BoardDao getInstance() {
		return dao;
	}
	
	
	private Connection con ;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public BoardDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jspweb",
					"root",
					"1234"
				);			
		}catch (Exception e) {
			System.out.println(e);
		}

	}
	
	//등록 [인수: 입력받은 값/ 반환은 성공여부]
	public boolean onwrite(BoardDto dto) {
		String sql="insert into ex03(bcontent,bwriter) values(? , ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getBcontent());
			ps.setString(2, dto.getBwriter());
			ps.executeUpdate();
			return true;
			
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}	
	
		//모든 방문록 출력 [인수: x/반환: 여러개[list]의 dto]
		public ArrayList<BoardDto> onlist(){
			ArrayList<BoardDto> list = new ArrayList<>();
			String sql = "select *from ex03";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				//레코드 1개가 필요하면 IF 레코드 여러개가 필요하면 while
				while(rs.next()) {
					BoardDto dto = new BoardDto(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4)
							);
					list.add(dto);
				}
			}catch (Exception e) {
					
			}
			
					return list;
			
		}
		
		
		public boolean ondelete(int bno) {
			String sql="delete from ex03 where bno=?";
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, bno);
				ps.executeUpdate();
				return true;
			}catch (Exception e) {
				System.out.println(e);
			}return false;
		}
		
		public boolean onupdate(int bno,String newContent) {
			String sql = "update ex03 set bcontent =? where bno=?";
			
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, newContent);
				ps.setInt(2, bno);
				ps.executeUpdate();
				return true;				
			}catch (Exception e) {
				System.out.println(e);
			}return false;
			
		}
		
		
	}


	


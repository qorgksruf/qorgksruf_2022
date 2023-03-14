package practice.과제1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	//싱글톤
	private static Dao dao = new Dao();
	public static Dao getInstance() {
		return dao;
	}
	
	//db연동
	Connection con;
	PreparedStatement ps;
	ResultSet rs;	
	private Dao() {
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
	}// 연동e	
	
	public boolean signup(SDto dto) {
		String sql="insert into scompany(cimg,cname,clevel,cform, cclassfy,csdate)values(?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getCimg());
			ps.setString(2, dto.getCname());
			ps.setString(3, dto.getClevel());
			ps.setString(4, dto.getCform());
			ps.setString(5, dto.getCclassfy());
			ps.setString(6, dto.getCsdate());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e);
		}return false;
	}	
	
	
	public boolean delete(String cname) {
		String sql1 = "SELECT *"
				+ "  FROM scompany "
				+ "	 WHERE cname=? ";
		
		String sql2 = "delete from scompany where cname=?";
		
		try {
			ps = con.prepareStatement(sql1);
			ps.setString(1, cname);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("삭제할 회원정보를 찾았습니다 해당 회원정보를 삭제합니다");
				
				ps = con.prepareStatement(sql2);
				ps.setString(1, cname);
				
				ps.executeUpdate();
				
				return true;
			}else {
				System.out.println("삭제할 회원정보 없음 ");
				return false;
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
		
	}


	public EDto bye(String cname, String cedate, String cecontent) {
		ArrayList<E>
		String sql="";
		try {
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return dto;
	}
	
}//class e

package practice.과제;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	/*
 	create table ex2(
		data1  varchar(100) ,
	    data2  varchar(100) ,
	    data3  int ,
	    data4  varchar(20) ,
	    data5  date ,
	    data6  char(1),
	    data7  boolean ,
	    data8  varchar(100),
	    data9  longtext
	   
	);
 */
	
	private static Dao dao = new Dao();
	public static Dao getInstance() {
		return dao;
	}//싱글턴 e
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	private Dao() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				con = DriverManager.getConnection( 
						"jdbc:mysql://localhost:3306/java",
						"root",
						"1234"
						);		
			
			}catch (Exception e) {
				System.out.println(e);
			}
	}
	
	// DTO 있는 애
	public boolean setDate2(Dto dto) {
		String sql="insert into homework values(?,?,?,?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString( 1 , dto.getData1() );
			ps.setString( 2 , dto.getData2() );
			ps.setInt(3, dto.getData3());
			ps.setString( 4 , dto.getData4() );
			ps.setString( 5 , dto.getData5() );
			ps.setString( 6 , dto.getData6() );
			ps.setBoolean( 7 , dto.isData7() );
			ps.setString( 8 , dto.getData8() );
			ps.setString( 9 , dto.getData9() );
			ps.executeUpdate();
			return true;
		}catch (Exception e) {

		}
		return false;
	}
	
	
	
	
	//dto 있는 인수
	public ArrayList< Dto> getDate(){
		ArrayList<Dto>list = new ArrayList<>();
		String sql="select * from homework";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Dto dto = new Dto(
						rs.getString(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getBoolean(7),
						rs.getString(8),
						rs.getString(9)
						);
				list.add(dto);
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	
	
	
}




package Day20.gallery.Model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {

	public Connection con;
	public PreparedStatement ps;
	public ResultSet rs;
	
	public Dao() {
		try {	//DB연동
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/boardDb"
					,"root"
					,"1234");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
		
}

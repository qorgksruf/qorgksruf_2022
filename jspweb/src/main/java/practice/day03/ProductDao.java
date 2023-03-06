package practice.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDao {
	//싱글톤
	private static ProductDao dao= new ProductDao();
	public static ProductDao getInstance() {
		return dao;
	}
	//연결
	private Connection con ;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//db연동
	public ProductDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jspweb",
					"root",
					"1234"
				);				
		}catch (Exception e) {
			System.out.println("연동실패"+e);
		}
	}
		
	
	//등록
	public boolean onregi(ProductDto dto) {
		String sql="insert into product(pname,pprice) values(?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getPname());
			ps.setInt(2, dto.getPno());
			ps.executeUpdate();
			return true;
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	//출력
	public ArrayList<ProductDto> prolist(){
		ArrayList<ProductDto> list = new ArrayList<>();
		String sql = "select *from product";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			//레코드 1개가 필요하면 IF 레코드 여러개가 필요하면 while
			while(rs.next()) {
				ProductDto dto = new ProductDto(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3)
						);
				list.add(dto);
			}
		}catch (Exception e) {
				
		}
		
				return list;
		
	}
	
	//삭제
	public boolean pdelete(int pno) {
		String sql="delete from product where pno=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
	
	
	//업데이트
	public boolean proupdate(int pno,String Pname, int PPrice) {
		String sql="update product set pname=? , pprice=? where pno=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Pname);
			ps.setInt(2,PPrice);
			ps.setInt(3,pno);
			ps.executeUpdate();
			return true;				
		}catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
	
	
	
}

package 과제11;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class ProductDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static ProductDao dao = new ProductDao();
	private ProductDao() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/과제11","root","1234");
		}catch (Exception e) { System.out.println( e ); }
	}
	public static ProductDao getInstance() { return dao; }
	
	
	//제품등록 
	public boolean regist (ProductDto dto) {
		//sql작성
		String sql="insert into product(pname, pprice,pstock)values(?,?,?);";
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, dto.getPname());
			ps.setInt( 2 , dto.getPprice() );
			ps.setInt( 3 , dto.getPstock() );
			ps.executeUpdate(); 
			return true;
		}catch (Exception e) {
			return false; 
		}
		//연동 db에 dql대입
		
		
	}
	
	public ArrayList<ProductDto>getProductAll(){
		ArrayList<ProductDto>list = new ArrayList<>();
		String sql = "select*from product";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
			ProductDto dto = new ProductDto(
					rs.getInt(1), rs.getNString(2),rs.getInt(3),rs.getInt(4));
					list.add(dto);
				
			}
			return list;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	

	
	//제품수정[이름,가격]
	public int update(int pno,String pname, int pprice) {
		String sql=
		"update product set pname =?, pprice= ? where pno = ?;";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, pname);
			
			ps.setInt(2, pprice);
			
			ps.setInt(3, pno);
			
			ps.executeUpdate();
			
			
			return 1;
			
		}catch (Exception e) {
			System.out.println("db오류");
			return 5;
			
			
		}
	}
	
	//재고수정
	public boolean saveupdate(int pno, int pstock) {
		String sql=
				"update product set pstock =? where pno = ?;";
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, pstock);
			
			ps.setInt(2, pno);
			
			ps.executeUpdate();
			
			return true;
			
		}catch (Exception e) {
			System.out.println("db연동실패");
			
			return false;
		}
	}
	
	
	
	
	
	
	
	//제품삭제
	public boolean delete(int pno) {
		String sql = "delete from product where pno = ?;";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, pno);
			
			ps.executeUpdate();
			
			return true;
			
		}catch (Exception e) {
			System.out.println("오류");
			return false;
			
		}
		
	}
	
	
	
	
	
}


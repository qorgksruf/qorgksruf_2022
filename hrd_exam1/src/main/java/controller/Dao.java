package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	public Connection con;
	   public PreparedStatement ps;
	   public ResultSet rs;
	   
	   public static Connection getConnection() throws Exception {
	      
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection con = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/xe",
	            "root",
	            "1234");
	      System.out.println("통신");
	      return con;
	   }
	   
	   public Dao() {
	      try {
	         con = getConnection();
	      }catch (Exception e) {
	         System.out.println( e );
	      }

	   }
	   
	  // 1.마지막 회원번호+1 가져오기 
	   public int getcustno() {
		   String sql="select max(custno)+1 from member_tbl_02;";

		   try {
			   ps=con.prepareStatement(sql);
			   rs=ps.executeQuery();
			   if(rs.next()) {
				   return rs.getInt(1); 
			   }
				  
			   
		   }catch (Exception e) {
			   System.out.println(e);
		}
		   return 0;
	   }
	   //회원등록
	   public boolean join(MemberDto dto) {
		
		   String sql="insert into member_tbl_02 "
		   		+ " (custname, phone, address,joindate,grade, city)"
		   		+ " values(?,?,?,?,?,?)";
		   try {
			   ps=con.prepareStatement(sql);
			   ps.setString(1,dto.getCustname() );
			   ps.setString(2,dto.getPhone() );
			   ps.setString(3,dto.getAddress() );
			   ps.setString(4,dto.getJoindate() );
			   ps.setString(5,dto.getGrade() );
			   ps.setInt(6,dto.getCity());
			   
			  ps.executeUpdate();
			  return true;
			   
		   }catch (Exception e) {
			   
		}
		   return false;
	   }
	   //모든회원출력
	   public ArrayList<MemberDto>getmemberlist(){
		   ArrayList<MemberDto>list = new ArrayList<>();
		   String sql ="select "
		   		+ "	custno, "
		   		+ "    custname, "
		   		+ "    phone, "
		   		+ "    address, "
		   		+ "    joindate, "
		   		+ "    if( grade ='A','VIP', if(grade='B','일반','직원'))AS g,  "
		   		+ "    city  "
		   		+ "from  member_tbl_02;";
		   try {
			   ps=con.prepareStatement(sql);
			   rs=ps.executeQuery();
			   
			   while(rs.next()) {
				   list.add(new MemberDto(
						   rs.getInt(1),
						   rs.getString(2),
						   rs.getString(3),
						   rs.getString(4), 
						   rs.getString(5),
						   rs.getString(6),
						   rs.getInt(7)
						   ));
				   
				   //return list;
			   }
		   }catch (Exception e) {
			   System.out.println(e);
		}
		return list;
	   }
	   
	   
	   //특정 회원수정하기
	   public MemberDto getmember(int custno) {
		   String sql="select * from member_tbl_02 where custno = "+custno;
		   try {
			   ps=con.prepareStatement(sql);
			   rs=ps.executeQuery();
			   
			   if(rs.next()) {
				   return new MemberDto(
						   rs.getInt(1),
						   rs.getString(2),
						   rs.getString(3),
						   rs.getString(4), 
						   rs.getString(5),
						   rs.getString(6),
						   rs.getInt(7)
						   );
				   
			   }
		   }catch (Exception e) {
			   System.out.println(e);
		}   
		   return null;
	   }
	   
	   public boolean onupdate(MemberDto dto) {
		   String sql="update member_tbl_02 set custno=?,custname=?, phone=?, address=?, joindate=?,grade=?,city=? where custno=?";
		   try {
			   ps=con.prepareStatement(sql);
			   ps.setInt(1, dto.getCustno());
			   ps.setString(2, dto.getCustname());
			   ps.setString(3, dto.getPhone());
			   ps.setString(4, dto.getAddress());
			   ps.setString(5, dto.getJoindate());
			   ps.setString(6, dto.getGrade());
			   ps.setInt(7, dto.getCity());
			   
			   ps.setInt(8, dto.getCustno());
			   ps.executeUpdate();
			   return true;
		   }catch (Exception e) {
			   System.out.println(e);
		}
		   return false;
	   }
	   
	   
	   //매출출력
	   public ArrayList<MemberDto>getsum(){
		   ArrayList<MemberDto>list = new ArrayList<>();
		   String sql = "select "
		   		+ "	m.custno,"
		   		+ "    m.custname, "
		   		+ "    if(m.grade='A','VIP', if(m.grade='B','일반','직원'))AS G,"
		   		+ "    sum(mo.price) AS 매출"
		   		+ " from member_tbl_02 m natural join money_tbl_02 mo"
		   		+ " group by m.custno"
		   		+ " order by sum(mo.price)desc;";
		   
		   try {
			   ps=con.prepareStatement(sql);
			   rs=ps.executeQuery();
			   
			   while(rs.next()) {
				   list.add(new MemberDto(
						   rs.getInt(1),
						   rs.getString(2),
						   rs.getString(3),
						   rs.getInt(4)
						   ));
				 
				  
			   }
			   return list;
		   }catch (Exception e) {
			   System.out.println("매출출력결과"+e);
		}
		return null;
	   }
	   
	   
}

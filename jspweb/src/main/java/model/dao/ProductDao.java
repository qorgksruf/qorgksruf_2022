package model.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.dto.ChatDto;
import model.dto.ProductDto;

public class ProductDao extends Dao{
	private static ProductDao dao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() { return dao; }
	
	//제품등록 
	public boolean onwrite(ProductDto dto ) {
		String sql="insert into product(pname, pcomment, pprice, plat, plng, mno) values (?,?,?,?,?,?)";
		try {
			
			ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getPname());
			ps.setString(2, dto.getPcomment());
			ps.setLong(3, dto.getPprice());
			ps.setString(4, dto.getPlat());
			ps.setString(5, dto.getPlng());
			ps.setInt(6, dto.getMno());
			ps.executeUpdate(); //insert 후 생성된 제품pk 번호 가져오기
			rs=ps.getGeneratedKeys();
			if(rs.next()) {//만약에 생성된 제품 pk 번호가 존재하면
				for(String pimgname :dto.getPimgList() ) {
					//dto 내 첨부파일명 반복문 돌려서 하나씩 insert 하기
					sql="insert into pimg(pimgname,pno)values(?,?)";
					ps=con.prepareStatement(sql);
					ps.setString(1, pimgname);
					ps.setInt(2, rs.getInt(1));	//pno 빼내는 작업
					ps.executeUpdate();
				}
			}
			return true;
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public ArrayList<ProductDto>getproductList(String 동, String 서, String 남, String 북){
		ArrayList<ProductDto>list = new ArrayList<>();
		String sql = " select p.* , m.mid , m.mimg from product p natural join member m "
					+ " where p.plng <= ? and p.plng >= ? and p.plat >= ? and p.plat <= ? ";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, 동);
			ps.setString(2, 서);
			ps.setString(3, 남);
			ps.setString(4, 북);
			rs=ps.executeQuery();
			
			while(rs.next() ) {
				
				//사진 레코드 호출
				ArrayList<String>pimgList = new ArrayList<>();
				sql="select * from pimg where pno="+rs.getInt(1);
				ps=con.prepareStatement(sql);
				ResultSet rs2 = ps.executeQuery();
				
				while(rs2.next()) {
					pimgList.add(rs2.getString(2));	//검색된 이미지이름을 리스트에 저장
				}
				
				ProductDto dto = new ProductDto(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5), 
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8),
						rs.getString(9),
						rs.getInt(10),
						rs.getString(11),
						rs.getString(12),
						pimgList);
				list.add(dto);
			}
		}catch (Exception e) {
				System.out.println(e);
		}
		return list;
	}
	
	//찜하기 등록/취소
	public boolean setplike(int pno,int mno) {
		//1.등록할지 취소할지 검색 먼저하기
		String sql="select * from plike where pno ="+pno+" and mno = "+mno+"";
		
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {//해당 회원이 이미 찜하기를 한 제품--> 취소하기
				sql="delete from plike where pno="+pno+" and mno = "+mno+"";
				ps=con.prepareStatement(sql);
				ps.executeUpdate();
				return false;
			}else {//해당회원이 찜하기를 하지 않은 제품 -> 등록하기
				sql="insert into plike( pno , mno)values("+pno+","+mno+")";
				 ps=con.prepareStatement(sql);
				 ps.executeUpdate();
				 return true;
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	//4. 현재 회워닝 해당 제춤의 찜하기 상태 확인
	public boolean getplike(int pno,int mno) {
		String sql="select * from plike where pno ="+pno+" and mno = "+mno;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	
	public boolean setChat(ChatDto dto) {
		String sql="insert into note(ncontent,pno,frommno,tomno)values(?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getNcontent());
			ps.setInt(2, dto.getPno());
			ps.setInt(3, dto.getFrommno());
			ps.setInt(4, dto.getTomno());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	//6.제품에 등록된 채팅 [제품번호 일치 , 현재 보고있는 회원[즉 로그인된회원] 받거나 보낸 내용 ]
	public ArrayList<ChatDto>getChatList( int pno, int mno){
		ArrayList<ChatDto>list = new ArrayList<>();
		String sql="select * from note where pno= ? and (frommno=? or tomno=?)";	//해당제품이면서 받거나 보낸거 다 갖구오기
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.setInt(2, mno);
			ps.setInt(3, mno);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new ChatDto(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getInt(6)));
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	
	
}

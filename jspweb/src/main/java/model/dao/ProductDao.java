package model.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import model.dto.ChatDto;
import model.dto.ProductDto;

public class ProductDao extends Dao{
	private static ProductDao dao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() { return dao; }
	
	//제품등록 [synchronized : 멀티스레드 사용시 (서블릿)헤딩 메소드 동시사용불가 =await ]
	public synchronized boolean onwrite(ProductDto dto ) {
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
	
	public synchronized ArrayList<ProductDto>getproductList(String 동, String 서, String 남, String 북){
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
	public synchronized boolean setplike(int pno,int mno) {
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
	public synchronized boolean getplike(int pno,int mno) {
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
	
	
	
	public synchronized boolean setChat(ChatDto dto) {
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
	public synchronized ArrayList<ChatDto>getChatList( int pno, int mno, int chatmno){
		ArrayList<ChatDto>list = new ArrayList<>();
		String sql="";
		
		if(chatmno!=0) { // 채팅방내 메시지 목록 출력할때
			 sql=		" select * from note "
						+ "where pno= ? and "
						+ "( (frommno = ? and tomno= ?) or(frommno = ? and tomno= ?) )";	
		}else {
			 sql=" select * from note where pno= ? and (frommno=? or tomno=? )";
		}
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, pno);
			if(chatmno!=0) {
				ps.setInt(2, mno);
				ps.setInt(3, chatmno);
				ps.setInt(4, chatmno);
				ps.setInt(5, mno);	
			}else {
				ps.setInt(2, mno);
				ps.setInt(3, mno);
			}
			rs=ps.executeQuery();
			while(rs.next()) {
				ChatDto dto = new ChatDto(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getInt(6));
					
				//보낸 회원의 정보호출
				sql="select mid, mimg from member where mno="+ rs.getInt(5); // rs.getInt(5) =frommno
				ps=con.prepareStatement(sql);
				ResultSet rs2=ps.executeQuery();
				if(rs2.next()) {
					dto.setFrommid(rs2.getString(1));
					dto.setFrommimg(rs2.getString(2));	
				}

				list.add(dto);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	//7.날짜별 포인트 충전 내역
	public HashMap<String, Integer> getSum(){
		HashMap<String, Integer>map = new HashMap<>();
		//ArrayList<String>list = new ArrayList<>(); 이거는 string 타입의 객체만 저장가능한데 Map는 string 타입의 키와 Interger 타입의 데이터 사용가능
		String sql="select "
				+ "   date_format( mdate , '%Y-%m-%d' ) as mdate , "
				+ "    sum( if( mpcomment = '포인트충전' , mpamount , 0 ) ) as point "
				+ "from mpoint group by date_format( mdate , '%Y-%m-%d' ) ;";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {	//put(키, 데이터)
				map.put(rs.getString(1), rs.getInt(2));
			}
			
		}catch (Exception e) {
			System.out.println(e);
		
		}
		return map;
	}

	
}
/*
 * Arraylist<타입>list = new Arraylist<>()
 * 이거 비슷한거
 * 
 * 해당 키타입과 데이터타입의 해당하는 키와데이터를 여러개 저장할 수 있는 맵객체
 * HashMap<키타입,데이터타입>map = new HashMap<>();
 * 
 * */

//얘가 채팅목록 가져오는거
//String sql=" select * from note where pno= ? and (frommno=? or tomno=? )";	//해당제품이면서 받거나 보낸거 다 갖구오기

//현재 같이 채팅하고 있는 대상자들의 내용물만 출력


// 1.로그인된 회원기준으로 보내거나 받은 메시지 모두출력
// String sql=" select * from note where pno= ? and (frommno=? or tomno=? )";
//1.구매자 문제 없음 2.판매자는 채팅 대상만의 메시지만 출력 해야함 문제 발생
//2. 만약에 채팅방에 4번 회원과 5번회원이 존재할때
//frommno=4 이면서 tomno=5 이거나 frommno=5 이면서 tomno=4 이 구조를 원함
//-4번 회원이 보냈거나 받았으면 5번 회원이 받았거나 보냈으면

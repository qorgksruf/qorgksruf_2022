package Day20.gallery.Model.Dao;

import java.util.ArrayList;

import Day20.gallery.Model.Dto.BoardDto;
import Day20.gallery.Model.Dto.CategoryDto;


public class BoardDao extends Dao{
	//싱글톤
	private static BoardDao dao = new BoardDao();
	private BoardDao() { }
	public static BoardDao getInstance( ) {
		return dao;
	}
	//카레고리 추가 sql
	 public boolean categoryAdd(String cname) {
		String sql="insert into category(cname) values (?)";
				try {
					ps=con.prepareStatement(sql);
					ps.setString(1, cname);
					ps.executeUpdate();
					return true;
				}catch (Exception e) {
					return false;
				}
	 }
	
	//모든 카테고리호출 sql	[인수 x, 반환: 여러개[리스트/배열]의 카테고리 Dto반환 ]
		public ArrayList<CategoryDto>categoryprint(){
			ArrayList<CategoryDto>clist = new ArrayList<>();	//여러개 dto 담을 리스트 선언
			String sql="select * from category";
			try {
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();	//select sql실행후 결과를 rs 조작할 예정
				//여긴 로그인의 rs.next 부분은 한번만 필요함, 있다 없다면되니까 근데 얘는 모든거 갖고와야하니까 반복문
				while(rs.next()) {
					//레코드를 ->dto 시킴	//rs.get 타입(필드순서번호)
					CategoryDto dto = new CategoryDto(rs.getInt(1), rs.getString(2));
					clist.add(dto); //위 필드 1 , 2 값을 dto의 list에 담기
				}
				return clist;//여러개 담은 dto 반환
				
			}catch (Exception e) {
				return null;//오류
			}
			
		}
	//게시물등록
	public boolean boardAdd(String btitle, String bcontent, int mno , int cno) {
		String sql="insert into board(btitle, bcontent ,mno_fk,cno_fk)"
				 + "values(?,?,?,?); ";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.setInt(3, mno);
			ps.setInt(4, cno);
			ps.executeUpdate();		
			return true;
			
		}catch (Exception e) {
			return false;
		}
	}
		
	//최신 게시물 3개 출력
	public ArrayList<BoardDto> boardPrintRecent(){
		ArrayList<BoardDto> blist = new ArrayList<>();
		String sql = " select b.bno , b.btitle , b.bcontent , b.bdate , b.bview , m.mid , c.cname "
				+ " from board b , member m , category c "
				+ " where b.mno_fk = m.mno and b.cno_fk = c.cno "
				+ " order by b.bdate desc limit 3 ";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				BoardDto dto = new BoardDto( rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
				blist.add(dto);
			}
		}catch (Exception e) {System.out.println(e);}
		return blist;
	}
	
	//해당 카테고리의 모든 게시물 출력	
	public ArrayList<BoardDto> boardPrint( int cno ){
		ArrayList<BoardDto> blist = new ArrayList<>();
		String sql = " select b.bno , b.btitle , b.bcontent , b.bdate , b.bview , m.mid , c.cname "
				+ "	from board b , member m , category c "
				+ "	where b.mno_fk = m.mno and b.cno_fk = c.cno and b.cno_fk = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt( 1 , cno );
			rs = ps.executeQuery();
			while( rs.next() ) {
				BoardDto dto = new BoardDto( rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
				blist.add(dto);
			}
		}catch (Exception e) {System.out.println(e);}
		return blist;
	}	
		
		
		
}//class e


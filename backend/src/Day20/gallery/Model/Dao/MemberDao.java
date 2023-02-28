package Day20.gallery.Model.Dao;

import Day20.gallery.Model.Dto.MemberDto;

public class MemberDao extends Dao{
	//싱글톤
	private static MemberDao dao = new MemberDao();
	private MemberDao() { }
	public static MemberDao getInstance( ) {
		return dao;
	}
	
	//기능 메소드
	
	
	//아이디중복체크 [아이디 검색]
	public boolean idchexk(String mid) {
		//1. SQL 작성
		String sql= "select * from member where mid=?";
		//2.연결된 DB에 작성된 SQL 대입
		try {			//select 는 다수니까 query update는 insert같이 하나일때 
			//2.연결된 DB에 작성된 SQL 대입
			ps=con.prepareStatement(sql);
			
			//3. SQL 조작[매개변수 없으면 생략]
			ps.setString(1, mid );
			
			//4. SQL 실행
			rs= ps.executeQuery();
			
			//5. SQL 결과
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			return true;
		}
		
	}
	
	//회원가입 
	public int signup(MemberDto dto) {
		String sql="insert into member(mid,mpw,mname,mphone)"
				+ "values(?,?,?,?)"; 
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			ps.setString(3, dto.getMname());
			ps.setString(4, dto.getMphone());
			ps.executeUpdate();	//update 할때 rs 필요없음 
			return 1;
			
		}catch (Exception e) {}
		 return 3;
	}
	
	//로그인 [반환: 로그인 성공한 회원 번호를 반환시킬거임 ]
		// - 로그인 세선(로그인 되어있는 동안 저장되는 거): 1. 회원번호 2.logindto [회원번호,포인트,등급]
	public int login(String mid, String mpw) {
		String sql = "select * from member where mid = ? and mpw=?;";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpw);
			rs = ps.executeQuery();
			if(rs.next()) {
				//만약에 다음 레코드가 존재하면 [로그인성공]
				return rs.getInt(1);	//검색된 레코드에서 천번째 필드 [회원번호 반환]
			}else {
				//다음 레코드가 존재하지 않으면 [로그인실패]
				return 0;	
			}
			
		}catch (Exception e) {
			return 0;
		}
	}
	
	
}

package model.dao;

import java.sql.Statement;
import java.util.ArrayList;

import model.dto.MemberDto;
import model.dto.ReplyDto;

public class MemberDao extends Dao{
	//싱글톤
	private static MemberDao dao= new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() {
		return dao;
	}	
	
	public boolean singup(MemberDto dto) {
		String sql ="insert into member(mid,mpwd,memail,mimg)values(?,?,?,?)";
		try {
			ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpwd());
			ps.setString(3, dto.getMemail());
			ps.setString(4, dto.getMimg());
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();	//pk값을 rs로 받기
			if(rs.next()) {	//결과에서 첫번째 필드(pk- 방금 생성된 회원번호)
				int pk=rs.getInt(1);
				setPoint("회원가입축하", 100 , pk);
			}
				//포인트 지급[ 내용, 개수, 방금회원가입한 회원번호[pk] ]
				/*
				 * 1.insert 이후에 자동으로 생성된  auto key 찾기=>pk 호출
				 * 	con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS  )
				 * 2.생성된 PK 결과 담기
				 * 	rs=ps.getGeneratedKeys()
				 * 3. 검색된 레코드 결과에서 pk 호출
				 * rs.next() --> rs.getInt(1);
				 * */
			return true;
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	// 모든 회원출력 [관리자기준 인수x 반환: 모든회원들의 dto]
	public ArrayList<MemberDto> getMemberList(int startrow,int listsize,String key,String keyword, int mno){
		ArrayList<MemberDto>list = new ArrayList<>();	
			String sql= "select * from member";
				try {
					ps=con.prepareStatement(sql);
					rs=ps.executeQuery();		
					while(rs.next()) {
						MemberDto dto = new MemberDto(
								rs.getInt(1), 
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5));
						list.add(dto);
					}//while e
					
				}catch (Exception e) {
					System.out.println(e);
		} return list;
	}
	
	
	//아이디 중복검사
	public boolean idcheck(String mid) {
		String sql="select* from member where mid='"+mid+"'";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			//만약에 검색 결과 레코드가 존재하면 중복 아이디
			if(rs.next()) {
				return true;
			}
		}catch (Exception e) {
			System.out.println(e);
		//없으면 중복 아이디 아닙니다
		}return false;
	}
	
	//4.//아이디 비밀번호 검증 [로그인]
	public boolean login( String mid, String mpwd) {
		String sql="select*from member where mid=? and mpwd=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpwd);
			rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	// 5. 특정 회원1명 찾기 
	public MemberDto getMember(String mid) {
		String sql=" select m.mno,m.mid,m.mimg,m.memail,sum(p.mpamount) as mpoint "
				+ " from member m, mpoint p"
				+ " where m.mno=p.mno and m.mid=?";	// 근데 이렇게하면 조건이 틀려도 들어와버리니까
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mid);
			rs=ps.executeQuery();
			if(rs.next()) {	//비밀번호 제외한 레코드1개를 dto만들기
				
				MemberDto dto = new MemberDto(rs.getInt(1), rs.getString(2), null, rs.getString(3), rs.getString(4));
				dto.setMpoint(rs.getInt(5));
				return dto;		//레코드1개->회원1명->회원 dto 반환	
						
			}
		}catch (Exception e) {
			System.out.println(e);
		}return null;	//없다
	}
	// 6. 아이디찾기 
	public String findid( String memail ) {
		String sql = "select mid from member where memail = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , memail );
			rs = ps.executeQuery();
			if( rs.next() ) { return rs.getString( 1 ); } // 찾은 아이디 반환
		}catch (Exception e) {System.out.println(e);} 
		return "false"; // 없으면 false 
	}
	// 7. 비밀번호찾기 
	public String findpwd( String mid , String memail , String updatePwd ) {
		String sql = "select mno from member where mid = ? and memail = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , mid );
			ps.setString( 2 , memail);
			rs = ps.executeQuery();
			if( rs.next() ) {  // 만약에 동일한 아이디와 이메일 일치한 레코드가 있으면 [ 찾았다. ]
				sql = "update member set mpwd = ? where mno = ?";
				ps = con.prepareStatement(sql);
				ps.setString( 1 , updatePwd );		// 임시비밀번호로 업데이트
				ps.setInt( 2 ,  rs.getInt( 1 ) );	// select 에서 찾은 레코드의 회원번호 
				int result = ps.executeUpdate();	// 업데이트한 레코드 개수 반환
				if( result == 1 ) { // 업데이트한 레코드가 1개 이면 
					// -- 이메일전송 테스트 되는경우 만 -- //
					//new MemberDto().sendEmail( memail, updatePwd ); // 임시비밀번호를 이메일로 보내기 
					//return "true";
					// -- 이메일전송 테스트 안되는 경우 -- //
					return updatePwd;
				}
			}
		}catch (Exception e) {System.out.println(e);} 
		return "false";
	}	
	
	// 8.포인트 함수[1.지급내용 2.지급개수 3. 대상]
	public boolean setPoint(String content, int point, int mno) {
		String sql="insert into mpoint( mpcomment, mpamount , mno ) values(?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, point);
			ps.setInt(3, mno);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}//
	
	
	// 9. 회원탈퇴 [ 인수 : mid , mpwd  			반환 : 성공실패 ]
	public boolean delete( String mid , String mpwd ) {
		String sql = "delete from member where mid = ? and mpwd = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , mid );	ps.setString( 2 , mpwd );
			int count = ps.executeUpdate();	// 삭제된 레코드 수 반환	// executeUpdate() 조작된 sql 레코드 수 반환
			if( count == 1 ) { return true; }	// 레코드 1개 삭제 성공시 true 
			
		}catch (Exception e) {System.out.println(e);} return false;
	} // 
	
	
	
	
	//10. 회원수정[인수:mid, mpwd, memail 반환: 성공실패]
	public boolean update(String mid, String mpwd,String newpwd, String memail, String newmimg ) {
		String sql="update member set mpwd=?, memail=?, mimg=? where mid= ? and mpwd=?";	
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, newpwd);
			ps.setString(2, memail);
			ps.setString(3, newmimg);
			ps.setString(4, mid);
			ps.setString(5, mpwd);			
			int count = ps.executeUpdate();	// 수정된 레코드 수 반환
			if(count==1) {
				return true;
			}	// 레코드 1개 수정시 true
		}catch (Exception e) {
		System.out.println(e);
		}
		return false;
	}

	//회원 id -- > 회원 mno 반환****
	public int getMno (String mid) {
		String sql = "select mno from member where mid=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mid);
			rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	
	//2-2 게시물/레코드 수 구하기
	public int gettotalsize(String key,String keyword, int mno){
			String sql="";
		if(key.equals("")&&keyword.equals("")) {//검색이없다
			 sql=" select count(*) from member m natural join board b where b.mno= "+mno ;
		}else {//검색이있다
			sql = " select count(*) from member m natural join board b "
					+ " where "+key+" like '%"+keyword+"%' and b.mno="+mno ;
		}	
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
	
	
	public int user_count( String key , String keyword ) {
		
		String sql = "";
		
		if( key.equals("") && keyword.equals("")  ) { // count 구할때 만약에 검색이 없으면 아래쿼리로 실행
			
			sql = "select count(*) from member";
			
		}else { // 만약에 검색이 있으면 검색된 카운트를 구하는 쿼리문 실행
			
			sql = "select count(*) from member where " + key + " like '%" + keyword + "%' ";
			
		}
		
		try{
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if ( rs.next() ) { return rs.getInt(1); }
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	
	
	public ArrayList<MemberDto> infoPrint( int startrow , int listsize , String key , String keyword ){
		
		ArrayList<MemberDto> MemberList = new ArrayList<>();
		
		// 공통사용을 위해 변수 밖에 선언
		String sql = "";
		
		// 검색처리를 위한 제어문 
		if( key.equals("") && keyword.equals("") ) { // 만약에 key 값이 공백이고 keyword 값이 공백이면 
			
			// 조건 없는 그냥 select 실행
			sql = "select * from member limit ? , ?";
			
			
		}else { // key 와 keyword 값이 있으면 
			
			// 조건이 추가된 sql 실행
			sql = "select * from member where " + key + " like '%" + keyword + "%' limit ? , ?";
			
		}
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, startrow );
			ps.setInt(2, listsize);
			
			rs = ps.executeQuery();
			while( rs.next() ) {
				
				MemberDto dto = new MemberDto(
						rs.getInt(1), rs.getString(2) , rs.getString(3) ,
						rs.getString(4) , rs.getString(5) );
				MemberList.add(dto);
			}
		}catch (Exception e) { System.out.println(e); }
		
		return MemberList;
	}

	
	
	
}
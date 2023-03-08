package model.dao;

import java.util.ArrayList;

import model.dto.MemberDto;

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
			ps= con.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			ps.setString(3, dto.getMemail());
			ps.setString(4, dto.getMing());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	// 모든 회원출력 [관리자기준 인수x 반환: 모든회원들의 dto]
	public ArrayList<MemberDto> getMemberList(){
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
	
	
	
}
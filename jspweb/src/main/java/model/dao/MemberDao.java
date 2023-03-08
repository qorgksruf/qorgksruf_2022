package model.dao;

import model.dto.MemberDto;

public class MemberDao extends Dao{
	//싱글톤
	private static MemberDao dao= new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() {
		return dao;
	}	
	
	public boolean singup(MemberDto dto) {
		String sql ="insert into member(mid,mpwd,memail,mimg)value(?,?,?,?)";
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			ps.setString(3, dto.getMemail());
			ps.setString(4, dto.getMing());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
	
		}
		return false;
	}
	

	
}

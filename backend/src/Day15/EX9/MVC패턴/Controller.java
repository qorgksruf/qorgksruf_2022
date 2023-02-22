package Day15.EX9.MVC패턴;

import java.util.ArrayList;

public class Controller {

	//싱글톤
	private static Controller con = new Controller();
	private Controller() {}
	public static Controller getInstance() {
		return con;
	}
	
	
	public boolean signup(String mid, String mpw) {
		
		MemberDto dto = new MemberDto(0,mid,mpw);
		
		boolean result
			=MemberDao.getInstance().signup(dto);
		
		return result;
	}
	

	
	
	
	public ArrayList<MemberDto> list() {
		//모든 회원을 호출하는 dao 메소드 호출해서 결과 얻기 다오에서 ArrayList로 결과 내놨으니 여기도 이걸로 받고 view도 그걸로 받는거임
		ArrayList<MemberDto>result=
		MemberDao.getInstance().list();
		
		return result;
	}
	
	
	public boolean update(int mno, String mpw) {
		return MemberDao.getInstance().update(mno,mpw);
	}

	//회원삭제
	public boolean delete(int mno) {
		return MemberDao.getInstance().delete(mno);
	}

	
	
	
}

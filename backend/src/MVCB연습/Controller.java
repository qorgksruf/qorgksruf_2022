package MVCB연습;

public class Controller {
	//싱글턴
	 private static Controller con = new Controller();
	 public Controller() {
	}
	public static Controller getInstance() {
		return con;
	}
	 
	
	public boolean signup(String mid, String mpw) {
		Memberdto dto = new Memberdto(0,mid,mpw);
		
//		dto.setMid(mid);
//		dto.setMpw(mpw);
		
		boolean result=
				MemberDao.getInstance().signup(dto);
		
		return result;
	}
	
}//class e

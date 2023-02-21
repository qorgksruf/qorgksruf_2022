package Day15.EX9.MVC패턴;

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
	

	
	
	
	public void list() {
		
	}
	
	
}

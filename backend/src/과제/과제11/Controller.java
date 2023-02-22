package 과제.과제11;

import java.util.ArrayList;

public class Controller {
	private static Controller con = new Controller();
	private Controller() {}
	public static Controller getInstance() {
		return con;
	}
	
	
	public boolean signup(String mid, int mprice, String msava) {
		
		BoardDto dto  = new BoardDto(mid, mprice,msava );
		
		boolean result
			=BoardDao.getInstance().signup(dto);
		
		return result;
	}
	
	//제품 출력함수
	public ArrayList<BoardDto>print(){
		
		ArrayList<BoardDto>result=
				BoardDao.getInstance().print();
		
		return result;
	}
	
}

package Day20.gallery.Controller;

import java.util.ArrayList;

import Day20.gallery.Model.Dao.BoardDao;
import Day20.gallery.Model.Dto.BoardDto;
import Day20.gallery.Model.Dto.CategoryDto;


public class Bcontroller {
	//싱글톤
	private static Bcontroller bcontroller = new Bcontroller();
	private Bcontroller() { }
	public static Bcontroller getInstance( ) {
		return bcontroller;
	}
	
	// 1. 카테고리 추가 처리 
	public boolean categoryAdd( String cname ) {
		return BoardDao.getInstance().categoryAdd(cname);
	}
	
	// 2. 모든 카테고리 호출 처리 
	public ArrayList< CategoryDto > categoryPrint(){
		return BoardDao.getInstance().categoryprint();
	}
	
	// 3. 
	public boolean boardAdd( String btitle , String bcontent , int cno ) {
		return BoardDao.getInstance().boardAdd(btitle, bcontent, MController.getInstance().getLogSession(), cno);
	}
	
	// 4. 
	public ArrayList<BoardDto> boardPrintRecent(){
		return BoardDao.getInstance().boardPrintRecent();
	}
	
	// 5. 
	public ArrayList<BoardDto> boardPrint( int cno ){ 
		return BoardDao.getInstance().boardPrint(cno);
	}
}

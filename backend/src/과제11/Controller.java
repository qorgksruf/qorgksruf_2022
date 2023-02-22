package 과제11;

import java.util.ArrayList;

public class Controller {
	
	//싱글톤 여기에 유효성검사해도됨 
	private static Controller con = new Controller();
	private Controller() {}
	public static Controller getInstance() {
			return con;
	}
	 //제품등록
	public boolean regist(String pname, int pprice, int pstock) {
		ProductDto dto = new ProductDto(0, pname, pprice, pstock);
		//db요청
		boolean result
				=ProductDao.getInstance().regist(dto);
		return result;
	}

	public ArrayList<ProductDto>getProductAll(){
		return ProductDao.getInstance().getProductAll();
	}
	
	// 사용자용 전체 메뉴 조회
	public ArrayList<ProductDto>getProductAll_Customer(){
		return ProductDao.getInstance().getProductAll_Customer();
	}
	

	
	//제품이름 가격 수정삭제
	public int update(int pno,String pname, int pprice) {
		return ProductDao.getInstance().update(pno,pname, pprice);
	}
	
	
	//제품삭제
	public boolean delete(int pno) {
		return ProductDao.getInstance().delete(pno);
	}
	
	public boolean saveupdate(int pno, int pstock) {
		return ProductDao.getInstance().saveupdate(pno, pstock);
	}
	
	


}

package Day20.gallery.Controller;

import Day20.gallery.Model.Dao.MemberDao;
import Day20.gallery.Model.Dto.MemberDto;

public class MController {
	private static MController mcontroller = new MController();
	private MController() { }
	public static MController getInstance( ) {
		return mcontroller;
	}
	//로그인세션
	private int logSession= 0;//로그인함 이보다 크면 로그인 안함 즉 여기에 회원번호 담기
	public void setLogSession(int logSession) {
		this.logSession = logSession;
	}
	//getter 만듬
	public int getLogSession() {
		return logSession;
	}	
	
	
	//회원가입 처리
	public int signup(String mid, 
					  String mpw,
					  String mname,
					  String mphone) {
		//아이디중복체크
		if(MemberDao.getInstance().idchexk(mid) ){
			return 2;
		}	
		//객체화
		MemberDto dto = 
				new MemberDto(0, mid, mpw, mname, mphone);
	
		//회원가입 DB처리 후 DB처리 결과를 반환
		return MemberDao.getInstance().signup(dto);
	
	}




	//로그인 처리
	public boolean login(String mid, String mpw) {
		//유효성검사
		
		//2.
		int result =
				MemberDao.getInstance().login(mid, mpw);
		
		//3. 로그인 성공 증거 [로그인 정보 저장소 = 세션]
		if(result==0) {
			return false;
		}else {
			logSession=result; //반환된 회원 번호를 세션에 저장
			return true;
		}
	}

}

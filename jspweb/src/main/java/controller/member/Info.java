package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.MemberDto;
import model.dto.infoDto;
import model.dto.pageDto;

/**
 * Servlet implementation class Info
 */
@WebServlet("/member")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Info() {
        super();
        
    }
	//회원가입
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//첨부파일있을떄
		//MultipartRequest
		//현재 서버의 배포된 프로잭트내 폴도 경로 찾기
		String uploadpath = request.getSession().getServletContext().getRealPath("/member/pimg");
		System.out.println(uploadpath);
		
		//업로드
		MultipartRequest multi = new MultipartRequest(
				request, 						//1.요청방식
				uploadpath, 					//2.첨부파일 가져와서 저장할 서버내 폴더
				1024*1024*10 ,					//3.첨부파일 허용 범위 용량 [바이트단위]//얘는 10메가임
				"UTF-8",						//4.첨부파일 한글 인코딩 
				new DefaultFileRenamePolicy()	//5.동일한 첨부파일명이 존재하면 뒤에 숫자 붙여짐 그래서 판별함
				);
		//그외 매개변수 요청 [request->multi / form하위테그 name 식별자 사용하기]
		String mid = multi.getParameter("mid");	//호출할 input의 name
		String mpwd = multi.getParameter("mpwd");
		String memail = multi.getParameter("memail");
		String mimg =multi.getFilesystemName("mimg");	//얘만다름~!!!
		
		MemberDto dto = new MemberDto(0, mid, mpwd, mimg, memail);
			System.out.println("dto:"+dto);
		boolean result = MemberDao.getInstance().singup(dto);
		response.getWriter().print(result);
			
		
		
		/*첨부파일 없을때
		 * request.setCharacterEncoding("UTF-8"); String mid =
		 * request.getParameter("mid"); String mpwd = request.getParameter("mpwd");
		 * String memail = request.getParameter("memail"); String mimg =
		 * request.getParameter("mimg");
		 * 
		 * //Dto 만들기 MemberDto dto =new MemberDto(0, mid, mpwd, mimg, memail);
		 * System.out.println("dto:"+dto); //Dao 호출하고 결과 받기 boolean result =
		 * MemberDao.getInstance().singup(dto);
		 * 
		 * response.getWriter().print(result);
		 */
	}
    //로그인	/ 회원1명/ 회원여러명 정보 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		String key = request.getParameter("key");
		String keyword = request.getParameter("keyword");
	
		
		int page = Integer.parseInt( request.getParameter("page") );			// 호출한 페이지 전달받기
		int listsize = Integer.parseInt( request.getParameter("listsize") );	// 리스트에 출력할 레코드 수 사이즈 받기 
		int startrow = (page-1)*listsize;										// 시작 레코드 번호
		
		// 1. 토탈사이즈 
		int totalsize = MemberDao.getInstance().user_count( key , keyword );	// DAO 에게 total count 수 요청 
		int totalpage = totalsize % listsize == 0 ? totalsize/listsize : totalsize/listsize+1 ; // 총 유저수에따른 페이지수 구하기
		
		int btnsize = 5; // 표시할 버튼의 갯수 지정
		int startbtn = ( (page-1) / btnsize ) * btnsize + 1 ; // 시작 버튼 번호구하기 
		
		int endbtn = startbtn + (btnsize-1); // 끝 버튼번호 구하기 
		
		if( endbtn > totalpage ) { // 끝 버튼이 총 페이지수를 넘어갈 수 없게 처리
			endbtn = totalpage;
		}
		
		
		// Dao 호출하여 MemberDto 구성 
		ArrayList<MemberDto> MemberList = MemberDao.getInstance().infoPrint( startrow , listsize , key , keyword );
		
		// 페이지 , 리스트사이즈 , 버튼 정보 , MemberDto 등 다양한 자료형을 한번에 담기위한 UserListDto 구성 
		infoDto dto = new infoDto(page, listsize, startrow, totalsize, totalpage, btnsize, startbtn, endbtn, MemberList);
		
		// 형변환
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString( dto );
		
		// 리턴
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print( json );
				
		}
			

	

	//회원수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 첨부파일있을때 업로드 코드구현
				//업로드 한 파일을 해당 서버 경로로 업로드
		String path=request.getSession().getServletContext().getRealPath("/member/pimg");
				//객체 
		MultipartRequest multi = new MultipartRequest(
				request, 						//1.요청방식
				path, 					//2.첨부파일 가져와서 저장할 서버내 폴더
				1024*1024*10 ,					//3.첨부파일 허용 범위 용량 [바이트단위]//얘는 10메가임
				"UTF-8",						//4.첨부파일 한글 인코딩 
				new DefaultFileRenamePolicy()	//5.동일한 첨부파일명이 존재하면 뒤에 숫자 붙여짐 그래서 판별함
				);
		
		String mid= (String)request.getSession().getAttribute("login");
		System.out.println(mid);
		String mpwd=multi.getParameter("mpwd");
		String newmpwd=multi.getParameter("newmpwd");
		String memail=multi.getParameter("memail");
		String newmimg=multi.getFilesystemName("newmimg");
		String defaultimg = multi.getParameter("defaultimg");
		//만약에 새로운 첨부파일이 없으면 
		if(newmimg==null) {
			//기존 이미지 파일 그대로 사용
			newmimg = MemberDao.getInstance().getMember(mid).getMimg();
		}
		//만약에 기본프로필 사용체크 했으면
		if (defaultimg.equals("true") ) {//기본프로필사용
			newmimg=null;
		}
		
		boolean result= MemberDao.getInstance().update(mid, mpwd, newmpwd, memail, newmimg);
		response.getWriter().print(result);
		/* 첨부파일없을떄
		 * //1.로그인된 회원 수정 String mid=
		 * (String)request.getSession().getAttribute("login");
		 * System.out.println("mid"+mid); String mpwd = request.getParameter("mpwd");
		 * System.out.println("mpwd"+mpwd); String newpwd =
		 * request.getParameter("newpwd"); System.out.println("newpwd"+newpwd); String
		 * memail = request.getParameter("memail"); System.out.println("memail"+memail);
		 * //2. boolean result = MemberDao.getInstance().update(mid, mpwd, newpwd
		 * ,memail ); //3. response.getWriter().print(result);
		 */
	}

	// 4. 회원탈퇴
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 로그인된 회원탈퇴
			// 1. 로그인된 회원아이디 가져오기 [ 세션(object) ]
		String mid =(String)request.getSession().getAttribute("login");		System.out.println( "mid:"+mid );
		String mpwd = request.getParameter("mpwd");
			// 2. Dao에게 요청후 결과 받기 
		boolean result = MemberDao.getInstance().delete(mid , mpwd);				System.out.println( "result : " + request );
			// 3. 결과 ajax에게 보내기 
		response.getWriter().print(result);
	}

}

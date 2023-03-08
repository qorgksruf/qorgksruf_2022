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

import model.dao.MemberDao;
import model.dto.MemberDto;

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
		
		ArrayList<MemberDto>result = MemberDao.getInstance().getMemberList();
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(result);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);

	}

	//회원수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

	//회원탈퇴
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}

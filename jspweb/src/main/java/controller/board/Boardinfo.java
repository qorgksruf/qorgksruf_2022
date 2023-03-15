package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.BoardDto;
import practice.day03.BoardDao;

/**
 * Servlet implementation class Boardinfo
 */
@WebServlet("/board/info")	// 프로젝트내 동일한 서블릿주소 있을경우 서버자체 안켜짐
public class Boardinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Boardinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//업로드할 파일의 저장위치 [경로]
				
			//경로찾기
		String path = request.getSession().getServletContext().getRealPath("/board/bfile");
			System.out.println("path"+path);
			// 파일복사 [대용량 바이트 복사하기 ]
		MultipartRequest multi= new MultipartRequest(
				request,
				path,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		
		System.out.println("Boardinfo쪽 multi"+multi);
		// 여기까지만 입력하고 확인해보기
			//multi.getParameter("객체명의 필드명")
		int cno =Integer.parseInt(  multi.getParameter("cno") );
			System.out.println("cno"+cno);
		String btitle = multi.getParameter("btitle");
			System.out.println("btitle"+btitle);
		String bcontent = multi.getParameter("bcontent");
			System.out.println("bcontent"+bcontent);
		String bfile = multi.getFilesystemName("bfile");
			System.out.println("bfile"+bfile);
					//getFilesystemName : input 실제 파일이름만 갖구오는 것임 얘랑 위 MultiPath 랑 세트임
		//--------------확인한번하기--------------------	
			//1. 회원제게시판 [로그인된 회원의 mno 필요!]
			String mid =(String)request.getSession().getAttribute("login");
			int mno = MemberDao.getInstance().getMno(mid);
				//만약에 회원번호가 존재하지 않으면 글쓰기 불가능
			if(mno > 0) {
				response.getWriter().print("false");	//로그인 안한사람 글쓰기 못하게 막기
			}
		// Dto 
			BoardDto dto = new BoardDto(btitle, bcontent, bfile, mno, cno);
				System.out.println("dto:"+dto);
		// Dao
			boolean result = model.dao.BoardDao.getInstance().bwrite(dto);
		// 응답	
			response.getWriter().print(result);
			
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}

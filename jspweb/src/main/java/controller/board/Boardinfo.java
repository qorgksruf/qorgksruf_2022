package controller.board;

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
import model.dto.BoardDto;
import model.dto.pageDto;


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

	 int type =Integer.parseInt(request.getParameter("type") );
		if( type==1 ) {	//전체출력
			
			//---------------page처리하기-------------------//
			// 1.현재페이지[요청], 2.페이지당 표시할 게시물수 약 세개로만 해보자  3.전체페이지[게시물시작, 게시물끝]	
			int page = Integer.parseInt(request.getParameter("page"));	//현재페이지 알기위한작업
			int listsize = 3;
			int startrow=(page-1)*listsize; // 해당 페이지에서의 게시물 시작번호  1페이지의 시작번호는 0이되는거임
			//--------page 버튼 만들기----------------------//
			//1.전체페이지수[총게시물레코드수/페이지당 표시수 ]  2.페이지 표시할 최대버튼 수 3.시작버튼 번호 
				//게시물 수 구하기
			int totalsize=BoardDao.getInstance().gettotalsize();
			int totalpage=totalsize % listsize ==0 ?
					totalsize/listsize : totalsize/listsize+1;
			
			ArrayList<BoardDto>result = BoardDao.getInstance().getBoardList(startrow,listsize);		
			pageDto pageDto =
					new pageDto(page, listsize, startrow, totalsize, totalpage, result);
			
			
			/*
					 * 총 레코드수=10	총 레코드의 인덱스: 0~9
					 * 총 게시물수=10 , 페이지당 표시할 게시물수=3
					 * 1.총 페이지수 = 012,345,678,9	--> 4
					 * 		
					 * 		총 레코드수/페이지당표시게시물수
					 * 			1. 나머지가 없으면 => 몫만 사용	10/3	->3.33
					 * 			2. 남머지가 있으면 => 몫+1		10/3	->4페이지
					 * 
					 *  
					 * 2.페이지별 게시물시작 번호 찾기
					 * 		1페이지요청-> (1-1)*3 =>0
					 * 		2페이지요청=> 3
					 * 		3페이지요청=> 6
					 * */

			ObjectMapper mapper = new ObjectMapper();
			String jsonArry= mapper.writeValueAsString(pageDto);
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(jsonArry);	
			
		}else if( type==2 ) {
			int bno =Integer.parseInt(request.getParameter("bno"));
			System.out.println("bno"+bno);
			
			BoardDto result = BoardDao.getInstance().getBoard(bno);
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonArry= mapper.writeValueAsString(result);
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(jsonArry);			
		}
		
		

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
			if(mno < 1) {
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

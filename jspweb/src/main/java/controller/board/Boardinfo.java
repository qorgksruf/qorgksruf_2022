package controller.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.print.DocFlavor.STRING;
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
			//------------카테고리 별 출력--------------------//
			//1.카테고리 매개변수 요청 
			int cno =Integer.parseInt(request.getParameter("cno") );
			
			
			//------------검색처리---------------------------//
			//검색에 필요한 매겨변수요청 [key,keyword ] 
			String key=request.getParameter("key");
				System.out.println(key);
			String keyword=request.getParameter("keyword");
				System.out.println(keyword);
			
			
			//---------------page처리하기-------------------//
			// 1.현재페이지[요청], 2.페이지당 표시할 게시물수 약 세개로만 해보자  3.전체페이지[게시물시작, 게시물끝]	
			int page = Integer.parseInt(request.getParameter("page"));	//현재페이지 알기위한작업
			int listsize = Integer.parseInt(request.getParameter("listsize"));	//화면에 표시할 게시물 수 요청
			int startrow=(page-1)*listsize; // 해당 페이지에서의 게시물 시작번호  1페이지의 시작번호는 0이되는거임
			//--------page 버튼 만들기----------------------//
			//1.전체페이지수[총게시물레코드수/페이지당 표시수 ]  2.페이지 표시할 최대버튼 수 3.시작버튼/마지막버튼 번호 
				//게시물 수 구하기
				//검색잉 없을때
			//int totalsize=BoardDao.getInstance().gettotalsize();
			int totalsize=BoardDao.getInstance().gettotalsize(key,keyword,cno);
			int totalpage=totalsize % listsize ==0 ?
					totalsize/listsize : totalsize/listsize+1;
			
			int btnsize =5;//최대 페이징버튼 출력수
			int startbtn = ((page-1)/btnsize)* btnsize+1;
			/* 
			 * 
			 * 	btnsize=5 이면 페이지별 시작번호패턴은 1 6 11 16 21
			 *  btnsize=3이면 시작번호패턴은 1 4 8
			 * 
			 * 			1페이지	: 1-1 / 5	*5+1		->0+1	1
			 * 			2페이지	: 2-1/ 5	*5+1		->0+1	1
			 * 			3페이지	: 3-1/ 5	*5+1		->0+1	1
			 * 			4페이지	: 4-1/ 5	*5+1		->0+1	1
			 * 			5페이지	: 5-1/ 5	*5+1		->0+1	1
			 * 			6페이지	: 6-1/ 5	*5+1		->1+1	6
			 * 			7페이지	: 7-1/ 5	*5+1		->1+1	6
			 * 
			 * */
			
			int endbtn =startbtn +(btnsize-1);	
			//*단 마지막버튼수가 총 페이지수보다 커지면 마지막버튼수는 총페이지로 대입
			if( endbtn>totalpage) endbtn=totalpage;
			
			
			ArrayList<BoardDto>result = BoardDao.getInstance().getBoardList(startrow,listsize,key,keyword,cno);		
			pageDto pageDto =
					new pageDto(page, listsize, startrow, totalsize, totalpage, btnsize, startbtn, endbtn, result);
			
			
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
					 * 3.시작버튼, 마지막버튼 수
					 * 	7페이지 
					 * 	1페이지-> 12345
					 * 	2페이지-> 12345
					 *  3페이지-> 12345
					 *  4페이지-> 12345
					 *  5페이지-> 67
					 *  6페이지-> 67
					 *  
					 *  
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
			
		//업로드만 담당
		String path = request.getSession().getServletContext().getRealPath("/board/bfile");
					System.out.println("보드인포의 path"+path);

			MultipartRequest multi= new MultipartRequest(
					request,
					path,
					1024*1024*10,
					"UTF-8",
					new DefaultFileRenamePolicy()
					);
			//정보
			int bno =Integer.parseInt(multi.getParameter("bno") );
			int cno =Integer.parseInt(multi.getParameter("cno") );
			String btitle = multi.getParameter("btitle");
			String bcnontent = multi.getParameter("bcontent");
			String bfile=multi.getFilesystemName("bfile");
			//기존에 첨부파일이 없었다	-> 새로운첨부파일없다 [x]
							//	->새로운첨부파일있다 [업로드,  새로운파일로 업데이트]
			
			//기존에 첨부파일이 있었다-->새로운첨부파일없다	[기존파일로 업데이트처리 (그대로사용)]
							//	-> 새로운첨부파일있다 [업로드,  새로운파일로 업데이트 처리, 기존파일삭제]
			String oldfile = BoardDao.getInstance().getBoard(bno).getBfile();
			
			if(bfile==null) {//새로운 첨부파일이 없다
				bfile=oldfile;	//기존첨부파일명을대입한다
				
			}else {//새로운 첨부파일이 있다
				//1.수정전 기존 첨부파일명 가져오기 
				//삭제할 첨부파일 경로 찾기
				String filepath=request.getSession().getServletContext().getRealPath("/board/bfile/"+oldfile);
				//파일삭제처리
				File file = new File(filepath);
				
				if(file.exists()) {
					file.delete();
				}
			}
			
			
			
			//dto
			BoardDto updatedto = new BoardDto(bno, btitle, bcnontent, bfile, cno);
				System.out.println("updatedto"+updatedto);
				
				 boolean result = BoardDao.getInstance().bupdate(updatedto); //응답
				 
				 response.getWriter().print(result);
				 
			
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int type = Integer.parseInt( request.getParameter("type"));
		int bno = Integer.parseInt( request.getParameter("bno"));
		
		//공통코드
		String bfile =BoardDao.getInstance().getBoard(bno).getBfile();
		boolean result=true;
		if(type==1) {//db삭제+파일삭제
			//db삭제처리
			result= BoardDao.getInstance().bdelete(bno);
		}else if(type==2) {//db업데이트+파일삭제
			result = BoardDao.getInstance().bfiledelete(bno);
		}
		
		
			if(result) {//파일삭제만
				String path=request.getSession().getServletContext().getRealPath("/board/bfile/"+bfile);
				File file = new File(path);//객체화
				if( file.exists() ){//만약에 파일이 존재하면
					file.delete();	//파일삭제		
				}

			}
			response.getWriter().print(result);
	}

}

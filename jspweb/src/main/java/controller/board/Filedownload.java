package controller.board;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Filedownload
 */
@WebServlet("/filedownload")
public class Filedownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Filedownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String bfile = request.getParameter("bfile");
			System.out.println(bfile);
		//2.파일 다운로드
			//1.다운로드할 파일의 경로 찾기
		/*
		 * String path =
		 * request.getSession().getServletContext().getRealPath("/board/bfile");
		 * System.out.println("path"+path);
		 */
			//2.다운로드할 폴더[폴도/파일명]의 파일 경로 찾기
		String path = request.getSession().getServletContext().getRealPath("/board/bfile/"+bfile);
			System.out.println("path"+path);
			//3. 파일 클래스[해당 경로의 파일을 파일 객체화]
		File file = new File(path);	//해당 경로의 파일을 객체화	
		
			//3.HTTP 다운로드형식 [프론트앤드]= 각 브라우저(크롬,엣지등) 제공 
			response.setHeader(
					"Content-Disposition",	//각 브라우저마다 다운로드형식 http 옵션에 포함해서 보내기
					"attachment;filename="+URLEncoder.encode(bfile,"UTF-8")
					//다운로드시 파일명이 표시되는 옵션[ 한글파일 인코딩 ]
					//URLEncoder.encode(파일명,"UTF-8" URL(통신주소)의 한글인코딩
					);
		
			//4.파일 스트림[바이트단위] 	*예외발생함
				//1.파일 객체의 바이트를 모두 읽어온다.
					//1.해당 경로[파일] 스트림객체 만들기		
		FileInputStream fin = new FileInputStream(file);
				//2.스트림객체에서 꺼내올 바이트들을 저장할 배열 준비[선언]
				//바이트배열 길이=파일의 길이=바이트개수
		byte[] bytes = new byte[(int)file.length() ];
				//3.파일입력스트림객체에서 read( ): 해당 파일을 바이트로 읽어오는 함수
		fin.read(bytes);
				//2.읽어온 바이트를 모두 출력한다 [클라이언트에게 응답 response ]
					//response 응답객체에서 출력스트림 호출해서 파일출력스트림객체 만들기
					//response.getOutputStream(): HTTP 스트림 단위[바이트] 전송
		BufferedOutputStream fout = new BufferedOutputStream( response.getOutputStream() );
					//2.파일입력스트림객체에서 읽어온 바이트들[바이트배열]
					//파일출력스트림객체 write() : 해당 배열내 바이트를 출력하는 함수
		fout.write(bytes);	//해당 파일객체의 바이트를 내보내기 함수
		//3.스트림 닫기[CG대신 직접 스트림 닫기]
		fin.close();	//파일입력스트림객체 닫기
		fout.flush();	//스트림 메모리 초기화
		fout.close();	//파일출력스트림객체 스트림 닫기 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

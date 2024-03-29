package controller.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Api1
 */
@WebServlet("/api2")
public class Api2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Api2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.공공데이터 포털에서 신청한 데이터 가져오기 [ 안산시 전기차 충전소 현황]
			//URL 클래스
				//1. .openStrem(): 해당 객체의 연결된 url 스트림 제공 함수 [반환 Inputstream]
		//URL url = new URL("URL주소")
		URL url = new URL("https://api.odcloud.kr/api/3071314/v1/uddi:e4e7774d-0b16-4299-b830-dee5045df70f_201909291441?page=1&perPage=135&serviceKey=LByHaZAPV%2B358qol0urRIjwiPtuFl%2BRzRrzTXQzCUhCm1bU0Eq7onkTRngIvK640oMHYOLPY6dRpVhdJbjIG3A%3D%3D");
		
		//해당 URL의 데이터[스트림(바이트)]읽어오기 위한 스트림 객체 생성  InputStreamReader 얘는 인코딩 지원해줌
		//InputStream inputStream = url.openStream();
		//InputStreamReader reader = new InputStreamReader(url.openStream(),"UTF-8") ;
		BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
			//
			//byte[]array1= new byte [100000];
			//char[]array2 = new char[100000];
		
		//스트림으로 바이트 읽어오기
		//inputStream.read(array1);	//바이트 배열로 읽어오기
		//reader.read(array2);	//문자 배열로 읽어오기
		String result = bf.readLine();

		System.out.println(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package practice.day03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex03
 */
@WebServlet("/Ex03")	//<--해당 클래스 [자원] url 정의	localhost:8080/jspweb(프로젝트명)/Ex3
public class Ex03 extends HttpServlet {	//<--HttpServlet 클래스에게 상속
	private static final long serialVersionUID = 1L;
    public Ex03() {
        super();
    }

    //get 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 메소드에서 통신받았습니다");
	}
	//post 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post 메소드에서 통신받았습니다");
	}

	//put 메소드
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("put 메소드에서 통신받았습니다");
	}

	//deltet메소드
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("delete 메소드에서 통신받았습니다");
	}

}

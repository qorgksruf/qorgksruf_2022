package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dto.MemberDto;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 세션에 담겨진 회원아이디 호출
		String mid = 
			(String)request.getSession().getAttribute("login");
		
		//로그인한 회원의 정보 호출
		MemberDto result= MemberDao.getInstance().getMember(mid);
			System.out.println("result:"+request);
		//java 객체 --> js객체 변환
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(result);
			System.out.println("json;;"+json);
		
		//응답
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//Ajax에게 데이터 요청		
	String mid = request.getParameter("mid");
	String mpwd = request.getParameter("mpwd");	
		
	//Dao 호출에서 요청데이터를 보내서 결과 얻기
	boolean result = MemberDao.getInstance().login(mid,mpwd);
	
	if(result) {//만약에 로그인성공했으면
		//로그인세션 만들기
			//request.getSession()
			//setAttribute("key", value);	//서버[톰캣] 내 세션객체에 속성[데이터]추가
		request.getSession().setAttribute("login", mid);	//세션에 login이라는 이름으로 로그인 성공한 데이터 저장
	}

	//Dao에게 받은 결과를 Ajax 전달
	response.getWriter().print(result);
	
	}

}

package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDao;

/**
 * Servlet implementation class view
 */
@WebServlet("/board/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//타입과 게시물번호 요청
		int type=Integer.parseInt(  request.getParameter("type"));
		int bno=Integer.parseInt(  request.getParameter("bno"));
	
		/*
		 * -	하루에 한번씩 조회수 또는 좋아요수 또는 싫어요수 증가 가능 
		 * -	회원별 vs pc마다 
		 * - 	세션 사용
		 * 	1. pc 네트워크 식별자 [ ip ] 	
		 * 		//java에서 현재 요청한 클라이언트의  ip확인

		 * */
			// pc 네트워크 식별자 [ ip ] 	
			//1.java에서 현재 요청한 클라이언트의  ip확인
		String ip=request.getRemoteAddr();
			System.out.println("ip"+ip);
			
		//4.만약에 기존 세션이 없으면 증가 있으면 증가불가
			Object o= request.getSession().getAttribute(type+ip+bno);
			if( o==null) {//세션[bno+type+ip ]이 생성된 적이 없다
				
				//2.세션 생성 [bno + type + ip ]
				request.getSession().setAttribute(type+ip+bno, 1);
				//3.세션 생명주기[생명주기 지나면 자동으로 메모리 삭제 / 초 단위]
						//세션이 초기화되는기준
							//1.서버끄면 2.서버키면 3.setMaxInactiveInterval 설정이 지났을때
				request.getSession().setMaxInactiveInterval(60*60*24);//하루	
				//Dao처리	
				BoardDao.getInstance().bIncrease(type,bno);
			}// if e
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

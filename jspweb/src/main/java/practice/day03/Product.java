package practice.day03;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Product
 */
@WebServlet("/Product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Product() {

    }

    //get 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		ArrayList<ProductDto> result = ProductDao.getInstance().prolist();
			System.out.println("prolist:"+result);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString( result );
			System.out.println("jsonArray"+ jsonArray);
			
		//응답	
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}

	//post 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String pname = request.getParameter("pname");
			System.out.println("pname:"+pname);
		int pprice =Integer.parseInt(request.getParameter("pprice"));
			System.out.println("pprice:"+pprice);
		
		ProductDto productDto = new ProductDto(pprice, pname, 0);
			System.out.println("dto:"+productDto);
			
		boolean result = ProductDao.getInstance().onregi(productDto);
			System.out.println("productDto result"+result);
		
			response.getWriter().print(result);
			
	}

	//put메소드
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		System.out.println("수정할 번호"+pno);
		
		String newPname = request.getParameter("newPname");
			System.out.println("수정할 제품명"+newPname);
		int newPrice = Integer.parseInt(request.getParameter("newPrice"));
		
			System.out.println("수정할 제품가격"+newPrice);
			
			
		boolean result = ProductDao.getInstance().proupdate(pno, newPname, newPrice);
		
		response.getWriter().print(result);
			
	}

	//delete메소드
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		System.out.println("삭제요청번호"+pno);
		
		boolean result = ProductDao.getInstance().pdelete(pno);
		response.getWriter().print(result);
		
		
	}

}

package product.controller;

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

import model.dao.ProductDao;
import model.dto.ProductDto;

/**
 * Servlet implementation class info
 */
@WebServlet("/product/info")
public class productinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String 동=request.getParameter("동");
		String 서=request.getParameter("서");
		String 남=request.getParameter("남");
		String 북=request.getParameter("북");
			
		ArrayList<ProductDto>result = ProductDao.getInstance().getproductList(동,서,남,북); 
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray =  mapper.writeValueAsString( result );
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print( jsonArray );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getSession().getServletContext().getRealPath("/product/pimg");
		System.out.println("============");
			System.out.println(path);
		MultipartRequest multi = new MultipartRequest(
				request, 
				path,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		String pname=multi.getParameter("pname");	
			System.out.println(pname);
		String pcomment=multi.getParameter("pcomment");	
			System.out.println(pcomment);
		int pprice=Integer.parseInt( multi.getParameter("pprice"));
			System.out.println(pprice);
		String plat=multi.getParameter("plat");
			System.out.println(plat);
		String plng=multi.getParameter("plng");	
			System.out.println(plng);
		
		ProductDto dto = new ProductDto(pname, pcomment, pprice, plat, plng);
			
		boolean result = ProductDao.getInstance().onwrite(dto);
		
		response.getWriter().print(result);
		
	}

}

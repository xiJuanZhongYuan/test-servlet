package study;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InputStream is = request.getInputStream();
		String reqStr = "";
		try {
			if(is == null){
				reqStr = null;
			}
			String strResult="";    
			byte[] b = new byte[1024];    
			int i = 0;    
			while ((i = is.read(b)) != -1) {    
			    strResult+=new String(b, "UTF-8");    
			    b = new byte[1024];    
			}  
			reqStr = strResult;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if(null != is){
				is.close();
			}
		}
		reqStr = URLDecoder.decode(reqStr, "UTF-8");
		String contentType = "text/plain; charset=UTF-8";
        response.setContentType(contentType); 
        PrintWriter out = response.getWriter();
        out.print("Ω¯»Îservlet¡À" + reqStr);
        out.flush();
        out.close();
	}

}

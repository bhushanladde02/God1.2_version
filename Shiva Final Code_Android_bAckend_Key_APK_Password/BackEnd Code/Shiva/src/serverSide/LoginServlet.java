package serverSide;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Collections;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//http://localhost:8080/Shiva/LoginServlet?username=8055925868&password=test
		//doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Post");
	    String result=null; 
		try{
		// TODO Auto-generated method stub
		String username=request.getParameter("username");

		String password=request.getParameter("password");
		
		if(username!=null && !username.equalsIgnoreCase("") && password!=null && !password.equalsIgnoreCase("")){
		
			   ResultSet rs=SqlCrudOperation.selectQueryLogin("Select * from registeruser where phone=? and password=?",username,password);
			   while(rs.next())
			   {
				   result=rs.getString("id");
			   }
	
		}
		
		if(result==null)
		{
			result="empty";
		}
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter pw=response.getWriter();
		
		pw.write(result);
		
		}catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		
	}

}

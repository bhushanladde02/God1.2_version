package serverSide;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ShivaPersist
 */
public class AddNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNews() {
        super();
        
        // TODO Auto-generated constructor stub
    }
@Override
public void init() throws ServletException {
	// TODO Auto-generated method stub
	super.init();

	
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("In get");
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Post");
		int result=0;
		
		try{
		// TODO Auto-generated method stub
		String headerValue=request.getParameter("headerText");
		String newsDetails=request.getParameter("newsDetails");
		String sessionId=request.getParameter("sessionId");
		
		if(headerValue!=null && !headerValue.equalsIgnoreCase("") && newsDetails!=null && !newsDetails.equalsIgnoreCase("")){
		
		DataShiva d=new DataShiva();
		String headerValueCon = new String(headerValue.getBytes("UTF-8"), "UTF-8");
		String newsDetailsCon = new String(newsDetails.getBytes("UTF-8"), "UTF-8");
		String sessionIdValue = new String(sessionId.getBytes("UTF-8"), "UTF-8");
		
		
		d.setHeaderValue(headerValue);
		d.setNewsDetails(newsDetails);
		String query="INSERT INTO `shiva`.`oldernewsdetails` (`title`, `details`, `lastupdated`,`authflag`,`personid`) VALUES ( '"+headerValueCon+"', '"+newsDetailsCon+"', '"+TodayDate.todaydate()+"','n','"+sessionIdValue+"');";
	    System.out.println("Query ::"+query);
	    String query1 = new String(query.getBytes("UTF-8"), "UTF-8");
	    result=SqlCrudOperation.insertQuery(query1);
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

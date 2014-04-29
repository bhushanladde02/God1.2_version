package serverSide;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 * Servlet implementation class ShivaPersist
 */
public class ShivaPersist extends HttpServlet {
	private static final long serialVersionUID = 1L;
    List<DataShiva> cData=null;   
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShivaPersist() {
        super();
        
        // TODO Auto-generated constructor stub
    }
@Override
public void init() throws ServletException {
	// TODO Auto-generated method stub
	super.init();
	cData=new Vector<DataShiva>();
	
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("In get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Post");
		try{
		// TODO Auto-generated method stub
		String headerValue=request.getParameter("headerText");
		String newsDetails=request.getParameter("newsDetails");
		if(headerValue!=null && !headerValue.equalsIgnoreCase("") && newsDetails!=null && !newsDetails.equalsIgnoreCase("")){
		
		DataShiva d=new DataShiva();
		d.setHeaderValue(headerValue);
		d.setNewsDetails(newsDetails);
		cData.add(d);
		}
		
	    StringBuffer strBuf=new StringBuffer();
		Collections.reverse(cData);
	//	String str=strBuf.toString().replaceAll("</table>","");
		//strBuf=new StringBuffer();
		//strBuf.append(str);
		//if(strBuf.indexOf("</table>"))
		
		for(DataShiva da:cData){
			System.out.println(strBuf.toString());
			strBuf.append(da);
		}
		Collections.reverse(cData);
		//strBuf.append("</table>");
		
		PrintWriter pw=response.getWriter();
		
		pw.write(strBuf.toString());
		
		}catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}{
			
		}
		
		
		
	}

}

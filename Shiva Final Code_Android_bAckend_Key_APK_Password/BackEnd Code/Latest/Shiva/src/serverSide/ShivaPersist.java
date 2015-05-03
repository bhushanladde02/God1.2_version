package serverSide;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
		/*String bhus="जन्मदिन काय सांगतो";
		System.out.println("bhusha:::::"+bhus);*/
		/*TestMarathi test=new TestMarathi();
		String bhus=test.TestMar();
		System.out.println("Bhushan :::::::::"+bhus);
		final String param = new String(bhus.getBytes(
                "iso-8859-1"), "UTF-8");
		System.out.println(param);*/
		try{
		// TODO Auto-generated method stub
		String headerValue=request.getParameter("headerText");
		
		//final String param = new String(request.getParameter("headerText").getBytes("iso-8859-1"), "UTF-8");
		//System.out.println("Param ::::::::::::::::::::"+param);
		
		String newsDetails=request.getParameter("newsDetails");
		if(cData.size()==0){
			System.out.println("cData.size()::"+cData.size());
			
			cData.clear();
			   ResultSet rs=SqlCrudOperation.selectQuery("Select * from oldernewsdetails");
			   while(rs.next())
			   {
				   String titl=rs.getString("title");
				   String descr=rs.getString("details");
				   //System.out.println("titl::"+titl);
				   DataShiva d=new DataShiva();
				   d.setHeaderValue(titl);
				   d.setNewsDetails(descr);
				   cData.add(d);
			   }
		}
		if(headerValue!=null && !headerValue.equalsIgnoreCase("") && newsDetails!=null && !newsDetails.equalsIgnoreCase("")){
		
		DataShiva d=new DataShiva();
		//System.out.println("headerValueheaderValueheaderValueheaderValue:"+headerValue);
		String headerValueCon = new String(headerValue.getBytes("UTF-8"), "UTF-8");
		String newsDetailsCon = new String(newsDetails.getBytes("UTF-8"), "UTF-8");
		
		//System.out.println("newStringnewStringnewStringnewString:::"+newString);
		
		d.setHeaderValue(headerValue);
		d.setNewsDetails(newsDetails);
		cData.add(d);
	    String query="INSERT INTO `shiva`.`oldernewsdetails` (`title`, `details`, `lastupdated`) VALUES ( '"+headerValueCon+"', '"+newsDetailsCon+"', '"+TodayDate.todaydate()+"');";
	    System.out.println("Query ::"+query);
	    String query1 = new String(query.getBytes("UTF-8"), "UTF-8");
		SqlCrudOperation.insertQuery(query1);
		}
		
	    StringBuffer strBuf=new StringBuffer();
		Collections.reverse(cData);
	//	String str=strBuf.toString().replaceAll("</table>","");
		//strBuf=new StringBuffer();
		//strBuf.append(str);
		//if(strBuf.indexOf("</table>"))
		
		for(DataShiva da:cData){
			//System.out.println("I am here");
			//System.out.println(strBuf.toString());
			strBuf.append(da);
		}
		
		System.out.println(strBuf.toString());
		Collections.reverse(cData);
		//strBuf.append("</table>");
		//response.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter pw=response.getWriter();
		
		pw.write(strBuf.toString());
		
		}catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		
		
	}

}

package serverSide;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Collections;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registeruser
 */
public class Registeruser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registeruser() {
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
		doPost(request,response);
		//http://onine.in/Shiva/Registeruser?name=bhushan&phonenumber=8055925868&city=nasik&country=india&deviceid=22&gender=m&password=test
		//http://localhost:8080/Shiva/Registeruser?name=bhushan&phonenumber=8055925868&city=nasik&country=india&deviceid=22&gender=m&password=test
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In Post");
		int resultinsert=0;
	
		try{
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String phonenumber=request.getParameter("phonenumber");
		String city=request.getParameter("city");
		String gender=request.getParameter("gender");
		String country=request.getParameter("country");
		String deviceid=request.getParameter("deviceid");
		String password=request.getParameter("password");
		
		//String headerValue=request.getParameter("headerText");
		//String newsDetails=request.getParameter("newsDetails");
		
		System.out.println("name:"+name);
		System.out.println("phonenumber:"+phonenumber);
		System.out.println("city:"+city);
		System.out.println("country:"+country);
		System.out.println("deviceid:"+deviceid);
		System.out.println("gender:"+gender);
		System.out.println("password:"+password);
		
		if(name!=null && !name.equalsIgnoreCase("") && phonenumber!=null && !phonenumber.equalsIgnoreCase("")  &&
				city!=null && !city.equalsIgnoreCase("") && gender!=null && !gender.equalsIgnoreCase("")  &&
						country!=null && !country.equalsIgnoreCase("") && deviceid!=null && !deviceid.equalsIgnoreCase("")
								&& password!=null && !password.equalsIgnoreCase("")		
				){
		
		//DataShiva d=new DataShiva();
		//System.out.println("headerValueheaderValueheaderValueheaderValue:"+headerValue);
		String nameCon = new String(name.getBytes("UTF-8"), "UTF-8");
		String phonenumberCon = new String(phonenumber.getBytes("UTF-8"), "UTF-8");
		String cityCon = new String(city.getBytes("UTF-8"), "UTF-8");
		String genderCon = new String(gender.getBytes("UTF-8"), "UTF-8");
		String countryCon = new String(country.getBytes("UTF-8"), "UTF-8");
		String deviceidCon = new String(deviceid.getBytes("UTF-8"), "UTF-8");
		String passwordCon = new String(password.getBytes("UTF-8"), "UTF-8");
		//String newsDetailsCon = new String(newsDetails.getBytes("UTF-8"), "UTF-8");
		
		
		//System.out.println("newStringnewStringnewStringnewString:::"+newString);
		
		//d.setHeaderValue(headerValue);
		//d.setNewsDetails(newsDetails);
	
	   // String query="INSERT INTO `shiva`.`oldernewsdetails` (`title`, `details`, `lastupdated`,`authflag`) VALUES ( '"+headerValueCon+"', '"+newsDetailsCon+"', '"+TodayDate.todaydate()+"','n');";
		String query="INSERT INTO `shiva`.`registeruser` (`id`, `name`, `address`, `email`, `phone`, `position`, `city`, `pannumber`, `gender`, `matrialstatus`, `age`, `country`, `Department`, `deviceid`, `lastupdatedate`, `password`) VALUES (NULL, '"+nameCon+"', '', '', '"+phonenumberCon+"', '', '"+cityCon+"', '', '"+genderCon+"', '', '', '"+countryCon+"', '', '"+deviceidCon+"', '"+TodayDate.todaydate()+"', '"+passwordCon+"');";
	    System.out.println("Query ::"+query);
	    String query1 = new String(query.getBytes("UTF-8"), "UTF-8");
	    resultinsert=SqlCrudOperation.insertQuery(query1);
		}
	
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter pw=response.getWriter();
		
		pw.write(resultinsert);
		
		}catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}

}

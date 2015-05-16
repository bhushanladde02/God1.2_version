package serverSide;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;





/**
 * Servlet implementation class AuthServlet
 */
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//cData=new Vector<DataShiva>();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//doPost(request,response);
	/*	System.out.println("In get");
		List<DataShiva> cData=new Vector<DataShiva>();;   

		try{

			if(cData.size()==0){
				System.out.println("cData.size()::"+cData.size());
				cData.clear();
				System.out.println("I am in post to authorize");
				//ResultSet rs=SqlCrudOperation.selectQuery("Select * from oldernewsdetails where authflag='n'");
				ResultSet rs=SqlCrudOperation.selectQuery("Select * from oldernewsdetails");
				while(rs.next())
				{
					String titl=rs.getString("title");
					String descr=rs.getString("details");
					String id=rs.getString("id");
					String authflag=rs.getString("authflag");
					String date=rs.getString("lastupdated");
					//System.out.println("titl::"+titl);
					DataShiva d=new DataShiva();
					d.setHeaderValue(titl);
					d.setNewsDetails(descr);
					d.setId(id);
					d.setAuthValue(authflag);
					d.setLastUpdatedDt(date);
					cData.add(d);
				}
			}

			StringBuffer strBuf=new StringBuffer();
			Collections.reverse(cData);


			for(DataShiva da:cData){
				strBuf.append(da);
			}

			System.out.println(strBuf.toString());
			Collections.reverse(cData);

			Gson g=new Gson();
			String json =g.toJson(cData);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter pw=response.getWriter();

			pw.write(json);

		}catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<DataShiva> cData=new Vector<DataShiva>();;   
		System.out.println("In Post");

		try{

			if(cData.size()==0){
				System.out.println("cData.size()::"+cData.size());
				cData.clear();
				System.out.println("I am in post to authorize");
				//ResultSet rs=SqlCrudOperation.selectQuery("Select * from oldernewsdetails where authflag='n'");
				ResultSet rs=SqlCrudOperation.selectQuery("Select oldernewsdetails.id as id,oldernewsdetails.title,oldernewsdetails.details,oldernewsdetails.authflag,oldernewsdetails.lastupdated,registeruser.name from oldernewsdetails left outer join registeruser on oldernewsdetails.personid=registeruser.id");
				while(rs.next())
				{
					String titl=rs.getString("title");
					String descr=rs.getString("details");
					String id=rs.getString("id");
					String authflag=rs.getString("authflag");
					String date=rs.getString("lastupdated");
					String name=rs.getString("name");
					//System.out.println("titl::"+titl);
					DataShiva d=new DataShiva();
					d.setHeaderValue(titl);
					d.setNewsDetails(descr);
					d.setId(id);
					d.setAuthValue(authflag);
					d.setLastUpdatedDt(date);
					d.setPerson(name);
					cData.add(d);
				}
			}

			StringBuffer strBuf=new StringBuffer();
			Collections.reverse(cData);


			for(DataShiva da:cData){
				strBuf.append(da);
			}

			System.out.println(strBuf.toString());
			Collections.reverse(cData);

			Gson g=new Gson();
			String json =g.toJson(cData);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter pw=response.getWriter();

			pw.write(json);

		}catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}

	}

}

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
public class Authorized extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Authorized() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Post");


		try{
			String id=request.getParameter("da");
			String valueflag=request.getParameter("value");
			if(id!=null && !id.equalsIgnoreCase("") && valueflag!=null && !valueflag.equalsIgnoreCase("") ){
				System.out.println(id);
				System.out.println(valueflag);

				String query="update oldernewsdetails set authflag='"+valueflag+"' where id='"+id+"'";
				System.out.println("Query ::"+query);
				// String query1 = new String(query.getBytes("UTF-8"), "UTF-8");

				int  result=SqlCrudOperation.updateQuery(query);
				PrintWriter pw=response.getWriter();
				System.out.println("Updated Result:::::::::::::"+result);
				pw.write(result);
				
			}
			else{
			List<DataShiva> cData=new Vector<DataShiva>();
			//cData.clear();
			ResultSet rs=SqlCrudOperation.selectQuery("Select * from oldernewsdetails");
			while(rs.next())
			{
				String titl=rs.getString("title");
				String descr=rs.getString("details");
				String date=rs.getString("lastupdated");
				String auth=rs.getString("authflag");
				String idv=rs.getString("id");

				DataShiva d=new DataShiva();
				d.setHeaderValue(titl);
				d.setAuthValue(auth);
				d.setNewsDetails(descr);
				d.setLastUpdatedDt(date);
				d.setId(idv);
				cData.add(d);
			}



			StringBuffer strBuf=new StringBuffer();
			Collections.reverse(cData);

			for(DataShiva da:cData){
				strBuf.append(da.authString());
			}

			//System.out.println(strBuf.toString());
			Collections.reverse(cData);
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw=response.getWriter();
			pw.write(strBuf.toString());
			}
		}catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}


	}

}

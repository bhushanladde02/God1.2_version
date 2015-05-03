package serverSide;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

public class SqlCrudOperation {
	
 // public static void Connection()
      
	   protected static final String dbName="shiva";
	   //Local
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   //static final String DB_URL = "jdbc:mysql://localhost/"+dbName;//savepasswords.com";
	   static final String DB_URL = "jdbc:mysql://localhost/"+dbName+"?useUnicode=true&characterEncoding=utf-8";//savepasswords.com";
	   static final String USER = "root";
	   static final String PASS = "macho0ma!";//live
	   //static final String PASS = "";//local
	   //End Local
	  
	

	// private  static final String JDBC_DRIVER = "org.gjt.mm.mysql.Driver";  
	// private  static final String DB_URL = "jdbc:mysql://localhost/"+dbName;
	// private  static final String USER = "checkmyp";
	// private  static final String PASS = "byj!@#~";
	
	   

	   public static Connection getConnection()
	   {
		   Connection conn = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName(JDBC_DRIVER);

		      //STEP 3: Open a connection
		      //System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		     // conn=DriverManager.getConnection(url);

		      //STEP 4: Execute a query
		      //System.out.println("Creating statement...");
		    }
		   catch(Exception exe)
		   {
			   System.out.println(exe);
		   }
		   return conn;
	   }
	   public static ResultSet selectQuery(String sqlData){
		   ResultSet rs=null; 
		   try{
				  Statement stmt = null;
			      stmt = getConnection().createStatement();
			      String sql=sqlData;
			      rs = stmt.executeQuery(sql);
			  }catch(SQLException sqle){
				  sqle.printStackTrace();
			  }catch(Exception exe){
			   exe.printStackTrace();
			 }
	   return rs;		   
	   }
	   
	
	   
	   public static int updateQuery(String updateQuery)
	   {
		   int valueSuccess=0;
		   try{
				  Statement stmt = null;
			      stmt = getConnection().createStatement();
			      String sql=updateQuery;
			      valueSuccess = stmt.executeUpdate(sql);
			  }
		     catch(Exception exe)
			 {
			   System.out.println(exe);
			 } 
		     return valueSuccess;
	   }
	   public static int deleteQuery(String deleteQuery)
	   {
		   int valueSuccess=0;
		   try{
				  Statement stmt = null;
			      stmt = getConnection().createStatement();
			      String sql=deleteQuery;
			      valueSuccess = stmt.executeUpdate(sql);
			  }
		     catch(Exception exe)
			 {
			   System.out.println(exe);
			 } 
		     return valueSuccess;
	   }
	   
	   public static int insertQuery(String insertQuery)
	   {
		   int valueSuccess=0;
		   try{
				  Statement stmt = null;
			      stmt = getConnection().createStatement();
			      String sql=insertQuery;
			      valueSuccess = stmt.executeUpdate(sql);
			  }
		     catch(Exception exe)
			 {
			   System.out.println(exe);
			 } 
		     return valueSuccess;
	   }
	   
	  

  

}

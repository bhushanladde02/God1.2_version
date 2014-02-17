package mainpackage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import Brodcast.GODBroadcast;
import Brodcast.TodayDate;

//D:\Android yog\PradeepGodWorkSPace\Sounds\FileCreationGod

public class AutoUpdate {

	//Html Setup
	private String fileVariableCreation=Paths.fileVariableCreation;//"D:/Android yog/PradeepGodWorkSPace/Sounds/FileCreationGod_Automationcode/god.html";
	private String fileVariableCreation1=Paths.fileVariableCreation1;//"D:/Android yog/PradeepGodWorkSPace/Sounds/FileCreationGod_Automationcode/god1.html";
	
   //Db Setup
   protected static final String dbName=Paths.dbName;//"god";
   static final String JDBC_DRIVER = Paths.JDBC_DRIVER;//"com.mysql.jdbc.Driver";  
   static final String DB_URL = Paths.DB_URL;//"jdbc:mysql://localhost/"+dbName;//savepasswords.com";
   static final String USER = Paths.USER;//"root";//change username
   static final String PASS = Paths.PASS;//"";//change password
   static final String mainQuery="SELECT gaaliback.* FROM gaaliback LEFT JOIN gaali ON gaali.Id=gaaliback.Id WHERE gaali.Id IS NULL "; 
   
	public static void main(String[] args) {
		
		AutoUpdate a=new AutoUpdate();
		Gaali ga=new Gaali();	
		List<String> coll=new LinkedList<String>();
		try{
			//db setup
			ResultSet rs=selectQuery(mainQuery);//selectQuery("select count(*) as count from gaali");
			while(rs.next())
			{				
				String origin=rs.getString("origin");
				String lang=rs.getString("language");
				
				//if((origin!=null && !origin.toString().trim().equalsIgnoreCase("")) || (lang!=null && !lang.toString().trim().equalsIgnoreCase("")) ){
				coll.add(rs.getString("Id"));
				System.out.println(rs.getString("Id"));
				//}				
			}
			String firstValue=(String)coll.get(0);
			System.out.println(firstValue);
		    String query="Select * from gaaliback where id="+firstValue;
		    ResultSet rsdata=selectQuery(query);
		    rsdata.next();
		    
		    String id=rsdata.getString("id");
		    String gaalitxt=rsdata.getString("gaali");
		    String pronounciation= rsdata.getString("pronounciation");
		    String uses1=rsdata.getString("uses1");
		    String uses2=rsdata.getString("uses2");
		    String uses3=rsdata.getString("uses3");
		    String uses4=rsdata.getString("uses4");
		    String properties=rsdata.getString("properties");
		    String origin=rsdata.getString("origin");
		    String language=rsdata.getString("language");
		    String description1=rsdata.getString("description1");
		    String description2=rsdata.getString("description2");
		    String description3=rsdata.getString("description3");
		    String description4=rsdata.getString("description4");
		    String relatedTo=rsdata.getString("relatedTo");
		    String extra=rsdata.getString("extra");
		    String country=rsdata.getString("country");
		    
            ga.setId(Integer.parseInt(id));
            ga.setGaali(gaalitxt);
            ga.setPronounciation(pronounciation);
            ga.setUses1(uses1);
            ga.setUses2(uses2);
            ga.setUses3(uses3);
            ga.setUses4(uses4);
            ga.setProperties(properties);
            ga.setOrigin(origin);           
            ga.setLanguage(language);           
            ga.setDescription1(description1);
            ga.setDescription2(description2);
            ga.setDescription3(description3);
            ga.setDescription4(description4);
            ga.setRelatedTo(relatedTo);
            
            System.out.println("IIIIIIIIIIIIIIIIIIIDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD:::::::"+id +"   Date:::::::            "+TodayDate.todaydate());
            String insertIntoGaaliTable="INSERT INTO `god`.`gaali` (`id`, `gaali`, `pronounciation`, `uses1`, `uses2`, `uses3`, `uses4`, `properties`, `origin`, `language`, `description1`, `description2`, `description3`, `description4`, `relatedTo`, `extra`,`country`, `lastupdated_dt`)" +
            							"VALUES ('"+id+"', '"+gaalitxt+"', '"+pronounciation+"', '"+uses1+"', '"+uses2+"', '"+uses3+"', '"+uses4+"', '"+properties+"', '"+origin+"', '"+language+"', '"+description1+"','"+description2+"' ,'"+description3+"', '"+description4+"', '"+relatedTo+"', '"+extra+"','"+country+"','"+TodayDate.todaydate()+"');";
            
            //Step 1:
            insertQuery(insertIntoGaaliTable);//Inserted into db
            
            //Step 2:
            SoundFileCopy sound=new SoundFileCopy(); // copy sound files
        	sound.copySoundFile(Integer.parseInt(id));	
        	
        	//Step 3: We already put image for the same
        	
        	//Step 4: Create HtmlPage
        	 a.htmlSetup(ga,a);
        	        	
        	//Step 5: Broadcast Code
        	GODBroadcast.broadCast();
            
            }
		catch(Exception e)
		{
			System.out.println(e);
		}
		


	
        //Remain to do ->0)Find Unique Id 
	
		//1)Insert row into gaali table	- done
		//sound copy(sound folder to normal SIRAN) - done
		//Imagegaali folder put image - done
		//Html Page set up - done
		//Broadcast - done
		
		
		//2)Brodcast code - done
		//3)Put into schedular 
		//4)Change the path,dbusername,dbpass
		//5)Create gaaliback on live
		//6)Put gaali table all into gaaliback
		//7)insert a new gaali into gaaliback. and with same id put image and sound  (Sound Folder)
		//8) and create war	and Put Live check		
		//9)Then Just put gaali into gaaliback and with Id number images and sounds (Sound Folder)
		
	}
	public void htmlSetup(Gaali gaali,AutoUpdate object)
	{
		AutoUpdate a=object;
		//Html Set Up
		System.out.println(a.constructHtml(gaali));
		a.fileCreation(a.constructHtml(gaali));
		a.fileCreation1(a.constructHtml(gaali));
	
	}
	//db setup
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
	
	
	
	//htmlsetup
	public void fileCreation(String html)
	{
		try {
			 
			String content = html;
 
			File file = new File(fileVariableCreation);
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void fileCreation1(String html)
	{
		try {
			 
			String content = html; 
			File file = new File(fileVariableCreation1); 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String constructHtml(Gaali gaali)
	{				
		 int id=gaali.getId();
		 String description1=gaali.getDescription1();
		 String description2=gaali.getDescription2();
		 String description3=gaali.getDescription3();
		 String description4=gaali.getDescription4();
		 String extra=gaali.getExtra(); //no used
		 String gaalitext=gaali.getGaali();
		 String language=gaali.getLanguage();
		 String origin=gaali.getOrigin();
		 String pronounciation=gaali.getPronounciation();//no used
		 String properties=gaali.getProperties();//no used
		 String relatedTo=gaali.getRelatedTo();
		 String uses1=gaali.getUses1();
		 String uses2=gaali.getUses2();
		 String uses3=gaali.getUses3();
		 String uses4=gaali.getUses4();
		
		
			String html="<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">"+
			"<html>"+
			"<head>"+
			"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">"+
			"</head>"+
			"<script>"+
			"  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){"+
			"  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),"+
			"  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)"+
			"  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');"+
			
			" ga('create', 'UA-48040164-1', 'onine.in');"+
			"  ga('send', 'pageview');"+
			
			"</script>"+
			"<body>"+
			
			
			
			"<style type=\"text/css\">"+
			 
			"#share-buttons img {"+
			"width: 35px;"+
			"padding: 5px;"+
			"border: 0;"+
			"box-shadow: 0;"+
			"display: inline;"+
			"}"+
			 
			"</style>"+
			
			"	<div data-role=\"content\">"+	
			"	 <p><b> </b><a href=\"https://www.facebook.com/gaalioftheday?ref=hl\"><img src=\"images/fb.png\" alt=\"some_text\"></a></p>"+
			"	   <!-- changing content -->"+				  
			"		<p><h1>"+gaalitext+"<h4>"+
			"		<sub><i>SHAKE TO HEAR!</i></h4></h1></sub></p>"+
			"		<p><h4></h4></p>"+
			"		<p><b>Uses :</b></p>"+getDes1(uses1)+getDes2(uses2)+getDes3(uses3)+getDes4(uses4)+			
			"		<p><b>Origin: </b>"+origin+"</p>"+
			"		<p><b>Language support: </b>"+language+"</p>"+
			"		<p><b>Description :</b></p>"+getDes1(description1)+getDes2(description2)+getDes3(description3)+getDes4(description4)+			
			"        <p><img src=\"imagesGaali\\"+id+".png\" alt=\"some_text\"></p>   "+
			"	    <p><b>Related to : </b>"+relatedTo+"</p>"+
			"		 <!-- changing content -->"+
			"	</div>"+
			"	<div id=\"share-buttons\">"+
			"	<p><b>Share : </b></p>		"+
			"	<a href=\"http://www.facebook.com/sharer.php?u=https://play.google.com/store/apps/details?id=com.onine.god\" target=\"_blank\"><img src=\"images/facebook.png\" alt=\"Facebook\" /></a>"+
			"	<a href=\"http://twitter.com/share?url=https://play.google.com/store/apps/details?id=com.onine.god\" target=\"_blank\"><img src=\"images/twitter.png\" alt=\"Twitter\" /></a>"+
			"	<a href=\"https://plus.google.com/share?url=https://play.google.com/store/apps/details?id=com.onine.god\" target=\"_blank\"><img src=\"images/google.png\" alt=\"Google\" /></a>"+
			"	<a href=\"http://www.digg.com/submit?url=https://play.google.com/store/apps/details?id=com.onine.god\" target=\"_blank\"><img src=\"images/diggit.png\" alt=\"Digg\" /></a>"+
			"	<a href=\"http://reddit.com/submit?url=https://play.google.com/store/apps/details?id=com.onine.god\" target=\"_blank\"><img src=\"images/reddit.png\" alt=\"Reddit\" /></a>"+
			"	<a href=\"http://www.stumbleupon.com/submit?url=https://play.google.com/store/apps/details?id=com.onine.god\" target=\"_blank\"><img src=\"images/stumbleupon.png\" alt=\"StumbleUpon\" /></a>"+
			"	<a href=\"mailto:?Subject=Gaali Of The Day&Body=I%20saw%20this%20and%20thought%20of%20you!%20 https://play.google.com/store/apps/details?id=com.onine.god\"><img src=\"images/email.png\" alt=\"Email\" /></a>"+
			"	</div>"+
			
			"</div>"+
			
			"</body></html>";
			System.out.println("***********************************************************************************************************************************************************************************************************************");
			return html;

}
	public String getDes1(String description1)
	{
		String descriptionchk=description1;
		if(description1!=null && !description1.equalsIgnoreCase("")){
			descriptionchk="		<p><b>1."+description1+"</b> </p>";
			}
		else
		{
			descriptionchk="";
		}
		return descriptionchk;
	}
	public String getDes2(String description1)
	{
		String descriptionchk=description1;
		if(description1!=null && !description1.equalsIgnoreCase("")){
			descriptionchk="		<p><b>2."+description1+"</b> </p>";
			}
		else
		{
			descriptionchk="";
		}
		return descriptionchk;
	}
	public String getDes3(String description1)
	{
		String descriptionchk=description1;
		if(description1!=null && !description1.equalsIgnoreCase("")){
			descriptionchk="		<p><b>3."+description1+"</b> </p>";
			}
		else
		{
			descriptionchk="";
		}
		return descriptionchk;
	}
	public String getDes4(String description1)
	{
		String descriptionchk=description1;
		if(description1!=null && !description1.equalsIgnoreCase("")){
			descriptionchk="		<p><b>4."+description1+"</b> </p>";
			}
		else
		{
			descriptionchk="";
		}
		return descriptionchk;
	}
	
	public String getUse1(String description1)
	{
		String descriptionchk=description1;
		if(description1!=null && !description1.equalsIgnoreCase("")){
			descriptionchk="		<p>&nbsp;&nbsp;&nbsp;1."+description1+"</p>";
			}
		else
		{
			descriptionchk="";
		}
		return descriptionchk;
	}
	public String getUse2(String description1)
	{
		String descriptionchk=description1;
		if(description1!=null && !description1.equalsIgnoreCase("")){
			descriptionchk="		<p>&nbsp;&nbsp;&nbsp;2."+description1+"</p>";
			}
		else
		{
			descriptionchk="";
		}
		return descriptionchk;
	}
	public String getUse3(String description1)
	{
		String descriptionchk=description1;
		if(description1!=null && !description1.equalsIgnoreCase("")){
			descriptionchk="		<p>&nbsp;&nbsp;&nbsp;3."+description1+"</p>";
			}
		else
		{
			descriptionchk="";
		}
		return descriptionchk;
	}
	public String getUse4(String description1)
	{
		String descriptionchk=description1;
		if(description1!=null && !description1.equalsIgnoreCase("")){
			descriptionchk="		<p>&nbsp;&nbsp;&nbsp;4."+description1+"</p>";
			}
		else
		{
			descriptionchk="";
		}
		return descriptionchk;
	}
	
}

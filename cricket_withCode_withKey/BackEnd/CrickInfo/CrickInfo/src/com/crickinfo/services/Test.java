package com.crickinfo.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test {

	public static void main(String[] args) {

		
	}
	
	
	public static void runTask(String matchId){
		int i=0;
		

		
		for (;;) {

			StringBuffer strbuffer=new StringBuffer();
			strbuffer.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
			strbuffer.append("<html>\n");
			strbuffer.append("<head>\n");
			strbuffer.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
			strbuffer.append("<title>onine LiveScore</title>\n");
			strbuffer.append("</head>\n");
			strbuffer.append("<body>\n");

			
			
			System.out.println("Run count"+(++i));
			try {
/*				URL url = new URL(
						"http://onine.in/CrickInfo/ScoreService");

				URLConnection connection = url.openConnection();
				connection.setDoInput(true);
				InputStream inStream = connection.getInputStream();
*/				
				BufferedReader br = null;
				 
				String line;
				String location="/var/lib/tomcat6/webapps/ROOT/god";
				try {
		 
/*					br = new BufferedReader(new InputStreamReader(inStream));
					while ((line = br.readLine()) != null) {
						strbuffer.append(line);
					}
*/
					strbuffer.append(getData(matchId));
					strbuffer.append("<br/><br/>Time : "+System.currentTimeMillis());
					strbuffer.append("</body>\n");
					strbuffer.append("</html>\n");
					PrintWriter writer = new PrintWriter(location+"/LiveScore.html", "UTF-8");
					writer.println(strbuffer.toString());
					writer.close();
					if(i==1000)i=0;
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (br != null) {
						try {
							br.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}

		
	}
	
	
	public static String getData(String id){
		
		StringBuilder strBuffer = new StringBuilder();
	    try {
	        URL url = new URL("http://www.espncricinfo.com/netstorage/"+id+".json?xhr=1");
	        
	        URLConnection connection = url.openConnection();
	        connection.setDoInput(true);
	        InputStream inStream = connection.getInputStream();
	        
	        BufferedReader br = null;
			StringBuilder sb = new StringBuilder();
	 
			String line;
			try {
	 
				br = new BufferedReader(new InputStreamReader(inStream));
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
	 
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	        
	        JSONParser parser=new JSONParser();
	        
	        
	        try{
	            Object obj = parser.parse(sb.toString());
	            JSONObject jsonObject = (JSONObject) obj;
	            
	            JSONObject matchInfo =(JSONObject) jsonObject.get("match");
	            
	            String team1name=(String)matchInfo.get("team1_name");
	            String team1Id=(String)matchInfo.get("team1_id");
	            String team2name=(String)matchInfo.get("team2_name");
	            String team2Id=(String)matchInfo.get("team2_id");
	            System.out.println("Team1 is : "+team1name);
	            System.out.println("Team2 is : "+team2name);
	            Map<Integer, String> teams=new HashMap<Integer, String>();
	            teams.put(Integer.parseInt(team1Id), team1name);
	            teams.put(Integer.parseInt(team2Id), team2name);
	            
	            String desc = (String)jsonObject.get("description");
	            JSONArray name = (JSONArray) jsonObject.get("innings");
	            
	            System.out.println("\n\n\n\n");
	            System.out.println("Innings Object: :");
	            
	            
//	            StringBuffer strBuffer=new StringBuffer();
	            strBuffer.append("");
	            strBuffer.append("<b>"+desc+"</b> <br/><br/>");
	            
	            
	            
	            System.out.println(name.get(0));
	            JSONObject jsonObject1 = (JSONObject)name.get(0);
	            
	            String battingTeam1=teams.get(Integer.parseInt((String) jsonObject1.get("batting_team_id")));
	            Integer runs1 = Integer.parseInt((String) jsonObject1.get("runs"));
	            String overs1=(String)jsonObject1.get("overs");
	            String wickets1=(String)jsonObject1.get("wickets");	            
	            String run_rate1=(String)jsonObject1.get("run_rate");
	            strBuffer.append("<b>"+battingTeam1+" Innings Score</b><br/>");
	            if(overs1.equals("20.0")){
	            	strBuffer.append(""+runs1+"/"+wickets1+"  &nbsp;&nbsp; ("+overs1+" ov)<br/>");
//	            	strBuffer.append("Overs: "+overs1);
	            }else{
	            	strBuffer.append("<br/>RUNS Are: "+runs1+"<br/> WICKETS: "+wickets1+"<br/>OVERS: "+overs1+"<br/>RUNRATE: "+run_rate1);
	            }
	            
	            System.out.println("RUN_RATE IS: : "+run_rate1);
	            System.out.println("RUNS ARE: : "+runs1);
	            System.out.println("WICKETS ARE: : "+wickets1);
	            System.out.println("OVERS ARE: : "+overs1);

	            
	            
	            System.out.println(name.get(1));
	            JSONObject jsonObject2 = (JSONObject)name.get(1);
	            Integer runs2 = Integer.parseInt((String) jsonObject2.get("runs"));
	            String overs2=(String)jsonObject2.get("overs");
	            String wickets2=(String)jsonObject2.get("wickets");
	            String run_rate2=(String)jsonObject2.get("run_rate");
	            String battingTeam2=teams.get(Integer.parseInt((String) jsonObject2.get("batting_team_id")));
	            strBuffer.append("<br/><br/><br/><b>"+battingTeam2+" Innings Score</b><br/>");
	            if(overs2==null){
	            	
	            	strBuffer.append("yet to start");
	            }else if((overs2.equals("20.0") && (runs2<=runs1)) || (!overs2.equals("20.0") && (runs2>runs1)) || (overs2.equals("20.0") && (runs2>=runs1)) || (!overs2.equals("20.0") && (runs2<runs1) && wickets2.equals("10"))){
	            	strBuffer.append(""+runs2+"/"+wickets2+"  &nbsp;&nbsp; ("+overs2+" ov)<br/>");
	            	
	            }else{
	            	
	            	strBuffer.append("<br/>RUNS Are: "+runs2+"<br/> WICKETS: "+wickets2+"<br/>OVERS: "+overs2+"<br/>RUNRATE: "+run_rate2);
	            }
	            
	            
	            System.out.println("RUN_RATE IS: : "+run_rate2);
	            System.out.println("RUNS ARE: : "+runs2);
	            System.out.println("OVERS ARE: : "+overs2);
	            System.out.println("WICKETS ARE: : "+wickets2);

//	            response.getWriter().write(strBuffer.toString());
	         }catch(ParseException pe){
	            System.out.println("position: " + pe.getPosition());
	            System.out.println(pe);
	         }
	        
	        
	        
	      /*  BufferedReader input = new BufferedReader(new InputStreamReader(inStream));
	        
	        jelement = new JsonParser().parse(input);

	        jarray = jelement.getAsJsonArray();
*/
	       
	        
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }


		return strBuffer.toString();
	}
}

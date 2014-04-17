package com.crickinfo.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

/**
 * Servlet implementation class ScoreService
 */
public class ScoreService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    try {
	        URL url = new URL("http://www.espncricinfo.com/netstorage/682943.json?xhr=1");
	        
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
	            
	            
	            StringBuffer strBuffer=new StringBuffer();
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

	            response.getWriter().write(strBuffer.toString());
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

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

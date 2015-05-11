package otherClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SMS {
 /*public static void main(String[] args) {
	//Your authentication key
	 String authkey = "2457AtJCqZ3UGT52ca85fc";
	 //Multiple mobiles numbers seperated by comma
	 String mobiles = "8308853970";
	 //Sender ID,While using route4 sender id should be 6 characters long.
	 String senderId = "102234";
	 //Your message to send, Add URL endcoding here.
	 String message = "test";
	 //define route
	 String route="default";

	 //Prepare Url
	 URLConnection myURLConnection=null;
	 URL myURL=null;
	 BufferedReader reader=null;

	 //encoding message 
	 String encoded_message=URLEncoder.encode(message);

	 //Send SMS API
	 String mainUrl="http://sms.ssdindia.com/sendhttp.php?";

	 //Prepare parameter string 
	 StringBuilder sbPostData= new StringBuilder(mainUrl);
	 sbPostData.append("authkey="+authkey); 
	 sbPostData.append("&mobiles="+mobiles);
	 sbPostData.append("&message="+encoded_message);
	 sbPostData.append("&route="+route);
	 sbPostData.append("&sender="+senderId);
     System.out.println(sbPostData.toString());
	 //final string
	 mainUrl = sbPostData.toString();
	 try
	 {
	     //prepare connection
	     myURL = new URL(mainUrl);
	     myURLConnection = myURL.openConnection();
	     myURLConnection.connect();
	     reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
	     //reading response 
	     String response;
	     while ((response = reader.readLine()) != null) 
	     //print response 
	     System.out.println(response);
	     
	     //finally close connection
	     reader.close();
	 } 
	 catch (IOException e) 
	 { 
	 	e.printStackTrace();
	 } 

}*/
	public static void main(String[] args) {
		sendSMS("8793501156","Hi");
	}
 public static void sendSMS(String mobileNumber,String Message)
 {
	 System.out.println("I am in SMS Module");
	//Your authentication key
	 String authkey = "2457AtJCqZ3UGT52ca85fc";
	 //Multiple mobiles numbers seperated by comma
	 String mobiles = mobileNumber;
	 //Sender ID,While using route4 sender id should be 6 characters long.
	 String senderId = "CMPASS";
	 //Your message to send, Add URL endcoding here.
	 String message = Message;
	 //define route
	 String route="template";

	 //Prepare Url
	 URLConnection myURLConnection=null;
	 URL myURL=null;
	 BufferedReader reader=null;

	 //encoding message 
	 String encoded_message=URLEncoder.encode(message);

	 //Send SMS API
	 String mainUrl="http://sms.ssdindia.com/sendhttp.php?";

	 //Prepare parameter string 
	 StringBuilder sbPostData= new StringBuilder(mainUrl);
	 sbPostData.append("authkey="+authkey); 
	 sbPostData.append("&mobiles="+mobiles);
	 sbPostData.append("&message="+encoded_message);
	 sbPostData.append("&route="+route);
	 sbPostData.append("&sender="+senderId);
     //System.out.println(sbPostData.toString());
	 //final string
	 mainUrl = sbPostData.toString();
	 try
	 {
	     //prepare connection
	     myURL = new URL(mainUrl);
	     myURLConnection = myURL.openConnection();
	     myURLConnection.connect();
	     reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
	     //reading response 
	     String response;
	     while ((response = reader.readLine()) != null) 
	     //print response 
	     System.out.println(response);
	     
	     //finally close connection
	     reader.close();
	 } 
	 catch (IOException e) 
	 { 
	 	e.printStackTrace();
	 } 

 }
}

package com.onine.tester;

import java.util.ArrayList;
import java.util.List;

public class GODTester {
	public static void main(String[] args) {
		/*String responseString = "";
		HttpClient client = new DefaultHttpClient();
	    HttpGet  get = new HttpGet("http://onine.in:8080/GODCloudBackend/History?id="+-1);
	    try {
	      HttpResponse response = client.execute(get);
	      BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	     responseString=rd.readLine();

	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    System.out.println(responseString);*/
		
		List<String> gaaliList = new ArrayList<String>();
		gaaliList.add("Bjemcjp");
		gaaliList.add("dsf");
		
//		String arrayValues[]  = (String[])gaaliList.toArray();
//		System.out.println(arrayValues.toString());
		String arrayValues[] = gaaliList.toArray(new String[gaaliList.size()]);
	}
}
